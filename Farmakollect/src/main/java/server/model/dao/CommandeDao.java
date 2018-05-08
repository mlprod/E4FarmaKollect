package server.model.dao;

import server.model.mapping.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CommandeDao extends AbstractDao{
/*
    Connection connexion;
    MedicamentDao mDao;

    //Récupère la commande en cours liée à un utilisateur
    public Set<Commande> getCurrentCommande(Long id)throws SQLException {
        this.connexion = getConnection();
        PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM commande WHERE USER_ID =" + id + " AND COM_ETAT = FALSE ;");
        resultSet = preparedStatement.executeQuery();
        Set<Commande> commandes = new HashSet<Commande>();
        while (resultSet.next()){
            Commande commande = new Commande();
            commande.setId(resultSet.getLong("COM_ID"));
            commande.setMedicament(mDao.getMedicament(resultSet.getString("MED_ID")));
            commande.setQuantite(resultSet.getLong("COM_QTE"));
        }
        this.closeConnection();

        return commandes;
    }

    //Récupère l'ensemble des commandes liées à un utilisateur
    public Set<Commande> getAllCommandeByUser(Long id)throws SQLException{
        this.connexion = getConnection();
        PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM commande WHERE USER_ID =" + id + ";");
        resultSet = preparedStatement.executeQuery();
        Set<Commande> commandes = new HashSet<Commande>();
        while (resultSet.next()){
            Commande commande = new Commande();
            commande.setId(resultSet.getLong("COM_ID"));
            commande.setMedicament(mDao.getMedicament(resultSet.getString("MED_ID")));
            commande.setQuantite(resultSet.getLong("COM_QTE"));
            commande.setDate(resultSet.getTimestamp("COM_DATE"));
            commande.setEtat(resultSet.getBoolean("COM_ETAT"));
        }
        this.closeConnection();

        return commandes;
    }

    //Ajoute ou édite un élement à la commande courante
    public void saveCommande(Long id, Long idUser, String idMedicament, Long quantite)throws SQLException{
        this.connexion = getConnection();
        if (id != null) {
            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE commande SET COM_QTE = " + quantite +
                    " WHERE COM_ID = " + id + ");");
            preparedStatement.executeQuery();
        }else{
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO commande VALUES(" + idUser +
                    ", '" + idMedicament +
                    "', " + quantite +
                    ", " + System.currentTimeMillis() +
                    ", FALSE );");
            preparedStatement.executeQuery();
        }
        this.closeConnection();
    }

    //Supprime un élément de la commande courante
    public void deleteCommande(Long id)throws SQLException{
        this.connexion = getConnection();
        PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM commande WHERE COM_ID = " + id + ";");
        preparedStatement.executeQuery();
        this.closeConnection();
    }

    //Passe la commande en cours
    public void passCommande()throws SQLException{
        this.connexion = getConnection();
        PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE commande SET COM_ETAT = TRUE ");
    }
*/
}
