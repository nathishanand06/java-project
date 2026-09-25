import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HistoryManager {

    private String fileName = "UserHistory.csv";

    public void saveRecord(User user, double total, String rating) {

        try {
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);

            int id = getNextId();

            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            java.time.format.DateTimeFormatter formatter =
                    java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            pw.println(
                id + "," +
                now.format(formatter) + "," +
                user.getName() + "," +
                user.getDistance() + "," +
                user.getElectricityUnits() + "," +
                user.getFoodType() + "," +
                user.getWaste() + "," +
                total + "," +
                rating
            );

            pw.close();

        } catch (Exception e) {
            System.out.println("Error saving record.");
        }
    }

    private int getNextId() {

        int id = 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 9) {
                    int currentId = Integer.parseInt(data[0]);

                    if (currentId >= id) {
                        id = currentId + 1;
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            id = 1;
        }

        return id;
    }

    public void viewRecords() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            System.out.println("\n================ USER HISTORY ================");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 9) {

                    System.out.println("----------------------------------------");
                    System.out.println("ID : " + data[0]);
                    System.out.println("Date : " + data[1]);
                    System.out.println("Name : " + data[2]);
                    System.out.println("Distance : " + data[3] + " km");
                    System.out.println("Electricity : " + data[4] + " kWh");
                    System.out.println("Food : " + data[5]);
                    System.out.println("Waste : " + data[6] + " kg");
                    System.out.println("Total : " + data[7] + " kg CO₂");
                    System.out.println("Rating : " + data[8]);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No history records found.");
        }
    }

    public void searchRecord(String name) {

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 9 && data[2].equalsIgnoreCase(name)) {

                    System.out.println("\n========== SEARCH RESULT ==========");
                    System.out.println("ID : " + data[0]);
                    System.out.println("Date : " + data[1]);
                    System.out.println("Name : " + data[2]);
                    System.out.println("Distance : " + data[3] + " km");
                    System.out.println("Electricity : " + data[4] + " kWh");
                    System.out.println("Food : " + data[5]);
                    System.out.println("Waste : " + data[6] + " kg");
                    System.out.println("Total : " + data[7] + " kg CO₂");
                    System.out.println("Rating : " + data[8]);

                    found = true;
                }
            }

            br.close();

            if (!found) {
                System.out.println("No record found for " + name);
            }

        } catch (Exception e) {
            System.out.println("No history records found.");
        }
    }

    public void updateRecord(int id, User user, double total, String rating) {

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            ArrayList<String> records = new ArrayList<>();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 9 && Integer.parseInt(data[0]) == id) {

                    line = data[0] + "," +
                           data[1] + "," +
                           user.getName() + "," +
                           user.getDistance() + "," +
                           user.getElectricityUnits() + "," +
                           user.getFoodType() + "," +
                           user.getWaste() + "," +
                           total + "," +
                           rating;

                    found = true;
                }

                records.add(line);
            }

            br.close();

            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);

            for (String record : records) {
                pw.println(record);
            }

            pw.close();

            if (found) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with ID " + id);
            }

        } catch (Exception e) {
            System.out.println("Error updating record.");
        }
    }

    public void deleteRecord(int id) {

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            ArrayList<String> records = new ArrayList<>();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 9 && Integer.parseInt(data[0]) == id) {
                    found = true;
                } else {
                    records.add(line);
                }
            }

            br.close();

            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);

            for (String record : records) {
                pw.println(record);
            }

            pw.close();

            if (found) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with ID " + id);
            }

        } catch (Exception e) {
            System.out.println("Error deleting record.");
        }
    }
}