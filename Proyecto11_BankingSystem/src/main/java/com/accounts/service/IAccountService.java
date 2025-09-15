package com.accounts.service;

import com.accounts.modelo.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> listAccounts();

    public Account findAccountById(Integer idAccount);

    public void saveAccount(Account account);

    public void deleteAccount(Account account);



}
