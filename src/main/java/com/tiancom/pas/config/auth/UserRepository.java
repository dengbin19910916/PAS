package com.tiancom.pas.config.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPrincipal, Long> {

    UserPrincipal findByUsername(String username);
}
