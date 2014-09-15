import java.util.ArrayList;
import java.util.List;


public class PrzeszukiwanieWprzod {

	List<List<Point>> list;
	boolean end=false;
	
	public PrzeszukiwanieWprzod(){
		end=false;
		list = new  ArrayList<List<Point>>();
		for(int i = 0; i<Properties.N; i++){
			list.add(getAllPossibilities(i));
		}
	}
	
	private List<Point> getAllPossibilities(int i){
		List<Point> tmp = new ArrayList<Point>();
		//for(int i=0; i<Properties.N; i++){
			for(int j=0; j<Properties.N; j++){
				tmp.add(new Point(i, j));
			}	
		//}
		return tmp;
	}
	
	public List<Point> doIt() {
		search(list, 0);
		return translate();
	}

	private List<List<Point>> search(List<List<Point>> _lis, int iter) {
		if(iter==Properties.N){
			end=true;
			list=_lis;
		//	System.out.println("job done");
			return _lis;
		}
		for(int i=0;i<_lis.get(iter).size();i++){
		//	System.out.println(iter);
			search(remover(_lis,_lis.get(iter).get(i),iter), iter+1);
			if(iter==Properties.N || end == true){
			//	System.out.println("job done");
				return _lis;
			}
		}
		return _lis;
	}
	
	private List<List<Point>> remover(List<List<Point>> l, Point p, int iter){
		List<List<Point>> copy = Helper.copy(l);
		//System.out.println(p.x+" "+p.y);
		for(int i=iter;i<Properties.N;i++){
			if(i == iter){
				List<Point> tmp = new ArrayList<Point>();
				tmp.add(p);
				copy.set(i, tmp);
			}
			else{
				for(int j=copy.get(i).size()-1;j>=0;j--){
					if(Helper.checkIfContain(p, copy.get(i).get(j))){
						copy.get(i).remove(j);
					}
				}
			}
		}
		return copy;
	}

	private List<Point> translate() {
		List<Point> tmp = new ArrayList<Point>();
		for(int i=0;i<list.size();i++){
			for(int j=list.get(i).size()-1;j>=0;j--){
				tmp.add(new Point(list.get(i).get(j).y, list.get(i).get(j).x));
				//System.out.println(list.get(i).get(j).x+"  "+list.get(i).get(j).y);
			}
		}
		return tmp;
	}

}
