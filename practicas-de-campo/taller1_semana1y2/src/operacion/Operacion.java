package operacion;

public class Operacion {
    // Método sumar con dos enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método sumar con dos decimales
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método sumar con tres enteros
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Clase principal para probar
    public static void main(String[] args) {
        Operacion op = new Operacion();

        System.out.println("Suma de dos enteros: " + op.sumar(5, 3));
        System.out.println("Suma de dos decimales: " + op.sumar(4.5, 2.3));
        System.out.println("Suma de tres enteros: " + op.sumar(1, 2, 3));
    }
}
