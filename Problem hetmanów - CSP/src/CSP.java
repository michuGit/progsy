import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CSP implements Runnable{
	MyFrame frame;
	PrzeszukiwanieWprzod przeszukiwanieWprzod;
	PrzeszukiwanieZNawracaniem przeszukiwanieZNawracaniem;
	List<Point> list;

	
	
	public CSP(){
		this.frame = new MyFrame();
		this.przeszukiwanieWprzod = new PrzeszukiwanieWprzod();
		this.przeszukiwanieZNawracaniem = new PrzeszukiwanieZNawracaniem();
		

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.list = przeszukiwanieWprzod.doIt();
//		this.list = przeszukiwanieZNawracaniem.doIt();
		System.out.println(list.size());
		this.frame.draw(this.list);
	//	this.frame.setPanel(null);
	}
}
