package com.zbq.model.entity.resp;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RespTVM
{
	private String ver;
	private String deviceId;
    private String responseCode;

    public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	private String responseMsg;
    @JsonFormat(pattern="yyyyMMddHHmmss", timezone="GMT+8")
    private Date responseDate;
    
    public String getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(String responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getResponseMsg()
    {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg)
    {
        this.responseMsg = responseMsg;
    }

    public Date getResponseDate()
    {
        return responseDate;
    }

    public void setResponseDate(Date responseDate)
    {
        this.responseDate = responseDate;
    }
    
    
    
    
    

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
