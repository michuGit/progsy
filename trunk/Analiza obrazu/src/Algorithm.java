import java.awt.Color;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Algorithm {
	List<ArrayList<Double>> list1 = null;
	List<ArrayList<Double>> list2 = null;

	public Algorithm() throws FileNotFoundException, IOException {
		list1 = Helper.parseFile("file1.sift");
		list2 = Helper.parseFile("file1.sift");

	}

	public List<Line> findCouples() {
		List<Line> tmp = new ArrayList<Line>();
		Integer val = null;
		for (int i = 0; i < this.list1.size(); i++) {
			val = Helper.checkCouples(i, list1, list2);
			if (val != null) {
				float hue = (float)Math.random();
				int rgb = Color.HSBtoRGB(hue,0.5f,0.5f);
				tmp.add(new Line( list1.get(i)
						.get(1).intValue(), list2.get(i).get(0).intValue(), list2.get(i)
						.get(1).intValue(), list1.get(i).get(0).intValue(), new Color(rgb)));
				System.out.println("Couple found");
			}
			
		}
		System.out.println("Searching done, ["+tmp.size()+" couples]");
		return tmp;
	}


}
