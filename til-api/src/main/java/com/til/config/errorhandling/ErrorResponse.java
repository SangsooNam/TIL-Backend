package com.til.config.errorhandling;

import com.til.common.response.ApiStatus;
import com.til.domain.common.enums.ErrorCode;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private ApiStatus status;

	private ErrorResponse(ErrorCode status) {
		this.status = ApiStatus.of(status);
	}

	public static ErrorResponse of(ErrorCode status) {
		return new ErrorResponse(status);
	}
}
