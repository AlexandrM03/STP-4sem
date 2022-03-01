package test;

import library.Book;
import library.Library;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class LibraryTest extends Assert {
    Book algorithms = new Book("Grokking Algorithms", "Aditya Bhargava", 2016);
    Book dynamite = new Book("I Am Dynamite!", "Sue Prideaux", 2018);

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod – аннотированный метод будет выполняться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod – аннотированный метод будет запускаться после каждого тестового метода.");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups – аннотирует методы, которые будут выполняться перед первым методом в любой из указанных групп.");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("@AfterGroups – аннотируется методы, которые будут выполняться после всех методом в любом из указанных групп.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass – указывает, что метод будет выполнен до всех тестовых методов тестового класса.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass  – аннотированный метод будет запущен после всех тестовых методов в текущем классе.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - аннотированный метод будет запускаться до всех тестовых методов.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest – аннотированный метод будет запущен после всех тестовых методов, принадлежащих классам внутри тега <test>.");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite – указывает, что данный метод будет запускаться перед любым методом тестового класса.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite – указывает, что данный метод, будет запускаться после всех методов тестового класса.");
    }

    @Test(groups = {"unit"})
    public void testAddBooks() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);

        Assert.assertNotNull(books);
    }

    @Test(timeOut = 1000)
    public void testCompareBooks() {
        ArrayList<Book> books = Book.getBooks();
        Library library = new Library();
        library.addBook(algorithms);
        library.addBook(dynamite);

        Assert.assertEquals(books, library.getLibrary());
    }

    @Test(groups = {"unit"})
    public void testRemoveBook() throws NullPointerException {
        Library library = new Library();
        library.addBook(algorithms);
        library.removeBook(algorithms);

        Assert.assertNotNull(library.getLibrary());
    }

    @Test(enabled = false)
    public void testAddBooksIgnore() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);

        Assert.assertNotNull(books);
    }
}

