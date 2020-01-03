package com.study.modu.parent.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * <p>
 * Explain:日期工具类
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-30 10:46
 */
public class DataUtils {

    public DataUtils() {
    }

    private final static String dateTimesFormat = "yyyy-MM-dd HH:mm:ss";

    public static String getFormatDate(Date date, String patent) {
        return DateFormatUtils.format(date, patent);
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static String getDateTimes() {
        return getFormatDate(getNowDate(), dateTimesFormat);
    }

}
