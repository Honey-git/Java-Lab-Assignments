import java.time.Year;
public class vehicle {
    private String regNo;
    public Year mfgYear;
    public double price;
    public String color;
    private String mfgCode;
    public String brandName;
    public String modelName;
    public String fuelType;
    // Added efficiency factor
    public double efficiencyFactor;
    public void setMfgCode(String mCode){
        mfgCode = mCode;
    }
    public String getMfgCode(){
        return mfgCode;
    }
    public String getRegNo(){
        return regNo;
    }
    public void setRegNo(String rNo){
        regNo = rNo;
    }
    // default constructor
    public vehicle(){
        regNo = "KA01AB1234";
        mfgYear = Year.of(2020);
        price = 500000.99;
        color = "Silver";
        mfgCode = "HY1234";
        brandName = "Hyundai";
        modelName = "i10";
        fuelType = "Petrol";
        efficiencyFactor = 1.0; // Default efficiency
    }
    // parameterized constructor
    public vehicle(String bName, String mName,double p, String mCode, String fType, double eff){
        this.brandName = bName;
        this.modelName = mName;
        this.price = p;
        this.mfgCode = mCode;
        this.fuelType = fType;
        this.efficiencyFactor = eff;
    }
    // creating an object of vehicle
    public vehicle(String mname, double p, String rNo){
        this.modelName = mname;
        this.price = p;
        this.regNo = rNo;
        this.fuelType = "Diesel";
        efficiencyFactor = 1.0;
    }
    // copy constructor
    public vehicle(vehicle v){
        brandName = v.brandName;
        modelName = v.modelName;
        price = v.price;
        color = v.color;
        mfgCode = v.mfgCode;
        regNo = v.regNo;
        mfgYear = v.mfgYear;
        fuelType = v.fuelType;
        efficiencyFactor = v.efficiencyFactor;
    }
    // methods
    public void start(int initSp){
        System.out.println("I've started with initail speed of " + initSp + " km/h");
    }
    public void stop(){
        System.out.println("That was a nice ride!");
    }
    public void drive(int initGear, int initSp, int tgtSp){
        if (initGear == 0)
            System.out.println("I need to change the gear to 1");
        if (initSp < 20)
            System.out.println("This is the ideal speed to start with");
        else
            System.out.println("Becareful! You're going too fast too start");
        if (tgtSp > 200)
            System.out.println("Look out for cops! You're overspeeding!");
        else
            System.out.println("Good speed, enjoy the ride!");
    }
    // Mileage calculation with fuel type + efficiency factor
    public double calcTripMileage(double noOfKms, double fuelUsed){
        double baseMileage;
        if (fuelType.equals("Petrol")){
            baseMileage = (noOfKms / fuelUsed) * 1.0;
        }
        else if (fuelType.equals("Diesel")){
            baseMileage = (noOfKms / fuelUsed) * 1.2;
        }
        else if (fuelType.equals("Electric")){
            baseMileage = (noOfKms / fuelUsed) * 2.0;
        }
        else{
            baseMileage = noOfKms / fuelUsed;
        }
        // Applying efficiency factor
        return baseMileage * efficiencyFactor;
    }
}
