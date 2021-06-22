import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemperatureDataRetriever {

	private static final String COMMA_DELIMITER = ";";
	public final int ANZAHL_DATENSAETZE = 365, ANZAHL_SPALTEN = 2; // so von uns vorgegeben
	private Path file = null;
	private List<List<String>> records = new ArrayList<>();

	public List<List<String>> getRecords() { return records; }

	public TemperatureDataRetriever(String filename) {
		super();
		this.file = Paths.get(filename);
		retrieve();
	}

	// Temperatur ist in der CSV-Datei eine ganze Zahl
	int getTemperatureInLine(int lineNumber) {
		return Integer.parseInt(records.get(lineNumber).get(1));
	}

	void retrieve() {
		try {
			List<String> lines =
					Files.readAllLines(file, StandardCharsets.UTF_8);
			for (String line : lines) {
				String[] values;
				if (line != null) {
					List<String> l = Arrays.asList(line.split(COMMA_DELIMITER));
					records.add(l);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("CSV-file does not exist.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Record does not exist.");
			e.printStackTrace();
		}

	}

	List<List<String>> getTemperatures() {
		retrieve();
		return records;
	}

	public void printData() {

		for (List<String> stringList : records) {
			for (String s : stringList)
				System.out.print(s + "; ");
			System.out.println();
		}
	}
}
