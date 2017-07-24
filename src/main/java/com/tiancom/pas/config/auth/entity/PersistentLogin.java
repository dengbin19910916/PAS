package com.tiancom.pas.config.auth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {
    private String username;
    @Id
    private String series;
    private String token;
    private Date lastUsed;
}
