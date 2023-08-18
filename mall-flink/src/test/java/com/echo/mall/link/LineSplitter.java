package com.echo.mall.link;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
    @Override
    public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
        String[] splits = s.toLowerCase().split("\\W+");
        for (String split : splits) {
            if (split.length() > 0) {
                collector.collect(new Tuple2<>(split, 1));
            }
        }
    }
}
