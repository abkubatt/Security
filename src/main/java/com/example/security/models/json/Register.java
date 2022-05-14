package com.example.security.models.json;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Register {
    String name;
    String phone;
    String email;
    Long roleId;
    String password;
    //Long userId;
}
