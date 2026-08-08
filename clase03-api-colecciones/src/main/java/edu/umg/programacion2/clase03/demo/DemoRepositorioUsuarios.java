package edu.umg.programacion2.clase03.demo;

import java.util.List;
import java.util.Scanner;

import edu.umg.programacion2.clase03.api.ApiUsuariosException;
import edu.umg.programacion2.clase03.api.ClienteUsuariosApi;
import edu.umg.programacion2.clase03.modelo.Usuario;
import edu.umg.programacion2.clase03.repositorio.DatosRespaldoUsuarios;
import edu.umg.programacion2.clase03.repositorio.RepositorioUsuarios;

/**
 * Menú interactivo del laboratorio: cargar usuarios desde el API, recorrer,
 * buscar, filtrar y agregar datos usando las tres colecciones del
 * RepositorioUsuarios.
 */
public class DemoRepositorioUsuarios {

	public static void ejecutar(Scanner teclado) {
		System.out.println("=== Laboratorio: usuarios desde un API público ===");

		RepositorioUsuarios repositorio = new RepositorioUsuarios();
		cargarDesdeApiOFallback(repositorio);

		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			String opcion = teclado.nextLine().trim();

			switch (opcion) {
			case "1":
				repositorio = new RepositorioUsuarios();
				cargarDesdeApiOFallback(repositorio);
				break;
			case "2":
				listarTodos(repositorio);
				break;
			case "3":
				buscarPorId(repositorio, teclado);
				break;
			case "4":
				System.out.println("Países registrados: " + repositorio.listarPaises());
				break;
			case "5":
				filtrarPorPais(repositorio, teclado);
				break;
			case "6":
				agregarUsuarioManual(repositorio, teclado);
				break;
			case "7":
				top10PorEdad(repositorio);
				break;
			case "8":
				usuarioMasViejoDePais(repositorio, teclado);
				break;
			case "0":
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	/**
	 * Intenta cargar el catálogo real desde randomuser.me. Si no hay
	 * internet o el API está caído, no dejamos el programa sin datos: caemos
	 * a una lista de respaldo para poder seguir practicando colecciones.
	 */
	private static void cargarDesdeApiOFallback(RepositorioUsuarios repositorio) {
		try {
			List<Usuario> usuarios = new ClienteUsuariosApi().obtenerUsuarios();
			repositorio.cargarTodos(usuarios);
			System.out.println("Cargados " + repositorio.total() + " usuarios desde el API.");
		} catch (ApiUsuariosException ex) {
			System.out.println("Aviso: " + ex.getMessage());
			System.out.println("Usando datos de respaldo en su lugar.");
			repositorio.cargarTodos(DatosRespaldoUsuarios.obtener());
			System.out.println("Cargados " + repositorio.total() + " usuarios de respaldo.");
		}
	}

	private static void listarTodos(RepositorioUsuarios repositorio) {
		for (Usuario usuario : repositorio.listarTodos()) {
			System.out.println(usuario);
		}
	}

	private static void buscarPorId(RepositorioUsuarios repositorio, Scanner teclado) {
		System.out.print("Id a buscar (uuid): ");
		String id = teclado.nextLine().trim();
		Usuario encontrado = repositorio.buscarPorId(id);
		System.out.println(encontrado != null ? encontrado : "No existe un usuario con ese id.");
	}

	private static void filtrarPorPais(RepositorioUsuarios repositorio, Scanner teclado) {
		System.out.print("País a filtrar (ej. Mexico): ");
		String pais = teclado.nextLine().trim();
		List<Usuario> resultado = repositorio.filtrarPorPais(pais);
		if (resultado.isEmpty()) {
			System.out.println("No hay usuarios registrados en ese país.");
			return;
		}
		for (Usuario usuario : resultado) {
			System.out.println(usuario);
		}
	}

	private static void agregarUsuarioManual(RepositorioUsuarios repositorio, Scanner teclado) {
		System.out.print("Id: ");
		String id = teclado.nextLine().trim();
		System.out.print("Nombre completo: ");
		String nombre = teclado.nextLine().trim();
		System.out.print("País: ");
		String pais = teclado.nextLine().trim();
		System.out.print("Ciudad: ");
		String ciudad = teclado.nextLine().trim();
		System.out.print("Edad: ");
		int edad = Integer.parseInt(teclado.nextLine().trim());
		System.out.print("Email: ");
		String email = teclado.nextLine().trim();

		repositorio.agregar(new Usuario(id, nombre, pais, ciudad, edad, email));
		System.out.println("Usuario agregado.");
	}

	private static void top10PorEdad(RepositorioUsuarios repositorio) {
		List<Usuario> ordenados = repositorio.ordenarPorEdadDescendente();
		int limite = Math.min(10, ordenados.size());
		for (int i = 0; i < limite; i++) {
			System.out.println((i + 1) + ". " + ordenados.get(i));
		}
	}

	private static void usuarioMasViejoDePais(RepositorioUsuarios repositorio, Scanner teclado) {
		System.out.print("País (ej. Mexico): ");
		String pais = teclado.nextLine().trim();
		try {
			Usuario resultado = repositorio.usuarioMasViejoDePais(pais);
			System.out.println(resultado != null ? resultado : "No hay usuarios registrados en ese país.");
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("--- Usuarios desde un API público ---");
		System.out.println("1) Recargar desde el API");
		System.out.println("2) Listar todo el catálogo");
		System.out.println("3) Buscar por id");
		System.out.println("4) Listar países únicos");
		System.out.println("5) Filtrar por país");
		System.out.println("6) Agregar un usuario manual");
		System.out.println("7) Top 10 más longevos");
		System.out.println("8) Usuario más viejo de un país (TODO de la tarea)");
		System.out.println("0) Volver al menú principal");
		System.out.print("Opción: ");
	}
}
