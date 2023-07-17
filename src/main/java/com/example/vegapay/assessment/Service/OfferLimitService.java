package com.example.vegapay.assessment.Service;

import com.example.vegapay.assessment.Entity.AccountEntity;
import com.example.vegapay.assessment.Entity.OfferLimitEntity;
import com.example.vegapay.assessment.Enum.Status;
import com.example.vegapay.assessment.Mapper.AccountMapper;
import com.example.vegapay.assessment.Mapper.OfferLimitMapper;
import com.example.vegapay.assessment.Model.AccountModel;
import com.example.vegapay.assessment.Model.OfferLimitModel;
import com.example.vegapay.assessment.Repository.AccountRepository;
import com.example.vegapay.assessment.Repository.OfferLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferLimitService {

    private final OfferLimitRepository offerLimitRepository;
    private final OfferLimitMapper offerLimitMapper;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public OfferLimitService(OfferLimitRepository offerLimitRepository, OfferLimitMapper offerLimitMapper, AccountRepository accountRepository, AccountMapper accountMapper) {
        this.offerLimitRepository = offerLimitRepository;
        this.offerLimitMapper = offerLimitMapper;
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    /**
     * This function helps us to create new offer Limit for the existing account
     *
     * @param offerLimitEntity
     * @return
     */
    public OfferLimitModel createOfferLimit(OfferLimitEntity offerLimitEntity){
        String accountId = offerLimitEntity.getAccountId();
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accountId);
        AccountEntity accountEntity = null;
        if(optionalAccountEntity.isPresent()){
            accountEntity = optionalAccountEntity.get();
        }
        long newLimit = offerLimitEntity.getNewLimit();
        long oldLimit = accountEntity != null ? accountEntity.getAccountLimit() : 0;
        if(newLimit > oldLimit){
            offerLimitEntity.setStatus(Status.PENDING);
            // store offer limit record in DB
            OfferLimitEntity createdOfferLimitEntity = offerLimitRepository.save(offerLimitEntity);
            return offerLimitMapper.convertEntityToModel(createdOfferLimitEntity);
        } else{
            return new OfferLimitModel();
        }
    }

    /**
     * This will give all the active offers for an account
     *
     * @param accountId
     * @return
     */
    public List<OfferLimitModel> getAllActiveOffers(String accountId){
        Optional<OfferLimitEntity> OptionalOfferLimitEntity = offerLimitRepository.findByAccountId(accountId);
        if(OptionalOfferLimitEntity.isPresent()){
            OfferLimitEntity offerLimitEntity = OptionalOfferLimitEntity.get();
            List<OfferLimitEntity> offerLimitEntities = offerLimitRepository.findByAccountIdAndStatus(accountId,Status.PENDING);
            return offerLimitEntities.stream().map(offerLimitMapper::convertEntityToModel).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    /**
     * This function will update the status to accepted/rejected if user updates his limit
     *
     * @param limitOfferId
     * @param status
     * @return
     */
    public AccountModel updateAccountLimit(String limitOfferId, Status status){
        Optional<OfferLimitEntity> offerLimitEntityOptional = offerLimitRepository.findById(limitOfferId);
        if(offerLimitEntityOptional.isPresent()){
            OfferLimitEntity offerLimitEntity = offerLimitEntityOptional.get();
            Optional<AccountEntity> accountEntityOptional = accountRepository.findById(offerLimitEntity.getAccountId());
            if(accountEntityOptional.isPresent()){
                AccountEntity accountEntity = accountEntityOptional.get();
                long newLimit = offerLimitEntity.getNewLimit();
                long oldLimit = accountEntity.getAccountLimit();
                if(newLimit > oldLimit){
                    if(status == Status.ACCEPTED){
                        accountEntity.setAccountLimit(newLimit);
                        accountEntity.setLastAccountLimit(oldLimit);
                        accountEntity.setAccountLimitUpdateTime(new Date());
                    } else if (status == Status.REJECTED){
                        accountEntity.setAccountLimit(oldLimit);
                    }
                    AccountEntity account = accountRepository.save(accountEntity);
                    offerLimitEntity.setStatus(status);
                    offerLimitRepository.save(offerLimitEntity);
                    return accountMapper.convertEntityToModel(account);
                } else {
                    return accountMapper.convertEntityToModel(accountEntity);
                }
            }
        }
        return null;
    }

}
