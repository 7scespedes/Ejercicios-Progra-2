package Ejercicios;

import Implementacion.Estrategia_1;
import Interfaces.PilaTDA;

/**
 * EJERCICIO 4 - Reversión de Strings
 *
 * Usamos los valores ASCII de cada letra.
 * En Java, cada char tiene un valor numérico:
 *   'A' = 65, 'L' = 76, 'G' = 71, etc.
 *
 * Fase 1: Apilar el valor ASCII de cada letra
 * Fase 2: Desapilar y convertir de vuelta a char para armar el string invertido
 */
public class ReversionString {

    private PilaTDA pila;

    public ReversionString() {
        pila = new Estrategia_1();
        pila.InicializarPila();
    }

    public void revertir(String palabra) {
        pila.InicializarPila();
        System.out.println("  Palabra original: \"" + palabra + "\"");

        // Fase 1: apilar valor ASCII de cada letra
        System.out.println("  -- Fase 1: Apilando (como valores ASCII) --");
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            int ascii = (int) c; // conversión de char a int
            pila.Apilar(ascii);
            System.out.println("    Apilar(" + ascii + ")  ← '" + c + "'");
        }

        // Fase 2: desapilar y reconstruir el string
        System.out.println("  -- Fase 2: Desapilando --");
        StringBuilder invertida = new StringBuilder();
        while (!pila.PilaVacia()) {
            int ascii = pila.Tope();
            pila.Desapilar();
            char c = (char) ascii; // conversión de int a char
            invertida.append(c);
            System.out.println("    Tope()=" + ascii + " → '" + c + "' | Parcial: \"" + invertida + "\"");
        }

        System.out.println("  Resultado: \"" + invertida + "\"\n");
    }

    public void demostrar() {
        System.out.println("\n--- 4. Reversión de String ---");
        revertir("ALGORITMOS");
    }
}
