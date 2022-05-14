package com.example.security.dao;

import com.example.security.models.entities.Account;
import com.example.security.models.json.SignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    @Query(value = "select * from tb_account a where a.login = ?1 and a.password = ?2  and  a.is_active = true", nativeQuery = true)
    Account checkAccount(String login, String password);
}
