package com.example.monthleradmin.modules.govnotice.repository;


import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import com.example.monthleradmin.modules.theme.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GovNoticeRepository extends JpaRepository<GovNotice, Long> {
}
