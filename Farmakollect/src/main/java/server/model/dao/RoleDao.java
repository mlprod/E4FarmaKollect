package server.model.dao;

import server.model.mapping.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    //Récupère une liste de Médicament
    public static List<Role> getRoles(){
        List<Role> roles = new ArrayList<Role>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM role ORDER BY ROLE_ID");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Role role= new Role();
                role.setId(resultSet.getLong("ROLE_ID"));
                role.setLibelle(resultSet.getString("ROLE_LIBELLE"));
                roles.add(role);

            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

}
