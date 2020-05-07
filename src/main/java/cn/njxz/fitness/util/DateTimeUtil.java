package cn.njxz.fitness.util;

import org.springframework.lang.Nullable;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * DateTime 工具类
 *
 * @author Kalend
 */
public class DateTimeUtil {
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME);
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE);
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_TIME);

    /**
     * 判断当前时间是否有效
     * 闭区间
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean validTime(@Nullable Long targetTime, @Nullable Long startTime, @Nullable Long endTime) {
        if (targetTime == null) {
    		return false;
        }
        //价格生效时间
        if (startTime != null && targetTime < startTime) {
            return false;
        }
        //价格生效时间
        if (endTime != null && targetTime > endTime) {
            return false;
        }
        return true;
    }

    /**
     * 判断当前时间是否有效
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean validTime(@Nullable Long startTime, @Nullable Long endTime) {
        return validTime(System.currentTimeMillis(), startTime, endTime);
    }

    /**
     * long类型转为Date
     * @param convertTime
     * @return
     */
    public static String convertTimeToString(long convertTime){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date exactOnlineDate = new Date(convertTime);
        String exactOnlineTime = format.format(exactOnlineDate);
        return exactOnlineTime;
    }


//	/**
//	 * 日期时间格式化
//	 *
//	 * @param temporal 时间
//	 * @return 格式化后的时间
//	 */
//	public static String formatDateTime(TemporalAccessor temporal) {
//		return DATETIME_FORMAT.format(temporal);
//	}
//
//	/**
//	 * 日期时间格式化
//	 *
//	 * @param temporal 时间
//	 * @return 格式化后的时间
//	 */
//	public static String formatDate(TemporalAccessor temporal) {
//		return DATE_FORMAT.format(temporal);
//	}
//
//	/**
//	 * 时间格式化
//	 *
//	 * @param temporal 时间
//	 * @return 格式化后的时间
//	 */
//	public static String formatTime(TemporalAccessor temporal) {
//		return TIME_FORMAT.format(temporal);
//	}
//
//	/**
//	 * 日期格式化
//	 *
//	 * @param temporal 时间
//	 * @param pattern  表达式
//	 * @return 格式化后的时间
//	 */
//	public static String format(TemporalAccessor temporal, String pattern) {
//		return DateTimeFormatter.ofPattern(pattern).format(temporal);
//	}
//
//	/**
//	 * 将字符串转换为时间
//	 *
//	 * @param dateStr 时间字符串
//	 * @param pattern 表达式
//	 * @return 时间
//	 */
//	public static TemporalAccessor parse(String dateStr, String pattern) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
//		return format.parse(dateStr);
//	}
//
//	/**
//	 * 将字符串转换为时间
//	 *
//	 * @param dateStr   时间字符串
//	 * @param formatter DateTimeFormatter
//	 * @return 时间
//	 */
//	public static TemporalAccessor parse(String dateStr, DateTimeFormatter formatter) {
//		return formatter.parse(dateStr);
//	}
//
//	/**
//	 * 时间转 Instant
//	 *
//	 * @param dateTime 时间
//	 * @return Instant
//	 */
//	public static Instant toInstant(LocalDateTime dateTime) {
//		return dateTime.atZone(ZoneId.systemDefault()).toInstant();
//	}
//
//	/**
//	 * Instant 转 时间
//	 *
//	 * @param instant Instant
//	 * @return Instant
//	 */
//	public static LocalDateTime toDateTime(Instant instant) {
//		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//	}
}
