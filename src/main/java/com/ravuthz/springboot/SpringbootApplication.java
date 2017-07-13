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

import javax.sql.DataSource;


@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
        logger.debug("DATASOURCE = " + dataSource);
        logger.debug("User Repository = " + userRepository);
        logger.debug("Role Repository = " + roleRepository);

        for (User user : userRepository.findAll()) {
            logger.debug(user.toString());
        }

        for (Role role : roleRepository.findAll()) {
            logger.debug(role.toString());
        }
	}
}
