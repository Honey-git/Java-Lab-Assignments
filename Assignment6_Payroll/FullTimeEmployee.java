public class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected double perfBonus;

    public FullTimeEmployee(String name, String panNo, String joiningDate, String designation, int empId, double baseSalary, double perfBonus) {
        super(name, panNo, joiningDate, designation, empId);
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
    }

    @Override
    public double calcCTC() {
        if (designation.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } else if (designation.equalsIgnoreCase("HR")) {
            return baseSalary + perfBonus; // Will override in HR if needed
        }
        return baseSalary;
    }
}