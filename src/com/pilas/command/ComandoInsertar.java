package com.pilas.command;

import com.pilas.editor.EditorTexto;

/**
 * Comando para insertar texto en el editor
 * Implementa el patrón Command para permitir deshacer/rehacer
 */
public class ComandoInsertar implements Comando {
    private final EditorTexto editor;
    private final String texto;
    private final int posicion;

    /**
     * Constructor del comando de inserción
     * @param editor Editor de texto donde se insertará
     * @param texto Texto a insertar
     * @param posicion Posición donde insertar el texto
     */
    public ComandoInsertar(EditorTexto editor, String texto, int posicion) {
        this.editor = editor;
        this.texto = texto;
        this.posicion = posicion;
    }

    @Override
    public void ejecutar() {
        editor.insertar(texto, posicion);
    }

    @Override
    public void deshacer() {
        editor.borrar(posicion, texto.length());
    }

    @Override
    public String getDescripcion() {
        return "Insertar: '" + texto + "' en posición " + posicion;
    }
}
