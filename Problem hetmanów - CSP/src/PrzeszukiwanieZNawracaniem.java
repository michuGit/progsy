import java.util.ArrayList;
import java.util.List;



public class PrzeszukiwanieZNawracaniem {
	
	public PrzeszukiwanieZNawracaniem(){

	}
	
	public List<Point> doIt() {

		return search(new ArrayList<Point>(), 0);
	}

	private ArrayList<Point> search(ArrayList<Point> arrayList, int j) {
		boolean flag = true;
		for(int i=0; i<Properties.N; i++){
			
			for(int k=0; k<arrayList.size(); k++){
				if(Helper.checkIfContain(new Point(i, j), arrayList.get(k))){
					flag = false;
				}	
			}
			if(flag==true){
				arrayList.add(new Point(i, j));
				if(arrayList.size() == Properties.N){
					System.out.println("Solution found " + arrayList.size());
					return arrayList;
				}
				else{
					System.out.println("Point("+i + ", " +j+") added");
					arrayList = search(arrayList, j+1);
					if(arrayList.size() == Properties.N){
						return arrayList;
					}
					arrayList.remove(arrayList.size()-1);
				}
			}
			flag = true;
		}
		return arrayList;
	}
}
