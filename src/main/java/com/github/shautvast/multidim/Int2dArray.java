package com.github.shautvast.multidim;

/**
 * Any dimensional int array, stored as an int[]
 * No runtime checks! Easy to shoot yourself in the foot!
 */
public class Int2dArray {
    private final int[] data;
    private int cols;

    public Int2dArray(int rows, int cols) {
        data = new int[rows * cols];
        this.cols = cols;
    }

    public int get(int row, int col) {
        return row * cols + col;
    }

    public void set(int row, int col, int val) {
        data[row * cols + col] = val;
    }

    int internalSize() {
        return data.length;
    }


}

