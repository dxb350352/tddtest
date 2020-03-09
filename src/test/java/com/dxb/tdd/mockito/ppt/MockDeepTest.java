package com.dxb.tdd.mockito.ppt;

import com.dxb.tdd.ppt.controller.UserController;
import com.dxb.tdd.ppt.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * User: dxb
 * Date: 2020/2/25
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
@RunWith(MockitoJUnitRunner.class)
public class MockDeepTest {
    @Mock
    private UserController userController;
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private UserController userControllerDeep;
    @Test
    public void testMock() {
        User user = userController.getUserService().login("x", "x");
        System.out.println(user);
    }
    @Test
    public void testDeepMock() {
        User user = userControllerDeep.getUserService().login("x", "x");
        System.out.println(user);
    }
}
