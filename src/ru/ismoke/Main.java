package ru.ismoke;

import java.util.Scanner;

public class Main {

    private static Database myDb= new Database();


    public static void main(String[] args) {

        Employee[] Employees = new Employee[10];
        Employees[0] = myDb.addEmployee(new ru.ismoke.Employee("Иванов","Иван","Иванович", 1, 50000));
        Employees[1] = myDb.addEmployee(new ru.ismoke.Employee("Петров","Петр","Петрович", 1, 56000));
        Employees[2] = myDb.addEmployee(new ru.ismoke.Employee("Сидоров","Сидор","Сидорович", 2, 53500));
        Employees[3] = myDb.addEmployee(new ru.ismoke.Employee("Кириллов","Иван","Иванович", 2, 50000));
        Employees[4] = myDb.addEmployee(new ru.ismoke.Employee("Урюпин","Эльдар","Петрович", 3, 55000));
        Employees[5] = myDb.addEmployee(new ru.ismoke.Employee("Курков","Юрий","Сидорович", 3, 58000));
        Employees[6] = myDb.addEmployee(new ru.ismoke.Employee("Юрьевич","Олег","Сидорович", 4, 52000));
        Employees[7] = myDb.addEmployee(new ru.ismoke.Employee("Новосёлов","Илья","Иванович", 4, 50000));
        Employees[8] = myDb.addEmployee(new ru.ismoke.Employee("Хиночек","Петр","Петрович", 5, 55000));
        Employees[9] = myDb.addEmployee(new ru.ismoke.Employee("Решетов","Сидор","Сидорович", 6, 53000));
        menu();

    Employees[1].setSalary(5000f);
    Employees[2].setDepartement(2);
    Employees[0].setFirstName("");
    Employees[3].setLastName("");}

    private static void menu() {
        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println("1. Добавить человека в базу");
            System.out.println("2. Найти/изменить человека в базе");
            System.out.println("3. Показать всех");
            System.out.println("4. Вывести средний размер зарплаты...");
            System.out.println("5. Вывести сумму размера зарплаты...");
            System.out.println("6. Работник с самым большой размером зарплаты");
            System.out.println("7. Работник с самым маленьким размером зарплаты");
            System.out.println("8. Процент размером зарплаты поднят на");
            System.out.println("9. Номер отдела");
            System.out.println("0. Выход");
            int result = scan.nextInt();

            switch (result) {

                case 1:
                    myDb.addEmployee(myDb.newEmployee());
                    break;
                case 2:
                    myDb.replaceEmployee(myDb.findEmployee(), myDb.newEmployee());
                    break;
                case 3:
                    myDb.Employee();
                    break;
                case 4:
                    myDb.Average();
                    break;
                case 5:
                    myDb.SalarAmount();
                    break;
                case 6:
                    myDb.EmployeeWithMaxСharges();
                    break;
                case 7:
                    myDb.EmployeeWithMinСharges();
                    break;
                case 8:
                    myDb.allPercentSalary();
                    break;
                case 9:
                    myDb.departmentNumber(Employees,number);;
                    break;
                default:
                    break mark;
            }

       }

    }
}