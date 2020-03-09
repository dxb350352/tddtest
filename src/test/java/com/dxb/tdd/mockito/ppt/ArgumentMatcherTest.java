package com.dxb.tdd.mockito.ppt;

import com.dxb.tdd.ppt.model.User;
import com.dxb.tdd.ppt.service.UserService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2020/2/25
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class ArgumentMatcherTest {

    @Test(expected = Exception.class)
    public void testAny() {
        UserService userService = Mockito.mock(UserService.class);
        when(userService.insert(anyInt(), anyString(), eq("123456"))).thenReturn(new User());
        assertNotNull(userService.insert(1, "222", "123456"));
        assertNull(userService.insert(1, "222", "xxx"));

        doThrow(Exception.class).when(userService).batch(anyListOf(User.class));
        userService.batch(new ArrayList<User>());

    }

    public void testIsAAny(){

    }
}
