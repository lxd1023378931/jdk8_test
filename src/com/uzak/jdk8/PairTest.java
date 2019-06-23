package com.uzak.jdk8;

import javafx.util.Pair;

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
        Pair<Long, List<String>> pair = getPair();
        System.out.println(pair.getKey());
        pair.getValue().forEach(System.out::print);
    }
}