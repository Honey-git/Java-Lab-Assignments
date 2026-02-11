public class MainForVehicle {

    public static void main(String[] args) {

        vehicle v1 = new vehicle();
        printVehicleDetails(v1);

        vehicle v2 = new vehicle("Toyota", "Camry", 3000000.00, "TY5678",
                                 "Diesel", 0.9);
        printVehicleDetails(v2);

        v2.start(20);
        v2.drive(0, 21, 120);

        double mileage = v2.calcTripMileage(140, 20);
        System.out.println("The mileage for the trip is: " + String.format("%.2f", mileage) + " km/l");

        v2.stop();

        vehicle v3 = v2;
        v3.setMfgCode("HON89733");
        v3.color = "Orange";
        v3.fuelType = "Electric";
        v3.efficiencyFactor = 1.5;

        printVehicleDetails(v3);
    }

    public static void printVehicleDetails(vehicle v){

        double mileage = v.calcTripMileage(140, 20);

        System.out.println("\n==================== VEHICLE DETAILS ====================\n");

        System.out.println("Brand        Model        Year     Fuel       Eff     Mileage     Price");
        System.out.println("---------------------------------------------------------------");

        System.out.println(
            v.brandName + "     " +
            v.modelName + "        " +
            v.mfgYear + "   " +
            v.fuelType + "     " +
            v.efficiencyFactor + "     " +
            String.format("%.2f", mileage) + "     " +
            v.price
        );

        System.out.println("\nReg No      : " + v.getRegNo());
        System.out.println("Mfg Code    : " + v.getMfgCode());

        System.out.println("\n=========================================================\n");
    }
}