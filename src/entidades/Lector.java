
package entidades;

import java.time.LocalDate;

public class Lector {
    private int idLector;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNac;
    private String direccion;
    private int telefono;
    private String mail;
    private boolean activo;

    public Lector() {
    }

    public Lector(int idLector, String apellido, String nombre, int dni, LocalDate fechaNac, String direccion, int telefono, String mail, boolean activo) {
        this.idLector = idLector;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.activo = activo;
    }

    public Lector(String apellido, String nombre, int dni, LocalDate fechaNac, String direccion, int telefono, String mail, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.activo = activo;
    }

    public int getIdLector() {
        return idLector;
    }

    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Lector {" + "id: " + idLector + ", nombre y apellido: " + nombre + ", "+ apellido + ", dni: " + dni + ", fecha Nac: " + fechaNac + ", direccion: " + direccion + ", telefono: " + telefono + ", mail: " + mail + ", estado: " + activo + '}';
    }
    
    
    
}
