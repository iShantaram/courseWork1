package pro.sky.java.course1.courseWork1Easy;

public class CourseWork1Easy {
    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[10];
        employees[1] = new Employee("Ivanov1 Ivan Ivanovich", 1, 165000);
        employees[2] = new Employee("Ivanov2 Ivan Ivanovich", 2, 175000);
        employees[3] = new Employee("Ivanov3 Ivan Ivanovich", 2, 185000);
        employees[4] = new Employee("Ivanov4 Ivan Ivanovich", 3, 195000);
        employees[5] = new Employee("Ivanov5 Ivan Ivanovich", 3, 205000);
        employees[6] = new Employee("Ivanov6 Ivan Ivanovich", 3, 215000);
        employees[7] = new Employee("Ivanov7 Ivan Ivanovich", 4, 225000);
        employees[9] = new Employee("Ivanov9 Ivan Ivanovich", 5, 235000);

        printData();
        System.out.println("Общая зарплата сотрудников в месяц: " + calculateTotalSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalaryEmployee());
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalaryEmployee());
        System.out.println("Средняя зарплата сотрудников: " + calculateAvgSalary());
        printNames();
    }

    public static void printData() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static void printNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public static int calculateTotalSalary() {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static Employee findMinSalaryEmployee() {
        if (Employee.counter > 0) {
            int j = 0;
            while (j < employees.length) {
                if (employees[j] != null) break;
                j++;
            }
            for (int i = j+1; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[j].getSalary() > employees[i].getSalary()) j = i;
                }
            }
            if (j < employees.length) {
                return employees[j];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Employee findMaxSalaryEmployee() {
        if (Employee.counter > 0) {
            int j = 0;
            while (j < employees.length) {
                if (employees[j] != null) break;
                j++;
            }
            for (int i = j+1; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[j].getSalary() < employees[i].getSalary()) j = i;
                }
            }
            if (j < employees.length) {
                return employees[j];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static int calculateAvgSalary() {
        if (Employee.counter > 0) {
            return calculateTotalSalary() / Employee.counter;
        } else {
            return 0;
        }
    }
}