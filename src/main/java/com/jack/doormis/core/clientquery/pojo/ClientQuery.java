package com.jack.doormis.core.clientquery.pojo;


import java.util.Date;

public class ClientQuery {
	private Integer id;

	private Integer clientId;

	private Integer userId;

	private Date queryTime;
	
	// %%ONLY_FOR_INS_FLD%FI_JAVA_ENTITY_DECLARE%%

	public ClientQuery() {		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}
	
	// %%ONLY_FOR_INS_FLD%FI_JAVA_ENTITY_GET_SET%%
}
