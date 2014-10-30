import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Populacion implements Runnable{
	private List <Specimen> populacion;
	private long size;
	private long numbefOfGenerations;
	private double propabilityOfKrossing;
	private double propabilityOfMutation;
	private List<Parcel> parcels;
	
	/**
	 * 
	 * @param size
	 * @param numbefOfGenerations
	 * @param propabilityOfKrossing
	 * @param propabilityOfMutation
	 * @param sizeOfGen
	 */
	public Populacion(long size, long numbefOfGenerations, double propabilityOfKrossing, double propabilityOfMutation, String str){
		System.out.println(str);
		this.size = size;
		this.numbefOfGenerations = numbefOfGenerations;
		this.propabilityOfKrossing = propabilityOfKrossing;
		this.propabilityOfMutation = propabilityOfMutation;
		this.populacion = new ArrayList<Specimen>();
		this.parcels = new ArrayList<Parcel>();
		
		inicializacion();
		
	}
	
	private void inicializacion() {
		
		
		for(int i = 0; i < Properties.values.length; i++){
			this.parcels.add(new Parcel(Properties.weights[i], Properties.values[i]));
		}
		
		Specimen s = null;
		
		for(int i = 0; i < this.size; i++){
			s = new Specimen();
			for(int j = 0; j < Properties.values.length; j++){		
				s.addGen(MathHelper.randomByte());
			}
			this.populacion.add(s);
			this.populacion.get(i).adjustGens();
			this.populacion.get(i).countValue();
		}
		Collections.sort(this.populacion);
		
	}

	public void addSpecimen(Specimen spec){
		this.populacion.add(spec);
	}
	
	private void krossing(){
	//	System.out.println(this.populacion.size());
		int iter = 0;
		for(int i = (int) (this.size/2); i < this.size; i++){
			if(MathHelper.checkPropability(propabilityOfKrossing)){
				Specimen spec = new Specimen();
				
				for(int j = 0; j < Properties.values.length; j++){		
					if(j<Properties.values.length/2){spec.addGen(this.populacion.get(i).gens.get(j));}
					else{spec.addGen(this.populacion.get(iter).gens.get(j));}	
				}
				this.populacion.add(spec);
				this.populacion.get(i).adjustGens();
				this.populacion.get(i).countValue();

				iter++;
			}
		}
		Collections.sort(this.populacion);
//		System.out.println(this.populacion.size());
	}
	
	private void mutation(){
		for(int i = 0; i < this.size; i++){
			if(MathHelper.checkPropability(propabilityOfMutation)){
				for(int j = Properties.values.length/2; j < Properties.values.length*2/3; j++){		
					this.populacion.get(i).swapGens(j, Properties.values.length - 1 - j);
					
				}
				this.populacion.get(i).adjustGens();
				this.populacion.get(i).countValue();
			}
		}
		Collections.sort(this.populacion);
	}
	
	private void selection(){
		for(int i = this.populacion.size()-1; i >= this.size;i--){
			this.populacion.remove(i);
		}
	}
	

	@Override
	public void run() {
		for(int i = 0; i<Properties.numberOfIterations;i++){
			for(int j = 0; j < this.numbefOfGenerations; j++){
				krossing();
				mutation();
				selection();
			}

			Counter.pop.add(this.populacion);
		}
		Counter.getInfo();
	}

}
