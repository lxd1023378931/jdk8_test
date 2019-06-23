package com.uzak.jdk8;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，
 * 调用get()方法会返回该对象。
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。
 * Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 */
public class OptionalTest {
    /**
     * 返回一个指定非null值的Optional。
     */
    private static final Optional<String> OPTIONAL = Optional.of("123");
    /**
     * 如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
     */
    private static final Optional EMPTY_OPTIONAL1 = Optional.ofNullable(null);
    private static final Optional EMPTY_OPTIONAL2 = Optional.empty();

    public static void main(String[] args) {
        /**
         * 如果值存在则方法会返回true，否则返回 false
         */
        System.out.println(OPTIONAL.isPresent());
        /**
         * 如果在这个Optional中包含这个值，返回值，否则抛出异常：NoSuchElementException
         */
        System.out.println(OPTIONAL.get());
        System.out.println("----------------");
        System.out.println(EMPTY_OPTIONAL1.isPresent());
        System.out.println("----------------");
        /**
         * 如果值存在则使用该值调用 consumer , 否则不做任何事情
         */
        OPTIONAL.ifPresent(one -> {
            System.out.println("Consumer sout:" + one);
        });
        System.out.println("----------------");
        /**
         * Optional<T> filter(Predicate<? super <T> predicate)
         * 如果值存在，并且这个值匹配给定的 predicate，
         * 返回一个Optional用以描述这个值，否则返回一个空的Option Optional。
         */
        System.out.println(OPTIONAL.filter(one -> {
            return Integer.valueOf(one) % 2 == 0;
        }).isPresent());
        System.out.println("----------------");
        /**
         * 如果存在该值，返回值，否则返回 other。
         */
        System.out.println(EMPTY_OPTIONAL1.orElse("456"));
        System.out.println("----------------");
        /**
         * 如果存在该值，返回值，否则触发 other，并返回 other 调用的结果。
         */
        System.out.println(EMPTY_OPTIONAL1.orElseGet(() -> "789"));
        System.out.println("----------------");
    }

    public void document(){
        /**
         * <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
         * 如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常。
         *
         * <U>Optional<U> map(Function<? super T,? extends U> mapper)
         * 如果存在该值，提供的映射方法，如果返回非null，返回一个Optional描述结果。
         *
         * <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper)
         * 如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional。
         */
    }
}