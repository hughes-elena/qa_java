package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline; // создаём мок объекта Feline

    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline); // передаём мок в Cat
    }

    @Test
    public void getSoundTest() {

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        assertEquals(expected, cat.getFood());
        Mockito.verify(feline).eatMeat();
    }
}