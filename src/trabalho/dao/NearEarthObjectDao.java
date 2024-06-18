/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.dao;

import trabalho.db.Connection;
import trabalho.dto.NearEarthObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import trabalho.dto.NearEarthObject;
/**
 *
 * @author lucas.wojahn
 */
public class NearEarthObjectDao {
    
    public void salvarLista(List<NearEarthObject> neos) throws SQLException {
        try (java.sql.Connection conn = Connection.getConnection()) {
            for (NearEarthObject neo : neos) {
                salvarObjeto(neo, conn);
            }
        }
    }

    public void salvarObjeto(NearEarthObject neo, java.sql.Connection conn) throws SQLException {
        
        String sql = "INSERT INTO NearEarthObject (id, neo_reference_id, name, nasa_jpl_url, absolute_magnitude_h, is_potentially_hazardous_asteroid, is_sentry_object) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "neo_reference_id = VALUES(neo_reference_id), " +
                "name = VALUES(name), " +
                "nasa_jpl_url = VALUES(nasa_jpl_url), " +
                "absolute_magnitude_h = VALUES(absolute_magnitude_h), " +
                "is_potentially_hazardous_asteroid = VALUES(is_potentially_hazardous_asteroid), " +
                "is_sentry_object = VALUES(is_sentry_object)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, neo.getId());
            statement.setString(2, neo.getNeoReferenceId());
            statement.setString(3, neo.getName());
            statement.setString(4, neo.getNasaJplUrl());
            statement.setDouble(5, neo.getAbsoluteMagnitudeH());
            statement.setBoolean(6, neo.isIsPotentiallyHazardousAsteroid());
            statement.setBoolean(7, neo.isIsSentryObject());

            statement.executeUpdate();
        }
    }
}
