package com.ravuthz.springboot.core;

import com.ravuthz.springboot.domain.Customer;
import com.ravuthz.springboot.domain.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/17, 12:08 AM
 * Email : ravuthz@gmail.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DatabaseLoaderTest {

    @Autowired
    private DatabaseLoader loader;

    @Test
    public void makeRoles() throws Exception {
        List<Role> roleList = loader.makeRoles();
        assertNotNull(roleList);
        Assert.assertEquals(3, roleList.size());
    }

    @Test
    public void makeCustomers() throws Exception {
        List<Customer> customerList = loader.makeCustomers();
        assertNotNull(customerList);
        assertEquals(3, customerList.size());
    }

    @Test
    public void assignCustomerRoleByEmail() throws Exception {
        String email = "admin@gmail.com";
        Customer customer = loader.assignCustomerRoleByEmail(email);
        assertNotNull(customer);
        assertEquals(email, customer.getEmail());
    }

    @Test
    public void assignRoleCustomerByEmail() throws Exception {
        String email = "manager@gmail.com";
        Role role = loader.assignRoleCustomerByEmail(email);
        assertNotNull(role);
        assertEquals(email, role.getCustomer().getEmail());
    }


}