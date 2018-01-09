package com.telenotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Urge_Smith on 1/5/18.
 */
public class TelenotesDbConnection {
    protected Connection dbConnection;

    public TelenotesDbConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dbConnection = DriverManager.getConnection("jdbc:sqlserver://tndb01.database.windows.net:1433;database=Telenotes;user=WebUSR@tndb01;password=7Ae@9mF52;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    }

    public void close() throws SQLException {
        dbConnection.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        dbConnection.close();
    }
}

