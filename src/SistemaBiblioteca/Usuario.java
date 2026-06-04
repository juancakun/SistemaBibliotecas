package SistemaBiblioteca;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private int idUsuario;
    private static int contadorUsuario;
    private String nombre;

    public Usuario() {
        this.idUsuario = ++contadorUsuario;
    }

    public Usuario(String nombre) {
        this();
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {}

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre);
    }
}
