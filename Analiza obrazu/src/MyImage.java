import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyImage extends JPanel {
	Image image; // Declare a name for our Image object.

	// Create a constructor method
	public MyImage() {
		super();
		// Load an image file into our Image object.
		// This file has to be in the same
		// directory as ShowImage.class.
		File f = new File("img.jpg");
		if (f.exists()) {
			image = Toolkit.getDefaultToolkit().getImage("img.jpg");
			System.out.println("Image loaded");
		}
	}

	// The following methods are instance methods.

	/*
	 * Create a paintComponent() method to override the one in JPanel. This is
	 * where the drawing happens. We don't have to call it in our program, it
	 * gets called automatically whenever the panel needs to be redrawn, like
	 * when it it made visible or moved or whatever.
	 */
	public void paintComponent(Graphics g) {
/*
BufferedImage mainImage = ImageIO.read(new File("/path/to/file.jpg"));

BufferedImage replaceArea = mainImage.getSubimage(startFromLeft, startFromTop, width, height);
Graphics g = replaceArea.getGraphics();

BufferedImage replaceImage = ImageIO.read(new File("/path/to/replace.jpg"));
g.drawImage(replaceImage, 0, 0, width, height, null);
g.dispose(); 
		 
		*/
BufferedImage bimg1 = null;
BufferedImage bimg2 = null;
		try {
			bimg1 = ImageIO.read(new File("img.jpg"));
			bimg2 = ImageIO.read(new File("img.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int width          = bimg1.getWidth();
		int height         = bimg1.getHeight();
		// Draw our Image object.


		g.drawImage(image, 0, 0, width, height, this); // at location 50,10
		g.drawImage(image, width, 0, width, height, this); // at location 50,10
		// 200 wide and high
	}
	/*
	 * public static void main(String arg[]){ JFrame frame = new
	 * JFrame("ShowImage");
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setSize(600,400);
	 * 
	 * MyImage panel = new MyImage(); frame.setContentPane(panel);
	 * frame.setVisible(true); }
	 */
}