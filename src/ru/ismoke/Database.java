package ru.ismoke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Database {
    private List<ru.ismoke.Employee> db = new ArrayList<>();

    Employee addEmployee(Employee human) {
        db.add(human);
        return human;
    }

    void EmployeeWithMaxСharges() {
        Collections.sort(db);
        System.out.println("Работник с самым большим размером зарплаты: ");
        System.out.println(Collections.max(db));
    }

    void EmployeeWithMinСharges() {
        Collections.sort(db);
        System.out.println("Работник с самым маленьким размером зарплаты: ");
        System.out.println(Collections.min(db));
    }

    void Average() {
        int count = 0;
        float sum = 0;
        for (ru.ismoke.Employee aDb : db) {
            sum = +aDb.getcharges_salary();
            count++;
        }
        System.out.println("Средний размер зарплаты  : " + (1. * sum / count));
    }

    void SalarAmount() {
        int count = 0;
        float sum = 0;
        for (ru.ismoke.Employee aDb : db) {
            sum = +aDb.getcharges_salary();
            count++;
        }
        System.out.println("Сумма размера зарплаты  : " + (1. * sum * count));
    }

    public static byte departmentCount(Employee[] arr, byte number) {
        byte k = 0;
        if (number > 6 || number < 1) {
            throw new IllegalArgumentException("Введен неверный отдел");
        } else {
            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    k++;
                }
            }
        }
        return k;
    }


    int findEmployee() {
        Scanner scan = new Scanner(System.in);
        String find;
        while (true) {
            System.out.print("Введите фамилию: ");
            find = scan.next();
            for (int i = 0; i < db.size(); i++) {
                if (find.equals(db.get(i).getLastName())) {
                    System.out.println("Найден номер записи: " + i);
                    return i;
                }
            }
            System.out.println("Совпадений не найдено!");
        }
    }

    ru.ismoke.Employee newEmployee() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        String lastName = scan.next();
        System.out.print("Введите имя: ");
        String firstName = scan.next();
        System.out.print("Введите отчество: ");
        String patronymic = scan.next();
        System.out.print("Введите отдел: ");
        int departement = scan.nextInt();
        System.out.print("Введите размер зарплаты: ");
        int clothing_charges = scan.nextInt();
        ru.ismoke.Employee h = new ru.ismoke.Employee(lastName, firstName, patronymic, departement, clothing_charges);
        System.out.println(h);
        return h;
    }

    void replaceEmployee(int index, ru.ismoke.Employee human) {
        db.add(index, human);
    }

    void Employee() {
        db.forEach(System.out::println);
    }

    public static void allPercentSalary(Employee[] arr, float percent) {
        for (byte i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arr[i].setSalary(arr[i].getSalary() + arr[i].getSalary() * percent);
            }
        }
        System.out.println("Зарплаты подняты на " + percent * 100 + " процентов");
    }

    public static byte departmentPeopleCount(Employee[] arr, byte number) {
        byte k = 0;
        if (number > 6 || number < 1) {
            throw new IllegalArgumentException("Введен неверный отдел");
        } else {

            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    k++;
                }
            }
        }
        return k;
    }

    public static float departmentSalarySum(Employee[] arr, byte number) {
        float sum = 0f;
        if (departmentPeopleCount(arr, number) > 0) {
            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    sum = sum + arr[i].getSalary();
                }
            }
            System.out.println("В отделе " + number + " сумарная зарплата=" + sum + " USD");
        } else {
            System.out.println("В отделе " + number + " нет сотрудников");
        }
        return sum;
    }

    public static void departmentAvarageSalary(Employee[] arr, byte number) {
        float sum = departmentSalarySum(arr, number);
        byte k = departmentPeopleCount(arr, number);
        if (k > 0) {
            System.out.println("Средняя зарплата в отделе " + number + ": " + sum / k + " USD");
        }
    }


    public static void departmentMaxSalary(Employee[] arr, byte number) {
        if (departmentPeopleCount(arr, number) > 0) {
            float max = 0f;
            byte t = 0;
            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    if (max < arr[i].getSalary()) {
                        max = arr[i].getSalary();
                        t = i;
                    }
                }
            }
            System.out.println("В отделе " + number + " максимальная зарплата " + max + " у " + arr[t].getLastName());
        } else {
            System.out.println("В отделе " + number + " нет сотрудников");
        }
    }

    public static void departmentMinSalary(Employee[] arr, byte number) {
        if (departmentPeopleCount(arr, number) > 0) {
            byte t = 0;
            float min = 50000000;
            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    if (min > arr[i].getSalary()) {
                        min = arr[i].getSalary();
                        t = i;
                    }
                }
            }
            System.out.println("В отделе " + number + " минимальная зарплата " + min + " USD у " + arr[t].getLastName());
        } else {
            System.out.println("В отделе " + number + " нет сотрудников");
        }
    }

    public static void departmentAddPercentSalary(Employee[] arr, byte number, float percent) {
        if (departmentPeopleCount(arr, number) > 0) {
            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    arr[i].setSalary(arr[i].getSalary() + arr[i].getSalary() * percent);
                }
            }
            System.out.println("В отделе " + number + " зарплата повышена на " + percent * 100 + " %");
        } else {
            System.out.println("В отделе " + number + " нет сотрудников");
        }

    }

    public static void departmentPeople(Employee[] arr, byte number) {
        if (departmentPeopleCount(arr, number) > 0) {
            System.out.println("Сотрудники отдела " + number + " :");
            for (byte i = 0; i < arr.length; i++) {
                if (arr[i].getDepartment() == number) {
                    System.out.println(arr[i].getFirstName() + " " + arr[i].getLastName());

                }
            }
        } else {
            System.out.println("В отделе " + number + " нет сотрудников");
        }

    }

    public static void compareLowerSalary(Employee[] arr, float salary) {
        for (byte i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getSalary() < salary) {
                    System.out.println("Зарплата работника " + arr[i].getLastName() + " меньше введенной " +
                            " и равна= " + arr[i].getSalary());
                }
            }
        }
    }

    public static void compareHigherSalary(Employee[] arr, float salary) {
        for (byte i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getSalary() > salary) {
                    System.out.println("Зарплата работника " + arr[i].getLastName() + " больше введенной " +
                            " и равна= " + arr[i].getSalary());
                }
            }
        }
    }
}