package com.johnsully83.utility;

public class Utility {

	public Utility() {
		super();
	}
	
	public static boolean nullOrEmpty(Object value) {
		return value == null || value.toString().trim().isEmpty();
	}

	public static Integer parseInteger(String value) {
		if(value == null || value.toString().isEmpty()) {
			return null;
		}

		try {
			return Integer.parseInt(value);
		} catch(Exception e) {
			return null;
		}
	}

	public static Integer forceParseInteger(String value) {
		if(value == null || value.toString().isEmpty()) {
			return 0;
		}

		try {
			return Integer.parseInt(value);
		} catch(Exception e) {
			return 0;
		}
	}

	public static String nullCheck(String subject) {
		return subject == null ? "" : subject;
	}

	public static String convertToJquiDateFormat(String javaSimpleDateFormat) {

		// Year
		if (javaSimpleDateFormat.contains("yyyy")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replaceAll("yyyy", "yy");
		} else {
			javaSimpleDateFormat = javaSimpleDateFormat.replaceAll("yy", "y");
		}

		// Month
		if (javaSimpleDateFormat.contains("MMMM")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("MMMM", "MM");
		} else if (javaSimpleDateFormat.contains("MMM")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("MMM", "M");
		} else if (javaSimpleDateFormat.contains("MM")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("MM", "mm");
		} else if (javaSimpleDateFormat.contains("M")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("M", "m");
		}

		// Day
		if (javaSimpleDateFormat.contains("DD")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("DD", "oo");
		} else if (javaSimpleDateFormat.contains("D")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("D", "o");
		}

		// Day of month
		if (javaSimpleDateFormat.contains("EEEE")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("EEEE", "DD");
		} else if (javaSimpleDateFormat.contains("EEE")) {
			javaSimpleDateFormat = javaSimpleDateFormat.replace("EEE", "D");
		}

		return javaSimpleDateFormat;
	}

}
