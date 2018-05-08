package server.model.mapping;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String login;
    private String password;

    private String nom;
    private String prenom;

    private Etablissement etablissement;
    private server.model.mapping.Role role;

    private Long idRole;
    private Long idEtab;


    public User(String login, String password, String nom, String prenom, Long idRole, Long idEtab) {
        this.login=login;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.idRole=idRole;
        this.idEtab=idEtab;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User (Long id, String login, String nom, String prenom){
        this.id=id;
        this.login=login;
        this.nom=nom;
        this.prenom=prenom;
    }

    public User(){

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getIdRole() { return idRole; }

    public void setIdRole(Long idRole) { this.idRole = idRole; }

    public Long getIdEtab() { return idEtab; }

    public void setIdEtab(Long idEtab) { this.idEtab = idEtab; }
}