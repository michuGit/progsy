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
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.grafika.data.Data;
import com.grafika.data.Person;
import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class ImagePanel extends JPanel implements MouseListener,
		MouseMotionListener, Runnable {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(Main.class.getName());

	private Component parent;

	private BufferedImage bufferedImage;
	private static List<Ellipse2D> ell;
	private static List<Rectangle2D> rect;
	private static List<Polygon> poly;

	public static Data data;

	Graphics graphics;

	int X;
	int Y;
	public static boolean draw = false;
	double ratio = 0;

	public ImagePanel(Component parent) {

		Path path = Paths.get(Properties.filename);

		data = new Data();
		ToolsPanel.table = new Table();

		this.parent = parent;
		ImagePanel.ell = new ArrayList<Ellipse2D>();
		ImagePanel.rect = new ArrayList<Rectangle2D>();
		ImagePanel.poly = new ArrayList<Polygon>();

		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public static void clean() {
		ell = new ArrayList<Ellipse2D>();
		rect = new ArrayList<Rectangle2D>();
		poly = new ArrayList<Polygon>();
	}

	public static Boolean save() {
		Person person = new Person();
		person.setName(Properties.userName);

		Boolean b = false;
		for (Ellipse2D e : ell) {
			person.addFigure(e);
			b = true;
			log.info("znaleziono elipse");
		}
		for (Rectangle2D r : rect) {
			person.addFigure(r);
			b = true;
			log.info("znaleziono prostokat");
		}
		for (Polygon p : poly) {
			person.addFigure(p);
			b = true;
			log.info("znaleziono wielokat");
		}
		if (b == true) {
			person.setColor(JColorChooser.showDialog(null, "Choose a Color",
					null));
		}
		data.add(person);
		return b;
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
				if (p.visible) {
					if (p.getFigure() instanceof Ellipse2D) {
						Graphics2D g2 = (Graphics2D) g;
						g2.setColor(p.getColor());
						g2.draw((Ellipse2D) p.getFigure());
						// g2.draw((Ellipse2D) p.getFigure());
					}
					if (p.getFigure() instanceof Rectangle2D) {
						Graphics2D g2 = (Graphics2D) g;
						g2.setColor(p.getColor());
						g2.draw((Rectangle2D) p.getFigure());
					}
					if (p.getFigure() instanceof Polygon) {
						Graphics2D g2 = (Graphics2D) g;
						g2.setColor(p.getColor());
						g2.draw((Polygon) p.getFigure());
					}

				}
			}
			for (Ellipse2D e : ell) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.RED);
				g2.draw(e);
			}
			for (Rectangle2D e : rect) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.RED);
				g2.draw(e);
			}
			for (Polygon e : poly) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.RED);
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
			ImagePanel.ell.add(new Ellipse2D.Double(x, y, 0, 0));
			this.X = x;
			this.Y = y;
		} else if (GroupRadioButtonPanel.prostokat.isSelected()) {
			ImagePanel.rect.add(new Rectangle2D.Double(x, y, 0, 0));
			this.X = x;
			this.Y = y;
		} else if (GroupRadioButtonPanel.wielokat.isSelected()) {
			if (draw == false) {
				ImagePanel.poly.add(new Polygon());
				draw = true;
				GroupRadioButtonPanel.addButton.setVisible(true);
			}
			ImagePanel.poly.get(ImagePanel.poly.size() - 1).addPoint(x, y);
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
		repaint();
	}

	private void paintEllipse(MouseEvent e) {
		if (ImagePanel.ell.get(ImagePanel.ell.size() - 1) != null) {
			ImagePanel.ell.get(ImagePanel.ell.size() - 1).setFrame(
					(e.getX() < this.X) ? e.getX() : this.X,
					(e.getY() < this.Y) ? e.getY() : this.Y,
					Math.abs(this.X - e.getX()), Math.abs(this.Y - e.getY()));
		}
	}

	private void paintRectangle(MouseEvent e) {
		if (ImagePanel.rect.get(ImagePanel.rect.size() - 1) != null) {
			ImagePanel.rect.get(ImagePanel.rect.size() - 1).setFrame(
					(e.getX() < this.X) ? e.getX() : this.X,
					(e.getY() < this.Y) ? e.getY() : this.Y,
					Math.abs(this.X - e.getX()), Math.abs(this.Y - e.getY()));
		}
	}

	private void paintMultiRectangle(MouseEvent e) {
		if (ImagePanel.poly.get(ImagePanel.poly.size() - 1) != null) {
		}
	}

	public static void saveData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(Properties.filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(data);
			log.info("zapisywanie...");
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void loadData() {
		Properties.first = true;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(Properties.filename);
			in = new ObjectInputStream(fis);
			data = (Data) in.readObject();
			if (ToolsPanel.table == null) {
				ToolsPanel.table = new Table();
			}
			ToolsPanel.table.addData(convertData(data));
			ToolsPanel.table.repaint();
			in.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Object[][] convertData(Data data2) {
		List<List<Object>> l = new ArrayList<List<Object>>();

		for (Person p : data.get()) {
			List<Object> o = new ArrayList<Object>();
			o.add(p.getName());
			if (p.getFigure() instanceof Ellipse2D) {
				o.add("elipsa");
			}
			if (p.getFigure() instanceof Rectangle2D) {
				o.add("prostok¹t");
			}
			if (p.getFigure() instanceof Polygon) {
				o.add("wielok¹t");
			}
			o.add(p.visible);
			l.add(o);
		}
		return toArray(l);
	}

	public static Object[][] toArray(List<List<Object>> list) {
		Object[][] r = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				r[i][j] = list.get(i).get(j);
			}
		}
		return r;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			log.info("Repaint in thread...");
			repaint();
		}

	}

}
