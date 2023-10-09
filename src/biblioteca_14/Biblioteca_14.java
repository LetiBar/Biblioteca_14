
package biblioteca_14;

import accesoADatos.LectorData;
import accesoADatos.LibroData;
import entidades.Lector;
import entidades.Libro;
import java.time.LocalDate;
import java.time.Month;

public class Biblioteca_14 {

    
    public static void main(String[] args) {
       
       
       // INSTANCIAR LIBRO
//        Libro habAt = new Libro (123456987,"Hábitos Atómicos", "James Clear", "Desarrollo Personal", "Paidós", true);
//        Libro cronica = new Libro (5, 654321,"Crónica de una muerte anunciada", "Gabriel García Marquez", "Novela", "La oveja negra", true);
//        
       //INSTANCIAR LIBRO DATA
        LibroData libData = new LibroData();
        
       //GUARDAR LIBRO:
       //libData.guardarLibro(cronica);
        
       //LISTAR LIBROS:
//        for (Libro libro : libData.listarLibros()) {            
//            System.out.println(libro.toString());            
//        }

        //MODIFICAR LIBRO:        
//        libData.modificarLibro(cronica);
        
        //BUSCAR LIBRO:
//        System.out.println(libData.buscarLibro(5));        
        
        //BUSCAR LIBRO por título:
         
//        for (Libro libro : libData.buscarPorEditoral("la")) {
//            System.out.println(libro.toString());
//        }

        //INSANCIAR LECTOR Y LECTORDATA
        LectorData lecData = new LectorData();
       // Lector lector = new Lector(2, "Gomez", "Pedro", 28353654, LocalDate.of(1980, 02, 12), "Alberdi 456", 280456235, "pedroGomez@gmail.com", true);
        
       //GUARDAR NUEVO LECTOR
        //lecData.guardarLector(lector);
        
       //MODIFOCAR LECTOR
        //lecData.modificarLector(lector);
       
       //LISTAR LECTORES
//        for (Lector lector : lecData.listarLectores()) {
//            System.out.println(lector.toString());
//        }

       //ELIMINAR LECTOR
        //lecData.eliminarLector(2);
            
    }
    
}
