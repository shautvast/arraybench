package com.github.shautvast.benchmarks.arrays;

/**
 * Any dimensional int array, stored as an int[]
 * No runtime checks! Easy to shoot yourself in the foot!
 */
public class IntArray {
    private final int[] data;
    private final int[] dims;

    public IntArray(int... dims) {
        if (dims.length < 1) {
            throw new IllegalArgumentException("array cannot have " + dims.length + " dimensions");
        }
        this.dims = dims;
        int size = 1;
        for (int dim : dims) {
            size *= dim;
        }
        data = new int[size];
    }

    public int get(int... coords) {
        if (coords.length < 1) {
            throw new IllegalArgumentException("must supply at least one coordinate");
        }
        int index = 0;
        if (coords.length > 1) {
            for (int i = coords.length - 2; i >= 0; i--) {
                index += coords[i] * dims[i + 1];
            }
        }

        return data[index + coords[coords.length - 1]];
    }

    /**
     * 'smart' use of varargs int: first values are the coordinates, last is the value itself
     *
     * @param coordsVal, all coordinates and the value to set
     */
    public void set(int... coordsVal) {
        if (coordsVal.length < 2) {
            throw new IllegalArgumentException("must supply at least one coordinate and a value to set");
        }
        int index = 0;
        if (coordsVal.length > 2) {
            for (int i = coordsVal.length - 3; i >= 0; i--) {
                index += coordsVal[i] * dims[i + 1];
            }
        }

        data[index + coordsVal[coordsVal.length - 2]] = coordsVal[coordsVal.length - 1];
    }

    int internalSize() {
        return data.length;
    }


}

