
public class Punkt  implements Comparable<Punkt>{
	int i;
	double val;
	
	
	
	public Punkt(int j, double liczOdleglosc) {
		this.i=j;
		this.val=liczOdleglosc;
	}



	@Override
	public int compareTo(Punkt arg) {
		// TODO Auto-generated method stub
		return (int)(arg.val - this.val);
	}  
}
