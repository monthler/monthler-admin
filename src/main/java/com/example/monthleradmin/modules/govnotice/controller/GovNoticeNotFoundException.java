package com.example.monthleradmin.modules.govnotice.controller;

// 2xx -> OK
// 4XX -> Client 요청오류
// 5XX -> Server 오류

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 공고번호가 존재하는 것은 서버오류가 아닌 클라이언트에서 잘못된 요청이기 때문에 404 처리
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GovNoticeNotFoundException extends RuntimeException {
    public GovNoticeNotFoundException(String message) {
        super(message);
    }
}
