package com.example.monthleradmin.modules.member.service;

import com.example.monthleradmin.modules.member.domain.Member;
import com.example.monthleradmin.modules.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository.findByMemberId(memberId);
    }
}
