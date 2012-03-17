package org.zephyrsoft.trackworktime.util;

import hirondelle.date4j.DateTime;
import java.util.TimeZone;

/**
 * Utility class for handling {@link DateTime} objects and converting them.
 * 
 * @author Mathis Dirksen-Thedens
 */
public class DateTimeUtil {
	
	/**
	 * Gets the current date and time.
	 * 
	 * @return {@link DateTime} object
	 */
	public static DateTime getCurrentDateTime() {
		DateTime now = DateTime.now(TimeZone.getDefault());
		return now;
	}
	
	/**
	 * Gets the week's start related to the specified date and time.
	 * 
	 * @param dateTime the date and time
	 * @return {@code DateTime} object
	 */
	public static String getWeekStart(DateTime dateTime) {
		// go back to this day's start
		DateTime ret = dateTime.getStartOfDay();
		// go back to last Monday
		while (ret.getWeekDay() != 2) {
			ret = ret.minusDays(1);
		}
		return DateTimeUtil.dateTimeToString(ret);
	}
	
	/**
	 * Formats a {@link DateTime} to a String.
	 * 
	 * @param dateTime
	 *            the input (may not be null)
	 * @return the String which corresponds to the given input
	 */
	public static String dateTimeToString(DateTime dateTime) {
		return dateTime.format("YYYY-MM-DD hh:mm:ss.ffff");
	}
	
	/**
	 * Formats a {@link DateTime} to a String which contains the date only
	 * (omitting the time part).
	 * 
	 * @param dateTime
	 *            the input (may not be null)
	 * @return the String which corresponds to the given input
	 */
	public static String dateTimeToDateString(DateTime dateTime) {
		return dateTime.format("YYYY-MM-DD");
	}
	
	/**
	 * Formats a String to a {@link DateTime}.
	 * 
	 * @param string
	 *            the input (may not be null)
	 * @return the DateTime which corresponds to the given input
	 */
	public static DateTime stringToDateTime(String string) {
		return new DateTime(string);
	}
	
	/**
	 * Formats a {@link DateTime} to a String which contains the hour and minute only
	 * (omitting the date and the seconds).
	 * 
	 * @param dateTime
	 *            the input (may not be null)
	 * @return the String which corresponds to the given input
	 */
	public static String dateTimeToHourMinuteString(DateTime dateTime) {
		// if the format is changed here, change it also in the method getCompleteDayAsHourMinuteString()
		return dateTime.format("hh:mm");
	}
	
	/**
	 * Returns a {@code String} representing the amount of time for a complete day (24 hours).
	 * The format is the same as in {@link #dateTimeToHourMinuteString(DateTime)}.
	 */
	public static String getCompleteDayAsHourMinuteString() {
		return "24:00";
	}
	
}