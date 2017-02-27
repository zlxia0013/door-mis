package com.jack.doormis.core.client.pojo;


import java.util.Date;

public class Client  {
	private Integer id;

	private Integer verNbr;

	private String realName;

	private String code;

	private String phone;

	private String address;

	private String wechat;

	private String logistics;

	private String remark;

	private Integer addUserId;

	private Date addTime;

	private Integer softDel;

	private Integer delUserId;

	private Date delTime;
	
	// %%ONLY_FOR_INS_FLD%FI_JAVA_ENTITY_DECLARE%%

	public Client() {		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVerNbr() {
		return verNbr;
	}

	public void setVerNbr(Integer verNbr) {
		this.verNbr = verNbr;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getLogistics() {
		return logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(Integer addUserId) {
		this.addUserId = addUserId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getSoftDel() {
		return softDel;
	}

	public void setSoftDel(Integer softDel) {
		this.softDel = softDel;
	}

	public Integer getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(Integer delUserId) {
		this.delUserId = delUserId;
	}

	public Date getDelTime() {
		return delTime;
	}

	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}
	
	// %%ONLY_FOR_INS_FLD%FI_JAVA_ENTITY_GET_SET%%
}
