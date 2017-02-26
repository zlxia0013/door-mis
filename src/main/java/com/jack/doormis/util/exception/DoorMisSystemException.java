package com.jack.doormis.util.exception;


import com.jack.doormis.util.ReturnCodes;

public class DoorMisSystemException extends RuntimeException {
	private static final long	serialVersionUID	= 17874544414545L;

	private Integer				errorCode			= ReturnCodes.SYSTEM_EXCEPTION;

	// default construct
	public DoorMisSystemException() {
		super();
	}

	public DoorMisSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoorMisSystemException(String message, Throwable cause, Integer errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public DoorMisSystemException(String message) {
		super(message);
	}

	public DoorMisSystemException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public DoorMisSystemException(Throwable cause) {
		super(cause);
	}

	public DoorMisSystemException(Throwable cause, Integer errorCode) {
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