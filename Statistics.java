import java.io.BufferedReader;
import java.io.FileReader;

public class Statistics {

    private String fileName = "UserHistory.csv";

    public void showStatistics() {

        int count = 0;
        double total = 0;
        double highest = 0;
        double lowest = Double.MAX_VALUE;

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 9) {

                    double carbon = Double.parseDouble(data[7]);

                    count++;
                    total = total + carbon;

                    if (carbon > highest) {
                        highest = carbon;
                    }

                    if (carbon < lowest) {
                        lowest = carbon;
                    }
                }
            }

            br.close();

            if (count == 0) {
                System.out.println("No records available for statistics.");
                return;
            }

            double average = total / count;

            System.out.println("\n================================");
            System.out.println("       CARBON STATISTICS");
            System.out.println("================================");

            System.out.println("Total Records       : " + count);
            System.out.printf("Total Carbon        : %.2f kg CO₂\n", total);
            System.out.printf("Average Carbon      : %.2f kg CO₂\n", average);
            System.out.printf("Highest Carbon      : %.2f kg CO₂\n", highest);
            System.out.printf("Lowest Carbon       : %.2f kg CO₂\n", lowest);

            System.out.println("================================");

        } catch (Exception e) {
            System.out.println("No history records found.");
        }
    }
}