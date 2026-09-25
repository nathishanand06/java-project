public class Validation {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidDistance(double distance) {
        return !Double.isNaN(distance) &&
               !Double.isInfinite(distance) &&
               distance >= 0;
    }

    public static boolean isValidElectricity(double electricity) {
        return !Double.isNaN(electricity) &&
               !Double.isInfinite(electricity) &&
               electricity >= 0;
    }

    public static boolean isValidWaste(double waste) {
        return !Double.isNaN(waste) &&
               !Double.isInfinite(waste) &&
               waste >= 0;
    }

    public static boolean isValidFoodChoice(int choice) {
        return choice >= 1 && choice <= 3;
    }

    public static boolean isValidRecordId(int id) {
        return id > 0;
    }
}