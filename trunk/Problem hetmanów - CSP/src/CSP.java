import java.util.List;


public class CSP implements Runnable{
	MyFrame frame;
	PrzeszukiwanieWprzod przeszukiwanieWprzod;
	PrzeszukiwanieZNawracaniem przeszukiwanieZNawracaniem;
	List<Point> list;
	
	public CSP(){
	//	this.frame = new MyFrame();
		this.przeszukiwanieWprzod = new PrzeszukiwanieWprzod();
		this.przeszukiwanieZNawracaniem = new PrzeszukiwanieZNawracaniem();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	//	this.list = przeszukiwanieWprzod.doIt();
		przeszukiwanieZNawracaniem.doIt();
		
		
	//	this.frame.setPanel(null);
	}
}
