package by.mozolevskiy.one.company;

import by.mozolevskiy.one.exceptions.AddException;
import by.mozolevskiy.one.human.Human;

public interface ICompany {
    public void add(Human human) throws AddException;
}
