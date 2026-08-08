package edu.umg.programacion2.clase03.repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.umg.programacion2.clase03.modelo.Usuario;

/**
 * Guarda el mismo conjunto de usuarios en tres colecciones distintas, cada
 * una optimizada para una operación distinta. Mismo patrón que
 * CatalogoProductos de la clase anterior, ahora con datos que vienen de un
 * API público en vez de estar escritos a mano.
 * <p>
 * - ArrayList&lt;Usuario&gt;: mantener el catálogo completo, en orden de llegada.
 * - HashMap&lt;String, Usuario&gt;: encontrar un usuario por id (uuid) al instante.
 * - HashSet&lt;String&gt;: saber qué países existen entre los usuarios, sin repetidos.
 */
public class RepositorioUsuarios {

	private final List<Usuario> usuarios = new ArrayList<>();
	private final Map<String, Usuario> usuariosPorId = new HashMap<>();
	private final Set<String> paises = new HashSet<>();

	public void agregar(Usuario usuario) {
		usuarios.add(usuario);
		usuariosPorId.put(usuario.getId(), usuario);
		paises.add(usuario.getPais());
	}

	public void cargarTodos(List<Usuario> usuariosACargar) {
		for (Usuario usuario : usuariosACargar) {
			agregar(usuario);
		}
	}

	public List<Usuario> listarTodos() {
		return usuarios;
	}

	public Usuario buscarPorId(String id) {
		// El HashMap ya compara claves con equals() internamente, por eso
		// basta con get(id): no hace falta recorrer nada.
		return usuariosPorId.get(id);
	}

	public Set<String> listarPaises() {
		return paises;
	}

	public List<Usuario> filtrarPorPais(String pais) {
		List<Usuario> resultado = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			if (usuario.getPais().equalsIgnoreCase(pais)) {
				resultado.add(usuario);
			}
		}
		return resultado;
	}

	public List<Usuario> ordenarPorEdadDescendente() {
		List<Usuario> copia = new ArrayList<>(usuarios);
		Collections.sort(copia, Usuario.POR_EDAD_DESC);
		return copia;
	}

	public int total() {
		return usuarios.size();
	}

	/**
	 * TODO (estudiante): completar para la siguiente clase.
	 * <p>
	 * Enunciado: dado el nombre de un país, encontrar el usuario con MAYOR
	 * edad dentro de ese país. Si el país no tiene ningún usuario
	 * registrado, retornar null.
	 * <p>
	 * Entrada de ejemplo: usuarioMasViejoDePais("Guatemala") con el catálogo
	 * cargado desde el API (o desde los datos de respaldo).
	 * Salida esperada: el usuario de Guatemala con mayor edad (Luis Pérez,
	 * 35 años, con los datos de respaldo).
	 * <p>
	 * Pista: primero usa filtrarPorPais(pais), que ya está resuelto. Con
	 * esa lista más corta, recorre con un for-each guardando en una variable
	 * el usuario "más viejo visto hasta ahora" y compara edad contra edad.
	 * No hace falta el Comparator de Usuario para esto: es un ejercicio de
	 * recorrer y comparar a mano.
	 * <p>
	 * Criterios de evaluación:
	 * - No usa Usuario.POR_EDAD_DESC ni Collections.sort() (es un recorrido
	 *   manual, ese es el punto del ejercicio).
	 * - Si el país no existe o no tiene usuarios, retorna null, no lanza
	 *   excepción.
	 * - Compara edades con &gt;, nunca con == (aquí == sí funcionaría porque
	 *   edad es un int, pero cuidado con este mismo error al comparar
	 *   Strings en otros ejercicios).
	 */
	public Usuario usuarioMasViejoDePais(String pais) {
		// TODO: reemplazar esta línea por la lógica descrita arriba.
		throw new UnsupportedOperationException("TODO: completar usuarioMasViejoDePais() en RepositorioUsuarios");
	}
}
