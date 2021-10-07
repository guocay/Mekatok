package icu.guokai.mekatok.framework.core.asserts.api.impl;

import cn.hutool.core.date.DateUtil;
import icu.guokai.mekatok.framework.core.asserts.api.Assert;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.Date;

/**
 * @author GuoKai
 * @date 2021/10/6
 */
public class DateAssert extends Assert<DateAssert, Date> {

    /**
     * 构造器
     * @param actual 待断言对象
     */
    public DateAssert(Date actual) {
        super(actual);
    }

    @Override
    public DateAssert is(Date obj) {
        return exception(actual.equals(obj));
    }

    /**
     * 上午
     * @return 断言工具
     */
    public DateAssert isAm(){
        return exception(DateUtil.isAM(actual));
    }

    /**
     * 下午
     * @return 断言工具
     */
    public DateAssert isPm(){
        return exception(DateUtil.isPM(actual));
    }

    /**
     * 星期几
     * @param dow 星期几
     * @return 断言工具
     */
    public DateAssert isWeekOf(DayOfWeek dow){
        return exception(dow.getValue() == DateUtil.dayOfWeek(actual));
    }

    /**
     * 年份
     * @param year 年份
     * @return 断言工具
     */
    public DateAssert isYearOf(Year year){
        return exception(year.getValue() == DateUtil.year(actual));
    }

    /**
     * 月份
     * @param month 月份
     * @return 断言工具
     */
    public DateAssert isMonthOf(Month month){
        return exception(month.getValue() == DateUtil.month(actual));
    }

    /**
     * 天数
     * @param day 几号
     * @return 断言工具
     */
    public DateAssert isDayOf(Integer day){
        return exception(day == DateUtil.dayOfMonth(actual));
    }

    /**
     * 小时数 - 24小时制
     * @param hour 小时
     * @return 断言工具
     */
    public DateAssert isHourOf(Integer hour){
        return exception(hour == DateUtil.hour(actual, true));
    }

    /**
     * 分钟数
     * @param minute 分钟数
     * @return 断言工具
     */
    public DateAssert isMinuteOf(Integer minute){
        return exception(minute == DateUtil.minute(actual));
    }

    /**
     * 秒数
     * @param second 秒数
     * @return 断言工具
     */
    public DateAssert isSecondOf(Integer second){
        return exception(second == DateUtil.second(actual));
    }

    /**
     * 毫秒数
     * @param mill 毫秒数
     * @return 断言工具
     */
    public DateAssert isMilliSecondOf(Integer mill){
        return exception(mill == DateUtil.millisecond(actual));
    }

    /**
     * 在给定日期之后
     * @param date 毫秒数
     * @return 断言工具
     */
    public DateAssert after(Date date){
        return exception(actual.after(date));
    }

    /**
     * 在给定日期之前
     * @param date 毫秒数
     * @return 断言工具
     */
    public DateAssert before(Date date){
        return exception(actual.before(date));
    }
}
