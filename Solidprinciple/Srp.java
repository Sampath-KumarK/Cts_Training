class Employee {

    private String name;

    private double salary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        return employee.getSalary() * 1.2;
    }
}
class ReportGenerator {
    public void generateReport(Employee employee) {
        System.out.println("Generating employee report for " + employee.getName() + "...");
    }
}

public class Srp {
    public static void main(String[] args) {
        Employee emp = new Employee("John", 10000);
        SalaryCalculator calculator = new SalaryCalculator();
        ReportGenerator reportGenerator = new ReportGenerator();

        reportGenerator.generateReport(emp);
        System.out.println("Salary: " + calculator.calculateSalary(emp));

    }
}