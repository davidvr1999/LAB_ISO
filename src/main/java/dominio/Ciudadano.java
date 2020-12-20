package dominio;

public class Ciudadano extends Usuario {
    private boolean positivo;
    private String email;
    private String nTarjetaSanitaria;

    public Informe informe;

    public Ciudadano() {
        super();
    }

    public Ciudadano(boolean positivo, String email, String nTarjetaSanitaria, Informe informe) {
        this.positivo = positivo;
        this.email = email;
        this.nTarjetaSanitaria = nTarjetaSanitaria;
        this.informe = informe;
    }

    public void setPositivo(boolean aPositivo) {
        this.positivo = aPositivo;
    }

    public boolean getPositivo() {
        return this.positivo;
    }

    public void setEmail(String aEmail) {
        this.email = aEmail;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNTarjetaSanitaria(String aNTarjetaSanitaria) {
        this.nTarjetaSanitaria = aNTarjetaSanitaria;
    }

    public String getNTarjetaSanitaria() {
        return this.nTarjetaSanitaria;
    }
}