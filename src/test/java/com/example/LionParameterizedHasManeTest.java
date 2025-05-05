package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedHasManeTest {

    private final String sex;
    private final boolean expectedHasMane;


    public LionParameterizedHasManeTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }


    // Тест, что метод boolean doesHaveMane выдает true если он Male
    @Test
    public void doesHaveManeShouldReturnTrue() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predator);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
