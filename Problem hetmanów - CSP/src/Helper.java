import java.util.ArrayList;
import java.util.List;



public class Helper {
	
	public static boolean checkIfContain(Point p1, Point p2){
		if(p1.x==p2.x || p1.y==p2.y || Math.abs(p1.y-p2.y)==Math.abs(p1.x-p2.x))
			return true;
	return false;
	}
	
	public static Object[] createTab(int iter){
		List<Object> tmp = new ArrayList<Object>();
		for(int i=0; i<Properties.N; i++){
			if(i==iter){
				tmp.add("X");
			}
			else{
				tmp.add("");
			}
		}
		return tmp.toArray();
	}

	public static List<List<Point>> copy(List<List<Point>> l) {
		List<List<Point>> tmp = new ArrayList<List<Point>>();
		for(int i=0;i<l.size();i++){
			List<Point> lst = new ArrayList<Point>();
			for(int j=0;j<l.get(i).size();j++){
				lst.add(l.get(i).get(j));
			}
			tmp.add(lst);
		}
		return tmp;
	}
}


