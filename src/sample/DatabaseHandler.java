package sample;

import sample.POJO.table;

import java.sql.*;

public class DatabaseHandler {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + "localHost" + ":" + "3306" + "/" + "yp2";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "root", "1234");
        return dbConnection;
    }



    // Удаление строки абитуриентов по id
    public void deleteRowAbit(int idAbit, String абитуриенты) {
        String querry = "DELETE FROM абитуриенты WHERE `Код абитуриента` = "+idAbit;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Удаление строки личных данных по id
    public void deleteRowMyData(int idAbit, String личные_данные) {
        String querry = "DELETE FROM `личные данные` WHERE `Код абитуриента` = "+idAbit;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Удаление строки образования по id
    public void deleteRowEduc(int idAbit, String образование) {
        String querry = "DELETE FROM образование WHERE `Код абитуриента` = "+idAbit;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Удаление строки родителей по id
    public void deleteRowParents(int idAbit, String родители) {
        String querry = "DELETE FROM родители WHERE `Код абитуриента` = "+idAbit;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(querry);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}