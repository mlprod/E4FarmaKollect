package server.model.dao;

import server.model.mapping.Etablissement;
import server.model.mapping.Medicament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EtablissementDao {

    //Récupère une liste de Médicament
    public static List<Etablissement> getEtablissements(){
        List<Etablissement> etablissements = new ArrayList<Etablissement>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etablissement ORDER BY ETAB_ID");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Etablissement etablissement = new Etablissement();
                etablissement.setId(resultSet.getInt("ETAB_ID"));
                etablissement.setNom(resultSet.getString("ETAB_NOM"));
                etablissement.setAdresse(resultSet.getString("ETAB_ADRESSE"));
                etablissement.setCp(resultSet.getInt("ETAB_CP"));
                etablissement.setVille(resultSet.getString("ETAB_VILLE"));
                etablissements.add(etablissement);

            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return etablissements;
    }

    //Ajoute un médicament
    public static void saveEtablissement(int id, String nom, String adresse, int cp, String Ville){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO etablissement VALUES(?,?,?,?,?);");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,nom );
            preparedStatement.setString(3, adresse);
            preparedStatement.setInt(4, cp);
            preparedStatement.setString(5, Ville);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
