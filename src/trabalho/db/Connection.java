/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.db;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author lucas.wojahn
 */
public class Connection {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/trabalho";
    private static final String USER = "root";
    private static final String PASS = "";

    public static java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
