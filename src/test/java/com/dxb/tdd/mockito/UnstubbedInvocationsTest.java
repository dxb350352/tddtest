package com.dxb.tdd.mockito;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2019/11/29
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class UnstubbedInvocationsTest {
    @Test
    public void unstubbed_invocations() {
        //mock对象使用Answer来对未预设的调用返回默认期望值
        List mock = mock(List.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return 999;
            }
        });
//        List mock = mock(List.class, (invocation) -> 999);
        //下面的get(1)没有预设，通常情况下会返回NULL，但是使用了Answer改变了默认期望值
        assertEquals(999, mock.get(1));
        //下面的size()没有预设，通常情况下会返回0，但是使用了Answer改变了默认期望值
        assertEquals(999, mock.size());
        assertEquals(999, mock.indexOf(1));
        assertEquals(999, mock.remove(1));
        assertEquals(999, mock.remove(1));
        when(mock.get(1)).thenReturn("-99");
        //类型都不同了！！！
        assertEquals("-99", mock.get(1));
    }
}
