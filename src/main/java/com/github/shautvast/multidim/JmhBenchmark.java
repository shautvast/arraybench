package com.github.shautvast.multidim;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
public class JmhBenchmark {

    private static final int ROWS = 100;
    private static final int COLS = 100;


    @org.openjdk.jmh.annotations.State(Scope.Thread)
    public static class State {
        Int2dArray seqInt2DArray;
        IntArray intArray;
        int[][] ints;

        @Setup(Level.Iteration)
        public void doSetup() {
            long seed = System.currentTimeMillis();
            Random random = new Random(seed);
            ints = new int[COLS][ROWS];
            intArray = new IntArray(COLS, ROWS);
            seqInt2DArray = new Int2dArray(COLS, ROWS);

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    int i = random.nextInt();
                    intArray.set(r, c, i);
                    seqInt2DArray.set(r, c, i);
                }
            }
        }

    }

    @Benchmark
    public Int2dArray seq2DArraySetTDLR(State state) {
        Int2dArray d2Array = new Int2dArray(ROWS, COLS);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                d2Array.set(r, c, r * c);
            }
        }
        return d2Array;
    }

    @Benchmark
    public int[][] classicArraySet(State state) {
        int[][] d2Array = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                d2Array[r][c] = r * c;
            }
        }
        return d2Array;
    }

    @Benchmark
    public int classicArrayGetTDLR(State state) {
        int t = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                t += state.ints[r][c];
            }
        }

        return t;
    }

    @Benchmark
    public int classicArrayGetLRTD(State state) {
        int t = 0;
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS; r++) {
                t += state.ints[r][c];
            }
        }
        return t;
    }

    @Benchmark
    public int seq2DArrayGetTDLR(State state) {
        int t = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                t += state.seqInt2DArray.get(r, c);
            }
        }
        return t;
    }

    @Benchmark
    public int seq2DArrayGetLRTD(State state) {
        int t = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                t += state.seqInt2DArray.get(r, c);
            }
        }
        return t;
    }

    @Benchmark
    public int seqMultArrayGetLRTD(State state) {
        int t = 0xFFFFFFFF;
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS; r++) {
                t = state.intArray.get(r, c);
            }
        }
        return t;
    }

    @Benchmark
    public int seqMultArrayGetTDLR(State state) {
        int t = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                t = state.intArray.get(r, c);
            }
        }
        return t;
    }
}