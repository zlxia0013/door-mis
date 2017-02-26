package com.jack.doormis.util.exception;


import com.jack.doormis.util.ReturnCodes;

public class DoorMisException extends Exception {
	private static final long	serialVersionUID	= 8589455703229910144L;

	private Integer				errorCode			= ReturnCodes.EXCEPTION;

	// default construct
	public DoorMisException() {
		super();
	}

	public DoorMisException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoorMisException(String message, Throwable cause, int errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public DoorMisException(String message) {
		super(message);
	}

	public DoorMisException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public DoorMisException(Throwable cause) {
		super(cause);
	}

	public DoorMisException(Throwable cause, int errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
