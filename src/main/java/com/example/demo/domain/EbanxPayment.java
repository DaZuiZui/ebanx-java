package com.example.demo.domain;

import java.io.Serializable;

public class EbanxPayment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;  // Primary key
    private Integer version;  // Optimistic lock
    private String createBy;  // Created by
    private Long createAt;    // Creation time (in milliseconds)
    private String updateBy;  // Updated by
    private Long updateAt;    // Update time (in milliseconds)
    private Integer status;   // Data status: 0: active, 1: deleted

    private Long subscriptionId;  // Associated subscription ID
    private Long userId;          // User ID
    private Integer appId;        // Application ID

    // Payment information
    private String ebanxPaymentId;  // EBANX payment ID
    private String orderNo;         // Business order number
    private Double amount;          // Payment amount
    private String currency;        // Currency

    // Status
    private String state;           // Payment status: pending / success / failed / refunded
    private String failReason;      // Failure reason

    // Payment method
    private String paymentMethod;   // Payment method: card / pix
    private String token;           // Token for this payment (one-time token, for debugging only)

    // Pix-specific
    private String pixQrCode;       // Pix payment QR code
    private String pixEnrollmentId; // Pix enrollment ID

    // Callback/Reconciliation
    private Long notifiedAt;        // Last time the callback was received
    private String rawCallback;     // Raw Webhook callback data

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

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
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

    public String getEbanxPaymentId() {
        return ebanxPaymentId;
    }

    public void setEbanxPaymentId(String ebanxPaymentId) {
        this.ebanxPaymentId = ebanxPaymentId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPixQrCode() {
        return pixQrCode;
    }

    public void setPixQrCode(String pixQrCode) {
        this.pixQrCode = pixQrCode;
    }

    public String getPixEnrollmentId() {
        return pixEnrollmentId;
    }

    public void setPixEnrollmentId(String pixEnrollmentId) {
        this.pixEnrollmentId = pixEnrollmentId;
    }

    public Long getNotifiedAt() {
        return notifiedAt;
    }

    public void setNotifiedAt(Long notifiedAt) {
        this.notifiedAt = notifiedAt;
    }

    public String getRawCallback() {
        return rawCallback;
    }

    public void setRawCallback(String rawCallback) {
        this.rawCallback = rawCallback;
    }

    @Override
    public String toString() {
        return "EbanxPayment{" +
                "id=" + id +
                ", version=" + version +
                ", createBy='" + createBy + '\'' +
                ", createAt=" + createAt +
                ", updateBy='" + updateBy + '\'' +
                ", updateAt=" + updateAt +
                ", status=" + status +
                ", subscriptionId=" + subscriptionId +
                ", userId=" + userId +
                ", appId=" + appId +
                ", ebanxPaymentId='" + ebanxPaymentId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", state='" + state + '\'' +
                ", failReason='" + failReason + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", token='" + token + '\'' +
                ", pixQrCode='" + pixQrCode + '\'' +
                ", pixEnrollmentId='" + pixEnrollmentId + '\'' +
                ", notifiedAt=" + notifiedAt +
                ", rawCallback='" + rawCallback + '\'' +
                '}';
    }
}
