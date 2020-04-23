package com.zbq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String getTime(String s) {
		String[] s1 = s.split(":");
		String[] s2 = s1[0].split(" ");
		StringBuffer date = new StringBuffer();
		if (s1[1].equals("0")) {
			date.append(s1[0]).append(":15:00");
		} else if (s1[1].equals("1")) {
			date.append(s1[0]).append(":30:00");
			return date.toString();
		} else if (s1[1].equals("2")) {
			date.append(s1[0]).append(":45:00");
			return date.toString();
		} else if (s1[1].equals("3")) {
			int q = Integer.parseInt(s2[1]) + 1;
			String w = String.valueOf(q);
			date.append(s2[0]).append(" " + w).append(":00:00");
			return date.toString();
		}
		return date.toString();
	}
/**
 * 返回显示的是实时的十五分钟
 * @param s
 * @return
 */
	public static String getMoment(String s) {
//		Date d = DateUtil.str2DateCompactFmt(s);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = formatter.format(s);
		String[] s1 = s.split(":");
		String[] s2 = s1[0].split(" ");
		StringBuffer date = new StringBuffer();
		int m = Integer.parseInt(s1[1]);
		if (m>=0&m<15) {
			date.append(s2[1]).append(":00:00--").append(s2[1]).append(":15:00");
		} else if (m>=15&m<30) {
			date.append(s2[1]).append(":15:00--").append(s2[1]).append(":30:00");
			return date.toString();
		} else if (m>=30&m<45) {
			date.append(s2[1]).append(":30:00--").append(s2[1]).append(":45:00");
			return date.toString();
		} else if (m>45) {
			int q = Integer.parseInt(s2[1]) + 1;
			String w = String.valueOf(q);
			date.append(s2[1]).append(":45:00--").append(""+ w).append(":00:00");
			return date.toString();
		}
		return date.toString();
	}

/**
 * 实际查询的是前一个十五分钟
 * @param s
 * @return
 */
public static String getData(String s) {
	String[] s1 = s.split(":");
	String[] s2 = s1[0].split(" ");
	StringBuffer date = new StringBuffer();
	int m = Integer.parseInt(s1[1]);
	if (m>=0&m<15) {
//		int q = Integer.parseInt(s2[1]) - 1;
//		String w = String.valueOf(q);
//		date.append(s2[0]).append(" "+ w).append(":00:00");
		date.append(s1[0]).append(":00:00");
	} else if (m>=15&m<30) {
		date.append(s1[0]).append(":15:00");
		return date.toString();
	} else if (m>=30&m<45) {
		date.append(s1[0]).append(":30:00");
		return date.toString();
	} else if (m>45) {
		date.append(s1[0]).append(":45:00");
		return date.toString();
	}
	return date.toString();
}
}
