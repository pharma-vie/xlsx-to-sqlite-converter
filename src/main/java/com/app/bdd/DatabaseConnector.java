package com.app.bdd;

import com.app.helper.OsHelper;

import java.sql.*;

import static com.app.helper.OsHelper.MAC;
import static com.app.helper.OsHelper.WINDOWS;

/**
 * Created by Oussama on 12/07/2016.
 */
public class DatabaseConnector {

    private Connection connection = null;
    private Statement statement = null;

    public DatabaseConnector() {
        connection = connection();
    }

    private Connection connection() {
        Connection connectionToDatabase = null;

        OsHelper osHelper = new OsHelper();

        if ( osHelper.getOsName().startsWith(MAC) ) {

            try {

                Class.forName("org.sqlite.JDBC");
                connectionToDatabase = DriverManager.getConnection("jdbc:sqlite:"+osHelper.getOsUser()+"/Documents/medbdd/medbdd.sqlite");

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } else if ( osHelper.getOsName().startsWith( WINDOWS )) {
            //TODO ajouter la lecture depuis windows
        }
        return connectionToDatabase;
    }

    protected ResultSet executeGetQuery(String requeteSql) {
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            System.out.println("Requete à exécuter : "+ requeteSql);
            resultSet= statement.executeQuery( requeteSql );

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return resultSet;
    }

    protected void excuteVoidQuery(String requeteSql) {
        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);

            System.out.println("Requete à exécuter : "+ requeteSql);

            statement.executeUpdate(requeteSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
