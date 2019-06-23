package com.uzak.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda Test
 */
public class LambdaTest {

    /**
     * 含有且仅含有一个抽象方法的接口被称为函数式接口
     * 需要注意的是,default关键字可以在接口中定义实现,如果一个接口含有多个实现但是只有一个抽象方法,那么它也属于函数式接口
     * @FunctionInterface对函数式接口来进行语义化标注
     */
    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface GreetingService {
        void soutMessage(String msg);
    }

    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
        MathOperation mul = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            return a * b;
        };
        MathOperation div = (a, b) -> a / b;

        GreetingService service = msg -> System.out.println("Greeting msg : "+ msg);

        System.out.println("a + b = " + add.operation(5, 2));
        System.out.println("a - b = " + sub.operation(5, 2));
        System.out.println("a x b = " + mul.operation(5, 2));
        System.out.println("a / b = " + div.operation(5, 2));

        service.soutMessage("Hello");

        /**
         * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在lambda 内部修改定义在域外的局部变量，否则会编译错误。
         * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有final 的语义）
         */
        List<String> list = Arrays.asList("a", "b", "c");
        int a = 1;
        list.forEach(one -> {
            System.out.println(a);
        });
        //Variable used in lambda expression should be final or effectively final
//        a = 2;
    }

}