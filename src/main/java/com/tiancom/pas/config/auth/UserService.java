package com.tiancom.pas.config.auth;

import com.tiancom.pas.config.auth.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MessageSource messageSource;

    @Value("${system.bcrypt.strength}")
    private int strength;

    @Autowired
    public UserService(UserRepository userRepository, MessageSource messageSource) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserPrincipal user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(messageSource.getMessage("user.present", null, LocaleContextHolder.getLocale()));
        }
        return user;
    }

    @Transactional
    public void saveUser(@Valid UserPrincipal principal, @NotNull(message = "") String newPassword) {
        if (newPassword != null && newPassword.length() > 0) {
            principal.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(strength)));
            userRepository.save(principal);
        }
    }
}
