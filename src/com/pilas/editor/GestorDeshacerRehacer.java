package com.pilas.editor;

import com.pilas.command.Comando;
import java.util.Stack;

/**
 * Gestor de Deshacer/Rehacer con Comandos (Editor de texto)
 * Implementa Ctrl+Z / Ctrl+Y sobre operaciones de edición
 * 
 * Utiliza dos pilas:
 * - pilaDeshacer: Almacena comandos ejecutados que pueden deshacerse
 * - pilaRehacer: Almacena comandos deshechos que pueden rehacerse
 */
public class GestorDeshacerRehacer {
    private final Stack<Comando> pilaDeshacer;  // Pila para deshacer (comandos ejecutados)
    private final Stack<Comando> pilaRehacer;   // Pila para rehacer (comandos deshechos)
    private final EditorTexto editor;

    /**
     * Constructor del gestor
     * @param editor Editor de texto sobre el que trabajará
     */
    public GestorDeshacerRehacer(EditorTexto editor) {
        this.pilaDeshacer = new Stack<>();
        this.pilaRehacer = new Stack<>();
        this.editor = editor;
    }

    /**
     * HU-06: Ejecuta un comando y lo agrega a la pila de deshacer
     * Limpia la pila de rehacer cuando se ejecuta una nueva acción
     * @param comando Comando a ejecutar
     */
    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        pilaDeshacer.push(comando);

        // HU-06: Limpiar la pila de rehacer al hacer una acción nueva
        pilaRehacer.clear();

        System.out.println("Ejecutado: " + comando.getDescripcion());
        editor.mostrarContenido();
    }

    /**
     * HU-04: Deshacer la última acción (Ctrl+Z)
     * @return true si se pudo deshacer, false si no hay acciones para deshacer
     */
    public boolean deshacer() {
        if (pilaDeshacer.isEmpty()) {
            System.out.println("No hay acciones para deshacer");
            return false;
        }

        Comando comando = pilaDeshacer.pop();
        comando.deshacer();
        pilaRehacer.push(comando);

        System.out.println("Deshecho: " + comando.getDescripcion());
        editor.mostrarContenido();
        return true;
    }

    /**
     * HU-05: Rehacer la última acción deshecha (Ctrl+Y)
     * @return true si se pudo rehacer, false si no hay acciones para rehacer
     */
    public boolean rehacer() {
        if (pilaRehacer.isEmpty()) {
            System.out.println("No hay acciones para rehacer");
            return false;
        }

        Comando comando = pilaRehacer.pop();
        comando.ejecutar();
        pilaDeshacer.push(comando);

        System.out.println("Rehecho: " + comando.getDescripcion());
        editor.mostrarContenido();
        return true;
    }

    /**
     * Muestra el estado actual del gestor y el editor
     */
    public void mostrarEstado() {
        System.out.println("\n=== Estado del Editor ===");
        editor.mostrarContenido();
        System.out.println("Comandos para deshacer: " + pilaDeshacer.size());
        System.out.println("Comandos para rehacer: " + pilaRehacer.size());
        System.out.println("========================\n");
    }
}
