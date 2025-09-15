package com.accounts.controller;

import com.accounts.modelo.Account;
import com.accounts.service.AccountService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    AccountService accountService;
    private List<Account> accounts;
    private Account selectedAccount;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        loadData();
    }

    public void loadData() {
        this.accounts = accountService.listAccounts();
        accounts.forEach((account) -> logger.info(account.toString()));
    }

    public void addAccount(){
        this.selectedAccount = new Account();
    }

    public void saveAccount(){
        logger.info("Account to be save: " + this.selectedAccount);
        if(this.selectedAccount.getIdAccount() == null){

        }
    }
}
