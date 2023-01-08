package com.example.monthleradmin.modules.theme.domain;

import com.example.monthleradmin.modules.category.domain.Category;
import com.example.monthleradmin.modules.govnotice.domain.GovNotice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@NoArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long themeId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "govNoticeId")
    private GovNotice notice;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    public void addCategory(Category category){
        this.category = category;
    }

    public Theme(GovNotice notice, Category category) {
        this.notice = notice;
        this.category = category;
    }
}
