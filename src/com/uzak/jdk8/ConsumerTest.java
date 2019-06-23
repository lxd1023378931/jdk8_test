package com.uzak.jdk8;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 接收参数并依据传递的行为应用传递的参数值
 */
public class ConsumerTest {
    private static final Predicate<String> PREDICATE = str -> "error".equals(str);
    private static final Consumer<String> CONSUMER = str -> {
        System.out.println(PREDICATE.negate().test(str) ? "NO ERROR" : "THROW EXCEPTION");
    };
    private static final Consumer<String> CONSUMER1 = s -> {
        System.out.println("FINISH");
    };

    public static void main(String[] args) {
        CONSUMER.accept("success");
        System.out.println("===================");
        CONSUMER.andThen(CONSUMER1).accept("error");
    }

    public void document(){
        /**
         * Consumer<T>  代表了接受一个输入参数并且无返回的操作。
         * BiConsumer<T,U>  代表了一个接受两个输入参数的操作，并且不返回任何结果。
         * DoubleConsumer   代表一个接受double值参数的操作，并且不返回结果。
         * IntConsumer  接受一个int类型的输入参数，无返回值。
         * LongConsumer 接受一个long类型的输入参数，无返回值。
         * ObjDoubleConsumer<T> 接受一个object类型和一个double类型的输入参数，无返回值。
         * ObjIntConsumer<T>    接受一个object类型和一个int类型的输入参数，无返回值。
         * ObjLongConsumer<T>   接受一个object类型和一个long类型的输入参数，无返回值。
         */
    }
}