package com.latex;

/**
*
*
*
*
*/
public class Latex {

	private String doc;

	public Latex() {
		doc = LatexParams.EMPTY;
	}

	public boolean write() {
		return false;
	}

	public boolean generate() {
		return false;
	}

	public boolean clear() {
		doc = LatexParams.EMPTY;
		return true;
	}
	
	private void create(){
//		doc = LatexParams.BASIS;
	}
}
