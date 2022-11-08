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

        printData();
        System.out.println("Общая зарплата сотрудников в месяц: " + totalSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary());
        System.out.println("Средняя зарплата сотрудников: " + avgSalary());
        printNames();
        indexSalary(25);

        int department = 3;
        indexSalary(-20, department);
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ": " + minSalary(department));
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + ": " + maxSalary(department));
        System.out.println("Общая месячная зарплата сотрудников в отделе " + department + ": " + totalSalary(department));
        System.out.println("Средняя зарплата сотрудников в отделе " + department + ": " + avgSalary(department));
        System.out.println("\nСотрудники отдела " + department + ":\n" + getData(department));

        int compareSalary = 200000;
        System.out.println("Сотрудники с зарплатой выше или равной " + compareSalary + ":\n" + toString(getEmployeesMoreSalary(compareSalary)));
        System.out.println("Сотрудники с зарплатой ниже " + compareSalary + ":\n" + toString(getEmployeesLessSalary(compareSalary)));
    }

    private static int avgSalary() {
        if (Employee.counter > 0) {
            return totalSalary() / Employee.counter;
        } else {
            return 0;
        }
    }

    private static Employee minSalary() {
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

    private static Employee maxSalary() {
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

    private static int totalSalary() {
        int totalSalary = 0;
        for (int i = 1; i <= 5 ; i++) {
            totalSalary += totalSalary(i);
        }
        return totalSalary;
    }

    private static void printNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    private static void printData() {
        System.out.println("Сотрудники:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static String toString(Employee[] employees){
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

    private static void indexSalary(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary()*(100+percent)/100);
            }
        }
    }

    private static String getData(int department) {
        String data = "";
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                data = data + "Employee{name='" + employee.getName() + "', salary=" + employee.getSalary() + ", id=" + employee.getId() + "}\n";
            }
        }
        return data;
    }

    private static int avgSalary(int department) {
        int countEmployeesOnDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployeesOnDepartment++;
            }
        }
        return totalSalary(department)/countEmployeesOnDepartment;
    }

    private static int totalSalary(int department) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    private static Employee maxSalary(int department) {
        if (Employee.counter > 0) {
            int j = 0;
            while (j < employees.length) {
                if (employees[j] != null && employees[j].getDepartment() == department) break;
                j++;
            }
            if (j == employees.length) return null;
            for (int i = j+1; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getDepartment() == department) {
                    if (employees[j].getSalary() < employees[i].getSalary()) j = i;
                }
            }
            return employees[j];
        } else {
            return null;
        }
    }

    private static Employee minSalary(int department) {
        if (Employee.counter > 0) {
            int j = 0;
            while (j < employees.length) {
                if (employees[j] != null && employees[j].getDepartment() == department) break;
                j++;
            }
            if (j == employees.length) return null;
            for (int i = j+1; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getDepartment() == department) {
                    if (employees[j].getSalary() > employees[i].getSalary()) j = i;
                }
            }
            return employees[j];
        } else {
            return null;
        }
    }

    private static void indexSalary(int percent, int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary()*(100+percent)/100);
            }
        }
    }
}
