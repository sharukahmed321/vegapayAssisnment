package com.example.vegapay.assessment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Account")
@Data
public class AccountEntity {

    @Id
    @JsonProperty("account_id")
    @Column(name="account_id")
    private String accountId;

    @JsonProperty("customer_id")
    @Column(name="customer_id")
    private String customerId;

    @JsonProperty("account_limit")
    @Column(name="account_limit")
    private long accountLimit;

    @JsonProperty("per_transaction_limit")
    @Column(name="per_transaction_limit")
    private long perTransactionLimit;

    @JsonProperty("last_account_limit")
    @Column(name="last_account_limit")
    private long lastAccountLimit;

    @JsonProperty("last_per_transaction_limit")
    @Column(name="last_per_transaction_limit")
    private long lastPerTransactionLimit;

    @JsonProperty("account_limit_update_time")
    @Column(name="account_limit_update_time")
    private Date accountLimitUpdateTime;

    @JsonProperty("per_transaction_limit_update_time")
    @Column(name="per_transaction_limit_update_time")
    private Date perTransactionLimitUpdateTime;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public long getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(long accountLimit) {
        this.accountLimit = accountLimit;
    }

    public long getPerTransactionLimit() {
        return perTransactionLimit;
    }

    public void setPerTransactionLimit(long perTransactionLimit) {
        this.perTransactionLimit = perTransactionLimit;
    }

    public long getLastAccountLimit() {
        return lastAccountLimit;
    }

    public void setLastAccountLimit(long lastAccountLimit) {
        this.lastAccountLimit = lastAccountLimit;
    }

    public long getLastPerTransactionLimit() {
        return lastPerTransactionLimit;
    }

    public void setLastPerTransactionLimit(long lastPerTransactionLimit) {
        this.lastPerTransactionLimit = lastPerTransactionLimit;
    }

    public Date getAccountLimitUpdateTime() {
        return accountLimitUpdateTime;
    }

    public void setAccountLimitUpdateTime(Date accountLimitUpdateTime) {
        this.accountLimitUpdateTime = accountLimitUpdateTime;
    }

    public Date getPerTransactionLimitUpdateTime() {
        return perTransactionLimitUpdateTime;
    }

    public void setPerTransactionLimitUpdateTime(Date perTransactionLimitUpdateTime) {
        this.perTransactionLimitUpdateTime = perTransactionLimitUpdateTime;
    }
}
