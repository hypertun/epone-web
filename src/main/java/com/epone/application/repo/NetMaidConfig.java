package com.epone.application.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class NetMaidConfig {
    public static String netMaidPass;

    @Autowired
    private void setNetMaidPass(@Value("${app.netmaid.pass}") String str) {
        NetMaidConfig.netMaidPass = str;
    }
}
