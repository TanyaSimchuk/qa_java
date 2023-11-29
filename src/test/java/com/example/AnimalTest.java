package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    @Parameterized.Parameter
    public String foodType;
    @Parameterized.Parameter(1)
    public String animalKind;

    @Parameterized.Parameters(name = "Тип животного {1} употребляет в рационе {0}")
    public static Object[][] data() {
        return new Object[][] {
                {"Трава, Различные растения", "Травоядное"},
                {"Животные, Птицы, Рыба", "Хищник"},
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = Arrays.asList(foodType.split(", "));
        assertEquals(expectedFood, animal.getFood(animalKind));
    }


    @Test(expected=Exception.class)
    public void testGetFoodException() throws Exception {
        Animal animal = new Animal();
        List<String> result = animal.getFood("Invalid Animal");
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String actualFamily = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actualFamily);
    }

}

