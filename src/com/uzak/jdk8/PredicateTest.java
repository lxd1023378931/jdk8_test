package com.uzak.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 利用我们在外部设定的条件对于传入的参数进行校验并返回验证通过与否
 */
public class PredicateTest {

    private static Predicate<String> predicate = str -> "error".equals(str);
    private static Predicate<String> predicate1 = str -> "warn".equals(str);

    public static void main(String[] args) {
        System.out.println(predicate.test("error"));//true
        System.out.println(predicate.and(predicate1).test("error"));//false
        System.out.println(predicate.negate().test("error"));//false
        System.out.println(predicate.or(predicate1).test("warn"));//true
        System.out.println(Predicate.isEqual("error").test("error"));//true

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        soutNum(list, n -> n % 2 == 0);
        System.out.println("---");
        soutNum(list, n -> n % 3 == 0);
    }

    public static void soutNum(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(one -> {
            if (predicate.test(one)) {
                System.out.println(one);
            }
        });
    }

    public void document() {
        /**
         * Predicate<T> 接受一个输入参数，返回一个布尔值结果。
         * LongPredicate    接受一个long输入参数，返回一个布尔值类型结果。
         * IntPredicate 接受一个int输入参数，返回一个布尔值的结果。
         * DoublePredicate  接受一个double值，返回一个boolean值的结果。
         * BiPredicate<T,U> 接收两个参数的，返回一个boolean值的结果。
         */
    }
}