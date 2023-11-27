package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class LionParamsTest {


    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean hasMane;

    @Parameterized.Parameters(name = "Пол льва: {0}; имеется ли грива: {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesLionHaveMane() throws Exception {
        Lion lion1 = new Lion("Самец");
        Lion lion2 = new Lion("Самка");
        assertTrue(lion1.doesHaveMane());
        assertFalse(lion2.doesHaveMane());
        assertThrows("Используйте допустимые значения пола животного - самец или самка", Exception.class, () -> new Lion("InvalidSex"));
    }
}
