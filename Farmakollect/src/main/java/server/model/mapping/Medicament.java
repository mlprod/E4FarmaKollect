package server.model.mapping;

public class Medicament {

    private String id;
    private String label;
    private FamilleMedicament code;
    private String composition;
    private String effets;
    private String contreIndic;
    private Stock stock;

    public Medicament() {
    }

    public Medicament(String id, String label, FamilleMedicament code, String composition, String effets, String contreIndic, Stock stock) {
        this.id = id;
        this.label = label;
        this.code = code;
        this.composition = composition;
        this.effets = effets;
        this.contreIndic = contreIndic;
        this.stock = stock;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public FamilleMedicament getCode() {
        return code;
    }

    public void setCode(FamilleMedicament code) {
        this.code = code;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getEffets() {
        return effets;
    }

    public void setEffets(String effets) {
        this.effets = effets;
    }

    public String getContreIndic() {
        return contreIndic;
    }

    public void setContreIndic(String contreIndic) {
        this.contreIndic = contreIndic;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

}
