package server.model.dao;

import server.model.mapping.Etablissement;
import server.model.mapping.Medicament;
import server.model.mapping.Role;
import server.model.mapping.User;
import sun.util.resources.ga.LocaleNames_ga;

import java.net.PasswordAuthentication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    Connection connexion;

    //Check la connexion d'un utlisateur
    public static User logUser(String login, String password){
        User user = new User();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE USER_LOGIN = ?" +
                    "AND USER_PASSWORD = ?;");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                user.setId(resultSet.getLong("USER_ID"));
                user.setNom(resultSet.getString("USER_NOM"));
                user.setPrenom(resultSet.getString("USER_PRENOM"));
                user.setEtablissement(getEtablissementByUser(resultSet.getLong("ETAB_ID")));
                user.setRole(getRoleByUser(resultSet.getLong("ROLE_ID")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static List<User> getUser(){
        List<User> users  = new ArrayList<User>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user ORDER BY USER_ID");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                User usere = new User();
                usere.setId(resultSet.getLong("USER_ID"));
                usere.setLogin(resultSet.getString("USER_LOGIN"));
                usere.setNom(resultSet.getString("USER_NOM"));
                usere.setPrenom(resultSet.getString("USER_PRENOM"));
                users.add(usere);

            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    private static Etablissement getEtablissementInUsers(int id){
        Etablissement etablissement = new Etablissement();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etablissement WHERE ETAB_ID '" + id + "';");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                etablissement.setId(resultSet.getInt("ETAB_ID"));
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return etablissement;
    }

    private static Role getRoleInUsers(Long role){
        Role roles= new Role();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM role WHERE ROLE_ID '" + role + "';");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                roles.setId(resultSet.getLong("ROLE_ID"));
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }



    private static Etablissement getEtablissementByUser(Long id){
        Etablissement etablissement = new Etablissement();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etablissement WHERE ETAB_ID = ?;");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                etablissement.setId(resultSet.getInt("ETAB_ID"));
                etablissement.setNom(resultSet.getString("ETAB_NOM"));
                etablissement.setAdresse(resultSet.getString("ETAB_ADRESSE"));
                etablissement.setCp(resultSet.getInt("ETAB_CP"));
                etablissement.setVille(resultSet.getString("ETAB_VILLE"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return etablissement;
    }


    //Ajoute un médicament
    public static void saveUser(String login, String password, String nom, String prenom, Long idRole, Long idEtab){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?);");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nom);
            preparedStatement.setString(4, prenom);
            preparedStatement.setLong(5, idRole);
            preparedStatement.setLong(6, idEtab);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //Récupère le rôle lié à un utilisateur
    private static Role getRoleByUser(Long id){
        Role role = new Role();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM role WHERE ROLE_ID = ?;");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                role.setId(resultSet.getLong("ROLE_ID"));
                role.setLibelle(resultSet.getString("ROLE_LIBELLE"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

}
