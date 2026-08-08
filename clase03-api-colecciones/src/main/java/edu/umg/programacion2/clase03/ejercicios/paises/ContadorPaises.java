package edu.umg.programacion2.clase03.ejercicios.paises;

import java.util.List;
import java.util.Map;

import edu.umg.programacion2.clase03.modelo.Usuario;

/**
 * TODO (estudiante): completar contarPorPais().
 * <p>
 * Enunciado: recorrer la lista de usuarios y devolver un Map donde la clave
 * es el país y el valor es cuántos usuarios de ese país hay en la lista.
 * <p>
 * Entrada de ejemplo: [Ana-Guatemala, Luis-Guatemala, Marta-México].
 * Salida esperada: {Guatemala=2, México=1} (el orden puede variar, HashMap
 * no garantiza orden).
 * <p>
 * Pista: recorre la lista con un for-each. Para cada usuario, usa
 * conteo.getOrDefault(pais, 0) para obtener el valor actual (o 0 si es la
 * primera vez que aparece ese país) y guarda ese valor + 1 con put().
 * <p>
 * Criterios de evaluación:
 * - No usa streams ni lambdas, solo un for-each y el Map.
 * - Usa Map.getOrDefault(), no un HashSet auxiliar ni un if con
 *   containsKey() por separado.
 * - Si la lista está vacía, retorna un Map vacío (no null).
 */
public class ContadorPaises {

	public Map<String, Integer> contarPorPais(List<Usuario> usuarios) {
		// TODO: reemplazar esta línea por la lógica descrita arriba.
		throw new UnsupportedOperationException("TODO: completar contarPorPais() en ContadorPaises");
	}
}
