package com.example.vegapay.assessment.Mapper;


import com.example.vegapay.assessment.Entity.OfferLimitEntity;
import com.example.vegapay.assessment.Model.OfferLimitModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferLimitMapper {

    OfferLimitModel convertEntityToModel(OfferLimitEntity offerLimitEntity);
}
