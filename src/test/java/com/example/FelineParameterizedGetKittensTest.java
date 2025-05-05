package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class FelineParameterizedGetKittensTest {

    private final int input;
    private final int expected;

    public FelineParameterizedGetKittensTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {3, 3},
                {5, 5}
        });
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}