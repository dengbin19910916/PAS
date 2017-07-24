package com.tiancom.pas.site.basic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 省份，地区。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Province {

    @Id
    private String code;
    private String name;

    @Override
    public String toString() {
        return name + "[" + code + "]";
    }
}
