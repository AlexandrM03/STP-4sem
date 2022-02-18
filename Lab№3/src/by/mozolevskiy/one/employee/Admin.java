package by.mozolevskiy.one.employee;

import by.mozolevskiy.one.human.Human;

public class Admin extends Human {
    public Admin(String name, int age, float salary) {
        super(name, age, salary);
    }

    public Admin() { }

    public void show() {
        System.out.println("Name: " + name +
                "\nAge: " + age +
                "\nSalary: " + salary + "\n");
    }
}
