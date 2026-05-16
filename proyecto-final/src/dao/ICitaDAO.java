package dao;

import modelo.Cita;
import java.util.List;

public interface ICitaDAO {

    public boolean insertar(Cita c);

    public boolean actualizar(Cita c);

    public List<Cita> listar();

    public boolean eliminar(int id);
}