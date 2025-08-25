package com.example.demo.domain;

import java.io.Serializable;

public class EbanxPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;  // 主键
    private Integer version;  // 乐观锁
    private String createBy;  // 创建人
    private Long createAt;  // 创建时间(毫秒)
    private String updateBy;  // 更新人
    private Long updateAt;  // 修改时间(毫秒)
    private Integer status;  // 数据状态 0:正常 1:删除

    private Long subscriptionId;  // 关联的订阅ID
    private Long userId;  // 用户ID
    private Integer appId;  // 应用ID

    // 支付信息
    private String ebanxPaymentId;  // EBANX支付ID
    private String orderNo;  // 业务订单号
    private Double amount;  // 支付金额
    private String currency;  // 货币

    // 状态
    private String state;  // 支付状态: pending / success / failed / refunded
    private String failReason;  // 失败原因

    // 支付方式
    private String paymentMethod;  // 支付方式: card / pix
    private String token;  // 本次支付的token(一次性token，仅调试用)

    // Pix 特有
    private String pixQrCode;  // Pix支付二维码
    private String pixEnrollmentId;  // Pix签约ID

    // 回调/对账
    private Long notifiedAt;  // 最后一次收到回调的时间
    private String rawCallback;  // Webhook回调原始数据

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
}
