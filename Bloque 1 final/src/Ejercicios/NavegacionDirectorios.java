package Ejercicios;

import Implementacion.Estrategia_1;
import Interfaces.PilaTDA;

/**
 * EJERCICIO 6 - Navegación de Directorios
 *
 * Códigos numéricos para cada carpeta:
 *   1 = C:/
 *   2 = Usuarios
 *   3 = Documentos
 */
public class NavegacionDirectorios {

    private PilaTDA pila;

    public NavegacionDirectorios() {
        pila = new Estrategia_1();
        pila.InicializarPila();
    }

    public void entrar(int codigoCarpeta) {
        pila.Apilar(codigoCarpeta);
        System.out.println("  Entrando a: " + traducirCarpeta(codigoCarpeta));
        System.out.println("  [Apilar(" + codigoCarpeta + ")]");
    }

    public void subirNivel() {
        if (pila.PilaVacia()) {
            System.out.println("  Ya estás en la raíz.");
            return;
        }
        String carpetaActual = traducirCarpeta(pila.Tope());
        pila.Desapilar();
        System.out.println("\n  [Subir un nivel]");
        System.out.println("  Saliste de: \"" + carpetaActual + "\"");

        if (!pila.PilaVacia()) {
            System.out.println("  Ahora estás en: \"" + traducirCarpeta(pila.Tope()) + "\"");
        } else {
            System.out.println("  Llegaste a la raíz.");
        }
    }

    private String traducirCarpeta(int codigo) {
        switch (codigo) {
            case 1: return "C:/";
            case 2: return "Usuarios";
            case 3: return "Documentos";
            default: return "Carpeta-" + codigo;
        }
    }

    public void demostrar() {
        System.out.println("\n--- 6. Navegación de Directorios ---");
        entrar(1);
        entrar(2);
        entrar(3);
        subirNivel();
        subirNivel();
    }
}
