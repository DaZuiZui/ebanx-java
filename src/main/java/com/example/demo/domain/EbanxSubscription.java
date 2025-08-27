package com.example.demo.domain;

import java.io.Serializable;

public class EbanxSubscription implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;          // Primary key
    private Integer version;  // Optimistic lock
    private String createBy;  // Created by

    public EbanxSubscription() {
    }

    private Long createAt;    // Creation time (in milliseconds)
    private String updateBy;  // Updated by
    private Long updateAt;    // Update time (in milliseconds)
    private Integer status;   // Data status: 0: active, 1: deleted
    private Long userId;      // Local user ID
    private Integer appId;    // Application ID
    private String subscriptionType;  // Subscription type: card / pix
    private String state;     // Subscription status: active / canceled / past_due / paused
    private Long currentProductId;   // Current subscribed product ID
    private Long currentPeriodStart; // Current period start time
    private Long currentPeriodEnd;   // Current period end time
    private Long cancelAt;    // Scheduled cancellation time (in milliseconds)
    private Long canceledAt;  // Cancellation time
    private String ebanxCustomerId;  // EBANX customer ID
    private String ebanxSubscriptionId; // EBANX subscription ID (if any)
    private String cardToken;        // Long-term credit card token (for recurring payments)
    private String pixEnrollmentId;  // Pix enrollment ID (enrollment_id)
    private Long latestPaymentId;    // Latest payment ID
    private String metadata;         // Subscription metadata (JSON)
    private Double amount;           // Subscription amount per period
    private String currency;          // currency

    @Override
    public String toString() {
        return "EbanxSubscription{" +
                "id=" + id +
                ", version=" + version +
                ", createBy='" + createBy + '\'' +
                ", createAt=" + createAt +
                ", updateBy='" + updateBy + '\'' +
                ", updateAt=" + updateAt +
                ", status=" + status +
                ", userId=" + userId +
                ", appId=" + appId +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", state='" + state + '\'' +
                ", currentProductId=" + currentProductId +
                ", currentPeriodStart=" + currentPeriodStart +
                ", currentPeriodEnd=" + currentPeriodEnd +
                ", cancelAt=" + cancelAt +
                ", canceledAt=" + canceledAt +
                ", ebanxCustomerId='" + ebanxCustomerId + '\'' +
                ", ebanxSubscriptionId='" + ebanxSubscriptionId + '\'' +
                ", cardToken='" + cardToken + '\'' +
                ", pixEnrollmentId='" + pixEnrollmentId + '\'' +
                ", latestPaymentId=" + latestPaymentId +
                ", metadata='" + metadata + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCurrentProductId() {
        return currentProductId;
    }

    public void setCurrentProductId(Long currentProductId) {
        this.currentProductId = currentProductId;
    }

    public Long getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    public void setCurrentPeriodStart(Long currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
    }

    public Long getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    public void setCurrentPeriodEnd(Long currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
    }

    public Long getCancelAt() {
        return cancelAt;
    }

    public void setCancelAt(Long cancelAt) {
        this.cancelAt = cancelAt;
    }

    public Long getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Long canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getEbanxCustomerId() {
        return ebanxCustomerId;
    }

    public void setEbanxCustomerId(String ebanxCustomerId) {
        this.ebanxCustomerId = ebanxCustomerId;
    }

    public String getEbanxSubscriptionId() {
        return ebanxSubscriptionId;
    }

    public void setEbanxSubscriptionId(String ebanxSubscriptionId) {
        this.ebanxSubscriptionId = ebanxSubscriptionId;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getPixEnrollmentId() {
        return pixEnrollmentId;
    }

    public void setPixEnrollmentId(String pixEnrollmentId) {
        this.pixEnrollmentId = pixEnrollmentId;
    }

    public Long getLatestPaymentId(Long id) {
        return latestPaymentId;
    }

    public void setLatestPaymentId(Long latestPaymentId) {
        this.latestPaymentId = latestPaymentId;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public EbanxSubscription(Long id, Integer version, String createBy, Long createAt, String updateBy, Long updateAt, Integer status, Long userId, Integer appId, String subscriptionType, String state, Long currentProductId, Long currentPeriodStart, Long currentPeriodEnd, Long cancelAt, Long canceledAt, String ebanxCustomerId, String ebanxSubscriptionId, String cardToken, String pixEnrollmentId, Long latestPaymentId, String metadata, Double amount, String currency) {
        this.id = id;
        this.version = version;
        this.createBy = createBy;
        this.createAt = createAt;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
        this.status = status;
        this.userId = userId;
        this.appId = appId;
        this.subscriptionType = subscriptionType;
        this.state = state;
        this.currentProductId = currentProductId;
        this.currentPeriodStart = currentPeriodStart;
        this.currentPeriodEnd = currentPeriodEnd;
        this.cancelAt = cancelAt;
        this.canceledAt = canceledAt;
        this.ebanxCustomerId = ebanxCustomerId;
        this.ebanxSubscriptionId = ebanxSubscriptionId;
        this.cardToken = cardToken;
        this.pixEnrollmentId = pixEnrollmentId;
        this.latestPaymentId = latestPaymentId;
        this.metadata = metadata;
        this.amount = amount;
        this.currency = currency;
    }
}
