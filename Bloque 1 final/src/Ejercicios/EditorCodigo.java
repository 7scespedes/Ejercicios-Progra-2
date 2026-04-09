package Ejercicios;

import Implementacion.Estrategia_1;
import Interfaces.PilaTDA;

/**
 * EJERCICIO 2 - Editor de Código (Undo/Deshacer)
 *
 * Como PilaTDA solo acepta int, representamos el estado del código
 * como un número de versión. Cada vez que el usuario escribe algo,
 * apilamos la versión anterior (para poder volver a ella).
 *
 * Ejemplo:
 *   version 0 = código vacío
 *   version 1 = después de escribir línea 1
 *   version 2 = después de escribir línea 2
 *
 * Al deshacer: Tope() nos dice a qué versión volver, Desapilar() la quita.
 */
public class EditorCodigo {

    private PilaTDA pilaUndo;
    private int versionActual;

    // Simulamos las líneas de código como un array fijo
    private static final String[] LINEAS = {
        "",
        "int x = 5;",
        "int y = 10;",
        "int z = x + y;"
    };

    public EditorCodigo() {
        pilaUndo = new Estrategia_1();
        pilaUndo.InicializarPila();
        versionActual = 0;
    }

    public void escribir(int numeroLinea) {
        // Apilamos la versión ANTERIOR antes de cambiar
        pilaUndo.Apilar(versionActual);
        System.out.println("  [Apilar versión " + versionActual + " → estado guardado]");

        versionActual = numeroLinea;
        System.out.println("  Escrito: " + LINEAS[numeroLinea]);
    }

    public void deshacer() {
        if (pilaUndo.PilaVacia()) {
            System.out.println("  No hay más cambios para deshacer.");
            return;
        }
        System.out.println("\n  [Ctrl+Z → Undo]");
        int versionAnterior = pilaUndo.Tope(); // guardo a dónde volver
        pilaUndo.Desapilar();                  // elimino ese estado de la pila
        versionActual = versionAnterior;
        System.out.println("  Volviste a versión " + versionActual);
        mostrarCodigo();
    }

    public void mostrarCodigo() {
        System.out.println("  --- Código actual (versión " + versionActual + ") ---");
        if (versionActual == 0) {
            System.out.println("  (vacío)");
        } else {
            for (int i = 1; i <= versionActual; i++) {
                System.out.println("  " + i + ": " + LINEAS[i]);
            }
        }
        System.out.println("  ----------------------------------");
    }

    public void demostrar() {
        System.out.println("\n--- 2. Editor de Código (Undo) ---");
        escribir(1);
        escribir(2);
        escribir(3);
        mostrarCodigo();
        deshacer();
        deshacer();
    }
}
