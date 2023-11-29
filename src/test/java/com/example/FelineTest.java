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
public class FelineTest {
    @Mock
    private Feline feline;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        feline = new Feline();
    }
    @Test
    public void testEatMeat() throws Exception {
        // Act
        List<String> food = feline.eatMeat();
        // Assert
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        // Assert
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittens() throws Exception {
        int result = feline.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void testGetKittensWithParam() throws Exception {
        int param = 4;
        int result = feline.getKittens(param);
        assertEquals(param, result);
    }

}