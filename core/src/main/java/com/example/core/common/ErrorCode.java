package com.example.core.common;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // User 관련 ErrorCode
    SAVE_FAILED(12000,"오류로 인한 회원가입 실패"),
    INTEGRITY_CONSTRAINT_VIOLATION(12001,"무결성 제약 조건 위반"),
    VERIFICATION_FAILED(12002,"입력값 검증 실패"),
    DATABASE_ERROR(12003,"데이터베이스 오류 발생"),
    ILLEGAL_ARGUMENT_EMAIL(12004,"email은 null이거나 비어 있을 수 없습니다."),
    ILLEGAL_ARGUMENT_ID(12005,"id는 null이거나 비어 있을 수 없습니다."),
    UPDATE_FAILED(12006,"user 정보 update 실패"),
    INCORRECT_PASSWORD(12007,"비밀번호가 다릅니다."),
    NO_EXIST(12008,"사용자를 찾을 수 없습니다."),
    AUTHENTICATION_FAIL(12009,"인증 실패 오류"),

    // Reservation 관련 ErrorCode
    RESERVATION_FAIL(52000, "예약 실패."),
    RESERVATION_SAVE_FAIL(52001,"예약 저장 실패"),
    NO_DATA(52002,"조회된 데이터 없음"),
    RESERVATION_DELETE_FAIL(52003,"예약 삭제 실패"),
    NO_RESERVATION_EXIST(52004,"존재하지 않는 예약입니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
