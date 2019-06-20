package com.rfchina.community.component.mobike;

import java.io.Serializable;
import java.util.List;

/**
 */
public class PartnerloginObject implements Serializable {

    private List<String> address;

    private String authtoken;

    private String comment;

    private String country;

    private String credits;

    private String currency;

    private String deposit;

    private String h5Url;

    private String img;

    private String isfirstshare;

    private String mobileno;

    private String nation;

    private String nickname;

    private String progress;

    private String pushkey;

    private String requestedDeposit;

    private String rsacode;

    private String special_progress;

    private String tag;

    private String thirdPartInfo;

    private String userid;

    private String userimage;

    private String username;

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIsfirstshare() {
        return isfirstshare;
    }

    public void setIsfirstshare(String isfirstshare) {
        this.isfirstshare = isfirstshare;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getPushkey() {
        return pushkey;
    }

    public void setPushkey(String pushkey) {
        this.pushkey = pushkey;
    }

    public String getRequestedDeposit() {
        return requestedDeposit;
    }

    public void setRequestedDeposit(String requestedDeposit) {
        this.requestedDeposit = requestedDeposit;
    }

    public String getRsacode() {
        return rsacode;
    }

    public void setRsacode(String rsacode) {
        this.rsacode = rsacode;
    }

    public String getSpecial_progress() {
        return special_progress;
    }

    public void setSpecial_progress(String special_progress) {
        this.special_progress = special_progress;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getThirdPartInfo() {
        return thirdPartInfo;
    }

    public void setThirdPartInfo(String thirdPartInfo) {
        this.thirdPartInfo = thirdPartInfo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PartnerloginObject{" +
                "address=" + address +
                ", authtoken='" + authtoken + '\'' +
                ", comment='" + comment + '\'' +
                ", country='" + country + '\'' +
                ", credits='" + credits + '\'' +
                ", currency='" + currency + '\'' +
                ", deposit='" + deposit + '\'' +
                ", h5Url='" + h5Url + '\'' +
                ", img='" + img + '\'' +
                ", isfirstshare='" + isfirstshare + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", nation='" + nation + '\'' +
                ", nickname='" + nickname + '\'' +
                ", progress='" + progress + '\'' +
                ", pushkey='" + pushkey + '\'' +
                ", requestedDeposit='" + requestedDeposit + '\'' +
                ", rsacode='" + rsacode + '\'' +
                ", special_progress='" + special_progress + '\'' +
                ", tag='" + tag + '\'' +
                ", thirdPartInfo='" + thirdPartInfo + '\'' +
                ", userid='" + userid + '\'' +
                ", userimage='" + userimage + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartnerloginObject that = (PartnerloginObject) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (authtoken != null ? !authtoken.equals(that.authtoken) : that.authtoken != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (credits != null ? !credits.equals(that.credits) : that.credits != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (deposit != null ? !deposit.equals(that.deposit) : that.deposit != null) return false;
        if (h5Url != null ? !h5Url.equals(that.h5Url) : that.h5Url != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (isfirstshare != null ? !isfirstshare.equals(that.isfirstshare) : that.isfirstshare != null) return false;
        if (mobileno != null ? !mobileno.equals(that.mobileno) : that.mobileno != null) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (progress != null ? !progress.equals(that.progress) : that.progress != null) return false;
        if (pushkey != null ? !pushkey.equals(that.pushkey) : that.pushkey != null) return false;
        if (requestedDeposit != null ? !requestedDeposit.equals(that.requestedDeposit) : that.requestedDeposit != null)
            return false;
        if (rsacode != null ? !rsacode.equals(that.rsacode) : that.rsacode != null) return false;
        if (special_progress != null ? !special_progress.equals(that.special_progress) : that.special_progress != null)
            return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (thirdPartInfo != null ? !thirdPartInfo.equals(that.thirdPartInfo) : that.thirdPartInfo != null)
            return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (userimage != null ? !userimage.equals(that.userimage) : that.userimage != null) return false;
        return username != null ? username.equals(that.username) : that.username == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (authtoken != null ? authtoken.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (credits != null ? credits.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (h5Url != null ? h5Url.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (isfirstshare != null ? isfirstshare.hashCode() : 0);
        result = 31 * result + (mobileno != null ? mobileno.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (progress != null ? progress.hashCode() : 0);
        result = 31 * result + (pushkey != null ? pushkey.hashCode() : 0);
        result = 31 * result + (requestedDeposit != null ? requestedDeposit.hashCode() : 0);
        result = 31 * result + (rsacode != null ? rsacode.hashCode() : 0);
        result = 31 * result + (special_progress != null ? special_progress.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (thirdPartInfo != null ? thirdPartInfo.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (userimage != null ? userimage.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
