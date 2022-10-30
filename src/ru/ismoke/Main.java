package ru.ismoke;

import java.util.Scanner;

public class Main {

    private static Database myDb= new Database();


    public static void main(String[] args) {

        Employee[] Employee = new Employee[11];
        Employee[0] = myDb.addEmployee(new ru.ismoke.Employee("Иванов","Иван","Иванович", 1, 50000));
        Employee[1] = myDb.addEmployee(new ru.ismoke.Employee("Петров","Петр","Петрович", 1, 55000));
        Employee[2] = myDb.addEmployee(new ru.ismoke.Employee("Сидоров","Сидор","Сидорович", 2, 53000));
        Employee[3] = myDb.addEmployee(new ru.ismoke.Employee("Кириллов","Иван","Иванович", 2, 50000));
        Employee[4] = myDb.addEmployee(new ru.ismoke.Employee("Урюпин","Эльдар","Петрович", 3, 55000));
        Employee[5] = myDb.addEmployee(new ru.ismoke.Employee("Курков","Юрий","Сидорович", 4, 53000));
        Employee[6] = myDb.addEmployee(new ru.ismoke.Employee("Юрьевич","Олег","Сидорович", 2, 53000));
        Employee[7] = myDb.addEmployee(new ru.ismoke.Employee("Новосёлов","Илья","Иванович", 2, 50000));
        Employee[8] = myDb.addEmployee(new ru.ismoke.Employee("Хиночек","Петр","Петрович", 3, 55000));
        Employee[9] = myDb.addEmployee(new ru.ismoke.Employee("Решетов","Сидор","Сидорович", 4, 53000));
        Employee[10] = myDb.addEmployee(new ru.ismoke.Employee("Пупкин","Иван","Сидорович", 4, 53000));

       menu();
    }

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
            System.out.println("8. Номер отдела");
            System.out.println("9. Процент размером зарплаты поднят на");
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
                    float percent =0.2f;
                    Employee[] Employee = new Employee[11];
                    Database.allPercentSalary(Employee,percent);
                    myDb.allPercentSalary(Employee,percent);
                    break;
                case 9:
                    Employee[] Employee1 = new Employee[11];
                    byte number = 4;
                    Database.departmentPeople(Employee1,number);
                    myDb.departmentPeopleCount(Employee1,number);
                    break;
                default:
                    break mark;
            }

            float percent =0.2f;
            Employee[] Employee = new Employee[11];
            Database.allPercentSalary(Employee,percent);
            byte number=5;

            Database.departmentPeople(Employee,number);
            Database.departmentSalarySum(Employee,number);
            Database.departmentMaxSalary(Employee,number);
            Database.departmentMinSalary(Employee,number);
            Database.departmentAvarageSalary(Employee,number);
            percent=0.2f;
           Database.departmentAddPercentSalary(Employee,number,percent);
            float highSalary=20_000f;
            Database.compareHigherSalary(Employee,highSalary);
            float lowSalary=10_000f;
            Database.compareLowerSalary(Employee,lowSalary);
       }

    }
}