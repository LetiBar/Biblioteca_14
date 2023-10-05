
package accesoADatos;

import entidades.Ejemplar;
import entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EjemplarData {
    
    private Connection con = null;
    private Libro libro;
    
    public EjemplarData(){
        con = Conexion.getConexion();
    }
    
    public void guardarEjemplar(Ejemplar ejem) {
        String sql = "INSERT INTO ejemplar (idLibro, stock, estado) "
                + "VALUES(?,?,?)";

       try {
           //Para generar el ps usamos la conexion(con). Pasamos sentencia sql 
           //y usamos la constante RETURN_GENERATED_KEYS
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, ejem.getLibro().getIdLibro());
            ps.setInt(2, ejem.getStock());
            ps.setBoolean(3,ejem.isActivo());
                                   
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                // Al ejemplar (ejem) le seteamos el idEjemplar, el que se 
                //encuentra en el ResultSet (rs) en la columna nº1 
                ejem.setIdEjemplar(rs.getInt(1)); 
                JOptionPane.showMessageDialog(null, "Ejemplar registrado");

            }
            ps.close();

        } catch (SQLException ex) {
            // mensaje error al acceder a la tabla de la base de datos
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar " + ex);
        }
      
    }
    
}
