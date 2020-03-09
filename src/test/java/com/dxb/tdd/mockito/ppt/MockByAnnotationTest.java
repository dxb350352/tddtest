package com.dxb.tdd.mockito.ppt;

import com.dxb.tdd.ppt.model.User;
import com.dxb.tdd.ppt.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2020/2/24
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class MockByAnnotationTest {
    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private UserService userService;

    @Test
    public void testAnnotation() {
        User user = new User();
        when(userService.login("admin", "123456")).thenReturn(user);
        assertThat(userService.login("admin", "123456"), equalTo(user));
    }
}
