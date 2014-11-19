package com.grafika.matrix;

import java.util.ArrayList;
import java.util.List;

import Jama.Matrix;

import com.grafika.graphics.Image;
import com.grafika.graphics.Tools;

public class Transformation {
	public static List<Matrix> transformacje = new ArrayList<Matrix>();

	public static Matrix transform() {
		double[][] prepare = new double[3][3];
		prepare[0][0] = 1;
		prepare[0][1] = 0;
		prepare[0][2] = (Tools.vectorImage==false?-1:1)* Image.w / 2;
		prepare[1][0] = 0;
		prepare[1][1] = 1;
		prepare[1][2] = (Tools.vectorImage==false?-1:1)*Image.h / 2;
		prepare[2][0] = 0;
		prepare[2][1] = 0;
		prepare[2][2] = 1;
		Matrix transform = new Matrix(prepare);
		for (Matrix m : transformacje) {
			transform = transform.times(m);
		}
		transform=transform.times(endMatrix());
		
		return transform;
	}
	
	public static Matrix endMatrix(){
		double[][] end = new double[3][3];
		end[0][0] = 1;
		end[0][1] = 0;
		end[0][2] = (Tools.vectorImage==false?1:-1)*Image.w / 2;
		end[1][0] = 0;
		end[1][1] = 1;
		end[1][2] = (Tools.vectorImage==false?1:-1)*Image.h / 2;
		end[2][0] = 0;
		end[2][1] = 0;
		end[2][2] = 1;
		return new Matrix(end);
	}

}
