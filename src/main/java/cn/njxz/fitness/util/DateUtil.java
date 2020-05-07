package cn.njxz.fitness.util;

/**
 * 日期工具类
 *
 * @author Kalend
 */
public class DateUtil {
	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_DATE = "yyyy-MM-dd";
	public static final String PATTERN_TIME = "HH:mm:ss";

//	/**
//	 * 设置年
//	 *
//	 * @param date   时间
//	 * @param amount 年数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setYears(Date date, int amount) {
//		return set(date, Calendar.YEAR, amount);
//	}
//
//	/**
//	 * 设置月
//	 *
//	 * @param date   时间
//	 * @param amount 月数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setMonths(Date date, int amount) {
//		return set(date, Calendar.MONTH, amount);
//	}
//
//	/**
//	 * 设置周
//	 *
//	 * @param date   时间
//	 * @param amount 周数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setWeeks(Date date, int amount) {
//		return set(date, Calendar.WEEK_OF_YEAR, amount);
//	}
//
//	/**
//	 * 设置天
//	 *
//	 * @param date   时间
//	 * @param amount 天数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setDays(Date date, int amount) {
//		return set(date, Calendar.DATE, amount);
//	}
//
//	/**
//	 * 设置小时
//	 *
//	 * @param date   时间
//	 * @param amount 小时数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setHours(Date date, int amount) {
//		return set(date, Calendar.HOUR_OF_DAY, amount);
//	}
//
//	/**
//	 * 设置分钟
//	 *
//	 * @param date   时间
//	 * @param amount 分钟数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setMinutes(Date date, int amount) {
//		return set(date, Calendar.MINUTE, amount);
//	}
//
//	/**
//	 * 设置秒
//	 *
//	 * @param date   时间
//	 * @param amount 秒数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setSeconds(Date date, int amount) {
//		return set(date, Calendar.SECOND, amount);
//	}
//
//	/**
//	 * 设置毫秒
//	 *
//	 * @param date   时间
//	 * @param amount 毫秒数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	public static Date setMilliseconds(Date date, int amount) {
//		return set(date, Calendar.MILLISECOND, amount);
//	}
//
//	/**
//	 * 设置日期属性
//	 *
//	 * @param date          时间
//	 * @param calendarField 更改的属性
//	 * @param amount        更改数，-1表示减少
//	 * @return 设置后的时间
//	 */
//	private static Date set(Date date, int calendarField, int amount) {
//		Assert.notNull(date, "The date must not be null");
//		Calendar c = Calendar.getInstance();
//		c.setLenient(false);
//		c.setTime(date);
//		c.add(calendarField, amount);
//		return c.getTime();
//	}



}
