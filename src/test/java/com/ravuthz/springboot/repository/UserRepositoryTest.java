package com.ravuthz.springboot.repository;

import com.ravuthz.springboot.domain.Role;
import com.ravuthz.springboot.domain.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.List;

/**
 * Created by ravuthz on 7/9/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.JVM)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void setUpUser() {
        Role userRole = roleRepository.save(new Role("USER"));
        Role adminRole = roleRepository.save(new Role("ADMIN"));

        User user = new User();
        user.setLastName("yo");
        user.setFirstName("ravuthz");
        user.setEmail("ravuthz@gmail.com");
        user.setPassword("123123");
        user.setActive(1);
        user.setRoles(new HashSet<>(Arrays.asList(adminRole)));
    }

    private User getStaticUser() {
        return userRepository.findByEmail("ravuthz@gmail.com");
    }

    @Test
    public void createUser() {
        Role role = roleRepository.findByRole("USER");
        User user = new User("ravuth1@gmal.com", "123123", new HashSet<>(Arrays.asList(role)));
        user.setFirstName("ravuth1");
        user.setLastName("yo");
        User createdUser = userRepository.save(user);
        Assert.assertEquals(createdUser, user);
        Assert.assertThat(createdUser, Matchers.equalTo(user));
    }

    @Test
    public void updateUser() {
        User user = userRepository.findByEmail("ravuth1@gmal.com");
        user.setFirstName("ravuth2");
        user.setEmail("ravuth2@gmal.com");
        User updatedUser = userRepository.save(user);
        Assert.assertNotEquals(updatedUser.getEmail(), "ravuth1@gmal.com");
        Assert.assertEquals(updatedUser.getEmail(), "ravuth2@gmal.com");
    }

    @Test
    public void showUser() {
        User oldUser = getStaticUser();
        User foundUser1 = userRepository.findOne(oldUser.getId());
        User foundUser2 = userRepository.findByEmail(oldUser.getEmail());
        Assert.assertEquals(foundUser1, oldUser);
        Assert.assertEquals(foundUser2, oldUser);
    }

    @Test
    public void listUser() {
        User oldUser = getStaticUser();
        List<User> userList = userRepository.findAll();
        Assert.assertTrue(userList.contains(oldUser));
        Assert.assertThat(userList.size(), Matchers.greaterThan(0));
    }


    @Test
    public void deleteUser() throws Exception {
        User oldUser = getStaticUser();
        userRepository.delete(oldUser);
        List<User> userList = userRepository.findAll();
        User deleledUser = userRepository.findOne(oldUser.getId());
        Assert.assertFalse(userList.contains(oldUser));
        Assert.assertEquals(deleledUser, null);
    }

}