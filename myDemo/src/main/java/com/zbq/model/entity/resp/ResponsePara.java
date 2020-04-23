package com.zbq.model.entity.resp;

import java.io.Serializable;

public class ResponsePara
{
    private String rtnCode;


	private String rtnMsg;

	private String token;
	public String getRtnCode() {
		return rtnCode;
	}


	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}


	public String getRtnMsg() {
		return rtnMsg;
	}


	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}


	public String getToken() {
		return token;
	}


	public void setToken(Serializable serializable) {
		this.token = (String) serializable;
	}





}
