package com.grafika.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import Jama.Matrix;

public class Image extends JPanel implements Runnable {
	static Logger log = Logger.getLogger(Image.class.getName());

	private static final long serialVersionUID = 1L;

	public static int w;
	public static int h;
	private BufferedImage bufferedImage = null;
	private Graphics graphics = null;

	public Image() {
		setBackground(Color.BLACK);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bufferedImage != null) {
			g.drawImage(bufferedImage, 0, 0, this);
			drawLines(g);
		}
	}

	private void drawLines(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 2.0f, new float[] { 2f, 0f, 2f }, 2f);
		g2d.setStroke(bs);

		g2d.drawLine(0, h / 2, w, h / 2);
		g2d.drawLine(w / 2, 0, w / 2, h);
		g2d.drawLine(0, 0, w, h);
		g2d.drawLine(0, h, w, 0);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			repaint();
		}
	}

	public void changeImage(String pathToFile) {
		try {
			bufferedImage = ImageIO.read(new File(pathToFile));
			w = bufferedImage.getWidth();
			h = bufferedImage.getHeight();
			setPreferredSize(new Dimension(w, h));
		} catch (IOException ex) {
		}
		this.setBackground(Color.BLACK);
		log.info("Rysunek dodany");
	}

	public void transform(Matrix m) {

		int[][] img = new int[w][h];

		log.info("Transformacja!");
		List<Pixel> pixels = new ArrayList<Pixel>();
		int _x = -1;
		int _y = -1;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				// img[i][j] = bufferedImage.getRGB(i, j);
				Matrix v = new Matrix(new double[][] { { i * w, j * h, 0 } });
				Matrix c = v.times(m);
				double[][] d = c.getArray();
				Pixel p = new Pixel(c.get(0, 0), c.get(0, 1), img[i][j]);
				if (p.x > _x) {
					_x = (int) p.x;
				}
				if (p.y > _y) {
					_y = (int) p.y;
				}
			}
		}
		int[][] tmp = new int[_x + 1][_y + 1];
		BufferedImage bufferedImage2 = new BufferedImage(_x + 1, _y + 1,
				BufferedImage.TYPE_INT_RGB);

		Matrix mat = m.inverse();
		for (int i = 0; i < bufferedImage2.getWidth(); i++) {
			for (int j = 0; j < bufferedImage2.getHeight(); j++) {
				Matrix v = new Matrix(new double[][] { { i, j, 0 } });
				Matrix c = v.times(mat);
				double[][] d = c.getArray();
				Pixel p = new Pixel(c.get(0, 0), c.get(0, 1), 0);
				// pixels.add(p);
				if ((int) p.x < w && (int) p.y < h) {
					bufferedImage2.setRGB(i, j,
							bufferedImage.getRGB((int) p.x, (int) p.y));
//					log.info("pixel changed " + (int) p.x + " " + (int) p.y);
				}
			}
		}
		bufferedImage=bufferedImage2;
		w = bufferedImage.getWidth();
		h = bufferedImage.getHeight();
		setPreferredSize(new Dimension(w, h));
		repaint();
		updateUI();
		log.info("I po transformacji");
	}
}

class Pixel {
	public Pixel(double x, double y, int v) {
		this.x = x;
		this.y = y;
		this.v = v;
	}

	public double x;
	public double y;
	public int v;
}
