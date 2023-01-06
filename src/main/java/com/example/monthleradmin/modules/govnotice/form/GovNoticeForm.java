package com.example.monthleradmin.modules.govnotice.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class GovNoticeForm {

    private String title;
    private String region;
    private String city;
    private List<String> themeList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate stayStDt; // 체류 시작일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate stayEdDt; // 체류 종료일

    private Integer minNight; // 미션 최소 박수
    private Integer maxNight; // 미션 최대 박수
    private Integer recruitmentTeam; // 모집인원(몇 팀)
    private Integer minPeople; // 최소 인원
    private Integer maxPeople; // 최대 인원
    private Integer supportFund; // 지원금

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate recruitmentStDt; // 모집 기간 시작일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate recruitmentEdDt; // 모집 기간 종료일
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDt; // 선정 발표일

    private String withChildYn; // 아이 동반 여부 (Y/N)
    private String email;
    private String phoneNumber;
    private String noticeLink; // 모집공고 링크
    private String refFileUrl; // 관련 파일 Url (파일 주소 수동 입력)
    private String mainDesc; // 메인 설명
    private String detailDesc; // 상세 설명

}
