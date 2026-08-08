package edu.umg.programacion2.clase03.ejercicios.busqueda;

import java.util.ArrayList;
import java.util.List;

import edu.umg.programacion2.clase03.modelo.Usuario;

/**
 * Ejercicio de práctica 2: buscador de usuarios por nombre parcial.
 * <p>
 * Enunciado: completa BuscadorPorNombre.buscarPorNombreParcial() para que
 * encuentre usuarios cuyo nombre contenga un texto dado, sin importar
 * mayúsculas o minúsculas.
 * <p>
 * Entrada de ejemplo: "Ana López", "Luis Pérez", "Marta Ruiz"; buscar "ana".
 * Salida esperada: solo "Ana López".
 * <p>
 * Criterios de evaluación:
 * - buscarPorNombreParcial() usa contains(), no equals().
 * - La comparación ignora mayúsculas/minúsculas.
 */
public class EjercicioBuscadorPorNombre {

	public static void ejecutar() {
		System.out.println("=== Ejercicio de práctica: buscador de usuarios por nombre parcial ===");

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("u1", "Ana López", "Guatemala", "Ciudad de Guatemala", 28, "ana@ejemplo.com"));
		usuarios.add(new Usuario("u2", "Luis Pérez", "Guatemala", "Quetzaltenango", 35, "luis@ejemplo.com"));
		usuarios.add(new Usuario("u3", "Marta Ruiz", "México", "Ciudad de México", 41, "marta@ejemplo.com"));

		BuscadorPorNombre buscador = new BuscadorPorNombre();

		try {
			List<Usuario> resultado = buscador.buscarPorNombreParcial(usuarios, "ana");
			System.out.println("Buscar \"ana\" -> " + resultado);
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}
}
