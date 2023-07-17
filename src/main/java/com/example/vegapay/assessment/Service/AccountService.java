package com.example.vegapay.assessment.Service;

import com.example.vegapay.assessment.Entity.AccountEntity;
import com.example.vegapay.assessment.Mapper.AccountMapper;
import com.example.vegapay.assessment.Model.AccountModel;
import com.example.vegapay.assessment.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    /**
     * This function will create account by taking input from FrontEnd
     * @param accountEntity
     * @return
     */
    public AccountModel createAccount(AccountEntity accountEntity){
        AccountEntity createdAccountEntity = accountRepository.save(accountEntity);
        return accountMapper.convertEntityToModel(createdAccountEntity);
    }


    /**
     * This will fetch all the list of available Account Details
     * @return
     */
    public List<AccountModel> getAccountDetails() {
        List<AccountEntity> accountEntityList = accountRepository.findAll();
        return accountEntityList.stream().map(accountMapper::convertEntityToModel).collect(Collectors.toList());
    }
}
