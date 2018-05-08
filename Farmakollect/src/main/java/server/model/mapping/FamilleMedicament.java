package server.model.mapping;

public class FamilleMedicament {

    private String familleCode;
    private String libelle;

    public FamilleMedicament() {
    }

    public FamilleMedicament(String familleCode) {
        this.familleCode = familleCode;
    }

    public String getFamilleCode() {
        return familleCode;
    }

    public void setFamilleCode(String familleCode) {
        this.familleCode = familleCode;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
