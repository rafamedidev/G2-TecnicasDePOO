package modelo;

public class Medico extends Persona {
    
    // Atributos médico
	private int idMedico;
    private String especialidad;
    private String nroColegiatura;

    // Constructor
    public Medico(int idMedico, String dni, String nombre, String apellido, String telefono, String especialidad, String nroColegiatura) {
        super(dni, nombre, apellido, telefono); // Heredamos de Persona
        this.idMedico = idMedico;
        this.especialidad = especialidad;
        this.nroColegiatura = nroColegiatura;
    }

    @Override
    public boolean validarDNI() {
        // valida si tiene 8 caracteres
        return this.dni != null && this.dni.length() == 8;
    }

    // Getters y Setters
	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNroColegiatura() {
        return nroColegiatura;
    }

    public void setNroColegiatura(String nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
    }
}