package persona;

//Creo la clase Persona
public class Persona {
	
	// Atributos de la clase
 private String nombre; // Aquí guardo el nombre
 private int edad;      // Aquí guardo la edad

	// Constructor: sirve para inicializar los datos cuando creo el objeto
 public Persona (String nombre, int edad) {
     this.nombre = nombre; // Asigno el nombre que recibo
     this.edad = edad;     // Asigno la edad que recibo
 }

	// Método para mostrar los datos
	public void mostrarDatos() {
     System.out.println("Nombre: " + nombre + " | Edad: " + edad); // Imprimo los datos

 }

 // Método principal
 public static void main(String[] args) {
 	
 	// Creo dos objetos con diferentes datos
     Persona p1 = new Persona ("Rafael", 25);
     Persona p2 = new Persona ("Jairo", 30);

     // Muestro la información de cada uno
     p1.mostrarDatos();
     p2.mostrarDatos();
 }
<<<<<<< HEAD
}
=======
}
>>>>>>> c68c05b (Ejercicios Actualizados)
