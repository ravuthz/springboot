package com.ravuthz.springboot;

import com.ravuthz.springboot.domain.Role;
import com.ravuthz.springboot.domain.User;
import com.ravuthz.springboot.repository.RoleRepository;
import com.ravuthz.springboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "com.ravuthz.springboot.domain")
@EnableJpaRepositories(basePackages = "com.ravuthz.springboot.repository")
public class SpringbootApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		logger.debug("DATASOURCE = " + dataSource);

		User ravuthz = userRepository.findByEmail("ravuthz@gmail.com");
        System.out.println("* ravuthz: " + ravuthz);

        List<String> roles = roleRepository.findRoleByEmail("ravuthz@gmail.com");

        for (String role : roles) {
            System.out.println("* ravuthz role: " + role);
        }

		for (User user : userRepository.findAll()) {
			System.out.println("* user: " + user);
		}

		for (Role role : roleRepository.findAll()) {
			System.out.println("* role: " + role);
		}
	}
}
