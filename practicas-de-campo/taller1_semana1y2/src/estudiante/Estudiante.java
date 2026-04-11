package estudiante;

import java.util.ArrayList; // Uso ArrayList para guardar nombres sin límite
import java.util.Scanner;   // Uso Scanner para leer lo que escribe el usuario

public class Estudiante {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // Creo el Scanner
        ArrayList<String> estudiantes = new ArrayList<>(); // Lista donde guardo los nombres

        // Aviso al usuario cómo funciona
        System.out.println("Ingrese nombres de estudiantes. Escriba 'fin' para terminar:");

        // Bucle infinito, solo se rompe cuando escriben "fin"
        while (true) {
            try {
                String nombre = sc.nextLine(); // Leo el nombre

                // Si escribe "fin", termino el programa
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }

                // Valido que no esté vacío o solo espacios
                if (nombre.trim().isEmpty()) {
                    throw new Exception("Nombre inválido, no puede estar vacío.");
                }

                // Si todo está bien, lo guardo en la lista
                estudiantes.add(nombre);

            } catch (Exception e) {
                // Si hay error, lo muestro pero el programa sigue
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Muestro todos los nombres ingresados
        System.out.println("\nLista completa de estudiantes:");
        
        // Recorro la lista y muestro cada nombre
        for (String est : estudiantes) {
            System.out.println(est);
        }

        sc.close(); // Cierro el Scanner
    }
}