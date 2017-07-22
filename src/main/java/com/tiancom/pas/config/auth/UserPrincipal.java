package com.tiancom.pas.config.auth;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

/**
 * 用户表。
 *
 * @author dengb
 * @see org.springframework.security.core.userdetails.UserDetails
 */
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "user_principal_username", columnNames = "username")
})
public class UserPrincipal implements UserDetails {
    private static final long serialVersionUID = 3876012774160372221L;

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    @ElementCollection(targetClass = UserAuthority.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_principal_authority", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    })
    private Set<UserAuthority> authorities;

    @Override
    public String toString() {
        return username + authorities.toString();
    }
}
