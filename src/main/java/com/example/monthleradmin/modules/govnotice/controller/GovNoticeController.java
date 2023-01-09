package com.example.monthleradmin.modules.govnotice.controller;

import com.example.monthleradmin.modules.category.domain.Category;
import com.example.monthleradmin.modules.category.service.CategoryService;
import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import com.example.monthleradmin.modules.govnotice.form.GovNoticeForm;
import com.example.monthleradmin.modules.govnotice.service.GovNoticeService;
import com.example.monthleradmin.modules.member.domain.Member;
import com.example.monthleradmin.modules.member.service.MemberService;
import com.example.monthleradmin.modules.theme.domain.Theme;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class GovNoticeController {

    private final GovNoticeService govNoticeService;
    private final MemberService memberService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping("/gov-notice")
    public String govNoticeListView(Model model) {
        model.addAttribute("govNoticeList", govNoticeService.getGovNoticeList());
        return "pages/gov-notice/list";
    }

    @GetMapping("/gov-notice/{govNoticeId}")
    public String govNoticeDetail(@PathVariable Long govNoticeId, Model model){
        model.addAttribute("govNotice", govNoticeService.getGovNotice(govNoticeId).get());
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
        govNoticeService.updateGovNotice(govNoticeForm, member);

        // HTTP Status Code제어 - RestContoller 에서는 이걸로 반환하는데 뷰에다가 이 정도를 어떻게 추가하지...?
        /*URI location = ServletUriComponentsBuilder.fromCurrentRequest() // 현재경로
                .path("/{govNoticeId}")
                .buildAndExpand(member.getMemberId())
                .toUri();
        */
        return "redirect:/gov-notice";
    }

    @DeleteMapping("/gov-notice/{govNoticeId}")
    public String deleteGovNotice(@PathVariable Long govNoticeId){
        govNoticeService.deleteByGovNoticeId(govNoticeId);
        return "redirect:/gov-notice";
    }

    @GetMapping("/gov-notice/{govNoticeId}/edit")
    public String editGovNoticeForm(@PathVariable Long govNoticeId, Model model){
        model.addAttribute(govNoticeService.getGovNoticeForm(govNoticeId));
        return "pages/gov-notice/edit";
    }

    @PostMapping("/gov-notice/{govNoticeId}/edit")
    public String editGovNoticeForm(@PathVariable Long govNoticeId, @Valid GovNoticeForm govNoticeForm){
        Member member = memberService.getMember(1L); // TODO: Security 적용 시 코드 변경
        govNoticeService.updateGovNotice(govNoticeForm, member);
        return "redirect:/gov-notice/" + govNoticeId;
    }


}
