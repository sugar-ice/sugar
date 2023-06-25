package com.sugar.sugar.entity;

import lombok.Data;

@Data
public class Account {
    int userId;
    String username;
    String password;
    String email;
    String roleName;
}
