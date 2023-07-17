package com.example.vegapay.assessment.Entity;

import com.example.vegapay.assessment.Enum.LimitType;
import com.example.vegapay.assessment.Enum.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "offerLimit")
@Data
public class OfferLimitEntity {

    @Id
    @JsonProperty("limit_offer_id")
    @Column(name = "limit_offer_id")
    private String limitOfferId;

    @JsonProperty("account_id")
    @Column(name="account_id")
    private String accountId;

    @JsonProperty("limit_type")
    @Column(name="limit_type")
    private LimitType limitType;

    @JsonProperty("new_limit")
    @Column(name="new_limit")
    private long newLimit;

    @JsonProperty("offer_activation_time")
    @Column(name="offer_activation_time")
    private Date offerActivationTime;

    @JsonProperty("offer_expiry_time")
    @Column(name="offer_expiry_time")
    private Date offerExpiryTime;

    @JsonProperty("status")
    @Column(name = "status")
    private Status status;

    public String getLimitOfferId() {
        return limitOfferId;
    }

    public void setLimitOfferId(String limitOfferId) {
        this.limitOfferId = limitOfferId;
    }

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

    public Date getOfferActivationTime() {
        return offerActivationTime;
    }

    public void setOfferActivationTime(Date offerActivationTime) {
        this.offerActivationTime = offerActivationTime;
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
