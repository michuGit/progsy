import java.util.List;


public class MathHelper {

	public static boolean checkPropability(double value){
		return (Math.random() > value) ? false : true;
	}
	
	public static int randomByte(){
		return (Math.random() <= 0.5) ? 0 : 1;
	}
	
	public static double average(List <Specimen> populacion){
		double tmp = 0;
		for(int i = 0; i < populacion.size();i++){
			tmp += populacion.get(i).value;
		}
		return tmp/populacion.size();
	}
	
	public static double dev(List<Double> val, double avg){
		double tmp=0;

		for(int i=0; i<val.size();i++){
			tmp+= Math.pow(val.get(i)-avg, 2); 
		}
		tmp=tmp/(avg-1);
		return Math.sqrt(tmp);
	}
	
}
