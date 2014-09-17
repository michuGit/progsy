import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Algorithm implements Runnable{
	List<ArrayList<Double>> list1 = null;
	List<ArrayList<Double>> list2 = null;

	public Algorithm() throws FileNotFoundException, IOException {
		list1 = Helper.parseFile("file1.sift");
		list2 = Helper.parseFile("file1.sift");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
