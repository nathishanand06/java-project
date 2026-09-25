import java.io.FileWriter;
import java.io.PrintWriter;

public class ReportExporter {

    public void exportReport(User user, double total, String rating, String suggestion) {

        try {

            FileWriter fw = new FileWriter("CarbonReport.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("==============================================");
            pw.println("          CARBON FOOTPRINT REPORT");
            pw.println("==============================================");

            pw.println("Name          : " + user.getName());
            pw.println("Distance      : " + user.getDistance() + " km");
            pw.println("Electricity   : " + user.getElectricityUnits() + " kWh");
            pw.println("Food Type     : " + user.getFoodType());
            pw.println("Waste         : " + user.getWaste() + " kg");

            pw.println("----------------------------------------------");

            pw.printf("Total Carbon  : %.2f kg CO₂%n", total);
            pw.println("Rating        : " + rating);

            pw.println("----------------------------------------------");

            pw.println("Suggestions:");
            pw.println(suggestion);

            pw.println("==============================================");

            pw.close();

            System.out.println("Report exported successfully to CarbonReport.txt");

        } catch (Exception e) {
            System.out.println("Error exporting report.");
        }
    }
}