package server.model.dao;

import java.sql.*;

public abstract class AbstractDao{

    protected Connection connection = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    public Connection getConnection(){
        try{
            Class.forName("com.sql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        }catch (Exception e){
            System.err.println("Connexion à la base impossible: " + e);
        }
        return connection;
    }

    public void closeConnection(){
        try{
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception e){
            System.err.println("Fermeture de la base impossible");
            e.printStackTrace();
        }
    }

}
