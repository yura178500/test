package ru.ismoke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Database {
    private static List<ru.ismoke.Employee> db = new ArrayList<>();

    Employee addEmployee(Employee human) {
        db.add(human);
        return human;
    }

    void EmployeeWithMaxSalary() {
        Collections.sort(db);
        System.out.println("Работник с самым большим размером зарплаты: ");
        System.out.println(Collections.max(db));
    }

    void EmployeeWithMinSalary() {
        Collections.sort(db);
        System.out.println("Работник с самым маленьким размером зарплаты: ");
        System.out.println(Collections.min(db));
    }

    void Average() {
        int count = 0;
        float sum = 0;
        for (ru.ismoke.Employee aDb : db) {
            sum = +aDb.getsalary();
            count++;
        }
        System.out.println("Средний размер зарплаты  : " + (1. * sum / count));
    }

    void SalarAmount() {
        int count = 0;
        float sum = 0;
        for (ru.ismoke.Employee aDb : db) {
            sum = +aDb.getsalary();
            count++;
        }
        System.out.println("Сумма размера зарплаты  : " + (1. * sum * count));
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

    Employee newEmployee() {
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
        float salary = scan.nextInt();
        Employee h = new Employee(lastName, firstName, patronymic, departement, salary);
        System.out.println(h);
        return h;
    }

    void replaceEmployee(int index, ru.ismoke.Employee human) {
        db.add(index, human);
    }

    void Employee() {
        db.forEach(System.out::println);
    }

    void allPercentSalary() {
        Scanner scan = new Scanner(System.in);
        byte number;
        float percent;
        while (true) {
            System.out.print("Введите отдел: ");
            number = (byte) Float.parseFloat(scan.next());
            System.out.print("Введите процент: ");
            percent = Float.parseFloat(scan.next());
            byte i;
            for (i = 0; i < db.size(); i++) {
                if (db.get(i) != null) {
                    db.get(i).setSalary(db.get(i).getsalary() + db.get(i).getsalary() * percent);

                }
            }
            System.out.println("Зарплаты подняты на " + percent * 100 + " процентов");

            break;
        }
    }
    public static byte departmentNumber() {
        Scanner scan = new Scanner(System.in);
        byte find;
        System.out.print("Введите отдел: ");
        find = Byte.parseByte(scan.next());
        byte k = 0;
        if (find < 6 || find > 0) {
            for (byte i = 0; i < db.size(); i++) {
                if (db.get(i).getDepartment() == find) {
                    k++;
                }
            }
        } else    {throw new IllegalArgumentException("Введен неверный отдел");
        }
        return k;
    }}











