package edu.umg.programacion2.clase03.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.umg.programacion2.clase03.modelo.Usuario;

/**
 * Habla con la API pública randomuser.me y convierte su respuesta JSON en
 * objetos Usuario que el resto del programa puede usar sin saber nada de
 * HTTP ni de JSON.
 * <p>
 * HttpClient ya viene incluido en el JDK desde Java 11, no es una
 * dependencia nueva. Lo único que agregamos al proyecto fue org.json, para
 * no tener que parsear el texto del JSON a mano.
 * <p>
 * Usamos el parámetro "seed" para que el API devuelva SIEMPRE los mismos 30
 * usuarios: así los ejemplos de este README y el comportamiento del
 * programa son reproducibles, en vez de cambiar en cada ejecución.
 */
public class ClienteUsuariosApi {

	private static final String URL_API = "https://randomuser.me/api/?results=30&seed=umgprog2";

	public List<Usuario> obtenerUsuarios() throws ApiUsuariosException {
		String jsonCrudo = descargarJson();
		return parsearUsuarios(jsonCrudo);
	}

	private String descargarJson() throws ApiUsuariosException {
		try {
			HttpClient cliente = HttpClient.newHttpClient();
			HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(URL_API)).GET().build();

			HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

			if (respuesta.statusCode() != 200) {
				throw new ApiUsuariosException("El API respondió con código " + respuesta.statusCode(), null);
			}

			return respuesta.body();

		} catch (IOException | InterruptedException causa) {
			throw new ApiUsuariosException("No se pudo conectar con el API de usuarios. ¿Hay conexión a internet?",
					causa);
		}
	}

	private List<Usuario> parsearUsuarios(String json) {
		List<Usuario> usuarios = new ArrayList<>();

		// Cuidado: la respuesta NO es un array en la raíz, es un objeto con
		// una clave "results" que contiene el array. Por eso primero leemos
		// el JSONObject completo y luego sacamos el JSONArray de adentro.
		JSONObject raiz = new JSONObject(json);
		JSONArray resultados = raiz.getJSONArray("results");

		for (int i = 0; i < resultados.length(); i++) {
			usuarios.add(convertirAUsuario(resultados.getJSONObject(i)));
		}

		return usuarios;
	}

	private Usuario convertirAUsuario(JSONObject objetoUsuario) {
		String id = objetoUsuario.getJSONObject("login").optString("uuid", "???");

		JSONObject nombre = objetoUsuario.getJSONObject("name");
		String nombreCompleto = nombre.optString("first", "") + " " + nombre.optString("last", "");

		JSONObject ubicacion = objetoUsuario.getJSONObject("location");
		String pais = ubicacion.optString("country", "Desconocido");
		String ciudad = ubicacion.optString("city", "Desconocida");

		int edad = objetoUsuario.getJSONObject("dob").optInt("age", 0);
		String email = objetoUsuario.optString("email", "sin-email@ejemplo.com");

		return new Usuario(id, nombreCompleto, pais, ciudad, edad, email);
	}
}
