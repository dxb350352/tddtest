package com.dxb.tdd.mockito.ppt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * User: dxb
 * Date: 2019/11/28
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class ListTest {

    @Test(expected = MyException.class)
    public void get() {
        //接口都行
        List mockList = mock(List.class);
        //any
        when(mockList.get(anyInt() * 2)).thenReturn("-12");
        assertEquals("-12", mockList.get(1));
        assertEquals("-12", mockList.get(12));
        //重置mock
        reset(mockList);
        //还有这种操作
        when(mockList.get(0)).thenReturn(1).thenReturn(2).thenReturn(3,4);
        //模拟连续调用返回期望值，如果分开，则只有最后一个有效
        when(mockList.get(2)).thenReturn(1);
        when(mockList.get(2)).thenReturn(2);

        when(mockList.get(3)).thenThrow(new MyException());

        //
        assertEquals(1, mockList.get(0));
        assertEquals(2, mockList.get(0));
        assertEquals(3, mockList.get(0));
        assertEquals(4, mockList.get(0));
        assertEquals(4, mockList.get(0));
        assertEquals(4, mockList.get(0));
        //模拟连续调用返回期望值，如果分开，则只有最后一个有效
        assertEquals(2, mockList.get(2));

        assertEquals(null, mockList.get(1));
        //exception
        mockList.get(3);
    }

    class MyException extends RuntimeException {
    }
}
