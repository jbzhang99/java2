package com.rfchina.community.component.parking;

/**
 */
public class GetParkingFeeResponse extends AbstractParkingResponse {

    private String carPlateNo;

    private String cardNo;

    private String enterTime;

    private String leaveTime;

    private String payTime;

    private Long payAmount;

    private Long specialAmount;

    private Long recAmount;

    private Integer payStatus;

    private Integer payType;

    private Long duration;

    private String serialNo;

    private String orderNo;

    private Long freeDuration;

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Long getSpecialAmount() {
        return specialAmount;
    }

    public void setSpecialAmount(Long specialAmount) {
        this.specialAmount = specialAmount;
    }

    public Long getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(Long recAmount) {
        this.recAmount = recAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getFreeDuration() {
        return freeDuration;
    }

    public void setFreeDuration(Long freeDuration) {
        this.freeDuration = freeDuration;
    }

    @Override
    public String toString() {
        return "GetParkingFeeResponse{" +
                "carPlateNo='" + carPlateNo + '\'' +
                ", status=" + status +
                ", cardNo='" + cardNo + '\'' +
                ", msg='" + msg + '\'' +
                ", enterTime='" + enterTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", payTime='" + payTime + '\'' +
                ", payAmount=" + payAmount +
                ", specialAmount=" + specialAmount +
                ", recAmount=" + recAmount +
                ", payStatus=" + payStatus +
                ", payType=" + payType +
                ", duration=" + duration +
                ", serialNo='" + serialNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", freeDuration=" + freeDuration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetParkingFeeResponse that = (GetParkingFeeResponse) o;

        if (carPlateNo != null ? !carPlateNo.equals(that.carPlateNo) : that.carPlateNo != null) return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (enterTime != null ? !enterTime.equals(that.enterTime) : that.enterTime != null) return false;
        if (leaveTime != null ? !leaveTime.equals(that.leaveTime) : that.leaveTime != null) return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (payAmount != null ? !payAmount.equals(that.payAmount) : that.payAmount != null) return false;
        if (specialAmount != null ? !specialAmount.equals(that.specialAmount) : that.specialAmount != null)
            return false;
        if (recAmount != null ? !recAmount.equals(that.recAmount) : that.recAmount != null) return false;
        if (payStatus != null ? !payStatus.equals(that.payStatus) : that.payStatus != null) return false;
        if (payType != null ? !payType.equals(that.payType) : that.payType != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (serialNo != null ? !serialNo.equals(that.serialNo) : that.serialNo != null) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        return freeDuration != null ? freeDuration.equals(that.freeDuration) : that.freeDuration == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (carPlateNo != null ? carPlateNo.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (enterTime != null ? enterTime.hashCode() : 0);
        result = 31 * result + (leaveTime != null ? leaveTime.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (payAmount != null ? payAmount.hashCode() : 0);
        result = 31 * result + (specialAmount != null ? specialAmount.hashCode() : 0);
        result = 31 * result + (recAmount != null ? recAmount.hashCode() : 0);
        result = 31 * result + (payStatus != null ? payStatus.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (freeDuration != null ? freeDuration.hashCode() : 0);
        return result;
    }
}
