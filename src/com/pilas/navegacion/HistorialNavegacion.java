package com.pilas.navegacion;

import java.util.Stack;

/**
 * Módulo de Historial de Navegación (Back/Forward)
 * Implementa la funcionalidad de navegador web con pilas
 * 
 * Utiliza dos pilas:
 * - pilaAtras: Almacena las páginas visitadas anteriormente
 * - pilaAdelante: Almacena las páginas cuando se navega hacia atrás
 */
public class HistorialNavegacion {
    private final Stack<String> pilaAtras;      // Pila para el historial hacia atrás
    private final Stack<String> pilaAdelante;   // Pila para el historial hacia adelante
    private String paginaActual;          // Página actual que está siendo vista

    /**
     * Constructor del historial de navegación
     */
    public HistorialNavegacion() {
        this.pilaAtras = new Stack<>();
        this.pilaAdelante = new Stack<>();
        this.paginaActual = null;
    }

    /**
     * HU-01 y HU-03: Visita una URL nueva
     * Si hay una página actual, la guarda en la pila de atrás
     * Limpia la pila de adelante cuando se visita una URL nueva
     * @param url URL a visitar
     */
    public void visitarURL(String url) {
        if (paginaActual != null) {
            pilaAtras.push(paginaActual);
        }
        paginaActual = url;
        // HU-03: Limpiar la pila de adelante al visitar una URL nueva
        pilaAdelante.clear();
        System.out.println("Visitando: " + url);
    }

    /**
     * HU-01: Regresar a la página anterior
     * @return true si se pudo retroceder, false si no hay historial
     */
    public boolean irAtras() {
        if (pilaAtras.isEmpty()) {
            System.out.println("No hay páginas anteriores");
            return false;
        }

        // Guardar página actual en pila de adelante
        pilaAdelante.push(paginaActual);

        // Recuperar página anterior
        paginaActual = pilaAtras.pop();
        System.out.println("Atrás -> Ahora en: " + paginaActual);
        return true;
    }

    /**
     * HU-02: Avanzar a la página siguiente (después de haber retrocedido)
     * @return true si se pudo avanzar, false si no hay historial adelante
     */
    public boolean irAdelante() {
        if (pilaAdelante.isEmpty()) {
            System.out.println("No hay páginas hacia adelante");
            return false;
        }

        // Guardar página actual en pila de atrás
        pilaAtras.push(paginaActual);

        // Recuperar página siguiente
        paginaActual = pilaAdelante.pop();
        System.out.println("Adelante -> Ahora en: " + paginaActual);
        return true;
    }

    /**
     * Obtiene la página actual
     * @return URL de la página actual
     */
    public String getPaginaActual() {
        return paginaActual;
    }

    /**
     * Muestra el estado actual del navegador
     */
    public void mostrarEstado() {
        System.out.println("\n=== Estado del Navegador ===");
        System.out.println("Página actual: " + paginaActual);
        System.out.println("Historial Atrás: " + pilaAtras);
        System.out.println("Historial Adelante: " + pilaAdelante);
        System.out.println("===========================\n");
    }
}
