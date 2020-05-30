package com.zhss.springboot.dao;

import com.zhss.springboot.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UserDAOTest {


    ThreadLocal<User> theadLocalUsers = new ThreadLocal<>();
    @Autowired
    private UserDAO userDAO;

    @Before
    public void init() {
        User user = new User();
        user.setName("test user");
        user.setAge(20);
        userDAO.saveUser(user);
        theadLocalUsers.set(user);
    }

    @Test
    public void testListUsers() throws Exception {

        assertThat(userDAO.listUsers().size(), is(greaterThan(0)));
    }

    @Test
    public void testGetUserById() throws Exception {
        User resultData = theadLocalUsers.get();
        assertEquals(userDAO.getUserById(resultData.getId()).toString(), resultData.toString());
    }


    @Test
    public void testSaveUser() throws Exception {
        User resultData = theadLocalUsers.get();
        assertThat(resultData.getId(), is(greaterThan(0L)));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User resultData = theadLocalUsers.get();
        Integer age = resultData.getAge() + 10;
        User user = new User();
        user.setId(resultData.getId());
        user.setName("test user");
        user.setAge(age);

        userDAO.updateUser(user);
        User updatedUser = userDAO.getUserById(user.getId());
        assertEquals(updatedUser.getAge(), age);
    }

    @Test
    public void testRemoveUser() throws Exception {
        User resultData = theadLocalUsers.get();
        assertTrue(userDAO.removeUser(resultData.getId()));
    }
}
