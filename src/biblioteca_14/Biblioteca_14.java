
package biblioteca_14;

import accesoADatos.LibroData;
import entidades.Libro;

public class Biblioteca_14 {

    
    public static void main(String[] args) {
       
       
       // INSTANCIAR LIBRO
//        Libro habAt = new Libro (123456987,"Hábitos Atómicos", "James Clear", "Desarrollo Personal", "Paidós", true);
        Libro cronica = new Libro (654321,"Crónica de una muerta anunciada", "Gabriel García Marquez", "Novela", "La oveja negra", true);
//        
       //INSTANCIAR LIBRO DATA
        LibroData libData = new LibroData();
        
       //GUARDAR LIBRO:
       //libData.guardarLibro(cronica);
        
       //LISTAR LIBROS:
//        for (Libro libro : libData.listarLibros()) {
//            
//            System.out.println(libro.toString());
//            
//        }

        //MODIFICAR LIBRO:        
        libData.modificarLibro(cronica);
        
        
        
    }
    
}
