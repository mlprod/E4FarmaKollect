package server.model.dao;

import java.sql.*;

public class StockDao{

    //Ajoute un stock
    public static void saveStock(String id, Long nombre, double prix){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmakollect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO stock VALUES(?,?,?);");
            preparedStatement.setString(1, id);
            if (nombre != null) preparedStatement.setLong(2, nombre);
            else preparedStatement.setLong(2, 0);
            if (prix != 0) preparedStatement.setDouble(3, prix);
            else preparedStatement.setDouble(3, 0);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Edite un stock
    public static void editStock(String id, Long nombre, double prix){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmakollect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE stock SET STO_NUM = ?," +
                    "STO_PRIX = ? " +
                    "WHERE MED_ID = ?;");
            preparedStatement.setString(3, id);
            preparedStatement.setLong(1, nombre);
            preparedStatement.setDouble(2, prix);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Supprime un stock
    public static void deleteStock(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmakollect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM stock WHERE MED_ID = ?;");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
