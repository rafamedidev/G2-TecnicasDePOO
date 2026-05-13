package controlador;

import dao.ICitaDAO;

import java.util.List;

import dao.CitaDAOImpl;
import modelo.Cita;

public class CitaController {

    private ICitaDAO citaDao = new CitaDAOImpl();

    public String agendarNuevaCita(Cita c) {
        if (citaDao.insertar(c)) {
            return "Cita agendada con éxito";
        } else {
            return "Error al agendar la cita";
        }
    }
    
    public List<Cita> listarCitas() {
        return citaDao.listar();
    }
}