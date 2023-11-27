package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class AnimalTest {

    @Test
    public void testGetFood() throws Exception {
        Animal animalHerbivore = new Animal();
        Animal animalCarnivore = new Animal();
        assertEquals(List.of("Трава", "Различные растения"), animalHerbivore.getFood("Травоядное"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animalCarnivore.getFood("Хищник"));
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

