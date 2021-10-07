package icu.guokai.mekatok.framework.core.asserts.api.impl;

import icu.guokai.mekatok.framework.core.asserts.api.Assert;

import java.time.*;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class LocalDateTimeAssert extends Assert<LocalDateTimeAssert, LocalDateTime> {
    /**
     * 构造器
     * @param actual 待断言对象
     */
    public LocalDateTimeAssert(LocalDateTime actual) {
        super(actual);
    }

    @Override
    public LocalDateTimeAssert is(LocalDateTime obj) {
        return exception(actual.equals(obj));
    }

    public LocalDateTimeAssert after(LocalDateTime obj){
        return exception(actual.isAfter(obj));
    }

    public LocalDateTimeAssert before(LocalDateTime obj){
        return exception(actual.isBefore(obj));
    }

    public LocalDateTimeAssert toLocalDate(LocalDate obj){
        return exception(actual.toLocalDate().equals(obj));
    }

    public LocalDateTimeAssert toLocalTime(LocalTime obj){
        return exception(actual.toLocalTime().equals(obj));
    }

    /**
     * 上午
     * @return 断言工具
     */
    public LocalDateTimeAssert isAm(){
        return exception(actual.getHour() < 12);
    }

    /**
     * 下午
     * @return 断言工具
     */
    public LocalDateTimeAssert isPm(){
        return exception(actual.getHour() >= 12);
    }

    /**
     * 星期几
     * @param dow 星期几
     * @return 断言工具
     */
    public LocalDateTimeAssert isWeekOf(DayOfWeek dow){
        return exception(dow.equals(actual.getDayOfWeek()));
    }

    /**
     * 年份
     * @param year 年份
     * @return 断言工具
     */
    public LocalDateTimeAssert isYearOf(Year year){
        return exception(actual.getYear() == year.getValue());
    }

    /**
     * 月份
     * @param month 月份
     * @return 断言工具
     */
    public LocalDateTimeAssert isMonthOf(Month month){
        return exception(actual.getMonth().equals(month));
    }

    /**
     * 天数
     * @param day 几号
     * @return 断言工具
     */
    public LocalDateTimeAssert isYearDayOf(Integer day){
        return exception(day == actual.getDayOfYear());
    }

    /**
     * 天数
     * @param day 几号
     * @return 断言工具
     */
    public LocalDateTimeAssert isMonthDayOf(Integer day){
        return exception(day == actual.getDayOfMonth());
    }

    /**
     * 小时数 - 24小时制
     * @param hour 小时
     * @return 断言工具
     */
    public LocalDateTimeAssert isHourOf(Integer hour){
        return exception(hour == actual.getHour());
    }

    /**
     * 分钟数
     * @param minute 分钟数
     * @return 断言工具
     */
    public LocalDateTimeAssert isMinuteOf(Integer minute){
        return exception(minute == actual.getMinute());
    }

    /**
     * 秒数
     * @param second 秒数
     * @return 断言工具
     */
    public LocalDateTimeAssert isSecondOf(Integer second){
        return exception(second == actual.getSecond());
    }

}
