package cuenta;

public class Cuenta {
    // Atributos
    private String titular;
    private double saldo;

    // Constructor
    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    // Método para mostrar información
    public void mostrarInformacion() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }

    // Clase principal para probar
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta("Jairo", 1000);

        c1.mostrarInformacion();
        c1.depositar(500);
        c1.mostrarInformacion();
        c1.retirar(300);
        c1.mostrarInformacion();
    }
}
