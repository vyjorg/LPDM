package com.lpdm.msorder.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties("microservice")
public class AppPropertiesConfig {

    private String domain;
    private String user_name;
    private String store_name;
    private String product_name;

    private int user_port;
    private int store_port;
    private int product_port;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getUser_port() {
        return user_port;
    }

    public void setUser_port(int user_port) {
        this.user_port = user_port;
    }

    public int getStore_port() {
        return store_port;
    }

    public void setStore_port(int store_port) {
        this.store_port = store_port;
    }

    public int getProduct_port() {
        return product_port;
    }

    public void setProduct_port(int product_port) {
        this.product_port = product_port;
    }
}
