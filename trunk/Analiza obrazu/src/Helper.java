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
		List<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		int iter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				ArrayList<Double> tmp = new ArrayList<Double>();
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				if (iter > 1 && line != null) {
					for (int i = 0; i < line.split(" ").length; i++) {
						tmp.add(Double.parseDouble(line.split(" ")[i]));
					}
					list.add(tmp);
				}
				iter++;
				System.out.println("Linia: " + iter + " wczytana");
			}
		}
		System.out.println("File parsed");
		return list;
	}

	public static Integer checkCouples(int var, List<ArrayList<Double>> list1,
			List<ArrayList<Double>> list2) {
		boolean flag = false;
		double min = Double.MAX_VALUE;
		int iter1=-1;
		int iter2=-1;
		double tmp = 0;
		double x = 0;
		
		for (int i = 0; i < list2.size(); i++) {
			tmp = 0;
			for (int j = 5; j < list2.get(i).size(); j++) {
				x = list2.get(i).get(j) - list1.get(var).get(j);
				tmp += x * x;
			}
			tmp = Math.sqrt(tmp);
			if (tmp < min) {
				min = tmp;
				iter1=i;
			}
		}
min=Double.MAX_VALUE;
		for (int i = 0; i < list1.size(); i++) {
			tmp = 0;
			for (int j = 5; j < list1.get(i).size(); j++) {
				x = list1.get(i).get(j) - list1.get(iter1).get(j);
				tmp += x * x;
			}
			tmp = Math.sqrt(tmp);
			if (tmp < min) {
				min = tmp;
				iter2=i;
			}
		}
	//	System.out.println(var+"  "+iter1+"  "+iter2);
		if(var==iter2){
			return iter1;
		}
		
		return null;
	}
}