package com.uni.rubber.helper;

public class BooleanHelper {
	public static boolean isTrue(Boolean obj) {
		if (obj == null || obj.booleanValue()==false) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean isFalse(Boolean obj){
		return !BooleanHelper.isTrue(obj);
	}
}
