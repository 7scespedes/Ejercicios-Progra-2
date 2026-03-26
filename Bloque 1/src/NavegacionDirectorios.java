import java.util.Stack;

/**
 * EJERCICIO 6 - Navegación de Directorios
 *
 * El sistema de archivos funciona como una pila:
 *   - Entrás a una carpeta → APILAR
 *   - "Subir un nivel" → DESAPILAR
 *
 * Ejemplo: C:/ → Usuarios → Documentos
 *
 *   entrar("C:/")        → push("C:/")        | Pila: [C:/]
 *   entrar("Usuarios")   → push("Usuarios")   | Pila: [C:/, Usuarios]
 *   entrar("Documentos") → push("Documentos") | Pila: [C:/, Usuarios, Documentos]
 *
 *   subirNivel() → pop() "Documentos"  | Pila: [C:/, Usuarios]
 *   subirNivel() → pop() "Usuarios"    | Pila: [C:/]
 *
 * La pila SABE a dónde volver porque guardó todo el recorrido.
 */
public class NavegacionDirectorios {

    private Stack<String> pila;

    public NavegacionDirectorios() {
        pila = new Stack<>();
    }

    /**
     * Entramos a una carpeta → se APILA
     */
    public void entrar(String carpeta) {
        pila.push(carpeta);
        System.out.println("  Entrando a: " + carpeta);
        System.out.println("  [push] Pila: " + pila);
    }

    /**
     * "Subir un nivel" → se DESAPILA la carpeta actual
     * La carpeta de debajo pasa a ser la ubicación actual.
     */
    public void subirNivel() {
        if (pila.isEmpty()) {
            System.out.println("  Ya estás en la raíz, no podés subir más.");
            return;
        }
        String carpetaActual = pila.pop();
        System.out.println("\n  [Subir un nivel]");
        System.out.println("  Saliendo de: \"" + carpetaActual + "\"");
        System.out.println("  [pop] Pila: " + pila);

        if (!pila.isEmpty()) {
            System.out.println("  Ahora estás en: \"" + pila.peek() + "\"");
        } else {
            System.out.println("  Llegaste a la raíz del sistema.");
        }
    }

    /**
     * Muestra la ruta actual (reconstruida desde la base hasta el tope)
     */
    public void mostrarRuta() {
        if (pila.isEmpty()) {
            System.out.println("  Ruta actual: (ninguna)");
            return;
        }
        StringBuilder ruta = new StringBuilder();
        Object[] elementos = pila.toArray();
        for (int i = 0; i < elementos.length; i++) {
            ruta.append(elementos[i]);
            if (i < elementos.length - 1) ruta.append(" > ");
        }
        System.out.println("  Ruta actual: " + ruta);
        System.out.println("  Carpeta actual (tope): \"" + pila.peek() + "\"");
    }
}
