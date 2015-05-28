package com.latex;

/**
* Klasa helperowa
*/
public class LatexHelper {

	public static boolean isEmpty(String str) {
		if (str == null || str.equals(""))
			return true;
		else
			return false;
	}

	public static String addLibrary(String libName) {
		if (isEmpty(libName)) {
			return LatexParams.EMPTY;
		} else {
			if (libName.split(LatexParams.SPLIT_STR).length == 2) {
				return "\\usepackage[" + libName.split(LatexParams.SPLIT_STR)[0] + "]{" + libName.split(LatexParams.SPLIT_STR)[1] + "}" + LatexParams.newLine;
			} else {
				return "\\usepackage{" + libName + "}" + LatexParams.newLine;
			}
		}
	}
}
