package com.aigodata.common.akanarika.util;

/***
 * 
 * @author saps.weaver
 *
 */
public class StringUtil {

	public static String ifNull(Object obj) {
		if (obj == null || "".equals(obj.toString())) {
			return "";
		}
		return obj.toString();
	}

	public static String ifNull(Object obj, String defaultValue) {
		if (obj == null || "".equals(obj.toString())) {
			return defaultValue;
		}
		return obj.toString();
	}

	public static long ifLongNull(Object obj) {
		if (obj == null || "".equals(obj.toString())) {
			return 0;
		}
		return Long.parseLong(obj.toString());
	}

	public static int ifIntNull(Object obj) {
		if (obj == null || "".equals(obj.toString())) {
			return 0;
		}
		return Integer.parseInt(obj.toString());
	}

	public static int ifIntNull(Object obj, int defaultValue) {
		if (obj == null || "".equals(obj.toString())) {
			return defaultValue;
		}
		return Integer.parseInt(obj.toString());
	}

	public static boolean isNull(Object obj) {
		if (obj == null || "".equals(obj.toString())) {
			return true;
		}
		return false;
	}

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	public static long[] str2long(String str) {
		long[] array = null;
		if (isNotNull(str)) {
			String a[] = str.split(",");
			int len = a.length;
			array = new long[len];
			for (int i = 0; i < len; i++) {
				array[i] = Long.parseLong(a[i]);
			}
		}
		return array;
	}
}