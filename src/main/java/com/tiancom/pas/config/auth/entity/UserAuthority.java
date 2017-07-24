package com.tiancom.pas.config.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Embeddable;

/**
 * 用户权限表。
 *
 * @author dengb
 * @see org.springframework.security.core.GrantedAuthority
 */
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserAuthority implements GrantedAuthority {

    private static final long serialVersionUID = -868733184094888789L;

    @Getter @Setter
    private String authority;

    @Override
    public String toString() {
        return authority;
    }
}
