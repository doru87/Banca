/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza.de.date;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class ConexiuneBazaDate {
    private static ConexiuneBazaDate conexiuneBadaDate;
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/banca";
    private final String username = "root";
    private final String password = "";

    private Connection conexiune;

    public ConexiuneBazaDate()
    {
        this.conexiune = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Class path error: " + e);
        }
    }

    public Connection creazaConexiune()
    {
        try {
            this.conexiune = (Connection) DriverManager.getConnection(connectionUrl, username, password);

        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex);
        }
        return this.conexiune;
    }

    public void inchideConexiune()
    {
        try {
            this.conexiune.close();
        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex);
        }
    }

    public static ConexiuneBazaDate obtineInstanta()
    {
        if (conexiuneBadaDate == null) {
            conexiuneBadaDate = new ConexiuneBazaDate();
        }
        return conexiuneBadaDate;
    }
}
