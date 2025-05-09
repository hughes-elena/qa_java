package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {
    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception { // Метод eatMeat() реализован в Feline и вызывает getFood("Хищник"), унаследованный от Animal. Мы проверяем, что возвращается правильный список для "Хищник".
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() { //Метод getFamily() переопределён в Feline и возвращает "Кошачьи".Этот метод есть в Animal, здесь мы тестируем поведение именно Feline.
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTestReturnOne() {
        assertEquals(1, feline.getKittens()); //Метод getKittens() переопределён в Feline и по умолчанию возвращает 1 (через вызов getKittens(1)).

    }
}