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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    // gov-notice 상세조회 (여기서 edit)
    @ResponseBody
    @GetMapping("/gov-notice/{govNoticeId}")
    public String retrieveGovNotice(@PathVariable Long govNoticeId, Model model){
        Optional<GovNotice> govNotice = govNoticeService.getGovNotice(govNoticeId);

        // 에러 핸들링
        if(!govNotice.isPresent()){
            throw new GovNoticeNotFoundException(String.format("상세조회하신 [%s] 가 존재하지 않습니다", govNoticeId));
        }

        // 추후 헤테오스 추가 적용??
        
        // 임시 테스트용 페이지 list.html 복붙 - 한개공고만 뜸
        model.addAttribute("govNotice", govNotice.get());
        return "pages/gov-notice/detail";
    }

    @GetMapping("/gov-notice/add")
    public String newGovNoticeForm(Model model) {
        model.addAttribute(new GovNoticeForm());
        return "pages/gov-notice/add";
    }

    @PostMapping("/gov-notice/add")
    public String newGovNoticeSubmit(@Valid GovNoticeForm govNoticeForm, Errors errors, Model model) {

        // 추후 handleGovNoticeNotFoundExceptions에서 에러 발생
        if (errors.hasErrors()) {
            //model.addAttribute(account);
            return "pages/gov-notice/add";
        }


        Member member = memberService.getMember(1L); // TODO: Security 적용 시 코드 변경

        // 여러개의 카테고리
        // govNoticeForm안에 themeList
        List<String> list = govNoticeForm.getThemeList();
        for(String theme : list){
            System.out.println("카테고리 테스트 " + theme);
        }
        govNoticeService.createGovNotice(modelMapper.map(govNoticeForm, GovNotice.class), member);

        // HTTP Status Code제어 - RestContoller 에서는 이걸로 반환하는데 뷰에다가 이 정도를 어떻게 추가하지...?
        /*URI location = ServletUriComponentsBuilder.fromCurrentRequest() // 현재경로
                .path("/{govNoticeId}")
                .buildAndExpand(member.getMemberId())
                .toUri();
        */
        return "redirect:/gov-notice";
    }

    @DeleteMapping("/gov-notice/{govNoticeId}")
    public void deleteGovNotice(@PathVariable Long govNoticeId){
        // 삭제 기능 마저 구현 하기 gss
        govNoticeService.deleteByGovNoticeId(govNoticeId);
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
