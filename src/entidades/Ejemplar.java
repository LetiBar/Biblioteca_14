
package entidades;

public class Ejemplar {
    private int idEjemplar;
    private Libro libro;
    private int stock;
    private boolean activo;

    public Ejemplar() {
        
    }

    public Ejemplar(int idEjemplar, Libro libro, int stock, boolean activo) {
        this.idEjemplar = idEjemplar;
        this.libro = libro;
        this.stock = stock;
        this.activo = activo;
    }

    public Ejemplar(Libro libro, int stock, boolean activo) {
        this.libro = libro;
        this.stock = stock;
        this.activo = activo;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "idEjemplar=" + idEjemplar + ", libros=" + libro + ", stock=" + stock + ", activo=" + activo + '}';
    }
    
    
        
    }

    