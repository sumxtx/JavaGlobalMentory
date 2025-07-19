package org.example.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    public static Connection getConnection(){
        Connection dbconnection = null;
        var baseDatos = "students_db";
        var url =  "jdbc:mariadb://localhost:3306/" + baseDatos;
        var usuario = "java";
        var password = "password";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            dbconnection = DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException e) {
            System.out.println("MariaDB JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return dbconnection;
    }

    public static void main(String[] args) {
        var conection = dbConnection.getConnection();
        if(conection != null){
            System.out.println("Conection Success " + conection);
        }
        else{
            System.out.println("Error al connect");
        }
    }

}
