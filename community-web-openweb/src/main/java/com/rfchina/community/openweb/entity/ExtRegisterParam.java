package com.rfchina.community.openweb.entity;

public class ExtRegisterParam {
	private int type;//类型，2为个人，1为商家
	private String title; //公司全称
	private String titleSimple;//公司简称或品牌名
	private String email;//邮箱
	
	private String passwd; //密码
	private String rePasswd; //重复密码
	private String managerPhone;//管家账号 (存起来)
	
	private String contactPerson; //联系人
	private String idNumber; //身份证号码
	private String registrationNumber; //统一信用代码
	//地址信息
	private int provinceAreaId;
	private int cityAreaId;
	private int areaId;
	private String areaInfo;
	
	//银行信息
	private String bankTitle;
	private String bankAccountName;
	private String bankAccount;
	
	private String phoneCheckCode;//注册手机验证码
	
	private String serviceTitle;//店铺名称
	private String description; //店铺介绍
	
	private int categoryId;//服务分类
	private String communityIds;//服务范围
	
	
	
//	private String introduction; //公司介绍
//	private String businessScope;//经营范围
//	private String businessLicense; //营业执照
//	private String targetMonthTurnover;//目标月营业额
//	private String contactPhone; //联系人手机号
//	//身份证正反面
//	private String idObverse; 
//	private String idPositive;
//	
//	private int isOtherLicense;//其他资格证书
//	private String otherLicense;//其他资格证书
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleSimple() {
		return titleSimple;
	}
	public void setTitleSimple(String titleSimple) {
		this.titleSimple = titleSimple;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRePasswd() {
		return rePasswd;
	}
	public void setRePasswd(String rePasswd) {
		this.rePasswd = rePasswd;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getProvinceAreaId() {
		return provinceAreaId;
	}
	public void setProvinceAreaId(int provinceAreaId) {
		this.provinceAreaId = provinceAreaId;
	}
	public int getCityAreaId() {
		return cityAreaId;
	}
	public void setCityAreaId(int cityAreaId) {
		this.cityAreaId = cityAreaId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaInfo() {
		return areaInfo;
	}
	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}
	public String getBankTitle() {
		return bankTitle;
	}
	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getPhoneCheckCode() {
		return phoneCheckCode;
	}
	public void setPhoneCheckCode(String phoneCheckCode) {
		this.phoneCheckCode = phoneCheckCode;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCommunityIds() {
		return communityIds;
	}
	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}
	
	
	
}
