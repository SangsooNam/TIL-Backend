package com.til.config.errorhandling;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
	private ErrorCode errorCode;

	public BaseException(ErrorCode code) {
		super(code.getMessage());
		this.errorCode = code;
	}
}
