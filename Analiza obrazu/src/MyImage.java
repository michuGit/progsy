import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyImage extends JPanel {
	Image image1;
	Image image2;
	List<Line> lines;

	public MyImage() {
		super();
		File f1 = new File(Properties.file1);
		File f2 = new File(Properties.file1);
		if (f1.exists() && f2.exists()) {
			image1 = Toolkit.getDefaultToolkit().getImage(Properties.file1);
			System.out.println("Image 1 loaded");
			image2 = Toolkit.getDefaultToolkit().getImage(Properties.file2);
			System.out.println("Image 2 loaded");
		}
	}

	@SuppressWarnings("unused")
	public void paintComponent(Graphics g) {

		BufferedImage bimg1 = null;
		BufferedImage bimg2 = null;
		try {
			bimg1 = ImageIO.read(new File(Properties.file1));
			bimg2 = ImageIO.read(new File(Properties.file2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int width = bimg1.getWidth();
		int height = bimg1.getHeight();

		g.drawImage(image1, 0, 0, width, height, this); // at location 50,10
		g.drawImage(image2, width, 0, width, height, this); // at location 50,10
		if (lines != null) {
			for (Line line : lines) {
				g.setColor(line.color);
				g.drawLine(line.x1, line.y1, line.x2 + width, line.y2);
			}
		}
		this.lines = new ArrayList<Line>();
	}

	/*
	 * public void addLine(int x1, int x2, int x3, int x4) { addLine(x1, x2, x3,
	 * x4, Color.black); }
	 */
	/*
	 * public void addLine(int x1, int x2, int x3, int x4, Color color) {
	 * lines.add(new Line(x1,x2,x3,x4, color)); repaint(); }
	 */

	public void setListe(List<Line> list) {
		this.lines = list;
		this.repaint();
	}
	
	public void addLinie(Line list) {
		this.lines.add(list);
		this.repaint();
	}
}