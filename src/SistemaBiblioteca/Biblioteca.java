package SistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private static final List<Libro> libros;
    private static final List<Usuario> usuarios;
    private static final List<Prestamo> prestamos;

    // Manejo de libros

    static{
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();

        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes"));
        libros.add(new Libro("1984", "George Orwell"));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen"));

    }

    public static void agregarLibro(Libro libro){
        libros.add(libro);
        System.out.println("Libro agregado correctamente!");
    }

    public static void mostrarLibros(){
        var inventarioLibros="";
        for(Libro libro: libros)
            inventarioLibros+=libro.toString()+"\n";
        System.out.println("--- Libros en el inventario ---");
        System.out.println(inventarioLibros);
    }

    public static Libro buscarLibroPorId(int id){
        for(Libro libro: libros){
            if(libro.getIdLibro() == id)
                return libro;
        }
        return null;
    }

    public static Libro buscarLibroPorNombre(String titulo){
        for(Libro libro: libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo))
                return libro;
        }
        return null;
    }

    // Manejo de Usuarios

    public static void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("Usuario agregado correctamente!");
    }

    public static void mostrarUsuarios(){
        var inventarioUsuarios="";
        for(Usuario usuario: usuarios)
            inventarioUsuarios+=usuario.toString();
        System.out.println("--- Usuarios registrados en sistema ---");
        System.out.println(inventarioUsuarios);
    }

    public static Usuario buscarUsuarioPorId(int id){
        for(Usuario usuario: usuarios){
            if (usuario.getIdUsuario()==id)
                return usuario;
        }
        return null;
    }

    public static Usuario buscarUsuarioPorNombre(String nombre){
        for(Usuario usuario: usuarios){
            if(usuario.getNombre().equalsIgnoreCase(nombre))
                return usuario;
        }
        return null;
    }

    // Manejo de Prestamos

    public static void historialPrestamos(){
        var inventarioPrestamos="";
        for (Prestamo prestamo: prestamos){
                inventarioPrestamos+=prestamo.toString()+"\n";
        }
        System.out.println("--- Prestamos en el inventario ---");
        System.out.println(inventarioPrestamos);
    }

    public static void mostrarPrestamos(){
        var inventarioPrestamos="";
        for (Prestamo prestamo: prestamos){
            if (prestamo.isActivo())
                inventarioPrestamos+=prestamo.toString()+"\n";
        }
        System.out.println("--- Prestamos en el inventario ---");
        System.out.println(inventarioPrestamos);
    }

    public static void agregarPrestamo(Libro libro, Usuario usuario){
        if(libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            prestamos.add(prestamo);
            libro.setDisponible(false);
            System.out.println("Prestamo agregado");
        } else {
            System.out.println("El libro ya esta prestado");
        }
    }

    public static void desactivarPrestamo(int idPrestamo){
        for(Prestamo prestamo: prestamos){
            if(prestamo.getIdPrestamo() == idPrestamo){
                if (prestamo.isActivo()) {
                    prestamo.getLibro().setDisponible(true);
                    prestamo.setActivo(false);
                    System.out.println("Libro devuelto correctamente");
                }else{
                    System.out.println("El libro no estaba en prestamo");
                }
                return;
            }
        }
        System.out.println("Prestamo no encontrado");
    }

}
