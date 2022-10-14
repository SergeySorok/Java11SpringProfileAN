package com.sbercource.saakian.java11springprofilean.database.config;

import com.sbercource.saakian.java11springprofilean.database.dao.BookDAO2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.sbercource.saakian.java11springprofilean.database.DBConstants.*;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" + DB,
                USER,
                PASSWORD
        );
        connectionResultOutput(connection);
        return connection;
    }

    @Bean
    public BookDAO2 bookDAO2() throws SQLException {
        return new BookDAO2(connection());
    }

    private static void connectionResultOutput(Connection connection) {
        if (connection != null) {
            System.out.println("Connected to the DB");
        } else {
            System.out.println("Connected to DB failed");
        }
    }
}
