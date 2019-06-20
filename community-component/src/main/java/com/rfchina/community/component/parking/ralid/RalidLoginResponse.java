package com.rfchina.community.component.parking.ralid;

/**
 */
public class RalidLoginResponse {

    private String resultCode;

    private String resultMessage;

    private String resultData;

    private String payFee;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public String getPayFee() {
        return payFee;
    }

    public void setPayFee(String payFee) {
        this.payFee = payFee;
    }

    @Override
    public String toString() {
        return "RalidLoginResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", resultData='" + resultData + '\'' +
                ", payFee='" + payFee + '\'' +
                '}';
    }
}
