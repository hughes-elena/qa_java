package com.example;//Импортируем необходимые пакеты

import com.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

//Подключим Mockito в тестовый класс при помощи аннотации @RunWith с раннером MockitoJUnitRunner:
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock                            //создаем  аннотацией Мок интерфейса Predator
    Predator predator;              // Мок интерфейса Predator

    Lion lion;                  // Это настоящий объект для тестирования

    @Before                     //Этот метод будет выполняться перед каждым тестом
    public void setUp() throws Exception {
        lion = new Lion("Самец", predator);  //Создаем объект Lion и передаем в него мок Predator
    }

    // Тест, что метод public List<String> getFood()
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Мясо", "Птица"));      // Задаём поведение мока

        List<String> food = lion.getFood();                 // Проверяем, что lion вызывает predator.eatMeat()
        assertEquals(List.of("Мясо", "Птица"), food);

        Mockito.verify(predator, Mockito.times(1)).eatMeat();       // Проверяем, что метод вызван 1 раз// Проверяем, что метод вызван 1 раз
    }

    // Тест, что метод getKittens() возвращает значение, кот в мок
    @Test
    public void testGetKittens() {
        Mockito.when(predator.getKittens()).thenReturn(3);        // Мок возвращает 3
        assertEquals(3, lion.getKittens());                 // Проверяем, что Lion вернул 3
        Mockito.verify(predator).getKittens();                      // Проверяем вызов метода
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        // Проверяем исключение при неверном поле
        new Lion("Неизвестно", predator);
    }
}

