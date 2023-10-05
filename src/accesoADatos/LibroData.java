
package accesoADatos;

import entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    
    public LibroData(){
        con = Conexion.getConexion();
    }
    
    public void guardarLibro(Libro libro){
        String sql = "INSERT INTO libro (isbn, titulo, autor, genero, editorial, estado) "
                + "VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getGenero());
            ps.setString(5, libro.getEditorial());
            ps.setBoolean(6, libro.isActivo());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                libro.setIdLibro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Nuevo libro Guardado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. ");
        }              
    }
    
    public List<Libro> listarLibros(){
        String sql = "SELECT idLibro, isbn, titulo, autor, editorial, genero, estado FROM libro WHERE estado = 1";
        ArrayList <Libro> libros = new ArrayList<>();
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {

               Libro libro = new Libro();
               
               libro.setIdLibro(rs.getInt("idLibro"));
               libro.setIsbn(rs.getInt("isbn"));
               libro.setTitulo(rs.getString("titulo"));
               libro.setAutor(rs.getString("autor"));
               libro.setEditorial(rs.getString("editorial"));
               libro.setGenero(rs.getString("genero"));
               libro.setActivo(rs.getBoolean("estado"));
               
               libros.add(libro);
                
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. ");
        }
        
        return libros;
    }
    
    public void modificarLibro(Libro libro){
        
        String sql = "UPDATE libro SET isbn = ?, titulo = ?, autor = ?, genero = ?, editorial = ? "
                + "WHERE idLibro = ?";
        System.out.println("123");
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getGenero());
            ps.setString(5, libro.getEditorial());            
            ps.setInt(6, libro.getIdLibro());
            
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "El libro ha sido modificado.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. ");
        }
        
        
    }
    
}
