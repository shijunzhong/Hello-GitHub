package com.paul;

public class JsonResult {
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;
	
	private int status;
	
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonResult() {
		super();
	}
	
	public JsonResult(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public static JsonResult success(Object data) {
		return new JsonResult(SUCCESS, data);
	}
	
	public static JsonResult failed(Object data) {
		return new JsonResult(FAILED, data);
	}
}
