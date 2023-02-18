package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User userName = new User("name@vijay.com", "nam2020", "vijay", "kumar");
        userName.addRole(roleAdmin);
        User savedUser = userRepo.save(userName);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateUserWithTwoRole() {
        User userName = new User("name@vija.com", "nam2020", "vijay", "kumar"); // shouldnt be same unique constraint
                                                                                // violation
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);
        userName.addRole(roleEditor);
        userName.addRole(roleAssistant);
        User savedUser = userRepo.save(userName);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = userRepo.findAll();
        listUsers.forEach(user -> System.out.println(user.toString()));
    }

    @Test
    public void testGetUserById() {
        User userName = userRepo.findById(1).get();
        System.out.println(userName.toString());
        assertThat(userName).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        String updatedEmail = "testingWithUpdateTest@gmail.com";
        User userName = userRepo.findById(1).get();
        System.out.println(userName.toString());
        userName.setEnabled(true);
        userName.setEmail(updatedEmail);
        userRepo.save(userName);
        User UpdateduserName = userRepo.findById(1).get();
        assertEquals(UpdateduserName.getEmail(), updatedEmail);
    }

    @Test
    public void testUpdateUserRoles() {
        User userRavi = userRepo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);
        userRavi.getRoles().remove(roleEditor);
        userRavi.addRole(roleSalesperson);

        userRepo.save(userRavi);
    }

    @Test
    public void testDeleteuser() {
        Integer userId = 2;
        userRepo.deleteById(userId);
        ;
    }
}
