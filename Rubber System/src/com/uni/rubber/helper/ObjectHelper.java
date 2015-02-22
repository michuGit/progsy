package com.uni.rubber.helper;

public class ObjectHelper {
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotNull(Object obj) {
		return !ObjectHelper.isNull(obj);
	}
}
