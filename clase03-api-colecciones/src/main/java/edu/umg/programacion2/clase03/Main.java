package edu.umg.programacion2.clase03;

import java.util.Scanner;

import edu.umg.programacion2.clase03.demo.DemoRepositorioUsuarios;
import edu.umg.programacion2.clase03.ejercicios.busqueda.EjercicioBuscadorPorNombre;
import edu.umg.programacion2.clase03.ejercicios.paises.EjercicioContadorPaises;

/**
 * Menú principal - Clase 3: consumir un API público y practicar
 * List, Map y Set con datos reales.
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			mostrarMenu();
			String opcion = teclado.nextLine().trim();

			switch (opcion) {
			case "1":
				DemoRepositorioUsuarios.ejecutar(teclado);
				break;
			case "2":
				EjercicioContadorPaises.ejecutar();
				break;
			case "3":
				EjercicioBuscadorPorNombre.ejecutar();
				break;
			case "0":
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}

		teclado.close();
		System.out.println("Fin del programa.");
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("=== Clase 3: API público + Colecciones ===");
		System.out.println("--- Laboratorio en clase ---");
		System.out.println("1) Usuarios desde un API público (List + Map + Set)");
		System.out.println("--- Ejercicios de práctica (con TODO) ---");
		System.out.println("2) Contador de usuarios por país (Map)");
		System.out.println("3) Buscador de usuarios por nombre parcial (List)");
		System.out.println("0) Salir");
		System.out.print("Opción: ");
	}
}
