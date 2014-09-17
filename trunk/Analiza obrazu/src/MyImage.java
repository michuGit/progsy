import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyImage extends JPanel {
	Image image1;
	Image image2;

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
	}
}