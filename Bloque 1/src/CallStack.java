import java.util.Stack;

/**
 * EJERCICIO 5 - Pila de Llamadas (Call Stack)
 *
 * Cuando Main() llama a CalcularPromedio() y esta llama a Sumar():
 *
 *   1. Main()             → push("Main()")
 *      Pila: [Main()]
 *
 *   2. Main llama a CalcularPromedio() → push("CalcularPromedio()")
 *      Pila: [Main(), CalcularPromedio()]
 *
 *   3. CalcularPromedio llama a Sumar() → push("Sumar()")
 *      Pila: [Main(), CalcularPromedio(), Sumar()]
 *
 *   → En el momento de ejecutar Sumar(), el TOPE es "Sumar()"
 *
 *   4. Sumar() termina → pop()  → regresa a CalcularPromedio()
 *   5. CalcularPromedio() termina → pop() → regresa a Main()
 *   6. Main() termina → pop() → programa finaliza
 */
public class CallStack {

    private Stack<String> pila;

    public CallStack() {
        pila = new Stack<>();
    }

    /**
     * Simula la llamada a una función (se apila)
     */
    private void llamar(String funcion) {
        pila.push(funcion);
        System.out.println("  → Llamando a " + funcion);
        System.out.println("    [push] Pila: " + pila);
        System.out.println("    Tope (ejecutándose): " + pila.peek());
    }

    /**
     * Simula el retorno de una función (se desapila)
     */
    private void retornar() {
        String funcion = pila.pop();
        System.out.println("  ← Retorna " + funcion);
        System.out.println("    [pop] Pila: " + pila);
        if (!pila.isEmpty()) {
            System.out.println("    Vuelve a: " + pila.peek());
        }
    }

    /**
     * Simula toda la secuencia: Main → CalcularPromedio → Sumar
     */
    public void simular() {
        System.out.println("  [Inicio del programa]");
        llamar("Main()");

        System.out.println();
        llamar("CalcularPromedio()");

        System.out.println();
        llamar("Sumar()");

        System.out.println();
        System.out.println("  *** En este momento se ejecuta Sumar() ***");
        System.out.println("  *** Tope = " + pila.peek() + " ***");

        System.out.println();
        retornar(); // Sumar() termina

        System.out.println();
        retornar(); // CalcularPromedio() termina

        System.out.println();
        retornar(); // Main() termina

        System.out.println("  [Programa finalizado. Pila vacía: " + pila.isEmpty() + "]");
    }
}
