package ru.ismoke;

class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String patronymic;

    private float salary;
    private int departement;
    private final int id;
    public static int idCounter = 0;

    public Employee(String firstName, String lastName, String patronymic, int departement, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.salary = salary;
        this.departement = departement;
        this.id = idCounter;
        idCounter++;

    }

    public void setSalary(float salary) {

        this.salary = salary;
    }

    public void setDepartement(int departement) {

        this.departement = departement;
    }

    public int getDepartment() {

        return this.departement;
    }

    public float getSalary() {

        return this.salary;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public String getPatronymic() {

        return this.patronymic;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {

        this.patronymic = patronymic;
    }


    float getcharges_salary() {
        return salary;
    }

    String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Идентификатор: " + this.id + " Фамилия: " + lastName + ", Имя: " + firstName + ", Отчество: " + patronymic + "\n" +
                "Департамент: " + departement + ", Размер зарплаты: " + salary + "\n";
    }

    public int compareTo(Employee human) {
        return (int) (salary - human.getcharges_salary());
    }
}
