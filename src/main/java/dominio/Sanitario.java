package dominio;

public class Sanitario extends Usuario {


    private String nSanitario;

    public Sanitario() {
    }

    public Sanitario(String dni, String nombre, String rol, String nSanitario) {
        super(dni, nombre, rol);
        this.nSanitario = nSanitario;
    }

    public void setNSanitario(String aNSanitario) {
        this.nSanitario = aNSanitario;
    }

    public String getNSanitario() {
        return this.nSanitario;
    }
}