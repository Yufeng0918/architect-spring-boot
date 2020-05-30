package com.zhss.springboot.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhss.springboot.domain.User;
import com.zhss.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    public static final String BASE_USER_API = "/api/v1.0/user/";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testListUsers() throws Exception {

        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("test user");
        user.setAge(20);
        users.add(user);

        when(userService.listUsers()).thenReturn(users);
        mockMvc.perform(get(BASE_USER_API)).andExpect(content().json(JSONArray.toJSONString(users)));
    }

    @Test
    public void testGetUserById() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("test user");
        user.setAge(20);

        when(userService.getUserById(userId)).thenReturn(user);
        mockMvc.perform(get(BASE_USER_API + "{id}", userId)).andExpect(content().json(JSONObject.toJSONString(user)));
    }


    @Test
    public void testSaveUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setName("test user");
        user.setAge(20);

        when(userService.saveUser(user)).thenReturn(userId);
        mockMvc.perform(post(BASE_USER_API).contentType(MediaType.APPLICATION_JSON_UTF8).content(JSONObject.toJSONString(user))).andExpect(content().json("{'status': 'success', 'message': '新增用户ID为" + user.getId() + "'}"));
    }

    @Test
    public void testUpdateUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("test user");
        user.setAge(25);

        when(userService.updateUser(user)).thenReturn(Boolean.TRUE);
        mockMvc.perform(put(BASE_USER_API + "{id}", userId).contentType(MediaType.APPLICATION_JSON_UTF8).content(JSONObject.toJSONString(user))).andExpect(status().isOk()).andExpect(content().string("success"));
    }

    @Test
    public void testRemoveUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setName("test user");
        user.setAge(20);

        when(userService.removeUser(userId)).thenReturn(Boolean.TRUE);
        mockMvc.perform(delete(BASE_USER_API + "{id}", userId)).andExpect(content().string("success"));
    }
}
