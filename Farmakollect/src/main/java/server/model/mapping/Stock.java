package server.model.mapping;

public class Stock {

    private Long nombre;
    private double prix;

    public Stock() {
    }

    public Stock(Long nombre, double prix) {
        this.nombre = nombre;
        this.prix = prix;
    }

    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
