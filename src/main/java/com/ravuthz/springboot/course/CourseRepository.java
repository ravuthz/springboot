package com.ravuthz.springboot.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:54 PM
 * Email : ravuthz@gmail.com
 */
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    @RestResource(rel = "title-contains", path = "contains")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable pageable);
}
