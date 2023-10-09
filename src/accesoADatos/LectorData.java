
package accesoADatos;

import entidades.Lector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LectorData {
    private Connection con = null;
    
    public LectorData(){
        con = Conexion.getConexion();
    }
    
    
    //GUARDAR LECTOR
    public void guardarLector(Lector lector){
        String sql = "INSERT INTO lector (apellido, nombre, dni, fechaNacimiento, direccion, telefono, mail, estado) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, lector.getApellido());
            ps.setString(2, lector.getNombre());
            ps.setInt(3, lector.getDni());
            ps.setDate(4, Date.valueOf(lector.getFechaNac()));
            ps.setString(5, lector.getDireccion());
            ps.setInt(6, lector.getTelefono());
            ps.setString(7, lector.getMail());
            ps.setBoolean(8, lector.isActivo());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                lector.setIdLector(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Nuevo lector Guardado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector. ");
        }              
    }
    
    //LISTAR LECTORES
    public List<Lector> listarLectores(){
        String sql = "SELECT * FROM lector WHERE estado = 1";
        ArrayList <Lector> lectores = new ArrayList<>();      
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {

               Lector lector = new Lector();
               
               lector.setIdLector(rs.getInt("idLector"));
               lector.setApellido(rs.getString("apellido"));
               lector.setNombre(rs.getString("nombre"));
               lector.setDni(rs.getInt("dni"));
               lector.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
               lector.setDireccion(rs.getString("direccion"));
               lector.setTelefono(rs.getInt("telefono"));
               lector.setMail(rs.getString("mail"));
               lector.setActivo(rs.getBoolean("estado"));
               
               lectores.add(lector);               
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. ");
        }        
        return lectores;
    }
    
    //MODIFICAR LECTOR
    public void modificarLector(Lector lector){
        
        String sql = "UPDATE lector SET apellido = ?, nombre = ?, dni = ?, fechaNacimiento = ?, direccion = ?, telefono = ?, mail = ? "
                + "WHERE idLector = ?";
      
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, lector.getApellido());
            ps.setString(2, lector.getNombre());
            ps.setInt(3, lector.getDni());
            ps.setDate(4, Date.valueOf(lector.getFechaNac()));
            ps.setString(5, lector.getDireccion());
            ps.setInt(6, lector.getTelefono());
            ps.setString(7, lector.getMail());
            ps.setInt(8, lector.getIdLector());
            
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "El lector ha sido modificado.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector. "+ex.getMessage());
        }       
    }
    
    //ELIMINAR LECTOR
    public void eliminarLector(int id){
    String sql = "UPDATE lector SET estado = 0 WHERE idLector = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Lector Eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector");
        }
    }
    
    public Lector buscarLectorPorId(int id) {
        String sql = "SELECT * FROM lector WHERE idLector = ? AND estado = 1";
        //Fuera de try - catch creamos una variable: 
        Lector lector = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //Dentro de if creamos un objeto alumno con la variable alumno:
                lector = new Lector(); // Estamos usando el contructor vacío de alumno
                //Vamos a setear los datos en base a los que devolvio el ResulSet
                lector.setIdLector(id);
                lector.setApellido(rs.getString("apellido"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                lector.setDireccion("direccion");
                lector.setTelefono(rs.getInt("telefono"));
                lector.setMail(rs.getString("mail"));
                lector.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el lector");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector. ");
        }
        return lector;
    }
    
}
