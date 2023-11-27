package com.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Lion lion;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            lion = new Lion("Самец");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetKittens() {
        int result = lion.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
