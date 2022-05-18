package com.example.security.dao;

import com.example.security.models.entities.Account;
import com.example.security.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    Account findByUser(User user);
    Account findByLogin(String login);
}
