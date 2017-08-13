package com.ravuthz.springboot.core;

import com.ravuthz.springboot.domain.Category;
import com.ravuthz.springboot.domain.Customer;
import com.ravuthz.springboot.domain.Product;
import com.ravuthz.springboot.domain.Role;
import com.ravuthz.springboot.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 7/21/17, 9:24 PM
 * Email : ravuthz@gmail.com
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    private Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomerRepository customerRepository;

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DatabaseLoader(
            UserRepository userRepository,
            RoleRepository roleRepository,
            CustomerRepository customerRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.customerRepository = customerRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.debug("Datasource : ", dataSource);

        makeRoles();
        makeCustomers();
        assignCustomersRoles();

        makeCategories();
        makeProducts();
        addProductsToCategories();

    }

    private Customer generateCustomer(String name) {
        Customer customer = new Customer(name, name + "@gmail.com", "123123");
        return customer;
    }

    private void makeRoles() {
        logger.debug("Creating roles ...");
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("admin@gmail.com", "ROLE_ADMIN"));
        roles.add(new Role("manager@gmail.com", "ROLE_MANAGER"));
        roles.add(new Role("ravuthz@gmail.com", "ROLE_CUSTOMER"));
        roleRepository.save(roles);
        logger.debug("There are " + roles.size() + " roles were created.");
    }

    private void makeCustomers() {
        logger.debug("Creating customers ...");
        List<Customer> customers = new ArrayList<>();
        customers.add(generateCustomer("admin"));
        customers.add(generateCustomer("manager"));
        customers.add(generateCustomer("ravuthz"));
        customerRepository.save(customers);
        logger.debug("There are " + customers.size() + " customers was created.");
    }

    private void assignCustomerRoleByEmail(String email) {
        Role role = roleRepository.findByEmail(email);
        Customer customer = customerRepository.findByEmail(email);
        customer.getRoles().add(role);
        customerRepository.save(customer);
        logger.info(role.toString());
        logger.info(customer.toString());
    }

    private void assignRoleCustomerByEmail(String email) {
        Role role = roleRepository.findByEmail(email);
        Customer customer = customerRepository.findByEmail(email);
        role.setCustomer(customer);
        roleRepository.save(role);
        logger.info(role.toString());
        logger.info(customer.toString());
    }

    private void assignCustomersRoles() {
        logger.debug("Assign role to customer ...");
        assignCustomerRoleByEmail("admin@gmail.com");
        assignRoleCustomerByEmail("manager@gmail.com");
        assignRoleCustomerByEmail("ravuthz@gmail.com");
        logger.debug("Customers were assigned roles.");
    }

    private Product generateProduct(String name, Double price, int unitInStock) {
        Product product = new Product();
        product.setDate(new Date());
        product.setName(name);
        product.setPrice(price);
        product.setCondition("LARGE");
        product.setSummary("Large " + name);
        product.setUnitInStock(unitInStock);
        product.setDescription("New Large " + name);
        return product;
    }

    private void makeCategories() {
        logger.debug("Creating categories ...");
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("clothes", "shirt"));
        categories.add(new Category("clothes", "pant"));
        categories.add(new Category("clothes", "shoes"));
        categoryRepository.save(categories);
        logger.debug("There are " + categories.size() + " categories were created.");

        categories = (List<Category>) categoryRepository.findAll();
        logger.debug(categories.toString());
    }

    private void makeProducts() {
        logger.debug("Creating products ...");
        List<Product> products = new ArrayList<>();
        products.add(generateProduct("pant", 200.00, 10));
        products.add(generateProduct("shoes", 220.00, 20));
        products.add(generateProduct("shirt", 110.50, 10));
        productRepository.save(products);
        logger.debug("There are " + products.size() + " products were created.");

        products  = (List<Product>) productRepository.findAll();
        logger.debug(products.toString());
    }

    private void addProductCategoryByName(String name) {
        Product product = productRepository.findByName(name);

        List<Category> categories = (List<Category>) categoryRepository.findAll();
        logger.debug(categories.toString());

//        Category category = categoryRepository.findByMainCategoryName(name);
//        product.setCategory(category);
//        productRepository.save(product);
//        logger.debug(product.toString());
//        logger.debug(category.toString());
    }

    private void addProductsToCategories() {
        logger.debug("Add products to categories ...");
        addProductCategoryByName("pant");
        addProductCategoryByName("shoes");
        addProductCategoryByName("shirt");
        logger.debug("Products were added to categories.");
    }
}
