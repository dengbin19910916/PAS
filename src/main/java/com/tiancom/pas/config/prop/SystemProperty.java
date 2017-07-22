package com.tiancom.pas.config.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("system")
@PropertySource("classpath:config/system.properties")
public class SystemProperty {

    private Bcrypt bcrypt;

    @Data
    private static class Bcrypt {
        private int strength;
    }
}
