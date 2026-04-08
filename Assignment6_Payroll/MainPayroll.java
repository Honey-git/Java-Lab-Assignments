public class MainPayroll {
    public static void main(String[] args) {
        FullTimeEmployee swe = new FullTimeEmployee("Alice", "PAN123", "2022-01-01", "SWE", 1, 50000, 10000);
        FullTimeEmployee hr = new FullTimeEmployee("Bob", "PAN456", "2021-05-10", "HR", 2, 40000, 8000);
        ContractEmployee ce = new ContractEmployee("Charlie", "PAN789", "2023-03-15", "Contractor", 3, 160, 300);
        Manager mgr = new Manager("Diana", "PAN321", "2020-07-20", 4, 70000, 15000, 5000, 3000);

        Employee[] employees = {swe, hr, ce, mgr};
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Gross Salary: " + PayRoll.computeGrossSalary(emp));
            System.out.println("Net Salary: " + PayRoll.computeNetSalary(emp));
            System.out.println("--------------------------");
        }
    }
}