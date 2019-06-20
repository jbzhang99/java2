package com.rfchina.community.component.parking;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 */
public class PayMonthNotifyRequest extends AbstractParkingRequest {

    public static final int RENEW_DATA_TYPE_YEAR = 3;
    public static final int RENEW_DATA_TYPE_MONTH = 2;
    public static final int RENEW_DATA_TYPE_DAY = 1;

    private String parkingCode;

    private Long timestamp;

    private String carPlateNo;

    private String cardNo;

    private String serialNo;

    private String orderNo;

    private Integer renewDayType;

    private Integer dealDate;

    private Long payAmount;

    private String payTime;

    private Integer payChannel;

    private String payDesc;

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

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

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public Integer getRenewDayType() {
        return renewDayType;
    }

    public void setRenewDayType(Integer renewDayType) {
        this.renewDayType = renewDayType;
    }

    public Integer getDealDate() {
        return dealDate;
    }

    public void setDealDate(Integer dealDate) {
        this.dealDate = dealDate;
    }

    @Override
    public String toString() {
        return "PayMonthNotifyRequest{" +
                "parkingCode='" + parkingCode + '\'' +
                ", timestamp=" + timestamp +
                ", carPlateNo='" + carPlateNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", renewDayType=" + renewDayType +
                ", dealDate=" + dealDate +
                ", payAmount=" + payAmount +
                ", payTime='" + payTime + '\'' +
                ", payChannel=" + payChannel +
                ", payDesc='" + payDesc + '\'' +
                '}';
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put("parkingCode", this.parkingCode);
        map.put("carPlateNo", this.carPlateNo);
        map.put("timestamp", Optional.ofNullable(this.timestamp)
                .map((value) -> value.toString())
                .orElse(""));
        map.put("cardNo", this.cardNo);
        map.put("serialNo", this.serialNo);
        map.put("orderNo", this.orderNo);
        map.put("payAmount", Optional.ofNullable(this.payAmount)
                .map((value) -> value.toString())
                .orElse(""));
        map.put("payTime", this.payTime);
        map.put("payChannel", String.valueOf(this.payChannel));
        map.put("payDesc", this.payDesc);
        map.put("renewDayType", Optional.ofNullable(this.renewDayType)
                .map((value) -> value.toString())
                .orElse(""));
        map.put("dealDate", Optional.ofNullable(this.dealDate)
                .map((value) -> value.toString())
                .orElse(""));
        return map;
    }
}
