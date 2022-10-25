package com.sbercource.saakian.java11springprofilean.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.sbercource.saakian.java11springprofilean.database.DBConstants.*;


public enum DbApp {
    INSTANCE;

    public Connection newConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" + DB,
                USER,
                PASSWORD
        );
        connectionResultOutput(connection);
        return connection;
    }

    private static void connectionResultOutput(Connection connection) {
        if (connection != null) {
            System.out.println("Connected to the DB");
        } else {
            System.out.println("Connected to DB failed");
        }
    }
}
