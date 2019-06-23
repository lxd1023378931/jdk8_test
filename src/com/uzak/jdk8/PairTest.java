package com.uzak.jdk8;

import io.vavr.Tuple2;
import javafx.util.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.List;

public class PairTest {

    private static Pair<Long, List<String>> getPair(){
        List<String> list = new ArrayList(){{
            add("info|");
            add("warn|");
            add("error\n");
        }};

        return new Pair(1155, list);

    }

    public static void main(String[] args) {
        /**
         * jfxrt库不可变配对
         */
        Pair<Long, List<String>> pair = getPair();
        System.out.println(pair.getKey());
        pair.getValue().forEach(System.out::print);

        /**
         * Apache-Commons库不可变配对
         */
        org.apache.commons.lang3.tuple.Pair<Integer, String> immutablePair = new ImmutablePair<>(1, "Xander");
        System.out.println(immutablePair.getLeft());
        System.out.println(immutablePair.getRight());
//        抛出UnsupportedOperationException异常
//        immutablePair.setValue("Error");

        /**
         * Apache-Commons库可变配对
         */
        org.apache.commons.lang3.tuple.Pair<Integer, String> mutablePair = new MutablePair<>(2, "Xander");
        mutablePair.setValue("Xander2");

        /**
         * Vavr库不可变配对
         */
        Tuple2<Integer, String> tuple2 = new Tuple2<>(3, "Xander");
        // 返回新对象
        Tuple2<Integer, String> tuple21 = tuple2.update1(4);
        Tuple2<Integer, String> tuple22 = tuple2.update2("Xander2");
    }
}