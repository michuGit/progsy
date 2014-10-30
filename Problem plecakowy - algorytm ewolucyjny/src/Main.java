import java.util.Date;

/**
 * 
 * @author michu
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Problem plecakowy.\n");
		
		Date start = new Date();
		/***********************************************/
		
		Populacion pop;
		
		pop = new Populacion(50,50,0.1,0.01,"50,50,0.1,0.01");
		pop.run();
		pop = new Populacion(50,100,0.2,0.1,"50,100,0.2,0.1");
		pop.run();
		pop = new Populacion(50,500,0.5,0.2,"50,500,0.5,0.2");
		pop.run();
		pop = new Populacion(50,500,0.75,0.5,"50,500,0.75,0.5");
		pop.run();
		
		pop = new Populacion(100,50,0.1,0.01,"100,50,0.1,0.01");
		pop.run();
		pop = new Populacion(100,100,0.2,0.1,"100,100,0.2,0.1");
		pop.run();
		pop = new Populacion(100,500,0.5,0.2,"100,500,0.5,0.2");
		pop.run();
		pop = new Populacion(100,500,0.75,0.5,"100,500,0.75,0.5");
		pop.run();
		
		pop = new Populacion(200,50,0.1,0.01,"200,50,0.1,0.01");
		pop.run();
		pop = new Populacion(200,100,0.2,0.1,"200,100,0.2,0.1");
		pop.run();
		pop = new Populacion(200,500,0.5,0.2,"200,500,0.5,0.2");
		pop.run();
		pop = new Populacion(200,500,0.75,0.5,"200,500,0.75,0.5");
		pop.run();
		
		pop = new Populacion(500,50,0.1,0.01,"500,50,0.1,0.01");
		pop.run();
		pop = new Populacion(500,100,0.2,0.1,"500,100,0.2,0.1");
		pop.run();
		pop = new Populacion(500,500,0.5,0.2,"500,500,0.5,0.2");
		pop.run();
		pop = new Populacion(500,500,0.75,0.5,"500,500,0.75,0.5");
		pop.run();
		
		/***********************************************/
		Date stop = new Date();
		System.out.println("\nI po problemie po "+ (stop.getTime() - start.getTime())/1000 +" sekundach :)");
	}

}
