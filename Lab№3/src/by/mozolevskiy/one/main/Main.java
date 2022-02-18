package by.mozolevskiy.one.main;

import by.mozolevskiy.one.company.Company;
import by.mozolevskiy.one.company.Director;
import by.mozolevskiy.one.employee.Admin;
import by.mozolevskiy.one.employee.Programmer;
import by.mozolevskiy.one.exceptions.AddException;
import by.mozolevskiy.one.human.Human;
import by.mozolevskiy.one.level.Level;
import by.mozolevskiy.one.parser.Sax;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("Starting program");

            Company company = new Company("MAD");
            company.add(new Programmer("Daniil", 24, Level.Middle, 620.8f));
            company.add(new Programmer("Alexey", 18, Level.Junior, 250.4f));
            company.add(new Programmer("Natalia", 25, Level.Senior, 1020.2f));
            company.add(new Admin("Ilya", 30, 800.8f));
            LOG.info("Company created");
            company.show();

            Director.count(company);
            System.out.println("-----Senior-----");
            Director.find(company, Level.Senior);
            LOG.info("Senior is found");

            System.out.println("-----Sorted-----");
            Director.sort(company);
            company.show();
            LOG.info("List is sorted");

            Admin admin = new Admin("Anna", 29, 1230.9f);

            System.out.println("-----XML Serialize-----");
            FileOutputStream xmlOut = new FileOutputStream("files/info.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(xmlOut);
            xmlEncoder.writeObject(admin);
            xmlEncoder.close();
            LOG.info("XML serialized");

            System.out.println("-----XML Deserialize-----");
            FileInputStream xmlIn = new FileInputStream("files/info.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(xmlIn);
            Admin annaXML = (Admin)xmlDecoder.readObject();
            xmlDecoder.close();
            annaXML.show();
            LOG.info("XML deserialized");

            System.out.println("-----JSON Serialize-----");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(admin);
            System.out.println(json);
            FileOutputStream jsonOut = new FileOutputStream("files/info.json");
            byte[] outText = json.getBytes(StandardCharsets.UTF_8);
            jsonOut.write(outText, 0, outText.length);
            LOG.info("JSON serialized");

            System.out.println("-----JSON Deserialize-----");
            Scanner scanner = new Scanner(new File("files/info.json"));
            StringBuilder result = new StringBuilder();
            while(scanner.hasNext())
                result.append(scanner.nextLine());
            scanner.close();
            Admin annaJson = gson.fromJson(result.toString(), Admin.class);
            annaJson.show();
            LOG.info("JSON deserialized");

            System.out.println("-----Stream API-----");
            Stream<Human> resStream = company.getList().stream().filter(s -> s.getSalary() > 800);
            for(var i : resStream.toList()) {
                i.show();
            }
            LOG.info("Stream API");

            System.out.println("-----SAX-----");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            Sax sax = new Sax();
            parser.parse(new File("files/Admin.xml"), sax);
            Admin max = sax.getResult();
            max.show();
            LOG.info("SAX");
        }
        catch (AddException ex) {
            LOG.info(ex.getMessage() + " (" + ex.number + ")");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } finally {
            LOG.info("Finally block\n");
        }
    }
}
