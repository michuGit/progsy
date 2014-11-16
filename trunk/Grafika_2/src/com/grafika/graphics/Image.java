package com.grafika.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class Image extends JPanel implements Runnable {
	static Logger log = Logger.getLogger(Image.class.getName());

	private static final long serialVersionUID = 1L;

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
				BasicStroke.JOIN_ROUND, 1.0f, new float[] { 2f, 0f, 2f }, 2f);
		g2d.setStroke(bs);

		g2d.drawLine(0, bufferedImage.getHeight() / 2,
				bufferedImage.getWidth(), bufferedImage.getHeight() / 2);
		g2d.drawLine(bufferedImage.getWidth() / 2, 0,
				bufferedImage.getWidth() / 2, bufferedImage.getHeight());

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			// log.info("Repaint in thread...");
			repaint();
		}
	}

	public void changeImage(String pathToFile) {
		try {
			bufferedImage = ImageIO.read(new File(pathToFile));
			setPreferredSize(new Dimension(bufferedImage.getWidth(),
					bufferedImage.getHeight()));
		} catch (IOException ex) {
		}
		this.setBackground(Color.BLACK);
		log.info("Rysunek dodany");
	}
}
