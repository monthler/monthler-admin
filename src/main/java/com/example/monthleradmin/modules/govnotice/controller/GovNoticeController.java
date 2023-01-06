package com.example.monthleradmin.modules.govnotice.controller;

import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import com.example.monthleradmin.modules.govnotice.form.GovNoticeForm;
import com.example.monthleradmin.modules.govnotice.service.GovNoticeService;
import com.example.monthleradmin.modules.member.domain.Member;
import com.example.monthleradmin.modules.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class GovNoticeController {

    private final GovNoticeService govNoticeService;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @GetMapping("/gov-notice")
    public String govNoticeListView(Model model) {
        model.addAttribute("govNoticeList", govNoticeService.getGovNoticeList());
        return "pages/gov-notice/list";
    }

    @GetMapping("/gov-notice/add")
    public String newGovNoticeForm(Model model) {
        model.addAttribute(new GovNoticeForm());
        return "pages/gov-notice/add";
    }

    @PostMapping("/gov-notice/add")
    public String newGovNoticeSubmit(@Valid GovNoticeForm govNoticeForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            //model.addAttribute(account);
            return "pages/gov-notice/add";
        }
        Member member = memberService.getMember(1L); // TODO: Security 적용 시 코드 변경
        govNoticeService.createGovNotice(modelMapper.map(govNoticeForm, GovNotice.class), member);
        return "redirect:/gov-notice";
    }

//    @GetMapping("/gov-notice/{govNoticeId}/edit")
//    public String updateGovNoticeForm(@PathVariable String path, @PathVariable("govNoticeId") GovNotice govNotice, Model model) {
//        model.addAttribute("govNoticeList", govNoticeService.getGovNoticeList());
//        return "pages/gov-notice/edit";
//    }

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
