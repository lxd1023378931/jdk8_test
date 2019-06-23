package com.uzak.jdk8;

/**
 * 解决接口的修改与现有的实现不兼容的问题
 */
public class InterfaceDefaultTest {
    public interface Interface1 {
        default void printf(){
            System.out.println("Interface1");
        }

        static void printStatic(){

        }
    }
    public interface Interface2 {
        default void printf(){
            System.out.println("Interface2");
        }
    }

    public class ClassA implements Interface1, Interface2{
        @Override
        public void printf() {
            Interface1.printStatic();
            Interface2.super.printf();
        }
    }
}