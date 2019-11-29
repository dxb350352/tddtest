package com.dxb.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * User: dxb
 * Date: 2019/11/29
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class RealPartialMockTest {
    @Test
    public void real_partial_mock() {
        //通过spy来调用真实的api
        List list = spy(new ArrayList());
        assertEquals(0, list.size());
        A a = mock(A.class);
        //通过thenCallRealMethod来调用真实的api
        when(a.doSomething(anyInt())).thenCallRealMethod();
        assertEquals(999, a.doSomething(999));
    }


    class A {
        public int doSomething(int i) {
            return i;
        }
    }
}
