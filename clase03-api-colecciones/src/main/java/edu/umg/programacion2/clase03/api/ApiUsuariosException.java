package edu.umg.programacion2.clase03.api;

/**
 * Excepción propia (checked) para todo lo que pueda salir mal al hablar con
 * el API de usuarios: sin internet, API caído, respuesta inesperada, etc.
 * <p>
 * IMPORTANTE: envolvemos la excepción original (IOException,
 * InterruptedException) en esta, con un mensaje en español que un usuario
 * final pueda entender. Nunca dejamos que un stack trace crudo llegue hasta
 * la persona que usa el programa.
 */
public class ApiUsuariosException extends Exception {

	public ApiUsuariosException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
