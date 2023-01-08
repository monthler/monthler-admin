package com.example.monthleradmin.modules.govnotice.service;

import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import com.example.monthleradmin.modules.govnotice.repository.GovNoticeRepository;
import com.example.monthleradmin.modules.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GovNoticeService {

    private final GovNoticeRepository govNoticeRepository;

    @Transactional
    public Optional<GovNotice> getGovNotice(Long govNoticeId){
        return govNoticeRepository.findById(govNoticeId);
    }

    @Transactional
    public void createGovNotice(GovNotice govNotice, Member member) {
        govNotice.setMember(member);
        System.out.println(govNotice.getGovNoticeId());
        govNoticeRepository.save(govNotice);
        System.out.println(govNotice.getGovNoticeId());
    }

    @Transactional
    public List<GovNotice> getGovNoticeList() {
        return govNoticeRepository.findAll();
    }

    @Transactional
    public void deleteByGovNoticeId(Long govNoticeId) {

    }
}