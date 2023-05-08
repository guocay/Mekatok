package mekatok.core.assertion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * 日期时间 断言工具类
 * @author GuoCay
 * @since 2023.03.10
 */
public class NewTimeApiAssertion extends AbstractAssertion<NewTimeApiAssertion, LocalDateTime>{

    /**
     * 日期
     */
    private final LocalDate date;

    /**
     * 时间
     */
    private final LocalTime time;

    public NewTimeApiAssertion(LocalDateTime actual, boolean nullable) {
        super(actual, nullable);
        date = actual.toLocalDate();
        time = actual.toLocalTime();
    }

    /**
     * 是否指定 时间之后
     * @return 断言工具
     */
    public NewTimeApiAssertion after(LocalDateTime obj){
        if (actual.isBefore(obj))
            throwException();
        return self();
    }

    /**
     * 是否指定 时间之前
     * @return 断言工具
     */
    public NewTimeApiAssertion before(LocalDateTime obj){
        if (actual.isAfter(obj))
            throwException();
        return self();
    }

    /**
     * 是否指定 日期
     * @return 断言工具
     */
    public NewTimeApiAssertion toLocalDate(LocalDate obj){
        if (date.equals(obj))
            throwException();
        return self();
    }


    /**
     * 是否指定 时间
     * @return 断言工具
     */
    public NewTimeApiAssertion toLocalTime(LocalTime obj){
        if (time.equals(obj))
            throwException();
        return self();
    }

    /**
     * 上午
     * @return 断言工具
     */
    public NewTimeApiAssertion isAm(){
        if (time.getHour() >= 12)
            throwException();
        return self();
    }

    /**
     * 下午
     * @return 断言工具
     */
    public NewTimeApiAssertion isPm(){
        if (time.getHour() < 12)
            throwException();
        return self();
    }

    /**
     * 星期几
     * @param dow 星期几
     * @return 断言工具
     */
    public NewTimeApiAssertion isWeekOf(DayOfWeek dow){
        if (!dow.equals(date.getDayOfWeek()))
            throwException();
        return self();
    }

    /**
     * 年份
     * @param year 年份
     * @return 断言工具
     */
    public NewTimeApiAssertion isYearOf(Integer year){
        if (date.getYear() != year)
            throwException();
        return self();
    }

    /**
     * 月份
     * @param month 月份
     * @return 断言工具
     */
    public NewTimeApiAssertion isMonthOf(Month month){
        if (!date.getMonth().equals(month))
            throwException();
        return self();
    }

    /**
     * 天数
     * @param dayOfMonth 几号
     * @return 断言工具
     */
    public NewTimeApiAssertion isYearDayOf(Integer dayOfMonth){
        if (date.getDayOfMonth() != dayOfMonth)
            throwException();
        return self();
    }

    /**
     * 小时数 - 24小时制
     * @param hour 小时
     * @return 断言工具
     */
    public NewTimeApiAssertion isHourOf(Integer hour){
        if (time.getHour() != hour)
            throwException();
        return self();
    }

    /**
     * 分钟数
     * @param minute 分钟数
     * @return 断言工具
     */
    public NewTimeApiAssertion isMinuteOf(Integer minute){
        if (time.getMinute() != minute)
            throwException();
        return self();
    }

    /**
     * 秒数
     * @param second 秒数
     * @return 断言工具
     */
    public NewTimeApiAssertion isSecondOf(Integer second){
        if (time.getSecond() != second)
            throwException();
        return self();
    }
}
