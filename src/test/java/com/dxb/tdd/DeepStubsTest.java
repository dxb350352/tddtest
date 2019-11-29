package com.dxb.tdd;

import lombok.Getter;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * User: dxb
 * Date: 2019/11/28
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class DeepStubsTest {
    //注解方式初始化《
    //RETURNS_DEEP_STUBS--自动创建依赖对象
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private People people;

    public DeepStubsTest() {
        //注解方式初始化》
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeepStubs() {
        when(people.getShoes().getSize()).thenReturn(40);
        assertEquals(40, people.getShoes().getSize());
    }

    class People {
        @Getter
        Shoes shoes;
    }

    class Shoes {
        @Getter
        int size;
    }
}
