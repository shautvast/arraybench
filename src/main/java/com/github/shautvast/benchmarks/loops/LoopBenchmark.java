package com.github.shautvast.benchmarks.loops;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
public class LoopBenchmark {

    @org.openjdk.jmh.annotations.State(Scope.Thread)
    public static class State {
        final static int LIST_SIZE = 1000;
        List<String> list = new ArrayList<>(LIST_SIZE);

        @Setup(Level.Iteration)
        public void doSetup() {
            for (int i = 0; i < LIST_SIZE; i++) {
                list.add(UUID.randomUUID().toString());
            }
        }
    }

    @Benchmark
    public long cStyle(LoopBenchmark.State state) {
        long totalLength = 0;
        for (int i = 0; i < State.LIST_SIZE; i++) {
            totalLength += state.list.get(i).length();
        }
        return totalLength;
    }

    @Benchmark
    public long iterator(LoopBenchmark.State state) {
        long totalLength = 0;
        for (Iterator<String> iterator = state.list.iterator(); iterator.hasNext(); ) {
            totalLength += iterator.next().length();
        }
        return totalLength;
    }

    @Benchmark
    public long enhancedForLoop(LoopBenchmark.State state) {
        long totalLength = 0;
        for (String element : state.list) {
            totalLength += element.length();
        }
        return totalLength;
    }

    @Benchmark
    public long stream(LoopBenchmark.State state) {
        return state.list.stream().mapToLong(String::length).sum();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LoopBenchmark.class.getSimpleName())
                .forks(1)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .addProfiler(DTraceAsmProfiler.class)
                .build();

        new Runner(opt).run();
    }
}
