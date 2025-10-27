package com.pilas.command;

/**
 * Interfaz para el patrón Command
 * Representa una acción que puede ser ejecutada y revertida
 * 
 * Este patrón es útil para implementar funcionalidades como:
 * - Deshacer/Rehacer (Undo/Redo)
 * - Historial de comandos
 * - Transacciones
 */
public interface Comando {
    /**
     * Ejecuta el comando
     */
    void ejecutar();
    
    /**
     * Revierte la acción del comando
     */
    void deshacer();
    
    /**
     * Obtiene una descripción del comando
     * @return Descripción textual del comando
     */
    String getDescripcion();
}
