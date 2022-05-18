package com.example.security.models.request;

import com.example.security.models.enums.Roles;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignInRequest {

    @NotEmpty(message = "Name must not be empty")
    String name;
    String phone;
    @Email(message = "Email is not correct")
    String email;
    @Size(min = 8, max = 15, message = "Password must be more 8 and less 15")
    String password;
    Roles role;

}
