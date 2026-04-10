package persona;

public class Persona {
	// Atributos
    private String nombre;
    private int edad;

	// Constructor
    public Persona (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

	// Impresion 
	public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad);

    }
    public static void main(String[] args) {
        Persona p1 = new Persona ("Rafael", 25);
        Persona p2 = new Persona ("Jairo", 30);

        p1.mostrarDatos();
        p2.mostrarDatos();
    }
}
