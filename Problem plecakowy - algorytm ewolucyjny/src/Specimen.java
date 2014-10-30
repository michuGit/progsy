import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author michu
 *
 * Klasa osobnik
 */
public class Specimen implements Comparable<Specimen>{
	public List<Integer> gens;
	public double value;
	public Specimen(){
		this.gens = new ArrayList<Integer>();
	}
	
	public List<Integer> getGens(){
		return this.gens;
	}
	
	public void addGen(Integer b){
		this.gens.add(b);
	}
	
	public void swapGens(int g1, int g2){
		int v1 = this.gens.get(g1);
		int v2 = this.gens.get(g2);
		this.gens.set(g1, v2);
		this.gens.set(g2, v1);
	}
	
	public void countValue(){
		this.value = 0;
		for(int i = 0; i < this.gens.size(); i++){
			if(gens.get(i) == 1){
				this.value += Properties.values[i];
			}
		}
	}
	
	private boolean checkSize(){
		double weight = 0;
		for(int i = 0; i< this.gens.size(); i++){
			if(this.gens.get(i) == 0 ? false : true){
				weight += Properties.weights[i];
			}
		}
//		System.out.println(weight+"     "+Properties.capacity);
		return (weight > Properties.capacity) ? true : false;
	}
	
	public void adjustGens(){
		while(checkSize()){
//			System.out.println(this.gens.size());
			for(int i = 0; i < this.gens.size(); i++){
				if(MathHelper.checkPropability(1/(double)this.gens.size())){
					this.gens.set(i, 0);
			//		System.out.println("Gen changed");
				}
			}
		}
	}

	@Override
	public int compareTo(Specimen arg) {
		// TODO Auto-generated method stub
		return (int)(arg.value - this.value);
	}
}
