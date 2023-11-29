package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline mockFeline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(mockFeline,"Самка");
        when(mockFeline.getKittens()).thenReturn(1);
        int result = lion.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void testEatMeat() throws Exception {
        Lion lion = new Lion(mockFeline,"Самец");
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeException() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Invalid sex");
    }
}
