package estudiante;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> estudiantes = new ArrayList<>();

        System.out.println("Ingrese nombres de estudiantes. Escriba 'fin' para terminar:");

        while (true) {
            try {
                String nombre = sc.nextLine();

                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }

                if (nombre.trim().isEmpty()) {
                    throw new Exception("Nombre inválido, no puede estar vacío.");
                }

                estudiantes.add(nombre);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nLista completa de estudiantes:");
        for (String est : estudiantes) {
            System.out.println(est);
        }

        sc.close();
    }
}
