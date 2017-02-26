package com.jack.doormis.util.exception;


import com.jack.doormis.util.ReturnCodes;

public class DoorMisRuntimeException extends RuntimeException {
	private static final long	serialVersionUID	= 3443937526999432007L;

	private Integer				errorCode			= ReturnCodes.RUNTIME_EXCEPTION;

	// default construct
	public DoorMisRuntimeException() {
		super();
	}

	public DoorMisRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoorMisRuntimeException(String message, Throwable cause, Integer errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public DoorMisRuntimeException(String message) {
		super(message);
	}

	public DoorMisRuntimeException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public DoorMisRuntimeException(Throwable cause) {
		super(cause);
	}

	public DoorMisRuntimeException(Throwable cause, Integer errorCode) {
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
