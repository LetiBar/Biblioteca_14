
package accesoADatos;

import entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    
    public LibroData(){
        con = Conexion.getConexion();
    }
    
    
    //GUARDAR LIBRO
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
    
    //LISTAR LIBROS
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
    
    //MODIFICAR LIBRO
    public void modificarLibro(Libro libro){
        
        String sql = "UPDATE libro SET isbn = ?, titulo = ?, autor = ?, genero = ?, editorial = ? "
                + "WHERE idLibro = ?";
      
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
    
    //ELIMINAR DATOS DE LIBRO (BORRADO LOGICO)
    public void eliminarLibro(int id) {
        String sql = "UPDATE libro SET estado = 0 WHERE idLibro = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Libro Eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
    }
    
    //BUSCAR LIBRO (SELECT ResultSet usa executeQuery)
    public Libro buscarLibro(int id) {
        String sql = "SELECT isbn, titulo, autor, genero, editorial FROM libro WHERE idLibro = ? AND estado = 1";
        //Fuera de try - catch creamos una variable: 
        Libro libro = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //Dentro de if creamos un objeto Libro con la variable libro:
                libro = new Libro(); // Estamos usando el contructor vacío de libro
                
                //Vamos a setear los datos en base a los que devolvio el ResulSet
                libro.setIdLibro(id);
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese libro");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libro;       
    }
    
    public List<Libro> buscarPorTitulo(String titulo){
        String sql = "SELECT * FROM libro WHERE titulo LIKE '%"+titulo+"%'";
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
    
    public List<Libro> buscarPorEditoral(String editorial){
        String sql = "SELECT * FROM libro WHERE editorial LIKE '%"+editorial+"%'";
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
    
    public List<Libro> buscarPorGenero(String genero){
        String sql = "SELECT * FROM libro WHERE genero LIKE '%"+genero+"%'";
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
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. ");
        }        
        return libros;
    }
}
