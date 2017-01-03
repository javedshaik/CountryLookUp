import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Driver object = new Driver();
		String input = object.userInput(sc);
		object.hashMapLoad(object.storeFiles());
		sc.close();

	}

	public String userInput(Scanner scanner) {

		System.out.print("Enter a city:");
		String s = scanner.nextLine();
		return s;

	}

	public HashMap<String, String> hashMapLoad(File[] files) {
		HashMap<String, String> city = new HashMap<>();

		String line = null, country = null;

		try {
			BufferedReader bufferedReader = new BufferedReader(
					new FileReader("C:/Users/javed/workspace/CountryLookUp/src"));

			System.out.println(line = bufferedReader.readLine());
			while ((line = bufferedReader.readLine()) != null) {
				if (line.charAt(line.length() - 1) == ':') {
					country = line.substring(0, line.length() - 1);
				}

				city.put(line, country);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Error reading file");
		}

		return city;
	}

	public File[] storeFiles() {
		File folder = new File("C:/Users/javed/workspace/CountryLookUp/src");
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;
	}

}