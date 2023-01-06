package com.example.monthleradmin.modules.member.repository;

import com.example.monthleradmin.modules.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberId (Long memberId);
}
