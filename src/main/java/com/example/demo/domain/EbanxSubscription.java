import java.io.Serializable;
import java.util.Date;

public class EbanxSubscription implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;  // 主键
    private Integer version;  // 乐观锁
    private String createBy;  // 创建人
    private Long createAt;  // 创建时间(毫秒)
    private String updateBy;  // 更新人
    private Long updateAt;  // 修改时间(毫秒)
    private Integer status;  // 数据状态 0:正常 1:删除
    private Long userId;  // 本地用户ID
    private Integer appId;  // 应用ID
    private String subscriptionType;  // 订阅类型: card / pix
    private String state;  // 订阅状态: active / canceled / past_due / paused
    private Long currentProductId;  // 当前订阅的产品ID
    private Long currentPeriodStart;  // 当前周期起始时间
    private Long currentPeriodEnd;  // 当前周期结束时间
    private Long cancelAt;  // 计划取消时间(毫秒)
    private Long canceledAt;  // 已取消时间
    private String ebanxCustomerId;  // EBANX客户ID
    private String ebanxSubscriptionId;  // EBANX订阅ID(如有)
    private String cardToken;  // 长期信用卡Token(用于recurring)
    private String pixEnrollmentId;  // Pix签约ID(enrollment_id)
    private Long latestPaymentId;  // 最近一次支付ID
    private String metadata;  // 订阅元数据(JSON)

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
