package com.zbq.model.entity.resp;
/**
 * @author zhongyi
 * 2017年11月10日
 * ResponseResult
 */
public class ResponseResult extends ResponsePara{

	private String rtnCode;
	
	private String rtnMsg;
	private String rtnTime;
	
	private Object result;
	private long total;
	private long pageNum;
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
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getPageNum() {
		return pageNum;
	}
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	public String getRtnTime() {
		return rtnTime;
	}
	public void setRtnTime(String rtnTime) {
		this.rtnTime = rtnTime;
	}


}
