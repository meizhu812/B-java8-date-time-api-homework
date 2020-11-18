package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {
    public static long getDaysBetweenNextLaborDay(LocalDate date) {
        int currentYear = date.getYear();
        LocalDate labourDayOfCurrentYear = getLabourDayOfYear(currentYear);
        LocalDate nextLabourDay = date.isBefore(labourDayOfCurrentYear)
                ? labourDayOfCurrentYear
                : getLabourDayOfYear(currentYear + 1);
        return ChronoUnit.DAYS.between(date, nextLabourDay);
    }

    private static LocalDate getLabourDayOfYear(int year) {
        return LocalDate.of(year, Month.MAY, 1);
    }
}
