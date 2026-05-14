package modelo;

public class Paciente extends Persona {

    // Atributos
    private String correo;
    private String historialClinico;
    private String contactoEmergencia;

    // Constructor
    public Paciente(String dni,
                     String nombre,
                     String apellido,
                     String telefono,
                     String historialClinico,
                     String contactoEmergencia) {

        super(dni, nombre, apellido, telefono);

        this.historialClinico = historialClinico;
        this.contactoEmergencia = contactoEmergencia;
    }

    // Validar DNI
    @Override
    public boolean validarDNI() {

        return this.dni != null
                && this.dni.length() == 8;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

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