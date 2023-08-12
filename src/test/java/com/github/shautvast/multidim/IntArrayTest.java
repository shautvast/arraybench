package com.github.shautvast.multidim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntArrayTest {
    @Test
    void test() {
        IntArray intArray = new IntArray(2, 3, 5);
        assertEquals(30, intArray.internalSize());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    intArray.set(i, j, k, 2 * 3 * i + 3 * j + k);
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    assertEquals(2 * 3 * i, 3 * j + k, intArray.get(i, j, k));
                }
            }
        }
    }
}
