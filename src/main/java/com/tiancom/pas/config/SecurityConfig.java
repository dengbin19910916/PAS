package com.tiancom.pas.config;

import com.tiancom.pas.config.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .defaultSuccessUrl("/")
                        .permitAll()
                    .and()
                    .logout().permitAll()
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
    }

    @Configuration
    @Profile("production")
    public static class CommonSecurityConfig extends WebSecurityConfigurerAdapter {

        private final UserService userService;

        @Value("${system.bcrypt.strength}")
        private int strength;

        @Autowired
        public CommonSecurityConfig(UserService userService) {
            this.userService = userService;
        }

        // @formatter:off
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/login", "/login/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and().logout()
                    .permitAll();
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
    }
}
