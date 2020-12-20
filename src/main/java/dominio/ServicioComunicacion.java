package dominio;

public class ServicioComunicacion {
	
	private String correoEnvio;
	private String pwdEnvio;
	
	public ServicioComunicacion(String correoEnvio, String pwdEnvio) {
		this.correoEnvio = correoEnvio;
		this.pwdEnvio = pwdEnvio;
	}

	public String getCorreoEnvio() {
		return correoEnvio;
	}

	public String getPwdEnvio() {
		return pwdEnvio;
	}

	public void setCorreoEnvio(String correoEnvio) {
		this.correoEnvio = correoEnvio;
	}

	public void setPwdEnvio(String pwdEnvio) {
		this.pwdEnvio = pwdEnvio;
	}
	
}