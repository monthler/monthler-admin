package com.example.monthleradmin.modules.theme.domain;

import com.example.monthleradmin.modules.category.domain.Category;
import com.example.monthleradmin.modules.govnotice.domain.GovNotice;

import javax.persistence.*;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long themeId;

    @ManyToOne
    @JoinColumn(name = "govNoticeId")
    private GovNotice notice;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
