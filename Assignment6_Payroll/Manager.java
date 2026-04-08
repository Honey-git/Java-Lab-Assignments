public class Manager extends FullTimeEmployee {
    private double ta; // Travel Allowance
    private double eduAllowance;

    public Manager(String name, String panNo, String joiningDate, int empId, double baseSalary, double perfBonus, double ta, double eduAllowance) {
        super(name, panNo, joiningDate, "Manager", empId, baseSalary, perfBonus);
        this.ta = ta;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + perfBonus + ta + eduAllowance;
    }
}