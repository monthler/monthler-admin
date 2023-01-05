package com.example.monthleradmin.modules.govnotice.controller;

import com.example.monthleradmin.modules.govnotice.form.GovNoticeForm;
import com.example.monthleradmin.modules.govnotice.service.GovNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class GovNoticeController {

    private final GovNoticeService govNoticeService;

    @GetMapping("/gov-notice")
    public String govNoticeListView() {
        return "pages/gov-notice/list";
    }

    @GetMapping("/gov-notice/add")
    public String newGovNoticeForm(Model model) {
        model.addAttribute(new GovNoticeForm());
        return "pages/gov-notice/add";
    }

//    @PostMapping(value = "/api/gov-notice")
//    public ResponseEntity<?> createGovNotice(@RequestBody GovNoticeRequestDto dto) {
//        // TODO: Member Spring Security 로 붙여야 함
//        govNoticeService.createGovNotice(dto);
//
//        // result
//        // TODO: 응답 처리 구조 생성 필요
//        HashMap<String,Object> result = new HashMap<>();
//        result.put("message", "정부공고 등록 완료.");
//        result.put("code", "00"); // success
//
//        return ResponseEntity.ok(result);
//    }

}
