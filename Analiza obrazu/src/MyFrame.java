import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MyFrame extends JFrame implements Runnable{
	MyImage img;
	public MyFrame() throws IOException{
		super();
		
		this.img = new MyImage();
		this.setContentPane(img);
		BufferedImage bimg = ImageIO.read(new File("img.jpg"));
		int width          = bimg.getWidth();
		int height         = bimg.getHeight();
		
		this.setSize(width*2, height);
		this.setVisible(true);
		this.setTitle("Analiza obraz�w");
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	@Override
	public void run() {
		
		
	}
}
