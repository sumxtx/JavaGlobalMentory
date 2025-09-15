package com.accounts.service;

import com.accounts.modelo.Account;
import com.accounts.repo.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private IAccountRepo accountRepo;

    @Override
    public List<Account> listAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account findAccountById(Integer idAccount) {
        Account account = accountRepo.findById(idAccount).orElse(null);
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepo.delete(account);
    }
}
