import java.io.*;
import java.util.*;

public class CSVReader {
    private HashMap<String, Double> factors;
    public CSVReader() {
        factors = new HashMap<>();
    }

    public void loadFactors(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String key = data[0].trim() + "-" + data[1].trim();
                    double value = Double.parseDouble(data[3].trim());
                    factors.put(key, value);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error Reading CSV File.");
        }
    }

    public double getTransportFactor(String vehicle) {
        return factors.getOrDefault("Transport-" + vehicle, 0.0);
    }

    public double getElectricityFactor() {
        return factors.getOrDefault("Electricity-Electricity", 0.0);
    }

    public double getFoodFactor(String food) {
        return factors.getOrDefault("Food-" + food, 0.0);
    }

    public double getWasteFactor() {
        return factors.getOrDefault("Waste-Mixed Waste", 0.0);
    }

}