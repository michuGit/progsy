package com.grafika.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.grafika.data.Data;
import com.grafika.data.Person;
import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class ImagePanel extends JPanel implements MouseListener,
		MouseMotionListener {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(Main.class.getName());

	private Component parent;

	private BufferedImage bufferedImage;
	 private List<Ellipse2D> ell;
	 private List<Rectangle2D> rect;
	 private List<Polygon> poly;

	public static Data data;

	Graphics graphics;

	int X;
	int Y;
	public static boolean draw = false;
	double ratio = 0;

	public ImagePanel(Component parent) {

		Path path = Paths.get(Properties.filename);

		if (Files.exists(path)) {
			loadData();
			log.info("Dane wczytane");
		} else {
			data = new Data();
			log.warn("Nie znaleziono pliku");
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				saveData();
				log.info("Dane zapisane");
			}
		}));

		this.parent = parent;
		 this.ell = new ArrayList<Ellipse2D>();
		 this.rect = new ArrayList<Rectangle2D>();
		 this.poly = new ArrayList<Polygon>();

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public double ratio(int w, int h) {
		return (double) h / (double) w;
	}

	public void changeImage(String pathToFile) {
		try {
			this.bufferedImage = ImageIO.read(new File(pathToFile));
			this.ratio = ratio(this.bufferedImage.getWidth(),
					this.bufferedImage.getHeight());
			this.bufferedImage = fitImage();
		} catch (IOException ex) {
		}
		this.setBackground(Color.BLACK);
		log.info("Rysunek dodany");
	}

	private BufferedImage fitImage() {
		double screenRatio = ratio(this.parent.getWidth(),
				this.parent.getHeight());
		int W = this.parent.getWidth();
		int H = this.parent.getHeight();
		if (screenRatio > this.ratio) {
			H = (int) (this.ratio * W);
		} else {
			W = (int) (H / this.ratio);
		}
		Image image = this.bufferedImage.getScaledInstance(W, H,
				Image.SCALE_SMOOTH);
		BufferedImage buffered = new BufferedImage(W, H,
				bufferedImage.getType());
		buffered.getGraphics().drawImage(image, 0, 0, null);
		this.graphics = buffered.getGraphics();
		return buffered;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.bufferedImage != null) {
			this.bufferedImage = fitImage();
			g.drawImage(bufferedImage, 0, 0, this);
			log.info("Rysunek odswiezony <szerokosc=" + this.parent.getWidth()
					+ ", wysokosc=" + this.parent.getHeight() + ">");
			for (Person p : data.get()) {

				List<Ellipse2D> ellipse = p.getEllipseList();
				List<Rectangle2D> rectangle = p.getRectangleList();
				List<Polygon> polygon = p.getPolygonList();
				for (Ellipse2D e : ellipse) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(Color.BLUE);
					g2.draw(e);
				}
				for (Rectangle2D e : rectangle) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(Color.BLUE);
					g2.draw(e);
				}
				for (Polygon e : polygon) {
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(Color.BLUE);
					g2.draw(e);
				}
			}
			for (Ellipse2D e : ell) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLUE);
				g2.draw(e);
			}
			for (Rectangle2D e : rect) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLUE);
				g2.draw(e);
			}
			for (Polygon e : poly) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLUE);
				g2.draw(e);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (GroupRadioButtonPanel.elipsa.isSelected()) {
			this.ell.add(new Ellipse2D.Double(x, y, 0, 0));
			this.X = x;
			this.Y = y;
		} else if (GroupRadioButtonPanel.prostokat.isSelected()) {
			this.rect.add(new Rectangle2D.Double(x, y, 0, 0));
			this.X = x;
			this.Y = y;
		} else if (GroupRadioButtonPanel.wielokat.isSelected()) {
			if (draw == false) {
				this.poly.add(new Polygon());
				draw = true;
				GroupRadioButtonPanel.drawButton.setVisible(true);
			}
			this.poly.get(this.poly.size() - 1).addPoint(x, y);
			this.X = x;
			this.Y = y;
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (GroupRadioButtonPanel.elipsa.isSelected()) {
			paintEllipse(e);
		} else if (GroupRadioButtonPanel.prostokat.isSelected()) {
			paintRectangle(e);
		}
		// else if (GroupRadioButtonPanel.wielokat.isSelected()) {
		// paintMultiRectangle(e);
		// }
		repaint();
	}

	// //////////////////////////////////////////////////////////

	private void paintEllipse(MouseEvent e) {
		if (this.ell.get(this.ell.size() - 1) != null) {
			this.ell.get(this.ell.size() - 1).setFrame(
					(e.getX() < this.X) ? e.getX() : this.X,
					(e.getY() < this.Y) ? e.getY() : this.Y,
					Math.abs(this.X - e.getX()), Math.abs(this.Y - e.getY()));
		}
	}

	private void paintRectangle(MouseEvent e) {
		if (this.rect.get(this.rect.size() - 1) != null) {
			this.rect.get(this.rect.size() - 1).setFrame(
					(e.getX() < this.X) ? e.getX() : this.X,
					(e.getY() < this.Y) ? e.getY() : this.Y,
					Math.abs(this.X - e.getX()), Math.abs(this.Y - e.getY()));
		}
	}

	private void paintMultiRectangle(MouseEvent e) {
		if (this.poly.get(this.poly.size() - 1) != null) {
		}
	}

	public void saveData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(Properties.filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(data);

			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(Properties.filename);
			in = new ObjectInputStream(fis);
			data = (Data) in.readObject();
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
