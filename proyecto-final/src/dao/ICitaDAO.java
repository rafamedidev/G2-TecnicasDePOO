package dao;

import modelo.Cita;
import java.util.List;

public interface ICitaDAO {
    // Los métodos en una interfaz no tienen cuerpo { }, solo la firma
    public boolean insertar(Cita c);
    public boolean actualizar(Cita c);
    List<Cita> listar();
    public boolean eliminar(int id);
	
}