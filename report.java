public class report {

    public void displayReport(User user, double total, String rating, String suggestion) {

        System.out.println("\n==============================================");
        System.out.println("          CARBON FOOTPRINT REPORT");
        System.out.println("==============================================");

        System.out.println("Name          : " + user.getName());
        System.out.println("Distance      : " + user.getDistance() + " km");
        System.out.println("Electricity   : " + user.getElectricityUnits() + " kWh");
        System.out.println("Food Type     : " + user.getFoodType());
        System.out.println("Waste         : " + user.getWaste() + " kg");

        System.out.println("----------------------------------------------");

        System.out.printf("Total Carbon  : %.2f kg CO₂\n", total);
        System.out.println("Rating        : " + rating);

        System.out.println("----------------------------------------------");

        System.out.println("Suggestions:");
        System.out.println(suggestion);

        System.out.println("==============================================");
    }
}