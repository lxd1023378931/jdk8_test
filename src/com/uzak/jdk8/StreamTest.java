package com.uzak.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class StreamTest {
    private static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

    public static void main(String[] args) {
        /**
         * Stream提供了新的foreach方法来迭代流
         */
        list.forEach(System.out::print);
        System.out.println("\n----------------");
        list.stream().forEach(System.out::print);
        System.out.println("\n----------------");
        /**
         * map用于映射每个元素对应的结果
         */
        list.stream().map(one -> one * one).forEach(System.out::print);
        System.out.println("\n----------------");
        /**
         * filter通过设置条件过滤出元素
         */
        IntPredicate intPredicate = one -> one % 2 == 0;
        System.out.print(list.stream().filter(one -> intPredicate.test(one)).count());
        System.out.println("\n----------------");
        /**
         * limit用于获取指定数量的流元素
         */
        list.stream().limit(10).forEach(System.out::print);
        System.out.println("\n----------------");
        /**
         * sorted对流元素进行排序
         */
        list.stream().sorted((i, j) -> j.compareTo(i)).forEach(System.out::print);
        System.out.println("\n----------------");
        /**
         * parallelStream 是流并行处理程序的代替方法
         * 如果不是太复杂的计算过程，尽量避免使用并行的方式，线程的生成调度会损耗性能，得不偿失
         * 并行调度会打乱原有的顺序，如果想保持原顺序可以用forEachOrdered代替forEach
         */
        list.parallelStream().filter(one -> intPredicate.test(one)).forEachOrdered(System.out::print);
        System.out.println("\n----------------");
        /**
         * Collectors归约操作，例如将流转换成集合和聚合元素
         */
        List<Integer> list2 = list.stream().sorted((i, j) -> j.compareTo(i)).collect(Collectors.toList());
        list2.forEach(System.out::print);
        System.out.print(list.stream().map(one -> one.toString()).collect(Collectors.joining(",")));
        System.out.println("\n----------------");
        /**
         * 统计
         */
        IntSummaryStatistics summaryStatistics = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());
        System.out.println("\n----------------");
    }
}