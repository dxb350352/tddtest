package com.dxb.tdd.mockito.ppt;

import com.dxb.tdd.ppt.controller.UserController;
import com.dxb.tdd.ppt.model.User;
import com.dxb.tdd.ppt.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2020/2/19
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;
    UserController userController;

    @Before
    public void before() {
//        this.userService = Mockito.mock(UserService.class);
        this.userController = new UserController(this.userService);
    }
    @Test
    public void testLogin() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        when(request.getParameter("userName")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");
        when(userService.login("admin", "123456")).thenReturn(new User());
        assertThat(userController.login(request), equalTo("login success"));
        when(request.getParameter("userName")).thenReturn("nobody");
        assertThat(userController.login(request), equalTo("No such user"));
    }

}
