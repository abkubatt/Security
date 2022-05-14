package com.example.security.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "tb_account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    @NotNull(message = "Password must be between 4 to 15 characters")
    @Size(min = 8, max = 15)
    String password;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    boolean isActive;

}
