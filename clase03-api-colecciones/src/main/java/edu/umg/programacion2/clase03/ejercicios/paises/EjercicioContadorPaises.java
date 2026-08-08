package edu.umg.programacion2.clase03.ejercicios.paises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.umg.programacion2.clase03.modelo.Usuario;

/**
 * Ejercicio de práctica 1: contador de usuarios por país.
 * <p>
 * Enunciado: completa ContadorPaises.contarPorPais() para que cuente
 * cuántos usuarios hay por país usando un HashMap&lt;String, Integer&gt;.
 * <p>
 * Entrada de ejemplo: Ana y Luis (Guatemala), Marta (México).
 * Salida esperada: {Guatemala=2, México=1}.
 * <p>
 * Criterios de evaluación:
 * - contarPorPais() recorre la lista una sola vez.
 * - El conteo usa Map.getOrDefault(), no un HashSet auxiliar.
 */
public class EjercicioContadorPaises {

	public static void ejecutar() {
		System.out.println("=== Ejercicio de práctica: contador de usuarios por país ===");

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("u1", "Ana López", "Guatemala", "Ciudad de Guatemala", 28, "ana@ejemplo.com"));
		usuarios.add(new Usuario("u2", "Luis Pérez", "Guatemala", "Quetzaltenango", 35, "luis@ejemplo.com"));
		usuarios.add(new Usuario("u3", "Marta Ruiz", "México", "Ciudad de México", 41, "marta@ejemplo.com"));

		ContadorPaises contador = new ContadorPaises();

		try {
			Map<String, Integer> conteo = contador.contarPorPais(usuarios);
			System.out.println("Conteo por país: " + conteo);
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}
}
