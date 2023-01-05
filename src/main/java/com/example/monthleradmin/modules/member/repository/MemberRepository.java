package com.example.monthleradmin.modules.member.repository;

import com.example.monthleradmin.modules.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
