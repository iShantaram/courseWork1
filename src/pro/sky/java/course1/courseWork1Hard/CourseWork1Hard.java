package pro.sky.java.course1.courseWork1Hard;

import pro.sky.java.course1.courseWork1Easy.Employee;

public class CourseWork1Hard {

    private static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[9];
        employees[1] = new Employee("Ivanov1 Ivan Ivanovich", 1, 165000);
        employees[2] = new Employee("Ivanov2 Ivan Ivanovich", 2, 175000);
        employees[3] = new Employee("Ivanov3 Ivan Ivanovich", 2, 185000);
        employees[4] = new Employee("Ivanov4 Ivan Ivanovich", 3, 195000);
        employees[5] = new Employee("Ivanov5 Ivan Ivanovich", 3, 205000);
        employees[6] = new Employee("Ivanov6 Ivan Ivanovich", 3, 215000);
        employees[7] = new Employee("Ivanov7 Ivan Ivanovich", 4, 225000);
        employees[8] = new Employee("Ivanov9 Ivan Ivanovich", 4, 235000);

        printData(employees);
        System.out.println("Общая зарплата сотрудников в месяц: " + calculateTotalSalary(employees));
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalaryEmployee(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalaryEmployee(employees));
        System.out.println("Средняя зарплата сотрудников: " + calculateAvgSalary(employees));
        printNames(employees);
        indexSalary(25, employees);

        int department = 3;
        indexSalary(-20, findEmployeesOnDepartment(employees, department));
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ": " +
                findMinSalaryEmployee(findEmployeesOnDepartment(employees, department)));
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + ": " +
                findMaxSalaryEmployee(findEmployeesOnDepartment(employees, department)));
        System.out.println("Общая месячная зарплата сотрудников в отделе " + department + ": " +
                calculateTotalSalary(findEmployeesOnDepartment(employees, department)));
        System.out.println("Средняя зарплата сотрудников в отделе " + department + ": " +
                calculateAvgSalary(findEmployeesOnDepartment(employees, department)));
        System.out.println("\nСотрудники отдела " + department + ":\n" + getData(findEmployeesOnDepartment(employees, department)));

        int compareSalary = 200000;
        System.out.println("Сотрудники с зарплатой выше или равной " + compareSalary + ":\n" + toString(getEmployeesMoreSalary(compareSalary)));
        System.out.println("Сотрудники с зарплатой ниже " + compareSalary + ":\n" + toString(getEmployeesLessSalary(compareSalary)));
    }

    private static Employee[] findEmployeesOnDepartment(Employee[] employees, int department) {
        int countEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployees++;
            }
        }
        Employee[] result = new Employee[countEmployees];
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                result[--countEmployees] = employee;
            }
        }
        return result;
    }

    private static int calculateAvgSalary(Employee[] employees) {
        int countEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                countEmployees++;
            }
        }
        if (countEmployees > 0) {
            return calculateTotalSalary(employees) / countEmployees;
        }
        return 0;
    }

    public static Employee findMaxSalaryEmployee(Employee[] employees) {
        Employee result = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findMinSalaryEmployee(Employee[] employees) {
        Employee result = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    private static int calculateTotalSalary(Employee[] employees) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    private static void printNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    private static void printData(Employee[] employees) {
        System.out.println("Сотрудники:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static String toString(Employee[] employees) {
        String data = "";
        for (Employee employee : employees) {
            if (employee != null) {
                data = data + "Employee{id=" + employee.getId() + ", name='" + employee.getName() + "', salary=" + employee.getSalary() + "}\n";
            }
        }
        return data;
    }

    private static Employee[] getEmployeesMoreSalary(int compareSalary) {
        int countEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= compareSalary) {
                countEmployees++;
            }
        }
        Employee[] employeesMoreSalary = new Employee[countEmployees];
        int j = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= compareSalary) {
                employeesMoreSalary[j++] = employee;
            }
        }
        return employeesMoreSalary;
    }

    private static Employee[] getEmployeesLessSalary(int compareSalary) {
        int countEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < compareSalary) {
                countEmployees++;
            }
        }
        Employee[] employeesLessSalary = new Employee[countEmployees];
        int j = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < compareSalary) {
                employeesLessSalary[j++] = employee;
            }
        }
        return employeesLessSalary;
    }

    private static void indexSalary(int percent, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (100 + percent) / 100);
            }
        }
    }

    private static String getData(Employee[] employees) {
        String data = "";
        for (Employee employee : employees) {
            if (employee != null) {
                data = data + "Employee{name='" + employee.getName() + "', salary=" + employee.getSalary() + ", id=" + employee.getId() + "}\n";
            }
        }
        return data;
    }
}