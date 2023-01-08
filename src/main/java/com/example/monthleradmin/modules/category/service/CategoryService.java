package com.example.monthleradmin.modules.category.service;

import com.example.monthleradmin.modules.category.domain.Category;
import com.example.monthleradmin.modules.category.repository.CategoryRepository;
import com.example.monthleradmin.modules.govnotice.form.GovNoticeForm;
import com.example.monthleradmin.modules.theme.domain.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Long> getCategoryIdList(List<String> themeList){
        List<Long> categoryIdList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for(int i=0; i<categoryList.size(); i++){
            if(themeList.contains(categoryList.get(i).getSubject())){
                // System.out.println("테마명 = " + categoryList.get(i).getSubject() + " categoryID = " + categoryList.get(i).getCategoryId());
                categoryIdList.add(categoryList.get(i).getCategoryId());
            }
        }
        return categoryIdList;
    }

    @Transactional
    public void getThemeList(GovNoticeForm govNoticeForm){
        List<Category> categoryList = categoryRepository.findAll();

        for(int i=0; i<categoryList.size(); i++){
            if(govNoticeForm.getThemeStringList().contains(categoryList.get(i).getSubject())){
                System.out.println("테마명 = " + categoryList.get(i).getSubject() + " categoryID = " + categoryList.get(i).getCategoryId());
                Theme theme = new Theme();
                theme.addCategory(categoryList.get(i));
                govNoticeForm.getThemeList().add(new Theme());
            }
        }
    }

}
