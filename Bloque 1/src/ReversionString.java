import java.util.Stack;

/**
 * EJERCICIO 4 - Reversión de Strings
 *
 * Para revertir "ALGORITMOS":
 *
 * FASE 1 - APILAR letra por letra:
 *   push('A') → Pila: [A]
 *   push('L') → Pila: [A, L]
 *   push('G') → Pila: [A, L, G]
 *   push('O') → Pila: [A, L, G, O]
 *   ... y así hasta push('S')
 *   Pila final: [A, L, G, O, R, I, T, M, O, S]  ← S es el tope
 *
 * FASE 2 - DESAPILAR para armar el string invertido:
 *   pop() → 'S'
 *   pop() → 'O'
 *   pop() → 'M'
 *   ... hasta vaciar la pila
 *   Resultado: "SOMTIRОГLA" → "SOMTIRОГLA"
 *
 * La magia del LIFO: el ÚLTIMO que entró (S) es el PRIMERO en salir.
 */
public class ReversionString {

    public void revertir(String palabra) {
        Stack<Character> pila = new Stack<>();

        System.out.println("  Palabra original: \"" + palabra + "\"");

        // FASE 1: Apilar letra por letra
        System.out.println("  -- Fase 1: Apilando --");
        for (char c : palabra.toCharArray()) {
            pila.push(c);
            System.out.println("    push('" + c + "') | Pila: " + pila);
        }

        // FASE 2: Desapilar para construir el string invertido
        System.out.println("  -- Fase 2: Desapilando --");
        StringBuilder invertida = new StringBuilder();
        while (!pila.isEmpty()) {
            char c = pila.pop();
            invertida.append(c);
            System.out.println("    pop() → '" + c + "' | Parcial: \"" + invertida + "\"");
        }

        System.out.println("  Resultado: \"" + invertida + "\"\n");
    }
}
