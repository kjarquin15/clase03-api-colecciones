package edu.umg.programacion2.clase03.repositorio;

import java.util.ArrayList;
import java.util.List;

import edu.umg.programacion2.clase03.modelo.Usuario;

/**
 * Datos de respaldo por si no hay internet o el API está caído.
 * <p>
 * IMPORTANTE: esto no es "hacer trampa" con el ejercicio, es una práctica
 * real: cualquier programa que dependa de un servicio externo necesita un
 * plan B para cuando ese servicio no responde.
 */
public class DatosRespaldoUsuarios {

	public static List<Usuario> obtener() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("resp-01", "Ana López", "Guatemala", "Ciudad de Guatemala", 28, "ana@ejemplo.com"));
		usuarios.add(new Usuario("resp-02", "Luis Pérez", "Guatemala", "Quetzaltenango", 35, "luis@ejemplo.com"));
		usuarios.add(new Usuario("resp-03", "Marta Ruiz", "México", "Ciudad de México", 41, "marta@ejemplo.com"));
		usuarios.add(new Usuario("resp-04", "Carlos Gómez", "México", "Guadalajara", 23, "carlos@ejemplo.com"));
		usuarios.add(new Usuario("resp-05", "Sofía Torres", "España", "Madrid", 30, "sofia@ejemplo.com"));
		usuarios.add(new Usuario("resp-06", "Diego Ramírez", "Argentina", "Buenos Aires", 45, "diego@ejemplo.com"));
		usuarios.add(new Usuario("resp-07", "Elena Castro", "Argentina", "Córdoba", 19, "elena@ejemplo.com"));
		usuarios.add(new Usuario("resp-08", "Pablo Morales", "Chile", "Santiago", 52, "pablo@ejemplo.com"));
		return usuarios;
	}
}
