public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIOS DE PILAS (LIFO) ===\n");

        // 1. Historial de Navegación
        System.out.println("--- 1. Historial de Navegación ---");
        HistorialNavegacion historial = new HistorialNavegacion();
        historial.visitar("fi.uba.ar");
        historial.visitar("campus.utn.edu.ar");
        historial.visitar("stackoverflow.com");
        historial.mostrarEstado();
        historial.atras();
        historial.mostrarEstado();
        historial.atras();
        historial.mostrarEstado();

        // 2. Editor de Código (Undo/Deshacer)
        System.out.println("\n--- 2. Editor de Código (Undo/Deshacer) ---");
        EditorCodigo editor = new EditorCodigo();
        editor.escribir("int x = 5;");
        editor.escribir("int y = 10;");
        editor.escribir("int z = x + y;");
        editor.mostrarCodigo();
        editor.deshacer();
        editor.mostrarCodigo();
        editor.deshacer();
        editor.mostrarCodigo();

        // 3. Balanceo de Paréntesis
        System.out.println("\n--- 3. Balanceo de Paréntesis ---");
        BalanceoParentesis bp = new BalanceoParentesis();
        bp.verificar("( ( a + b ) * c )");
        bp.verificar("( ( a + b ) * c");   // mal balanceado
        bp.verificar("( a + b ) )");        // mal balanceado

        // 4. Reversión de Strings
        System.out.println("\n--- 4. Reversión de String ---");
        ReversionString rev = new ReversionString();
        rev.revertir("ALGORITMOS");

        // 5. Pila de Llamadas (Call Stack)
        System.out.println("\n--- 5. Call Stack ---");
        CallStack callStack = new CallStack();
        callStack.simular();

        // 6. Navegación de Directorios
        System.out.println("\n--- 6. Navegación de Directorios ---");
        NavegacionDirectorios nav = new NavegacionDirectorios();
        nav.entrar("C:/");
        nav.entrar("Usuarios");
        nav.entrar("Documentos");
        nav.mostrarRuta();
        nav.subirNivel();
        nav.mostrarRuta();
        nav.subirNivel();
        nav.mostrarRuta();
    }
}
