package com.ravuthz.springboot.core;

import com.ravuthz.springboot.course.Course;
import com.ravuthz.springboot.course.CourseRepository;
import com.ravuthz.springboot.review.Review;
import com.ravuthz.springboot.user.User;
import com.ravuthz.springboot.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 10:13 PM
 * Email : ravuthz@gmail.com
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);
    private final CourseRepository courses;
    private final UserRepository users;

    private List<User> userList;

    @Autowired
    public DatabaseLoader(CourseRepository courses, UserRepository users) {
        this.courses = courses;
        this.users = users;
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
        logger.debug("Generate the users ...");
        generateUsers();
        logger.debug("Random the course ...");
        randomCourses();
    }

    private void randomCourses() {
        String[] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
                "%s for Neckbeards",
                "Under the hood: %s"
        };
        String[] buzzwords = {
                "String REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "Spring HATEOAS"
        };

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];
                    String title = String.format(template, buzzword);
                    Course course = new Course(title, "http://www.test-courses.com");
                    Review review = new Review((i % 5) + 1, String.format("Moar %s please !!!!!", buzzword));
                    review.setReviewer(userList.get(i % userList.size()));
                    course.addReview(review);
                    bunchOfCourses.add(course);
                });
        courses.save(bunchOfCourses);
    }

    private void generateUsers() {
        String adminRole = "ROLE_ADMIN";
        String userRole = "ROLE_USER";
        userList = Arrays.asList(
                new User("ravuth", "yo", "admin", "123123", new String[]{adminRole, userRole}),
                new User("ravuth", "yo", "ravuthz", "123123", new String[]{adminRole}),
                new User("ravuth", "yo", "ravuth1", "123123", new String[]{userRole}),
                new User("ravuth", "yo", "ravuth2", "123123", new String[]{userRole}),
                new User("ravuth", "yo", "ravuth3", "123123", new String[]{userRole})
        );
        users.save(userList);
    }
}
