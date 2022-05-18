package com.example.security.dao;

import com.example.security.models.entities.User;
import com.example.security.models.entities.UserCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCodeDao extends JpaRepository<UserCode, Long> {
    UserCode findByUser(User user);
}
