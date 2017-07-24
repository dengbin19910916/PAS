package com.tiancom.pas.config.auth;

import com.tiancom.pas.config.auth.entity.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPrincipal, Long> {

    UserPrincipal findByUsername(String username);
}
