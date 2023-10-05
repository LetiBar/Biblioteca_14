
package entidades;

import java.time.LocalDate;

public class Prestamo {
    private int idPrestamo;
    private Lector lector;
    private Ejemplar ejemplar;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean estado;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, Lector lector, Ejemplar ejemplar, LocalDate fechaPrestamo, LocalDate fechaDevolucion, boolean estado) {
        this.idPrestamo = idPrestamo;
        this.lector = lector;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public Prestamo(Lector lector, Ejemplar ejemplar, LocalDate fechaPrestamo, LocalDate fechaDevolucion, boolean estado) {
        this.lector = lector;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
