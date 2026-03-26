import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/**
 * EJERCICIO 2 - Editor de Código (Undo/Deshacer)
 *
 * Cada vez que el usuario escribe una línea, se guarda
 * el ESTADO ANTERIOR del código en una pila de undo.
 *
 * Al deshacer, se DESAPILA el estado anterior y se restaura.
 *
 * ¿Qué se apila? → Una COPIA del código ANTES de hacer el cambio.
 * ¿Cómo se recupera el estado anterior? → Con pop() se obtiene
 * el último estado guardado y reemplaza el código actual.
 */
public class EditorCodigo {

    // Estado actual del código (lista de líneas)
    private List<String> codigoActual;

    // Pila de estados anteriores (para Undo)
    private Stack<List<String>> pilaUndo;

    public EditorCodigo() {
        codigoActual = new ArrayList<>();
        pilaUndo = new Stack<>();
    }

    /**
     * Escribe una nueva línea de código.
     * ANTES de modificar, guarda el estado actual en la pila.
     */
    public void escribir(String linea) {
        // APILAR: guardamos copia del estado ANTES del cambio
        pilaUndo.push(new ArrayList<>(codigoActual));
        System.out.println("  [Se apila estado previo con " + codigoActual.size() + " línea(s)]");

        // Ahora aplicamos el cambio
        codigoActual.add(linea);
        System.out.println("  Escrito: " + linea);
    }

    /**
     * Deshace el último cambio.
     * DESAPILA el estado anterior y lo restaura.
     */
    public void deshacer() {
        if (pilaUndo.isEmpty()) {
            System.out.println("  No hay más cambios para deshacer.");
            return;
        }
        System.out.println("\n  [Ctrl+Z → Undo]");
        // DESAPILAR: recuperamos el estado anterior
        codigoActual = pilaUndo.pop();
        System.out.println("  Estado restaurado (" + codigoActual.size() + " línea(s))");
    }

    /**
     * Muestra el código actual en el editor
     */
    public void mostrarCodigo() {
        System.out.println("  --- Código actual ---");
        if (codigoActual.isEmpty()) {
            System.out.println("  (vacío)");
        } else {
            for (int i = 0; i < codigoActual.size(); i++) {
                System.out.println("  " + (i + 1) + ": " + codigoActual.get(i));
            }
        }
        System.out.println("  ---------------------");
    }
}
