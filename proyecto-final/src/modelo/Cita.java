package modelo;

import java.time.LocalDateTime;

public class Cita {
    private int idCita;
    private LocalDateTime fechaHora;
    private String estado;
    private String diagnostico;
    private int duracionMinutos;

    // Constructor
    public Cita(int idCita, LocalDateTime fechaHora, String estado, String diagnostico, int duracionMinutos) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.duracionMinutos = duracionMinutos;
    }

    public void calcularDuracion() {
    }

    // Getters y Setters
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
}