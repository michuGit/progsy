import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helper {

	@SuppressWarnings("unused")
	public static String loadFile(String filename)
			throws FileNotFoundException, IOException {
		String everything = "";

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		}
		System.out.println("File loaded");
		return everything;
	}
	
	public static List<ArrayList<Double>> parseFile(String filename)
			throws FileNotFoundException, IOException {
		String everything = "";
		List<ArrayList<Double>> list = new  ArrayList<ArrayList<Double>>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				ArrayList<Double> tmp = new ArrayList<Double>();
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				for(int i=0;i<line.split(" ").length;i++){
					tmp.add(Double.parseDouble(line.split(" ")[i]));
				}
				list.add(tmp);
			}
		}
		System.out.println("File loaded");
		return list;
	}
}