
public class MainTemperaturCSV {

	public static void main(String[] args) {
		/*
		 * Die Datei TemperaturenJJJJ.csv muss im Projektverzeichnis liegen (nicht im
		 * src oder im bin)
		 */

		// Das Objekt, welches die Daten aus der CSV-Datei ausliest
		TemperatureDataRetriever tdr = new TemperatureDataRetriever("Temperaturen2019.csv");
		
		tdr.printData();
	}

}
