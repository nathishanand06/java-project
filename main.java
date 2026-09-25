import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CSVReader csv = new CSVReader();
        csv.loadFactors("EmissionFactors.csv");

        CarbonCalculator calculator = new CarbonCalculator(csv);
        HistoryManager history = new HistoryManager();
        report report = new report();
        Statistics statistics = new Statistics();
        ReportExporter exporter = new ReportExporter();

        User lastUser = null;
        double lastTotal = 0;
        String lastRating = "";
        String lastSuggestion = "";

        while (true) {

            System.out.println("\n================================");
            System.out.println("   CARBON FOOTPRINT CALCULATOR");
            System.out.println("================================");
            System.out.println("1. Calculate Carbon Footprint");
            System.out.println("2. View History");
            System.out.println("3. Search Record");
            System.out.println("4. Update Record");
            System.out.println("5. Delete Record");
            System.out.println("6. View Statistics");
            System.out.println("7. Export Last Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid choice.");
                sc.next();
                continue;
            }

            if (choice == 1) {

                User user = new User();

                sc.nextLine();

                System.out.print("Enter Name: ");
                user.setName(sc.nextLine());

                double distance;

                while (true) {
                    try {
                        System.out.print("Enter Distance (km): ");
                        distance = sc.nextDouble();

                        if (distance < 0) {
                            System.out.println("Distance cannot be negative.");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }

                user.setDistance(distance);

                double electricity;

                while (true) {
                    try {
                        System.out.print("Enter Electricity Units (kWh): ");
                        electricity = sc.nextDouble();

                        if (electricity < 0) {
                            System.out.println("Electricity cannot be negative.");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }

                user.setElectricityUnits(electricity);

                int foodChoice;

                while (true) {

                    System.out.println("\nFood Type");
                    System.out.println("1. Vegetarian");
                    System.out.println("2. Non-Vegetarian");
                    System.out.println("3. Vegan");
                    System.out.print("Choice: ");

                    try {
                        foodChoice = sc.nextInt();

                        if (foodChoice >= 1 && foodChoice <= 3) {
                            break;
                        }

                        System.out.println("Please choose 1, 2, or 3.");

                    } catch (Exception e) {
                        System.out.println("Please enter a valid choice.");
                        sc.next();
                    }
                }

                user.setFoodChoice(foodChoice);

                double waste;

                while (true) {
                    try {
                        System.out.print("Enter Waste (kg): ");
                        waste = sc.nextDouble();

                        if (waste < 0) {
                            System.out.println("Waste cannot be negative.");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }

                user.setWaste(waste);

                double total = calculator.calculateTotal(user);
                String rating = calculator.getRating(total);
                String suggestion = calculator.getSuggestion(total);

                history.saveRecord(user, total, rating);

                report.displayReport(user, total, rating, suggestion);

                lastUser = user;
                lastTotal = total;
                lastRating = rating;
                lastSuggestion = suggestion;

                System.out.println("\nRecord saved successfully.");

            } else if (choice == 2) {

                history.viewRecords();

            } else if (choice == 3) {

                sc.nextLine();

                System.out.print("Enter Name to Search: ");
                String name = sc.nextLine();

                history.searchRecord(name);

            } else if (choice == 4) {

                System.out.print("Enter Record ID to Update: ");

                int id;

                try {
                    id = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a valid ID.");
                    sc.next();
                    continue;
                }

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                User user = new User();
                user.setName(name);

                double distance;

                while (true) {
                    try {
                        System.out.print("Enter New Distance (km): ");
                        distance = sc.nextDouble();

                        if (distance < 0) {
                            System.out.println("Distance cannot be negative.");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }

                user.setDistance(distance);

                double electricity;

                while (true) {
                    try {
                        System.out.print("Enter New Electricity Units (kWh): ");
                        electricity = sc.nextDouble();

                        if (electricity < 0) {
                            System.out.println("Electricity cannot be negative.");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }

                user.setElectricityUnits(electricity);

                int foodChoice;

                while (true) {

                    System.out.println("\nNew Food Type");
                    System.out.println("1. Vegetarian");
                    System.out.println("2. Non-Vegetarian");
                    System.out.println("3. Vegan");
                    System.out.print("Choice: ");

                    try {
                        foodChoice = sc.nextInt();

                        if (foodChoice >= 1 && foodChoice <= 3) {
                            break;
                        }

                        System.out.println("Please choose 1, 2, or 3.");

                    } catch (Exception e) {
                        System.out.println("Please enter a valid choice.");
                        sc.next();
                    }
                }

                user.setFoodChoice(foodChoice);

                double waste;

                while (true) {
                    try {
                        System.out.print("Enter New Waste (kg): ");
                        waste = sc.nextDouble();

                        if (waste < 0) {
                            System.out.println("Waste cannot be negative.");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                }

                user.setWaste(waste);

                double total = calculator.calculateTotal(user);
                String rating = calculator.getRating(total);
                String suggestion = calculator.getSuggestion(total);

                history.updateRecord(id, user, total, rating);

                report.displayReport(user, total, rating, suggestion);

                lastUser = user;
                lastTotal = total;
                lastRating = rating;
                lastSuggestion = suggestion;

            } else if (choice == 5) {

                System.out.print("Enter Record ID to Delete: ");

                int id;

                try {
                    id = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a valid ID.");
                    sc.next();
                    continue;
                }

                history.deleteRecord(id);

            } else if (choice == 6) {

                statistics.showStatistics();

            } else if (choice == 7) {

                if (lastUser == null) {
                    System.out.println("Please calculate a carbon footprint first.");
                } else {
                    exporter.exportReport(
                        lastUser,
                        lastTotal,
                        lastRating,
                        lastSuggestion
                    );
                }

            } else if (choice == 8) {

                System.out.println("Thank you for using Carbon Footprint Calculator.");
                break;

            } else {

                System.out.println("Invalid choice. Please select 1 to 8.");
            }
        }

        sc.close();
    }
}