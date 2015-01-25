package com.latex;

public final class LatexParams {
	
	public static String EMPTY = "";
	public static String SPLIT_STR = "*";
	
	static String newLine = System.getProperty("line.separator");
	static String header = "Unirubber Sp. z o.o.\\\\" + newLine + "Zielonka 17, 59-940 Wêgliniec " + newLine;
	static String orientation = "";
	static String name="name";
	static String surname="name";
	private static String PROPERTIES  = "\\documentclass[" + orientation + ", 12pt]{article}" + newLine;
	private static String SIZE =  "\\usepackage[top=2cm, bottom=2cm, left=2cm, right=2cm]{geometry}" + newLine;
	
	private static String LIBS_GRAPHICX = "graphicx";
	private static String LIBS_CAPTION = "caption";
	private static String LIBS_FANCYHDR = "fancyhdr";
	private static String LIBS_FANCYHEADINGS = "fancyheadings";
	private static String LIBS_XCOLOR = "xcolor";
	private static String LIBS_COLORTBL = "colortbl";
	private static String LIBS_SUBCAPTION = "subcaption";
	private static String LIBS_LASTPAGE = "lastpage";
	private static String LIBS_FLOAT = "float";
	private static String LIBS_LONGTABLE = "longtable";
	private static String LIBS_POLSKI = "polski";
	private static String LIBS_PGFPLOTS = "pgfplots";

	private static String LIBS_INPUTENC = "utf8*inputenc";

	private static String LIBS_DATEPLOT = "dateplot";
	private static String LIBS_BACKGROUNDS = "backgrounds";
	private static String LIBS_PGFPLOTS_GROUPPLOTS = "pgfplots.groupplots";
	
	
	
	private static String BEGIN =  "\\begin{document}" + newLine;
	private static String HEADER_FOOTER = "\\pagestyle{fancy}" + newLine +
            "\\fancyhf{}" + newLine +
            "\\lhead{" + header + "}" + newLine +
            "\\rhead{\\includegraphics[scale=0.09]{logo}}" + newLine +
            "\\lfoot{" + name + " " + surname + "}" + newLine +
            "\\rfoot{\\today}" + newLine +
            "\\cfoot{Strona \\thepage}" + newLine;
	
	private static String END = "\\end{document}";
	private static String NEW_PAGE = "\\newpage" + newLine + "\\thispagestyle{fancy}";
	
}
