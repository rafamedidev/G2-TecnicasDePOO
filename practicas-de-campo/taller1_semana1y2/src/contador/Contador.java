package contador;

public class Contador {
    // Variable estática compartida por todos los objetos
    private static int contador = 0;

    // Constructor: cada vez que se crea un objeto, incrementa el contador
    public Contador() {
        contador++;
    }

    // Método para mostrar cuántos objetos se han creado
    public static void mostrarContador() {
        System.out.println("Se han creado " + contador + " objetos.");
    }

    // Clase principal para probar
    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        Contador.mostrarContador();
    }
}
