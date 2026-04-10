public class Contador {

    // Variable estática que será compartida por todos los objetos
    private static int contador = 0;

    // Constructor de la clase
    public Contador() {
        // Cada vez que se crea un objeto, aumenta el contador
        contador++;
    }

    // Método estático para obtener el valor del contador
    public static int getContador() {
        return contador;
    }

    public static void main(String[] args) {

        // Aquí se están creando 3 objetos de la clase Contador
        new Contador();
        new Contador();
        new Contador();

        // Se imprime la cantidad de objetos creados
        System.out.println("Objetos creados: " + Contador.getContador());
    }
}
