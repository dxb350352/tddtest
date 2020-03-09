package com.dxb.tdd.mockito.ppt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2020/2/25
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    @Test
    public void testSpy() {
        List<String> list = new ArrayList<>();
        List<String> spy = Mockito.spy(list);
        //调用了真实方法
        spy.add("a");
        spy.add("b");
        assertThat(spy.get(0), equalTo("a"));
        assertThat(spy.get(1), equalTo("b"));
        assertThat(spy.size(), equalTo(2));
        //stub一下
        when(spy.size()).thenReturn(0);
        assertThat(spy.size(), equalTo(0));
    }

    @Test
    public void testMock() {
        List<String> mock = Mockito.mock(ArrayList.class);
        //不会调用真实方法
        mock.add("a");
        mock.add("b");
        assertThat(mock.get(0), nullValue());
        assertThat(mock.get(1), nullValue());
        assertThat(mock.size(), equalTo(0));
    }
}
