/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import trabalho.model.AproachData;
import trabalho.model.Diameter;
import trabalho.model.MissDistance;
import trabalho.model.NearEarthObject;
import trabalho.model.Velocity;
import trabalho.model.Kilometers;

/**
 *
 * @author lucas.wojahn
 */
public class NearEarthObjectDao {

    public void saveList(List<NearEarthObject> neos) throws SQLException {
        try (java.sql.Connection conn = Connection.getConnection()) {
            for (NearEarthObject neo : neos) {
                this.save(neo, conn);
            }
        }
    }

    public void save(NearEarthObject neo, java.sql.Connection conn) throws SQLException {

        String sql = "INSERT INTO NearEarthObject (id, name, nasa_jpl_url, absolute_magnitude_h, is_potentially_hazardous_asteroid, is_sentry_object,max_diameter,min_diameter) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "id = VALUES(id), "
                + "name = VALUES(name), "
                + "nasa_jpl_url = VALUES(nasa_jpl_url), "
                + "absolute_magnitude_h = VALUES(absolute_magnitude_h), "
                + "is_potentially_hazardous_asteroid = VALUES(is_potentially_hazardous_asteroid), "
                + "is_sentry_object = VALUES(is_sentry_object),"
                + "max_diameter = VALUES(max_diameter),"
                + "min_diameter = VALUES(min_diameter)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, neo.getId());
            statement.setString(2, neo.getName());
            statement.setString(3, neo.getNasaJplUrl());
            statement.setDouble(4, neo.getAbsoluteMagnitudeH());
            statement.setBoolean(5, neo.isIsPotentiallyHazardousAsteroid());
            statement.setBoolean(6, neo.isIsSentryObject());
            statement.setDouble(7, Double.parseDouble(neo.getDiameter().getKilometer().getMax()));
            statement.setDouble(8, Double.parseDouble(neo.getDiameter().getKilometer().getMin()));

            statement.executeUpdate();
        }

        String aproachSql = "INSERT INTO AproachData (neo_id , kilometers, kilometers_hour, kilometers_second, approach_date)\n"
                + "VALUES (?, ?, ?, ?, ?)\n"
                + "ON DUPLICATE KEY UPDATE \n"
                + "neo_id = VALUES(neo_id),\n"
                + "kilometers = VALUES(kilometers),\n"
                + "kilometers_hour = VALUES(kilometers_hour),\n"
                + "kilometers_second = VALUES(kilometers_second),\n"
                + "approach_date = VALUES(approach_date)";

        try (PreparedStatement aproachStatement = conn.prepareStatement(aproachSql)) {
            for (AproachData ad : neo.getAproachData()) {
                aproachStatement.setString(1, neo.getId());
                aproachStatement.setDouble(2, Double.parseDouble(ad.getMissDistance().getKilometers()));
                aproachStatement.setDouble(3, Double.parseDouble(ad.getVelocity().getKmH()));
                aproachStatement.setDouble(4, Double.parseDouble(ad.getVelocity().getKmS()));
                aproachStatement.setDate(5, java.sql.Date.valueOf(LocalDate.parse(ad.getAproachDate())));

                if (ad.getMissDistance() == null || ad.getMissDistance().getKilometers() == null) {
                    aproachStatement.setNull(2, java.sql.Types.DOUBLE);
                } else {
                    aproachStatement.setDouble(2, Double.parseDouble(ad.getMissDistance().getKilometers()));
                }

                aproachStatement.executeUpdate();
            }
        }
    }

    public List<NearEarthObject> findOrderBy(List<String> campos, String mode) throws SQLException {
        List<NearEarthObject> neos = new ArrayList<>();
        String sql = "SELECT *  FROM NearEarthObject neo JOIN AproachData ad ON neo.id = ad.neo_id ORDER BY ";

        for (int x = 0; x < campos.size(); x++) {
            if (x == campos.size() - 1) {
                sql += campos.get(x);
            } else {
                sql += campos.get(x) + ", ";
            }
        }

        sql += " " + mode + ";";
        System.out.println(sql);

        try (java.sql.Connection conn = Connection.getConnection(); PreparedStatement statement = conn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                neos.add(this.builObjectFromSet(resultSet));
            }
        }
        return neos;
    }

    public List<NearEarthObject> findAll() throws SQLException {
        List<NearEarthObject> neos = new ArrayList<>();
        String sql = "SELECT *  FROM NearEarthObject neo JOIN AproachData ad ON neo.id = ad.neo_id";

        try (java.sql.Connection conn = Connection.getConnection(); PreparedStatement statement = conn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                neos.add(this.builObjectFromSet(resultSet));
            }
        }

        return neos;
    }

    public List<NearEarthObject> findSearch(String search) throws SQLException {
        List<NearEarthObject> neos = new ArrayList<>();
        String sql = "SELECT * FROM NearEarthObject neo JOIN AproachData ad ON neo.id = ad.neo_id WHERE neo.id = ? OR neo.name = ?";

        try (java.sql.Connection conn = Connection.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, search);
            statement.setString(2, search);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    neos.add(this.builObjectFromSet(resultSet));
                }
            }
        }

        return neos;
    }

    private NearEarthObject builObjectFromSet(ResultSet resultSet) throws SQLException {
        List<AproachData> aproachData = new ArrayList();

        AproachData aproach = new AproachData();
        Velocity velocity = new Velocity();
        velocity.setKmH(String.valueOf(resultSet.getDouble("kilometers_hour")));
        velocity.setKmS(String.valueOf(resultSet.getDouble("kilometers_second")));
        aproach.setVelocity(velocity);

        MissDistance distance = new MissDistance();
        distance.setKilometers(String.valueOf(resultSet.getDouble("kilometers")));
        aproach.setMissDistance(distance);

        aproach.setAproachDate(String.valueOf(resultSet.getDate("approach_date")));

        aproachData.add(aproach);

        NearEarthObject neo = new NearEarthObject();
        neo.setId(resultSet.getString("id"));
        neo.setName(resultSet.getString("name"));

        Diameter diameter = new Diameter();
        Kilometers kilometer = new Kilometers();

        kilometer.setMax(String.valueOf(resultSet.getDouble("max_diameter")));
        kilometer.setMin(String.valueOf(resultSet.getDouble("min_diameter")));
        diameter.setKilometer(kilometer);

        neo.setDiameter(diameter);
        neo.setAproachData(aproachData);
        neo.setIsPotentiallyHazardousAsteroid(this.getBooleanFromInt(resultSet.getInt("is_potentially_hazardous_asteroid")));

        return neo;
    }

    private boolean getBooleanFromInt(int value) {
        if (value == 0) {
            return false;
        } else if (value == 1) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid input: expected 0 or 1");
        }
    }
}
