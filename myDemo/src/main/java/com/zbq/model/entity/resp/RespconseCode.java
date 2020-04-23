package com.zbq.model.entity.resp;
/**
 * @author zhongyi
 * 2017年11月10日
 * RespconseCode
 */
public enum RespconseCode {

	SUCCESS ("000000", "处理成功"),
	FAIL    ("999999", "处理失败"),
	NOTAUTH ("000403", "认证失败"),
	ILLEGALFILE("000402", "文件不合法");
	
	private String code;
	
	private String value;

	private RespconseCode(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
