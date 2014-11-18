package com.grafika.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	List<Point> p = new ArrayList<Point>();
	List<Point> e = new ArrayList<Point>();
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
			if (e.size() == 0) {
				g.drawImage(bufferedImage, 0, 0, this);
				drawLines(g);
			} else {
				for (Point point : e) {
					g.setColor(Color.WHITE);
					g.drawLine(p.get(point.x).x, p.get(point.x).y,
							p.get(point.y).x, p.get(point.y).y);
				}
			}

		}
	}

	private void drawLines(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 2.0f, new float[] { 2f, 0f, 2f }, 2f);
		g2d.setStroke(bs);

		g2d.drawLine(0, h / 2, w, h / 2);
		g2d.drawLine(w / 2, 0, w / 2, h);
		// g2d.drawLine(0, 0, w, h);
		// g2d.drawLine(0, h, w, 0);
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

	}

	public void changeImageVector(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String everything = null;
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		} finally {
			br.close();
		}
		String[] chars = everything.split("\\s+");
		p = new ArrayList<Point>();
		e = new ArrayList<Point>();
		int _X = Integer.MIN_VALUE;
		int _Y = Integer.MIN_VALUE;
		int _x = Integer.MAX_VALUE;
		int _y = Integer.MAX_VALUE;
		boolean hash = false;
		for (int i = 0; i < chars.length; i++) {
			if (hash == false) {
				int x = Integer.parseInt(chars[i]);
				int y = Integer.parseInt(chars[++i]);
				if (x > _X) {
					_X = x;
				}
				if (y > _Y) {
					_Y = y;
				}
				if (x < _x) {
					_x = x;
				}
				if (y < _y) {
					_y = y;
				}
				p.add(new Point(x, y));
				if (chars[i + 1].equals("#")) {
					hash = true;
					i++;
				}
			} else {
				e.add(new Point(Integer.parseInt(chars[i]), Integer
						.parseInt(chars[++i])));
			}
		}

		bufferedImage = new BufferedImage(Math.abs(_x) + _X + 1, Math.abs(_y)
				+ _Y + 1, BufferedImage.TYPE_INT_RGB);

		w = bufferedImage.getWidth();
		h = bufferedImage.getHeight();
		setPreferredSize(new Dimension(w, h));
		this.setBackground(Color.BLACK);
	}
	public void transformVector(Matrix m) {
		for(Point point:p){
					Matrix v = new Matrix(new double[][] { {point.getX(), point.getY(), 0 } });
					Matrix c = v.times(m.inverse());
					double[][] d = c.getArray();
					point.x=(int) c.get(0, 0);
					point.y=(int) c.get(0, 1);
		}
	}
	public void transform(Matrix m) {
		log.info("Transformacja!");
		List<Pixel> pixels = new ArrayList<Pixel>();
		int _X = Integer.MIN_VALUE;
		int _Y = Integer.MIN_VALUE;
		int _x = Integer.MAX_VALUE;
		int _y = Integer.MAX_VALUE;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				Matrix v = new Matrix(new double[][] { { i * w, j * h, 0 } });
				Matrix c = v.times(m);
				double[][] d = c.getArray();
				Pixel p = new Pixel(c.get(0, 0), c.get(0, 1));
				if (p.x > _X) {
					_X = (int) p.x;
				}
				if (p.y > _Y) {
					_Y = (int) p.y;
				}
				if (p.x < _x) {
					_x = (int) p.x;
				}
				if (p.y < _y) {
					_y = (int) p.y;
				}
			}
		}
		int[][] tmp = new int[Math.abs(_x) + _X + 1][Math.abs(_y) + _Y + 1];
		BufferedImage bufferedImage2 = new BufferedImage(Math.abs(_x) + _X + 1,
				Math.abs(_y) + _Y + 1, BufferedImage.TYPE_INT_RGB);

		Matrix mat = m.inverse();
		for (int i = 0; i < bufferedImage2.getWidth(); i++) {
			for (int j = 0; j < bufferedImage2.getHeight(); j++) {
				Matrix v = new Matrix(new double[][] { { i + _x, j + _y, 0 } });
				Matrix c = v.times(mat);
				double[][] d = c.getArray();

				if ((int) Math.ceil(c.get(0, 0)) < w
						&& (int) Math.ceil(c.get(0, 1)) < h
						&& (int) Math.floor(c.get(0, 0)) >= 0
						&& (int) Math.floor(c.get(0, 1)) >= 0) {
					int p = bilineralTransformation(c.get(0, 0), c.get(0, 1));
					bufferedImage2.setRGB(i, j, p);
				}
			}
		}
		bufferedImage = bufferedImage2;
		w = bufferedImage.getWidth();
		h = bufferedImage.getHeight();
		setPreferredSize(new Dimension(w, h));
		repaint();
		updateUI();
		log.info("I po transformacji");
	}

	private int bilineralTransformation(double x, double y) {
		Color a = new Color(bufferedImage.getRGB((int) Math.floor(x),
				(int) Math.floor(y)));
		Color b = new Color(bufferedImage.getRGB((int) Math.ceil(x),
				(int) Math.floor(y)));
		Color c = new Color(bufferedImage.getRGB((int) Math.floor(x),
				(int) Math.ceil(y)));
		Color d = new Color(bufferedImage.getRGB((int) Math.ceil(x),
				(int) Math.ceil(y)));
		double alpha = x % 1;
		double betha = y % 1;

		int red = countColor(alpha, betha, a.getRed(), b.getRed(), c.getRed(),
				d.getRed());
		int green = countColor(alpha, betha, a.getGreen(), b.getGreen(),
				c.getGreen(), d.getGreen());
		int blue = countColor(alpha, betha, a.getBlue(), b.getBlue(),
				c.getBlue(), d.getBlue());
		if (red > 255 || blue > 255 || green > 255) {
			int asd = 234;
		}
		Color cc = new Color(red, green, blue);
		return cc.getRGB();
	}

	private int countColor(double alpha, double betha, int a, int b, int c,
			int d) {
		double kA = (1 - alpha) * a + alpha * b;
		double kB = (1 - alpha) * c + alpha * d;
		double kD = (1 - betha) * kA + betha * kB;
		return (int) kD;
	}

}

class Pixel {
	public Pixel(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x;
	public double y;
}
