package com.uzak.jdk8;

import java.time.*;
import java.time.temporal.TemporalAccessor;

public class DateTest {

    public static void main(String[] args) {
        localTime();
        System.out.println("==============");
        zoneTime();
    }

    private static void localTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("当前时间：" + currentDateTime);
        LocalDate currentDate = currentDateTime.toLocalDate();
        System.out.println("当前日期：" + currentDate);
        System.out.println("当前月份：" + currentDate.getMonth());
        System.out.println("当前日号：" + currentDate.getDayOfMonth());
        LocalDate historyDate = currentDate.withDayOfMonth(10).withDayOfYear(123);
        System.out.println("历史日期：" + historyDate);
        LocalDate targetDate = LocalDate.of(2018, Month.JANUARY, 12);
        System.out.println("指定日期：" + targetDate);
        LocalTime targetTime = LocalTime.of(11, 24, 32);
        System.out.println("指定时间：" + targetTime);
        LocalTime strTime = LocalTime.parse("12:30:30");
        System.out.println("字符串时间："+strTime);
        LocalDateTime strDateTime = LocalDateTime.parse("2019-05-20T13:14:00.000");
        System.out.println("字符串日期："+strDateTime);
    }

    private static void zoneTime(){
        ZoneId currentId = ZoneId.systemDefault();
        System.out.println("当前时区："+currentId);
        System.out.println("所有时区："+ZoneId.getAvailableZoneIds().toString());
    }
}