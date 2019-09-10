package com.nguyenDat.DataDictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnectionSQL {

    public static Connection getConnection() {
        // ten driver + url db
        final String JDBC_DRIVER = "org.sqlite.JDBC";

        final String url = "jdbc:sqlite:dictionaryE_V.db";

        try {
            Class.forName(JDBC_DRIVER);

            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
