package com.example.monthleradmin.modules.category.domain;

import com.example.monthleradmin.modules.theme.domain.Theme;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// 추후 코드관리 테이블로 변환?
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String subject;

    @OneToMany(mappedBy = "category")
    List<Theme> themeList = new ArrayList<>();
}
