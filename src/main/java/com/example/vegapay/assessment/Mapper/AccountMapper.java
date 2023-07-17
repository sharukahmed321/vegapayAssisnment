package com.example.vegapay.assessment.Mapper;

import com.example.vegapay.assessment.Entity.AccountEntity;
import com.example.vegapay.assessment.Model.AccountModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountModel convertEntityToModel(AccountEntity accountEntity);

}
