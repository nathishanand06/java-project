public class User {

    private String name;
    private double distance;
    private double electricityUnits;
    private int foodChoice;
    private double waste;

    public User() {
    }

    public User(String name, double distance, double electricityUnits, int foodChoice, double waste) {
        this.name = name;
        this.distance = distance;
        this.electricityUnits = electricityUnits;
        this.foodChoice = foodChoice;
        this.waste = waste;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setElectricityUnits(double electricityUnits) {
        this.electricityUnits = electricityUnits;
    }

    public void setFoodChoice(int foodChoice) {
        this.foodChoice = foodChoice;
    }

    public void setWaste(double waste) {
        this.waste = waste;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getElectricityUnits() {
        return electricityUnits;
    }

    public int getFoodChoice() {
        return foodChoice;
    }

    public double getWaste() {
        return waste;
    }

    public String getFoodType() {
        switch (foodChoice) {
            case 1:
                return "Vegetarian";
            case 2:
                return "Non-Vegetarian";
            case 3:
                return "Vegan";
            default:
                return "Unknown";
        }
    }
}