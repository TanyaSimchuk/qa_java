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
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }
    @Test(expected = Exception.class)
    public void doesHaveManeException() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Invalid sex");
    }

}
