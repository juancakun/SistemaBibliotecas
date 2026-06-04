package SistemaBiblioteca;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        SistemaBiblioteca();
    }

    public static void SistemaBiblioteca(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos la lista de libros
        List<Libro> productos = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Prestamo> prestamos = new ArrayList<>();
        System.out.println("*** Sistema Biblioteca ***");
        Biblioteca.mostrarLibros();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, usuarios, prestamos);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                Menu:
                1. Agregar libro
                2. Registrar usuario
                3. Mostrar libros
                4. Prestar libro
                5. Devolver libro
                6. Ver préstamos activos
                7. Historial prestamos
                8. Salir
                Elige una opción:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Libro> productos,  List<Usuario> usuarios, List<Prestamo> prestamos){
        var salir = false;
        switch (opcion){
            case 1 -> agregarLibro(consola, productos);
            case 2 -> registrarUsuario(consola, usuarios);
            case 3 -> mostrarLibros();
            case 4 -> prestarLibro(consola, prestamos, productos, usuarios);
            case 5 -> devolverLibro(consola);
            case 6 -> prestamosActivos();
            case 7 -> historialPrestamos();
            case 8 -> salir = true;
            default -> System.out.println("Opción invalida");
        }
        return salir;
    }

    private static void agregarLibro(Scanner consola, List<Libro> productos){
        System.out.println("*** Agregar libro ***");
        System.out.print("Nombre: ");
        var nombre = consola.nextLine();
        System.out.print("Autor: ");
        var autor = consola.nextLine();
        Biblioteca.agregarLibro(new Libro(nombre, autor));
    }

    private static void registrarUsuario(Scanner consola, List<Usuario> usuarios){
        System.out.println("*** Registrar usuario ***");
        System.out.print("Nombre: ");
        var nombre = consola.nextLine();
        Biblioteca.agregarUsuario(new Usuario(nombre));
        Biblioteca.mostrarUsuarios();
    }

    private static void mostrarLibros(){
        Biblioteca.mostrarLibros();
    }

    private static void prestarLibro(Scanner consola, List<Prestamo> prestamos, List<Libro> libros,  List<Usuario> usuarios){
        System.out.println("*** Prestar libro ***");

        System.out.print("Nombre del libro: ");
        var libroTitulo = consola.nextLine();
        Libro libro = Biblioteca.buscarLibroPorNombre(libroTitulo);

        System.out.print("Nombre o id del Usuario: ");
        var nombreUsuario = consola.nextLine();
        Usuario usuario = Biblioteca.buscarUsuarioPorNombre(nombreUsuario);

        if(usuario != null && libro != null)
            Biblioteca.agregarPrestamo(libro, usuario);
    }

    private static void prestamosActivos(){
        Biblioteca.mostrarPrestamos();
    }

    private static void devolverLibro(Scanner consola){
        System.out.println("*** Devolver libro ***");
        System.out.print("Id del prestamo: ");
        var idPrestamo = consola.nextInt();
        Biblioteca.desactivarPrestamo(idPrestamo);
    }

    private static void historialPrestamos(){
        Biblioteca.historialPrestamos();
    }

}
