package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline mockFeline;
    private Cat cat;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(mockFeline);
    }
    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodCallsPredatorEatMeat() throws Exception{
        cat.getFood();
        verify(mockFeline, times(1)).eatMeat();
    }

}
