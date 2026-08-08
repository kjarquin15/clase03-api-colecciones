package edu.umg.programacion2.clase03.modelo;

import java.util.Comparator;

/**
 * Reutiliza encapsulamiento con getters (ya visto en Prog 1 y en el
 * catálogo de la clase anterior). Es inmutable a propósito: una vez
 * cargado desde el API, un usuario no cambia sus datos.
 */
public class Usuario {

	private final String id;
	private final String nombreCompleto;
	private final String pais;
	private final String ciudad;
	private final int edad;
	private final String email;

	public Usuario(String id, String nombreCompleto, String pais, String ciudad, int edad, String email) {
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.pais = pais;
		this.ciudad = ciudad;
		this.edad = edad;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getPais() {
		return pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getEdad() {
		return edad;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s (%d años) - %s, %s - %s", id, nombreCompleto, edad, ciudad, pais, email);
	}

	/**
	 * Comparator reutilizable para ordenar usuarios por edad, de mayor a
	 * menor. Se implementa con una clase anónima (no con lambda) porque en
	 * Prog 2 todavía no cubrimos lambdas: es exactamente la misma idea de
	 * "implementar una interface" que vimos con Vehiculo en la clase 1, solo
	 * que esta vez la interface (Comparator) ya viene del JDK.
	 */
	public static final Comparator<Usuario> POR_EDAD_DESC = new Comparator<Usuario>() {
		@Override
		public int compare(Usuario u1, Usuario u2) {
			return Integer.compare(u2.getEdad(), u1.getEdad());
		}
	};
}
