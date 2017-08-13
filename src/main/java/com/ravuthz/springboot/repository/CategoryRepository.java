package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vannaravuth Yo
 * Date : 8/13/17, 4:01 PM
 * Email : ravuthz@gmail.com
 */

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findByMainCategoryName(String name);
    Category findBySubCategoryName(String name);
}
