public class CarbonCalculator extends EmissionCalculator {

    private CSVReader csv;

    public CarbonCalculator(CSVReader csv) {
        this.csv = csv;
    }

    @Override
    public String getType() {
        return "Carbon Footprint Calculator";
    }

    public double calculateTransport(double distance) {
        double factor = csv.getTransportFactor("Car (Petrol)");
        return calculate(distance, factor);
    }

    public double calculateElectricity(double units) {
        double factor = csv.getElectricityFactor();
        return calculate(units, factor);
    }

    public double calculateFood(int choice) {

        String food;

        switch (choice) {
            case 1:
                food = "Vegetarian";
                break;

            case 2:
                food = "Non-Vegetarian";
                break;

            case 3:
                food = "Vegan";
                break;

            default:
                return 0;
        }

        return csv.getFoodFactor(food);
    }

    public double calculateWaste(double wasteKg) {
        double factor = csv.getWasteFactor();
        return calculate(wasteKg, factor);
    }

    public double calculateTotal(User user) {

        double transport = calculateTransport(user.getDistance());
        double electricity = calculateElectricity(user.getElectricityUnits());
        double food = calculateFood(user.getFoodChoice());
        double waste = calculateWaste(user.getWaste());

        return transport + electricity + food + waste;
    }

    public String getRating(double total) {

        if (total < 50) {
            return "Excellent";
        } else if (total < 100) {
            return "Good";
        } else if (total < 200) {
            return "Moderate";
        } else {
            return "High";
        }
    }

    public String getSuggestion(double total) {

        if (total < 50) {
            return "Excellent! Continue your eco-friendly habits.";
        } else if (total < 100) {
            return "Try using public transport and reduce electricity usage.";
        } else if (total < 200) {
            return "Reduce vehicle usage, electricity consumption and waste.";
        } else {
            return "Your carbon footprint is high. Consider major lifestyle changes.";
        }
    }
}