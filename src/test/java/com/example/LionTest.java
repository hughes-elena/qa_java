package com.example;//Импортируем необходимые пакеты

import com.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.junit.Assert.*;

//Подключим Mockito в тестовый класс при помощи аннотации @RunWith с раннером MockitoJUnitRunner:
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock                            //создаем  аннотацией Мок интерфейса Predator
    Feline feline;              // Мок интерфейса Feline

    Lion lion;                  // Это настоящий объект для тестирования

    @Before                     //Этот метод будет выполняться перед каждым тестом
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);  //Создаем объект Lion и передаем в него мок feline
    }

    // Тест, что метод public List<String> getFood()
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Птица"));      // Задаём поведение мока

        List<String> food = lion.getFood();                 // Проверяем, что lion вызывает predator.eatMeat()
        assertEquals(List.of("Мясо", "Птица"), food);

        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");       // Проверяем, что метод вызван 1 раз// Проверяем, что метод вызван 1 раз


    // Тест, что метод getKittens() возвращает значение, кот в мок
    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(3);        // Мок возвращает 3
        assertEquals(3, lion.getKittens());                 // Проверяем, что Lion вернул 3
        Mockito.verify(feline).getKittens();                      // Проверяем вызов метода
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        // Проверяем исключение при неверном поле
        new Lion("Неизвестно", feline);
    }
}

