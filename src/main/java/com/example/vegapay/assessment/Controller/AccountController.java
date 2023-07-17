package com.example.vegapay.assessment.Controller;

import com.example.vegapay.assessment.Entity.AccountEntity;
import com.example.vegapay.assessment.Model.AccountModel;
import com.example.vegapay.assessment.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * use this api to create an account
     *
     * @param accountEntity
     * @return
     */
    @PostMapping("/createAccount")
    public AccountModel createAccount(@RequestBody AccountEntity accountEntity){
        return accountService.createAccount(accountEntity);
    }

    /**
     * use this api to fetch all accounts from DB
     *
     * @return
     */
    @GetMapping("/getAccounts")
    public List<AccountModel> getAccountDetails(){
        return accountService.getAccountDetails();
    }

}
