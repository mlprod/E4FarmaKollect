package server.model.dao;

import server.model.mapping.FamilleMedicament;
import server.model.mapping.Medicament;
import server.model.mapping.Stock;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentDao {

    //Récupère une liste de Médicament
    public static List<Medicament> getMedicaments(){
        List<Medicament> medicaments = new ArrayList<Medicament>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicament ORDER BY MED_LABEL");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Medicament medicament = new Medicament();
                medicament.setId(resultSet.getString("MED_ID"));
                medicament.setLabel(resultSet.getString("MED_LABEL"));
                medicament.setCode(getFamilleMedicament(resultSet.getString("FAM_CODE")));
                medicament.setComposition(resultSet.getString("MED_COMPOSITION"));
                medicament.setEffets(resultSet.getString("MED_EFFETS"));
                medicament.setContreIndic(resultSet.getString("MED_CONTREINDIC"));
                medicament.setStock(getStockMedicament(resultSet.getString("MED_ID")));
                medicaments.add(medicament);

            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicaments;
    }


    //Récupère un Médicament par rapport à un id
    public static Medicament getMedicament(String id){
        Medicament medicament = new Medicament();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicament WHERE MED_ID = ?;");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                medicament.setId(resultSet.getString("MED_ID"));
                medicament.setLabel(resultSet.getString("MED_LABEL"));
                medicament.setCode(getFamilleMedicament(resultSet.getString("FAM_CODE")));
                medicament.setComposition(resultSet.getString("MED_COMPOSITION"));
                medicament.setEffets(resultSet.getString("MED_EFFETS"));
                medicament.setContreIndic(resultSet.getString("MED_CONTREINDIC"));
                medicament.setStock(getStockMedicament(resultSet.getString("MED_ID")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return medicament;
    }


    //Ajoute un médicament
    public static void saveMedicament(String id, String label, String code, String composition, String effets, String contreIndic){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicament VALUES(?,?,?,?,?,?);");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, label);
            preparedStatement.setString(3, code);
            preparedStatement.setString(4, composition);
            preparedStatement.setString(5, effets);
            preparedStatement.setString(6, contreIndic);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Edite un médicament
    public static void editMedicament(String id, String label, String code, String composition, String effets, String contreIndic){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE medicament SET MED_LABEL = ?, " +
                    "FAM_CODE = ?," +
                    "MED_COMPOSITION = ?, " +
                    "MED_EFFETS = ?, " +
                    "MED_CONTREINDIC = ?" +
                    "WHERE MED_ID = ?;");
            preparedStatement.setString(6, id);
            preparedStatement.setString(1, label);
            preparedStatement.setString(2, code);
            preparedStatement.setString(3, composition);
            preparedStatement.setString(4, effets);
            preparedStatement.setString(5, contreIndic);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Supprime un médicament
    public static void deleteMedicament(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicament WHERE MED_ID = ?;");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Récupère une famille de médicament
    public static List<FamilleMedicament> getFamilleMedicaments(){
        List<FamilleMedicament> familleMedicaments = new ArrayList<FamilleMedicament>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM famille;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                FamilleMedicament familleMedicament = new FamilleMedicament();
                familleMedicament.setFamilleCode(resultSet.getString("FAM_CODE"));
                familleMedicament.setLibelle(resultSet.getString("FAM_LIBELLE"));
                familleMedicaments.add(familleMedicament);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return familleMedicaments;
    }

    //Récupère une famille de médicament
    private static FamilleMedicament getFamilleMedicament(String code){
        FamilleMedicament familleMedicament = new FamilleMedicament();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM famille WHERE FAM_CODE = '" + code + "';");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                familleMedicament.setFamilleCode(resultSet.getString("FAM_CODE"));
                familleMedicament.setLibelle(resultSet.getString("FAM_LIBELLE"));
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return familleMedicament;
    }
/*
    //Ajoute ou édite une famille de médicament
    public void saveFamilleMedicament(String code, String libelle) throws SQLException{
        this.connexion = getConnection();
        if (code != null) {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO famille VALUES ('" + code + "', " + libelle + " ;");
            resultSet = preparedStatement.executeQuery();
        }else{
            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE famille SET FAM_CODE = '" + code +
                    "', FAM_LIBELLE = '" + libelle + "';");
            preparedStatement.executeQuery();
        }
        this.closeConnection();

    }

    //supprime une famille de médicament
    public void deleteFamilleMedicament(String code)throws SQLException{
        this.connexion = getConnection();
        PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM famille WHERE FAM_CODE = '" + code + "';");
        preparedStatement.executeQuery();
        this.closeConnection();
    }
    */

    private static Stock getStockMedicament(String id)throws SQLException {
        Stock stock = new Stock();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsb3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stock WHERE MED_ID = '" + id + "';");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                stock.setNombre(resultSet.getLong("STO_NUM"));
                stock.setPrix(resultSet.getDouble("STO_PRIX"));
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return stock;
    }

}