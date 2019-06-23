package com.uzak.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * Supplier<T></>定义了一个名为get的抽象方法，不接受任何参数，返回T
 */
public class SupplierTest {

    private Double random = Math.random();

    public Double getRandom() {
        return this.random;
    }

    public static SupplierTest create(Supplier<SupplierTest> supplier) {
        return supplier.get();
    }

    public void soutClassName(){
        System.out.println(this.getRandom());
    }

    public static void main(String[] args) {
        SupplierTest supplierTest = SupplierTest.create(SupplierTest::new);
        List<SupplierTest> supplierTests = Arrays.asList(supplierTest);
        supplierTests.forEach(SupplierTest::soutClassName);
    }

    public void document(){
        /**
         * Supplier<T>  无参数，返回一个结果。
         * BooleanSupplier  代表了boolean值结果的提供方。
         * DoubleSupplier   代表一个double值结构的提供方。
         * IntSupplier  无参数，返回一个int类型结果。
         * LongSupplier 无参数，返回一个结果long类型的值。
         */
    }
}