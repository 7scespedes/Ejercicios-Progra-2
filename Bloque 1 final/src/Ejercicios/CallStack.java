package Ejercicios;

import Implementacion.Estrategia_1;
import Interfaces.PilaTDA;

/**
 * EJERCICIO 5 - Pila de Llamadas (Call Stack)
 *
 * Usamos códigos numéricos para cada función:
 *   1 = Main()
 *   2 = CalcularPromedio()
 *   3 = Sumar()
 */
public class CallStack {

    private PilaTDA pila;

    public CallStack() {
        pila = new Estrategia_1();
        pila.InicializarPila();
    }

    private void llamar(int codigoFuncion) {
        pila.Apilar(codigoFuncion);
        System.out.println("  → Llamando a " + traducirFuncion(codigoFuncion));
        System.out.println("    [Apilar(" + codigoFuncion + ")] Tope actual: "
                + traducirFuncion(pila.Tope()));
    }

    private void retornar() {
        String funcionActual = traducirFuncion(pila.Tope());
        pila.Desapilar();
        System.out.println("  ← Retorna " + funcionActual);
        if (!pila.PilaVacia()) {
            System.out.println("    Vuelve a: " + traducirFuncion(pila.Tope()));
        }
    }

    private String traducirFuncion(int codigo) {
        switch (codigo) {
            case 1: return "Main()";
            case 2: return "CalcularPromedio()";
            case 3: return "Sumar()";
            default: return "Funcion-" + codigo;
        }
    }

    public void demostrar() {
        System.out.println("\n--- 5. Call Stack ---");
        llamar(1); // Main()
        llamar(2); // CalcularPromedio()
        llamar(3); // Sumar()

        System.out.println();
        System.out.println("  *** Ejecutando Sumar() ***");
        System.out.println("  *** Tope = " + traducirFuncion(pila.Tope()) + " ***");
        System.out.println();

        retornar(); // Sumar() termina
        retornar(); // CalcularPromedio() termina
        retornar(); // Main() termina

        System.out.println("  [Programa finalizado. PilaVacia: " + pila.PilaVacia() + "]");
    }
}
