package com.dxb.tdd.mockito.ppt;

import com.dxb.tdd.ppt.model.User;
import com.dxb.tdd.ppt.service.UserService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2020/2/25
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class MockByRuleTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private UserService userService;

    @Test
    public void testRule() {
//        UserService userService= Mockito.mock(UserService.class);

        User user = new User();
        when(userService.login("admin", "123456")).thenReturn(user);
        assertThat(userService.login("admin", "123456"), equalTo(user));
    }
}
