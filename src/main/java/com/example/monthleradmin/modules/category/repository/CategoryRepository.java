package com.example.monthleradmin.modules.category.repository;

import com.example.monthleradmin.modules.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
