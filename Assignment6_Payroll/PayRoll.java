
public class PayRoll {
	public static double computeGrossSalary(Employee emp) {
		return emp.calcCTC();
	}

	public static double computeNetSalary(Employee emp) {
		// For simplicity, assume 10% deduction
		return emp.calcCTC() * 0.9;
	}
}

