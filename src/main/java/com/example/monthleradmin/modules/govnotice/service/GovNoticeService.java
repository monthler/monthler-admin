package com.example.monthleradmin.modules.govnotice.service;

import com.example.monthleradmin.modules.category.domain.Category;
import com.example.monthleradmin.modules.category.repository.CategoryRepository;
import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import com.example.monthleradmin.modules.govnotice.form.GovNoticeForm;
import com.example.monthleradmin.modules.govnotice.repository.GovNoticeRepository;
import com.example.monthleradmin.modules.member.domain.Member;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GovNoticeService {

    private final GovNoticeRepository govNoticeRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Optional<GovNotice> getGovNotice(Long govNoticeId){
        Optional<GovNotice> govNotice = govNoticeRepository.findById(govNoticeId);
        return govNotice;
    }

    @Transactional
    public GovNoticeForm getGovNoticeForm(Long govNoticeId){
        GovNotice govNotice = govNoticeRepository.findById(govNoticeId).get();
        System.out.println(govNotice);
        GovNoticeForm govNoticeForm = modelMapper.map(govNotice, GovNoticeForm.class);
        govNoticeForm.settingThemeList(govNotice.getThemeList());
        return govNoticeForm;
    }

    @Transactional
    public void updateGovNotice(GovNoticeForm govNoticeForm, Member member) {
        GovNotice govNotice = modelMapper.map(govNoticeForm, GovNotice.class);
        govNotice.setMember(member);
        govNotice.settingThemeList(govNoticeForm.getThemeList(), categoryRepository.findAll());
        govNoticeRepository.save(govNotice);
    }

    @Transactional
    public List<GovNotice> getGovNoticeList() {
        return govNoticeRepository.findAll();
    }

    @Transactional
    public void deleteByGovNoticeId(Long govNoticeId) {
        govNoticeRepository.deleteById(govNoticeId);
    }
}