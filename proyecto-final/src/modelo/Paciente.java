package modelo;

public class Paciente extends Persona {
    
	// Atributos paciente
    private String historialClinico;
    private String contactoEmergencia;

    // Constructor
    public Paciente(String dni, String nombre, String apellido, String telefono, String historialClinico, String contactoEmergencia) {
        super(dni, nombre, apellido, telefono); // Heredamos de Persona
        this.historialClinico = historialClinico;
        this.contactoEmergencia = contactoEmergencia;
    }

    @Override
    public boolean validarDNI() {
    	// valida si tiene 8 caracteres
        return this.dni != null && this.dni.length() == 8;
    }

    // Getters y Setters
    public String getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(String historialClinico) {
        this.historialClinico = historialClinico;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }
    
}