package com.accounts.repo;

import com.accounts.modelo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account, Integer> {
}

