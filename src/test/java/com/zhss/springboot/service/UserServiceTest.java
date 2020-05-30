package com.zhss.springboot.service;

import com.zhss.springboot.dao.UserDAO;
import com.zhss.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDAO userDAO;

    @Test
    public void testListUsers() throws Exception {

        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("test user");
        user.setAge(20);
        users.add(user);

        when(userDAO.listUsers()).thenReturn(users);
        assertEquals(users, userService.listUsers());
    }

    @Test
    public void testGetUserById() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("test user");
        user.setAge(20);

        when(userDAO.getUserById(userId)).thenReturn(user);
        assertEquals(user, userService.getUserById(userId));
    }


    @Test
    public void testSaveUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setName("test user");
        user.setAge(20);

        when(userDAO.saveUser(user)).thenReturn(userId);
        assertEquals(userId, userService.saveUser(user));
    }

    @Test
    public void testUpdateUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("test user");
        user.setAge(25);

        when(userDAO.updateUser(user)).thenReturn(Boolean.TRUE);
        assertTrue(userService.updateUser(user));
    }

    @Test
    public void testRemoveUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setName("test user");
        user.setAge(20);

        when(userDAO.removeUser(userId)).thenReturn(Boolean.TRUE);
        assertTrue(userService.removeUser(userId));
    }
}
