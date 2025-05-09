package com.example;

import java.util.List;

/*
 * Класс Feline (Кошачьи) наследует от Animal и реализует интерфейс Predator.
 * 1. Feline - это Animal (наследует все его методы и поля)
 * 2. Feline - это Predator (обязан реализовать все методы интерфейса) */

public class Feline extends Animal implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {          // Реализация метода eatMeat() из интерфейса Predator @return Список того, что едят кошачьи (хищники)
        return getFood("Хищник");                   // Используем метод getFood() родительского класса Animal с параметром "Хищник"
    }

    @Override
    public String getFamily() {                         // Переопределяем метод getFamily() из класса Animal, @return Название семейства - "Кошачьи"
        return "Кошачьи";
    }
    //Реализация метода из интерфейса Predator. @return Количество котят (по умолчанию 1)
    public int getKittens() {
        return getKittens(1);
    }
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
