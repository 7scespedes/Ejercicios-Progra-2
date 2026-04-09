package Ejercicios;

import Implementacion.Estrategia_1;
import Interfaces.PilaTDA;

/**
 * EJERCICIO 3 - Balanceo de Paréntesis
 *
 * Este ejercicio encaja perfecto con PilaTDA:
 * usamos el valor 1 para representar '(' en la pila.
 *
 * Regla:
 *   Encontramos '(' → Apilar(1)
 *   Encontramos ')' → si PilaVacia() hay error, sino Desapilar()
 *   Al final: si PilaVacia() → balanceado, sino → faltan cerrar
 */
public class BalanceoParentesis {

    private PilaTDA pila;

    public BalanceoParentesis() {
        pila = new Estrategia_1();
        pila.InicializarPila();
    }

    public void verificar(String expresion) {
        // Reiniciamos la pila para cada verificación
        pila.InicializarPila();
        boolean error = false;

        System.out.println("  Expresión: \"" + expresion + "\"");

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                pila.Apilar(1); // usamos 1 para representar '('
                System.out.println("    '" + c + "' → Apilar(1)");

            } else if (c == ')') {
                if (pila.PilaVacia()) {
                    System.out.println("    '" + c + "' → ERROR: pila vacía, cierra sin abrir");
                    error = true;
                    break;
                }
                pila.Desapilar();
                System.out.println("    '" + c + "' → Desapilar() ✓");
            }
        }

        if (!error) {
            if (pila.PilaVacia()) {
                System.out.println("  Resultado: BALANCEADO ✓\n");
            } else {
                System.out.println("  Resultado: NO BALANCEADO ✗ (faltan cerrar paréntesis)\n");
            }
        } else {
            System.out.println("  Resultado: NO BALANCEADO ✗\n");
        }
    }

    public void demostrar() {
        System.out.println("\n--- 3. Balanceo de Paréntesis ---");
        verificar("( ( a + b ) * c )");
        verificar("( ( a + b ) * c");
        verificar("( a + b ) )");
    }
}
