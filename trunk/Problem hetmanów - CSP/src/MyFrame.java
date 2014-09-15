import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	JPanel panel;
	public MyFrame(){
		super();
		this.setSize(480, 600);
		this.setVisible(true);
		this.setTitle("N-hetmanów");
		this.setResizable(false);
		
		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		this.panel.setSize(480, 480);
		this.add(this.panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setPanel(List<Point> list){
		
	}
}
