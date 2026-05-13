package modelo;

public class Usuario {
	
	// Atributos usuario
    private int id;
    private String username;
    private String password;
    private String rol;

    // Constructor
    public Usuario(int id, String username, String password, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public boolean cambiarContraseña(String newPass) {
        if (newPass != null && !newPass.isEmpty()) {
            this.password = newPass;
            return true;
        }
        return false;
    }

    // Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}    
}