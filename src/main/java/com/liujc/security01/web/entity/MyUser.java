package com.liujc.security01.web.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyUser implements Serializable {

    private static final long serialVersionUID = 7551823622125397357L;
    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    // get,set略
}