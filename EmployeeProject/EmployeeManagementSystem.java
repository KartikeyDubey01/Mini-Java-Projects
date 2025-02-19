import java.util.Scanner;

class Employee {
    int id;
    String name;
    String designation;
    double basicSalary;
    double da;

    Employee(int id, String name, String designation, double basicSalary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.da = calculateDA(designation);
    }

    private double calculateDA(String designation) {
        switch (designation.toLowerCase()) {
            case "manager":
                return 0.30 * basicSalary;
            case "developer":
                return 0.25 * basicSalary;
            case "tester":
                return 0.20 * basicSalary;
            default:
                return 0.15 * basicSalary;
        }
    }

    double calculateTotalSalary() {
        return basicSalary + da;
    }

    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("DA: " + da);
        System.out.println("Total Salary: " + calculateTotalSalary());
        System.out.println("---------------------------");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Designation (Manager/Developer/Tester/Other): ");
            String designation = scanner.nextLine();
            System.out.print("Basic Salary: ");
            double basicSalary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees[i] = new Employee(id, name, designation, basicSalary);
        }
        System.out.println("\nEmployee Information:");
        for (Employee emp : employees) {
            emp.displayInfo();
        }

        scanner.close();
    }
}
