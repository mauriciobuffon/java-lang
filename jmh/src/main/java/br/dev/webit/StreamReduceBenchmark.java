package br.dev.webit;

import org.openjdk.jmh.annotations.Benchmark;

public class StreamReduceBenchmark {

    // TODO: still understanding how this works
    // @State(Scope.Thread)
    // private List<Integer> list = new ArrayList<>();

    @Benchmark
    public Integer onSequentialStream() {
        return null;
        // return this.list.stream().reduce(0, Integer::sum);
    }

    @Benchmark
    public Integer onParallelStream() {
        return null;
        // return this.list.parallelStream().reduce(0, Integer::sum);
    }
}
