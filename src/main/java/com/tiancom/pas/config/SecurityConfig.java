package com.tiancom.pas.config;

import com.tiancom.pas.config.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 系统安全验证配置。
 *
 * @author dengb
 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
 */
@SuppressWarnings("all")
public class SecurityConfig {

    @Configuration
    @Profile("development")
    public static class H2SecurityConfig extends WebSecurityConfigurerAdapter {

        private final UserService userService;

        @Autowired
        private DataSource dataSource;

        @Value("${system.bcrypt.strength}")
        private int strength;

        @Autowired
        public H2SecurityConfig(UserService userService) {
            this.userService = userService;
        }

        // @formatter:off
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/", "/login").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/content")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .rememberMe().tokenRepository(tokenRepository())
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();
        }
        // @formatter:on

        // @formatter:off
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(userService)
                    .passwordEncoder(new BCryptPasswordEncoder(strength))
                .and()
                .eraseCredentials(true);
        }
        // @formatter:on

        @Bean
        public PersistentTokenRepository tokenRepository() {
            JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
            tokenRepository.setDataSource(dataSource);
            return tokenRepository;
        }
    }

    @Configuration
    @Profile("production")
    public static class CommonSecurityConfig extends WebSecurityConfigurerAdapter {

        private final UserService userService;

        @Autowired
        private DataSource dataSource;

        @Value("${system.bcrypt.strength}")
        private int strength;

        @Autowired
        public CommonSecurityConfig(UserService userService) {
            this.userService = userService;
        }

        // @formatter:off
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/login", "/login/**").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/content")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .rememberMe().tokenRepository(tokenRepository());
        }
        // @formatter:on

        // @formatter:off
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(userService)
                    .passwordEncoder(new BCryptPasswordEncoder(strength))
                .and()
                .eraseCredentials(true);
        }
        // @formatter:on

        @Bean
        public PersistentTokenRepository tokenRepository() {
            JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
            tokenRepository.setDataSource(dataSource);
            return tokenRepository;
        }
    }
}
