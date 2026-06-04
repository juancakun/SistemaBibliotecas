package SistemaBiblioteca;

import java.io.Serializable;
import java.util.Objects;

public class Prestamo implements Serializable {
    private final int idPrestamo;
    private static int contadorPrestamos=0;
    private Libro libro;
    private Usuario usuario;
    private boolean activo;

    public Prestamo() {
        this.idPrestamo = ++contadorPrestamos;
    }

    public Prestamo(Libro libro, Usuario usuario) {
        this();
        this.libro = libro;
        this.usuario = usuario;
        this.activo = true;
    }

    public int getIdPrestamo() {
        return this.idPrestamo;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", libro=" + libro +
                ", usuario=" + usuario +
                ", activo=" + activo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return idPrestamo == prestamo.idPrestamo && activo == prestamo.activo && Objects.equals(libro, prestamo.libro) && Objects.equals(usuario, prestamo.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrestamo, libro, usuario, activo);
    }
}
