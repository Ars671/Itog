package com.example.cruddemo.models;

import org.springframework.security.core.GrantedAuthority;

public enum roleEnum implements GrantedAuthority {
    STOREKEEPER, ADMIN, BROKER;
    @Override
    public String getAuthority()
    {
        return name();
    }
}
