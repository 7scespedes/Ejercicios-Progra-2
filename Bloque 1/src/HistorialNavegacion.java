import java.util.Stack;

/**
 * EJERCICIO 1 - Historial de Navegación
 *
 * Simula el botón "Atrás" del navegador Chrome.
 * Cada vez que visitás una página, se APILA.
 * Al presionar "Atrás", se DESAPILA la página actual
 * y se muestra la página anterior (nueva cima).
 */
public class HistorialNavegacion {

    private Stack<String> historial;

    public HistorialNavegacion() {
        historial = new Stack<>();
    }

    /**
     * Visitar una nueva página → SE APILA
     */
    public void visitar(String url) {
        historial.push(url);
        System.out.println("  Visitando: " + url);
        System.out.println("  [Se apila: \"" + url + "\"]");
    }

    /**
     * Presionar botón "Atrás" → SE DESAPILA
     * La página que estaba debajo pasa a ser la actual.
     */
    public void atras() {
        if (historial.isEmpty()) {
            System.out.println("  No hay páginas anteriores.");
            return;
        }
        String paginaActual = historial.pop();
        System.out.println("\n  [Presionando Atrás]");
        System.out.println("  Se desapila: \"" + paginaActual + "\"");

        if (!historial.isEmpty()) {
            System.out.println("  Ahora estás en: \"" + historial.peek() + "\"");
        } else {
            System.out.println("  No hay más páginas en el historial.");
        }
    }

    /**
     * Muestra el estado actual de la pila (de tope a base)
     */
    public void mostrarEstado() {
        System.out.println("  Pila actual (tope → base): " + historial);
    }
}
