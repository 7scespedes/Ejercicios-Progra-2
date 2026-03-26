import java.util.Stack;

/**
 * EJERCICIO 3 - Balanceo de Paréntesis
 *
 * Expresión de ejemplo: ( ( a + b ) * c )
 *
 * REGLA:
 *   - Al encontrar '(' → APILAR
 *   - Al encontrar ')' → DESAPILAR y comparar
 *     Si la pila está vacía al desapilar → ERROR (cierra sin abrir)
 *   - Al final, si la pila NO está vacía → ERROR (abre sin cerrar)
 *
 * Paso a paso para "( ( a + b ) * c )":
 *   Carácter '(' → push('(')   | Pila: [( ]
 *   Carácter '(' → push('(')   | Pila: [( , (]
 *   Carácter 'a' → ignorar
 *   Carácter '+' → ignorar
 *   Carácter 'b' → ignorar
 *   Carácter ')' → pop()       | Pila: [(]   → coincide con '(' ✓
 *   Carácter '*' → ignorar
 *   Carácter 'c' → ignorar
 *   Carácter ')' → pop()       | Pila: []    → coincide con '(' ✓
 *   Fin: pila vacía → BALANCEADO ✓
 */
public class BalanceoParentesis {

    private Stack<Character> pila;

    public BalanceoParentesis() {
        pila = new Stack<>();
    }

    /**
     * Verifica si la expresión tiene paréntesis balanceados.
     * Muestra paso a paso cada APILAR y DESAPILAR.
     */
    public void verificar(String expresion) {
        pila.clear();
        System.out.println("  Expresión: \"" + expresion + "\"");
        boolean error = false;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                pila.push(c);
                System.out.println("    '" + c + "' → APILAR  | Pila: " + pila);

            } else if (c == ')') {
                if (pila.isEmpty()) {
                    System.out.println("    '" + c + "' → DESAPILAR | ERROR: pila vacía, cierra sin abrir");
                    error = true;
                    break;
                }
                char abierto = pila.pop();
                System.out.println("    '" + c + "' → DESAPILAR '" + abierto + "' | Pila: " + pila + " ✓");
            }
            // letras, operadores, espacios → se ignoran
        }

        if (!error) {
            if (pila.isEmpty()) {
                System.out.println("  Resultado: BALANCEADO ✓\n");
            } else {
                System.out.println("  Resultado: NO BALANCEADO ✗ (quedan " + pila.size() + " paréntesis sin cerrar)\n");
            }
        } else {
            System.out.println("  Resultado: NO BALANCEADO ✗\n");
        }
    }
}
