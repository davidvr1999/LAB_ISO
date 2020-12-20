package dominio;

public class Usuario {
    protected String dni;
    protected String nombre;
    protected String rol;

    public Usuario() {
        super();
    }

    public Usuario(String dni, String nombre, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
    }

    public void setDni(String aDni) {
        this.dni = aDni;
    }

    public String getDni() {
        return this.dni;
    }

    public void setNombre(String aNombre) {
        this.nombre = aNombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setRol(String aRol) {
        this.rol = aRol;
    }

    public String getRol() {
        return this.rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}