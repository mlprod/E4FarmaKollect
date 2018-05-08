package server.model.mapping;

import java.sql.Timestamp;

public class Commande {

    private Long id;
    private User user;
    private Medicament medicament;
    private Long quantite;
    private Timestamp date;
    private Boolean etat;

    public Commande(){}

    public Commande(Long id, User user, Medicament medicament, Long quantite, Timestamp date, Boolean etat) {
        this.id = id;
        this.user = user;
        this.medicament = medicament;
        this.quantite = quantite;
        this.date = date;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}
