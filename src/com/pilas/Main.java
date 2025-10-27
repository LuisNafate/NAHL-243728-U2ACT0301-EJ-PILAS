package com.pilas;

import com.pilas.command.ComandoBorrar;
import com.pilas.command.ComandoInsertar;
import com.pilas.editor.EditorTexto;
import com.pilas.editor.GestorDeshacerRehacer;
import com.pilas.navegacion.HistorialNavegacion;

/**
 * Clase principal que demuestra el uso de Pilas (Stacks)
 * con dos casos de uso prácticos:
 * 1. Historial de navegación web (Back/Forward)
 * 2. Sistema de Deshacer/Rehacer en un editor de texto (Undo/Redo)
 * 
 * @author Luis
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("EJEMPLOS DE PILAS - ESTRUCTURAS DE DATOS");
        System.out.println("===========================================\n");

        // Demostración 1: Historial de Navegación
        demoHistorialNavegacion();

        System.out.println("\n\n");

        // Demostración 2: Gestor Deshacer/Rehacer
        demoGestorDeshacerRehacer();
    }

    /**
     * Demostración del Módulo de Historial de Navegación (Back/Forward)
     * Cubre HU-01, HU-02 y HU-03
     */
    private static void demoHistorialNavegacion() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  MÓDULO 1: HISTORIAL DE NAVEGACIÓN           ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        HistorialNavegacion navegador = new HistorialNavegacion();

        // Visitando varias páginas
        System.out.println("--- Visitando páginas web ---");
        navegador.visitarURL("https://www.google.com");
        navegador.visitarURL("https://www.youtube.com");
        navegador.visitarURL("https://www.github.com");
        navegador.visitarURL("https://www.stackoverflow.com");
        navegador.mostrarEstado();

        // HU-01: Probar funcionalidad de Atrás
        System.out.println("--- HU-01: Probando botón ATRÁS ---");
        navegador.irAtras();  // stackoverflow -> github
        navegador.irAtras();  // github -> youtube
        navegador.mostrarEstado();

        // HU-02: Probar funcionalidad de Adelante
        System.out.println("--- HU-02: Probando botón ADELANTE ---");
        navegador.irAdelante();  // youtube -> github
        navegador.mostrarEstado();

        // HU-03: Visitar nueva URL limpia la pila de adelante
        System.out.println("--- HU-03: Nueva URL limpia historial adelante ---");
        navegador.visitarURL("https://www.wikipedia.org");
        navegador.mostrarEstado();

        System.out.println("Intentando ir adelante (debería estar vacío):");
        navegador.irAdelante();  // No debería haber nada
        navegador.mostrarEstado();

        // Caso límite: intentar retroceder sin historial
        System.out.println("--- Caso límite: Atrás sin historial ---");
        HistorialNavegacion navegadorNuevo = new HistorialNavegacion();
        navegadorNuevo.visitarURL("https://www.ejemplo.com");
        navegadorNuevo.irAtras();  // No hay historial previo
    }

    /**
     * Demostración del Gestor de Deshacer/Rehacer con Comandos
     * Cubre HU-04, HU-05 y HU-06
     */
    private static void demoGestorDeshacerRehacer() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  MÓDULO 2: GESTOR DESHACER/REHACER (Ctrl+Z)  ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        EditorTexto editor = new EditorTexto();
        GestorDeshacerRehacer gestor = new GestorDeshacerRehacer(editor);

        // Ejecutando varias operaciones de edición
        System.out.println("--- Ejecutando operaciones de edición ---");
        gestor.ejecutarComando(new ComandoInsertar(editor, "Hola ", 0));
        gestor.ejecutarComando(new ComandoInsertar(editor, "mundo", 5));
        gestor.ejecutarComando(new ComandoInsertar(editor, "!", 10));
        gestor.ejecutarComando(new ComandoInsertar(editor, " Java es genial", 11));
        gestor.mostrarEstado();

        // HU-04: Probar funcionalidad de Deshacer (Ctrl+Z)
        System.out.println("--- HU-04: Probando DESHACER (Ctrl+Z) ---");
        gestor.deshacer();  // Quita " Java es genial"
        gestor.deshacer();  // Quita "!"
        gestor.mostrarEstado();

        // HU-05: Probar funcionalidad de Rehacer (Ctrl+Y)
        System.out.println("--- HU-05: Probando REHACER (Ctrl+Y) ---");
        gestor.rehacer();   // Vuelve a poner "!"
        gestor.mostrarEstado();

        // HU-06: Nueva acción limpia la pila de rehacer
        System.out.println("--- HU-06: Nueva acción limpia pila de rehacer ---");
        gestor.ejecutarComando(new ComandoInsertar(editor, " Python también", 11));
        gestor.mostrarEstado();

        System.out.println("Intentando rehacer (debería estar vacío):");
        gestor.rehacer();  // No debería haber nada para rehacer
        gestor.mostrarEstado();

        // Demostrando comando de borrar
        System.out.println("--- Probando comando BORRAR ---");
        gestor.ejecutarComando(new ComandoBorrar(editor, 5, 6));  // Borra "Python"
        gestor.mostrarEstado();

        System.out.println("--- Deshaciendo el borrado ---");
        gestor.deshacer();  // Restaura "Python"
        gestor.mostrarEstado();

        // Caso límite: deshacer sin historial
        System.out.println("--- Caso límite: Deshacer todo ---");
        while (gestor.deshacer()) {
            // Deshacer todas las operaciones
        }
        gestor.mostrarEstado();
    }
}
