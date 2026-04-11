package calculadora;

import java.util.Scanner; // Importo Scanner para leer datos del usuario

public class Calculadora {
	
	// Método para sumar dos números
	public static double sumar(double a, double b) {
		return a + b; // Retorno la suma de los dos valores
	}
				
	// Método para restar dos números
	public static double restar(double a, double b) {
		return a - b; // Retorno la resta
	}			
				
	// Método para multiplicar dos números
	public static double multiplicar(double a, double b) {
		return a * b; // Retorno la multiplicación
	}			
				
	// Método para dividir dos números
	public static double dividir(double a, double b) {
		// Verifico que el divisor no sea cero
		if (b != 0) {
			return a / b; // Realizo la división
		} else {
			System.out.println("Error: no se puede dividir entre cero."); // Mensaje de error
			return 0; // Retorno 0 en caso de error
		}
	}			

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Creo el objeto Scanner
		
		// Solicito al usuario el primer número
		System.out.print("Ingrese el primer número: ");
		double num1 = sc.nextDouble();
		
		// Solicito el segundo número
		System.out.print("Ingrese el segundo número: ");
		double num2 = sc.nextDouble();
		
		// Muestro el menú de opciones
		System.out.println("Elija la operación:");
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicación");
		System.out.println("4. Dvisión");
		
		int opcion = sc.nextInt(); // Leo la opción elegida
		
		// Uso un switch para ejecutar la operación seleccionada
		switch (opcion) {
			case 1:
				System.out.println("Resultado: " + sumar(num1, num2)); // Llamo al método sumar
				break;
			case 2:
				System.out.println("Resultado: " + restar(num1, num2)); // Llamo al método restar
				break;
			case 3:
				System.out.println("Resultado: " + multiplicar(num1, num2)); // Llamo al método multiplicar
				break;
			case 4:
				System.out.println("Resultado: " + dividir(num1, num2)); // Llamo al método dividir
				break;
			default:
				System.out.println("Opción inválida."); // Mensaje si la opción no existe

		sc.close(); // Cierro el Scanner para liberar recursos
				
		}

	}

}
