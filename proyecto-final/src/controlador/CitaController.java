package controlador;

import dao.CitaDAOImpl;
import dao.ICitaDAO;
import modelo.Cita;

import java.util.List;

public class CitaController {

    private ICitaDAO dao = new CitaDAOImpl();

    public String agendarNuevaCita(Cita cita) {

        if (dao.insertar(cita)) {

            return "Cita registrada correctamente";

        } else {

            return "Error al registrar la cita";
        }
    }

    public String actualizarCita(Cita cita) {

        if (dao.actualizar(cita)) {

            return "Cita actualizada correctamente";

        } else {

            return "Error al actualizar la cita";
        }
    }

    public String eliminarCita(int idCita) {

        if (dao.eliminar(idCita)) {

            return "Cita eliminada correctamente";

        } else {

            return "Error al eliminar la cita";
        }
    }

    public List<Cita> listarCitas() {

        return dao.listar();
    }
}