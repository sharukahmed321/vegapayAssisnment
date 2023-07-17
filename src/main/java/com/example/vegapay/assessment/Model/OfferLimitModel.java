package com.example.vegapay.assessment.Model;


import com.example.vegapay.assessment.Enum.LimitType;
import com.example.vegapay.assessment.Enum.Status;
import lombok.Data;

import java.util.Date;

@Data
public class OfferLimitModel {

    private String accountId;
    private LimitType limitType;
    private long newLimit;
    private Date offerActivationLimit;
    private Date offerExpiryTime;
    private Status status;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }

    public long getNewLimit() {
        return newLimit;
    }

    public void setNewLimit(long newLimit) {
        this.newLimit = newLimit;
    }

    public Date getOfferActivationLimit() {
        return offerActivationLimit;
    }

    public void setOfferActivationLimit(Date offerActivationLimit) {
        this.offerActivationLimit = offerActivationLimit;
    }

    public Date getOfferExpiryTime() {
        return offerExpiryTime;
    }

    public void setOfferExpiryTime(Date offerExpiryTime) {
        this.offerExpiryTime = offerExpiryTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
