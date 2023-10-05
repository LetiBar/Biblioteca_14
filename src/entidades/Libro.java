
package entidades;

public class Libro {
    private int idLibro;
    private int isbn;
    private String titulo;
    private String autor;
    private String genero;
    private String editorial;
    private boolean activo;

    public Libro() {
    }

    public Libro(int idLibro, int isbn, String titulo, String autor, String genero, String editorial, boolean activo) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.activo = activo;
    }

    public Libro(int isbn, String titulo, String autor, String genero, String editorial, boolean activo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.activo = activo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", editorial=" + editorial + ", activo=" + activo + '}';
    }
    
}
    

    