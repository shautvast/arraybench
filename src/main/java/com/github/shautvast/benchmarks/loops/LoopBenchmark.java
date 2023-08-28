package com.github.shautvast.benchmarks.loops;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
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
@State(Scope.Thread)
public class LoopBenchmark {

    final static int LIST_SIZE = 1000;
    List<String> list = new ArrayList<>(LIST_SIZE);

    @Setup(Level.Iteration)
    public void doSetup() {
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(UUID.randomUUID().toString());
        }
    }

    @Benchmark
    public void forLoop(Blackhole bh) {
        for (int i = 0; i < LIST_SIZE; i++) {
            bh.consume(list.get(i));
        }
    }

    @Benchmark
    public void whileLoop(Blackhole bh) {
        int i = 0;
        while (i < LIST_SIZE) {
            bh.consume(list.get(i));
            i++;
        }
    }

    @Benchmark
    public void iterator(Blackhole bh) {
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            bh.consume(iterator.next());
        }
    }

    @Benchmark
    public void enhancedForLoop(Blackhole bh) {
        for (String element : list) {
            bh.consume(element.length());
        }
    }

    @Benchmark
    public void stream(Blackhole bh) {
        list.stream().forEach(bh::consume);
    }

    @Benchmark
    public void forEach(Blackhole bh) {
        list.forEach(bh::consume);
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
