package com.til.domain.user.enums;

import com.til.domain.common.enums.SuccessCode;

import lombok.Getter;

@Getter
public enum UserSuccessCode implements SuccessCode {

    SUCCESS_JOIN("회원가입에 성공하였습니다."),
    SUCCESS_LOGIN("로그인에 성공하였습니다."),
    POSSIBLE_NICKNAME("사용 가능한 닉네임입니다.");

    private final String message;

    UserSuccessCode(String message) {
        this.message = message;
    }
}
