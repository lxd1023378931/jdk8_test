package com.uzak.jdk8;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Function<T, R> 执行转换操作，输入类型 T 的数据，返回 R 类型的结果
 */
public class FunctionTest {
    private static Function<String, Boolean> function = s -> !Objects.equals("error", s);

    private static Function<Boolean, String> function1 = aBoolean -> {
        return aBoolean ? "SUCCESS" : "FAIL";
    };

    public static void main(String[] args) {
        System.out.println(function.apply("error"));

        System.out.println(function.andThen(function1).apply("error"));

        System.out.println(function1.compose(function).apply("info"));

        System.out.println(Function.identity().apply(function));
    }

    public void document(){
        /**
         * Function<T,R>    接受一个输入参数，返回一个结果。
         * BiFunction<T,U,R>    代表了一个接受两个输入参数的方法，并且返回一个结果。
         * DoubleFunction<R>    代表接受一个double值参数的方法，并且返回结果。
         * DoubleToIntFunction  接受一个double类型输入，返回一个int类型结果。
         * DoubleToLongFunction 接受一个double类型输入，返回一个long类型结果。
         * IntFunction<R>   接受一个int类型输入参数，返回一个结果。
         * IntToDoubleFunction  接受一个int类型输入，返回一个double类型结果。
         * IntToLongFunction    接受一个int类型输入，返回一个long类型结果。
         * LongFunction<R>  接受一个long类型输入参数，返回一个结果。
         * LongToIntFunction    接受一个long类型输入，返回一个int类型结果。
         * ToDoubleBiFunction<T,U>  接受两个输入参数，返回一个double类型结果。
         * ToDoubleFunction<T>  接受一个输入参数，返回一个double类型结果。
         * ToIntBiFunction<T,U> 接受两个输入参数，返回一个int类型结果。
         * ToIntFunction<T> 接受一个输入参数，返回一个int类型结果。
         * ToLongBiFunction<T,U>    接受两个输入参数，返回一个long类型结果。
         * ToLongFunction<T>    接受一个输入参数，返回一个long类型结果。
         *
         * BinaryOperator<T>    代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果，继承BiFunction<T,T,T>
         * UnaryOperator<T>     接受一个参数为类型T,返回值类型也为T。
         * DoubleBinaryOperator 代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。
         * DoubleUnaryOperator  接受一个参数同为类型double,返回值类型也为double。
         * IntBinaryOperator    接受两个参数同为类型int,返回值类型也为int。
         * IntUnaryOperator     接受一个参数同为类型int,返回值类型也为int。
         * LongBinaryOperator   接受两个参数同为类型long,返回值类型也为long。
         * LongUnaryOperator    接受一个参数同为类型long,返回值类型也为long。
         */
    }
}