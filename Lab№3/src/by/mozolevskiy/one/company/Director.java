package by.mozolevskiy.one.company;

import by.mozolevskiy.one.comparator.CustomComparator;
import by.mozolevskiy.one.employee.Programmer;
import by.mozolevskiy.one.human.Human;
import by.mozolevskiy.one.level.Level;

import java.util.ArrayList;

public class Director {
    public static void count(Company company) {
        System.out.println(company.name + " has " + company.getList().size() + " members\n");
    }

    public static void sort(Company company) {
        company.getList().sort(new CustomComparator());
    }

    public static void find(Company company, Level level) {
        for(var i : company.getList()) {
            if (i instanceof Programmer)
                if (((Programmer) i).level == level)
                    i.show();
        }
    }
}
