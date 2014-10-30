
public class Parcel {
	private double weight;
	private double value;
	
	public Parcel(double weight, double value){
		this.weight = weight;
		this.value = value;
	}
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	public void setValuet(double value){
		this.value = value;
	}
	
	public double getValue(){
		return this.value;
	}
}
