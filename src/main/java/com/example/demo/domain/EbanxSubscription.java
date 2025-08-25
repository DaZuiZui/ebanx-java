package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class EbanxSubscription implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;          // Primary key
    private Integer version;  // Optimistic lock
    private String createBy;  // Created by
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


    // Getters and Setters
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

    public Long getLatestPaymentId() {
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
}
