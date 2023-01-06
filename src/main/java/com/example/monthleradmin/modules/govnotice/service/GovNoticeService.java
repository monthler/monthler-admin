package com.example.monthleradmin.modules.govnotice.service;

import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import com.example.monthleradmin.modules.govnotice.dto.GovNoticeRequestDto;
import com.example.monthleradmin.modules.govnotice.repository.GovNoticeRepository;
import com.example.monthleradmin.modules.member.domain.Member;
import com.example.monthleradmin.modules.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GovNoticeService {

    private final GovNoticeRepository govNoticeRepository;

    @Transactional
    public void createGovNotice(GovNotice govNotice, Member member) {
        govNoticeRepository.save(govNotice);
        govNotice.setMember(member);
    }

    @Transactional
    public List<GovNotice> getGovNoticeList() {
        return govNoticeRepository.findAll();
    }
}