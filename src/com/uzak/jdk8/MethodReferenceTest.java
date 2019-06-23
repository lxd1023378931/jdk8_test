package com.uzak.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用
 * 条件：
 * 方法引用的方式，只能和函数式接口一起使用，普通接口方法是不能接收函数式引用的。
 * （1）出参：
 * 函数式接口方法与方法引用的方法的出参类型一致。
 * （2）入参：
 * Clazz::method条件：
 * 函数接口第一个参数类型必须是Clazz，后续参数依顺序与method参数列表保持一致；
 * instance::method/Clazz::static_method条件：
 * 参数依顺序与method参数列表保持一致即可调用。
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        /**
         * 构造器引用
         */
        MethodReferenceTest methodReferenceTest = MethodReferenceTest.create(MethodReferenceTest::new);

        List<MethodReferenceTest> methodReferenceTests = Arrays.asList(methodReferenceTest);
        /**
         * 静态方法引用，语法为Class::static_method
         */
        methodReferenceTests.forEach(Test::soutStatic);
        /**
         * 特定类的任意对象的方法引用，语法为Class::method
         */
        methodReferenceTests.forEach(MethodReferenceTest::soutSelf);
        /**
         * 特定对象的方法引用，语法为instance::method
         */
        methodReferenceTests.forEach(methodReferenceTest::sout);

//        List<String> sList = Arrays.asList("a", "b", "c");
//        Arrays.sort(sList, String::compareToIgnoreCase);
//        Arrays.sort(sList,(s1,s2)->s1.compareToIgnoreCase(s2));
    }

    public static MethodReferenceTest create(Supplier<MethodReferenceTest> supplier){
        return supplier.get();
    }

    public void soutSelf(){
        System.out.println(this.toString());
    }

    public void sout(MethodReferenceTest methodReferenceTest){
        System.out.println(methodReferenceTest.toString());
    }

    public static class Test{
        public static void soutStatic(MethodReferenceTest methodReferenceTest){
            System.out.println(methodReferenceTest.toString());
        }

    }
}