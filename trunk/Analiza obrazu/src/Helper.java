import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		return null;
	}
}
