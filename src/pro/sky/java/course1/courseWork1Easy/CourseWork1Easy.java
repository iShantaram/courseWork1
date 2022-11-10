package pro.sky.java.course1.courseWork1Easy;

public class CourseWork1Easy {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[1] = new Employee("Ivanov1 Ivan Ivanovich", 1, 65000);
        employees[2] = new Employee("Ivanov2 Ivan Ivanovich", 2, 75000);
        employees[3] = new Employee("Ivanov3 Ivan Ivanovich", 2, 85000);
        employees[4] = new Employee("Ivanov4 Ivan Ivanovich", 3, 95000);
        employees[5] = new Employee("Ivanov5 Ivan Ivanovich", 3, 105000);
        employees[6] = new Employee("Ivanov6 Ivan Ivanovich", 3, 115000);
        employees[7] = new Employee("Ivanov7 Ivan Ivanovich", 4, 125000);
        employees[9] = new Employee("Ivanov9 Ivan Ivanovich", 5, 135000);

        printData(employees);
        System.out.println("Общая зарплата сотрудников в месяц: " + monthTotalSalary(employees));
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary(employees));
        System.out.println("Средняя зарплата сотрудников: " + avgSalary(employees));
        printNames(employees);
    }

    public static void printData(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static void printNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public static int monthTotalSalary(Employee[] employees) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static Employee minSalary(Employee[] employees) {
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
            return employees[j];
        } else {
            return null;
        }
    }

    public static Employee maxSalary(Employee[] employees) {
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
            return employees[j];
        } else {
            return null;
        }
    }

    public static int avgSalary(Employee[] employees) {
        return monthTotalSalary(employees)/Employee.counter;
    }
}