package by.mozolevskiy.one.employee;

import by.mozolevskiy.one.human.Human;
import by.mozolevskiy.one.level.Level;

public class Programmer extends Human {
    public Level level;

    public Programmer(String name, int age, Level level, float salary) {
        super(name, age, salary);
        this.level = level;
    }

    public void show() {
        System.out.println("Name: " + name +
                "\nAge: " + age +
                "\nLevel: " + level +
                "\nSalary: " + salary + "\n");
    }
}
