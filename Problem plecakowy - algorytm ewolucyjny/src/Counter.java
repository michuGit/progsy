import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Counter {
	public static List<List<Specimen>> pop = new ArrayList<List<Specimen>>();
	
	
	public static void getInfo(){
		List<Double> tmp = new ArrayList<Double>();
		double sum = 0;
		for(int i=0;i<Counter.pop.size();i++){
			for(int j = 0; j< pop.get(i).size();j++){
				tmp.add(pop.get(i).get(j).value);
				sum += pop.get(i).get(j).value;
			}
			
		}
		
		System.out.println("Minimalna wartoœæ: " + Collections.min(tmp));
		System.out.println("Maksymalna wartoœæ: " + Collections.max(tmp));
		System.out.println("Srednia wartoœæ: " + sum/tmp.size());
		System.out.println("Odchylenie stand.: " + MathHelper.dev(tmp, sum/tmp.size()) + "\n");
	}
}
