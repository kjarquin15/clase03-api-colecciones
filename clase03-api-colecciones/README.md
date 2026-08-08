# Clase 3 — API público + Colecciones (List, Map, Set con datos reales)

Sábado 1 de agosto de 2026.

## Cómo ejecutar

**Eclipse:** File > Import > Existing Maven Projects, seleccionar esta
carpeta (Eclipse/m2e descarga la dependencia y genera la configuración del
proyecto). Ejecutar `Main.java` como Java Application.

**Terminal:**
```bash
mvn compile exec:java
```

La primera vez que corras `mvn compile` necesitas internet para que Maven
descargue la dependencia `org.json` (una sola vez, luego queda en caché
local). El programa en sí también necesita internet para llamar al API;
si no hay conexión, carga automáticamente una lista de respaldo (ver
`DatosRespaldoUsuarios`) para que puedas seguir practicando sin depender
de la red.

## Contenido

| Paquete | Qué muestra |
|---|---|
| `modelo` | `Usuario`, el mismo patrón de encapsulamiento con getters que ya conocen, más un `Comparator` como clase anónima (reutiliza la idea de "implementar una interface" de la clase 1) |
| `api` | `ClienteUsuariosApi`: llama a randomuser.me con `HttpClient` (incluido en el JDK) y convierte el JSON a `List<Usuario>` con `org.json` |
| `repositorio` | Laboratorio en clase: `RepositorioUsuarios` combina `ArrayList`, `HashMap` y `HashSet` sobre datos reales, más `DatosRespaldoUsuarios` para cuando no hay internet |
| `demo` | Menú interactivo del laboratorio |
| `ejercicios` | Ejercicios de práctica con `TODO` para completar en casa o en clase |

## Idea clave de la clase

- Un programa casi nunca trabaja con datos que "ya están ahí": normalmente
  hay que **traerlos de algún lado** (un API, un archivo, una base de
  datos) y convertirlos a objetos de nuestro dominio antes de poder
  recorrerlos, buscarlos o filtrarlos con colecciones.
- Ese API puede fallar (sin internet, caído, lento). Un programa robusto
  **no se cae**: captura la excepción y decide un plan B razonable
  (`DatosRespaldoUsuarios` en este caso).
- El patrón de la clase anterior (`ArrayList` + `HashMap` + `HashSet`
  combinados) no cambia aunque los datos vengan de otro lado — por eso
  `RepositorioUsuarios` se ve casi igual a `CatalogoProductos`.

## Única dependencia nueva del proyecto: `org.json`

Este proyecto es Maven (a diferencia de la clase 2) porque necesitamos
parsear JSON y el JDK no trae un parser incluido. Es la misma mecánica de
dependencias que vieron en el demo `clase2.util` / `clase2.handler`, solo
que ahora la dependencia viene de Maven Central en vez de ser un proyecto
propio.

## ¿Por qué randomuser.me y no otro API?

Se evaluó primero restcountries.com, pero su versión pública (v3.1) quedó
deprecada y la nueva versión (v5) ya pide una API key. randomuser.me sigue
sin necesitar registro y además soporta un parámetro `seed`
(`&seed=umgprog2` en `ClienteUsuariosApi`) que hace que el API devuelva
siempre los mismos 30 usuarios — así el comportamiento del programa es
reproducible entre ejecuciones, en vez de cambiar cada vez.

## Laboratorio en clase incluido

**Usuarios desde un API público** (`repositorio` + `demo`):
`ArrayList<Usuario>` para el catálogo completo, `HashMap<String, Usuario>`
para buscar por id (uuid) y `HashSet<String>` para los países sin
repetir. Menú interactivo por consola (opción 1 del `Main`).

## Ejercicios de práctica incluidos

1. **Contador de usuarios por país** (`ejercicios/paises`): completar
   `ContadorPaises.contarPorPais()` usando un `HashMap<String, Integer>`
   como contador.
2. **Buscador por nombre parcial** (`ejercicios/busqueda`): completar
   `BuscadorPorNombre.buscarPorNombreParcial()` recorriendo un `ArrayList`
   con `contains()`.

## Tarea para la siguiente clase

Completar `RepositorioUsuarios.usuarioMasViejoDePais(String pais)`
(paquete `repositorio`) para que devuelva el usuario con mayor edad de un
país dado, recorriendo a mano el resultado de `filtrarPorPais()` (ya
resuelto). Se puede probar desde la opción 8 del menú del laboratorio
(`DemoRepositorioUsuarios`). Subir al repositorio.
