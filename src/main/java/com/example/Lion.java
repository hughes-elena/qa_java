package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private Predator predator; //Создать в зависимом классе поле того же типа, что и интерфейс I Predator.java

    public Lion(String sex, Predator predator) throws Exception {
        this.predator = predator; // Инъекция зависимости. Внутри конструктора передать значение параметра в созданное поле
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat(); //return feline.getFood("Хищник"); - было это. Но он работает через интерфейс, поэтому predator.eatMeat()
    }
}
