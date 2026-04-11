package contador;

// Creo la clase Contador
public class Contador {
    
    // Variable estática: esta es compartida por todos los objetos
    private static int contador = 0; // Solo existe una y todos la usan

    // Constructor: cada vez que creo un objeto, el contador aumenta
    public Contador() {
        contador++; // Cada nuevo objeto suma 1
    }

    // Método estático para mostrar cuántos objetos se han creado
    public static void mostrarContador() {
        // Muestro el total acumulado
        System.out.println("Se han creado " + contador + " objetos.");
    }

    // Método principal
    public static void main(String[] args) {
        
        // Creo objetos sin guardarlos porque solo me interesa que aumente el contador
        new Contador(); // 1
        new Contador(); // 2
        new Contador(); // 3

        // Llamo al método static directamente con la clase
        Contador.mostrarContador();
    }
}