package Ejercicios;

import Implementacion.Estrategia_1;
import Interfaces.PilaTDA;

/**
 * EJERCICIO 1 - Historial de Navegación
 *
 * Como PilaTDA solo acepta int, usamos códigos numéricos para las URLs:
 *   1 = fi.uba.ar
 *   2 = campus.utn.edu.ar
 *   3 = stackoverflow.com
 *
 * Operaciones:
 *   Apilar(codigo)  → visitar una página
 *   Tope()          → ver la página actual
 *   Desapilar()     → presionar "Atrás"
 */
public class HistorialNavegacion {

    private PilaTDA historial;

    public HistorialNavegacion() {
        historial = new Estrategia_1();
        historial.InicializarPila();
    }

    public void visitar(int codigoUrl) {
        historial.Apilar(codigoUrl);
        System.out.println("  Visitando: " + traducirUrl(codigoUrl));
        System.out.println("  [Apilar(" + codigoUrl + ")]");
    }

    public void atras() {
        if (historial.PilaVacia()) {
            System.out.println("  No hay páginas anteriores.");
            return;
        }
        int paginaActual = historial.Tope(); // primero guardo el tope
        historial.Desapilar();               // después lo elimino
        System.out.println("\n  [Presionando Atrás]");
        System.out.println("  Salí de: " + traducirUrl(paginaActual));

        if (!historial.PilaVacia()) {
            System.out.println("  Ahora estás en: " + traducirUrl(historial.Tope()));
        } else {
            System.out.println("  No hay más páginas en el historial.");
        }
    }

    private String traducirUrl(int codigo) {
        switch (codigo) {
            case 1: return "fi.uba.ar";
            case 2: return "campus.utn.edu.ar";
            case 3: return "stackoverflow.com";
            default: return "pagina-" + codigo;
        }
    }

    public void demostrar() {
        System.out.println("\n--- 1. Historial de Navegación ---");
        visitar(1);
        visitar(2);
        visitar(3);
        atras();
        atras();
    }
}
