import java.util.Date;
import java.util.List;


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
		long startTime = System.currentTimeMillis();
		
		
	//	this.list = przeszukiwanieWprzod.doIt();
		this.list = przeszukiwanieZNawracaniem.doIt();
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		
		System.out.println(estimatedTime+" ms");
		this.frame.draw(this.list);
	}
}
