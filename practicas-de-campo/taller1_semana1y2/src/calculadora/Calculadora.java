package calculadora;

import java.util.Scanner;

public class Calculadora {
	
	// Método para sumar
	public static double sumar(double a, double b) {
		return a + b;			
	}
				
	// Método para restar
	public static double restar(double a, double b) {
		return a - b;
	}			
				
	// Método para multiplicar
	public static double multiplicar(double a, double b) {
		return a * b;
	}			
				
	// Método para dividir
	public static double dividir(double a, double b) {
		if (b != 0) {
			return a / b;
		} else {
			System.out.println("Error: no se puede dividir entre cero.");
			return 0;
		}
	}			

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingrese el primer número: ");
		double num1 = sc.nextDouble();
		
		System.out.print("Ingrese el segundo número: ");
		double num2 = sc.nextDouble();
		
		System.out.println("Elija la operación:");
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicación");
		System.out.println("4. Dvisión");
		
		int opcion = sc.nextInt();
		
		switch (opcion) {
			case 1:
				System.out.println("Resultado: " + sumar(num1, num2));
				break;
			case 2:
				System.out.println("Resultado: " + restar(num1, num2));
				break;
			case 3:
				System.out.println("Resultado: " + multiplicar(num1, num2));
				break;
			case 4:
				System.out.println("Resultado: " + dividir(num1, num2));
				break;
			default:
				System.out.println("Opción inválida.");

		sc.close();
				
		}

	}

}