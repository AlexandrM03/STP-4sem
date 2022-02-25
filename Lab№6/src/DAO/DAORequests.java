package DAO;

import Data.Planet;
import Data.Sputnik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAORequests {
    private final Connection connection;

    public DAORequests(Connection connection) {
        this.connection = connection;
    }

    public void getPlanetsWithLife() throws SQLException {
        System.out.println("Planets with life:");
        String sql = "select * from Planets join Sputnik\n" +
                "on Planets.Sputnik = Sputnik.Name\n" +
                "where Planets.Life = 1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Planet planet = new Planet();
            Sputnik sputnik = new Sputnik();
            planet.setName(resultSet.getString(1));
            planet.setRadius(resultSet.getFloat(2));
            planet.setTemperature(resultSet.getFloat(3));
            planet.setAtmosphere(resultSet.getBoolean(4));
            planet.setLife(resultSet.getBoolean(5));
            planet.setSputnik(resultSet.getString(6));

            sputnik.setName(resultSet.getString(7));
            sputnik.setRadius(resultSet.getFloat(8));
            sputnik.setDistance(resultSet.getFloat(9));

            System.out.println(planet + "\n" + sputnik + "\n");
        }
    }

    public void smallestRadius() throws SQLException {
        System.out.println("Planets with smallest radius:");
        String sql = "select * from Planets join Sputnik\n" +
                "on Planets.Sputnik = Sputnik.Name\n" +
                "where Planets.Radius = (select min(Planets.Radius) from Planets)";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Sputnik> sputniks = new ArrayList<>();
        Planet planet = new Planet();
        while (resultSet.next()) {
            Sputnik sputnik = new Sputnik();
            planet.setName(resultSet.getString(1));
            planet.setRadius(resultSet.getFloat(2));
            planet.setTemperature(resultSet.getFloat(3));
            planet.setAtmosphere(resultSet.getBoolean(4));
            planet.setLife(resultSet.getBoolean(5));

            sputnik.setName(resultSet.getString(7));
            sputnik.setRadius(resultSet.getFloat(8));
            sputnik.setDistance(resultSet.getFloat(9));
            sputniks.add(sputnik);
        }

        StringBuilder planetSputniks = new StringBuilder();
        for (var i : sputniks) {
            planetSputniks.append(i.getName()).append(" ");
        }
        planet.setSputnik(planetSputniks.toString().trim());
        System.out.println(planet);
        for (var i : sputniks) {
            System.out.println(i);
        }
        System.out.println();
    }

    public void maxSputnikRadius() throws SQLException {
        System.out.println("Planet with the biggest sputniks:");
        String sql = "use Galaxy\n" +
                "select * from Planets join Sputnik\n" +
                "on Planets.Sputnik = Sputnik.Name\n" +
                "where Sputnik.Radius = (select max(Sputnik.Radius) from Sputnik)";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Planet planet = new Planet();
        while (resultSet.next()) {
            planet.setName(resultSet.getString(1));
            planet.setRadius(resultSet.getFloat(2));
            planet.setTemperature(resultSet.getFloat(3));
            planet.setAtmosphere(resultSet.getBoolean(4));
            planet.setLife(resultSet.getBoolean(5));
            planet.setSputnik(resultSet.getString(6));
        }
        System.out.println(planet + "\n");
    }
}
