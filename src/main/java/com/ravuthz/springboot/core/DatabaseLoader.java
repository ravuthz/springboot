package com.ravuthz.springboot.core;

import com.ravuthz.springboot.course.Course;
import com.ravuthz.springboot.course.CourseRepository;
import com.ravuthz.springboot.review.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 10:13 PM
 * Email : ravuthz@gmail.com
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository courses;
    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    @Autowired
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.debug("Creating courses ...");
        Course course1 = new Course("Java Basic", "http://teamtreehouse.com/library/java-basics");
        Course course2 = new Course("Big Data", "https://teamtreehouse.com/library/introduction-to-big-data");
        logger.debug("Rate the courses ...");
        course1.addReview(new Review(3, "It's good"));
        course2.addReview(new Review(5, "Wow, It's great"));
        courses.save(course1);
        courses.save(course2);
    }
}
