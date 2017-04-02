package com.binaryhunter.framework.exception;
import org.apache.commons.lang.exception.ExceptionUtils;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String errorCode = null;

	protected String[] errorArgs = null;

	private String errorMessage = null;
	
	private Object customObj;

	public BusinessException() {
		super();
	}

	public BusinessException(Throwable e) {
		super(e);
		this.errorMessage = ExceptionUtils.getStackTrace(e);
	}

	public BusinessException(String errorCode, String[] errorArgs) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	public BusinessException(String errorCode, String errorMessage) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BusinessException(String errorCode, String errorMessage, String[] errorArgs) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorArgs = errorArgs;
	}

	public BusinessException(String errorCode, String[] errorArgs, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	public BusinessException(String errorCode, String errorArg, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.errorArgs = new String[] { errorArg };
	}

	public BusinessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public BusinessException(String errorMessage, Throwable cause) {
		super(errorMessage,cause);
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		if (errorMessage != null) {
			return errorMessage;
		}
		if (super.getMessage() != null)
			return super.getMessage();
		return errorMessage;

	}

	public String getMessageDetail() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Object getCustomObj() {
		return customObj;
	}

	public void setCustomObj(Object customObj) {
		this.customObj = customObj;
	}
}