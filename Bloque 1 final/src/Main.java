import Ejercicios.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIOS DE PILAS (LIFO) ===");
        System.out.println("=== Implementación con PilaTDA  ===\n");

        new HistorialNavegacion().demostrar();
        new EditorCodigo().demostrar();
        new BalanceoParentesis().demostrar();
        new ReversionString().demostrar();
        new CallStack().demostrar();
        new NavegacionDirectorios().demostrar();
    }
}
