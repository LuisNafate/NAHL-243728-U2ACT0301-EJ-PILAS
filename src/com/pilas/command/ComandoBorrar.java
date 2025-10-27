package com.pilas.command;

import com.pilas.editor.EditorTexto;

/**
 * Comando para borrar texto del editor
 * Implementa el patrón Command para permitir deshacer/rehacer
 */
public class ComandoBorrar implements Comando {
    private final EditorTexto editor;
    private final String textoEliminado;
    private final int posicion;
    private final int longitud;

    /**
     * Constructor del comando de borrado
     * @param editor Editor de texto donde se borrará
     * @param posicion Posición desde donde borrar
     * @param longitud Cantidad de caracteres a borrar
     */
    public ComandoBorrar(EditorTexto editor, int posicion, int longitud) {
        this.editor = editor;
        this.posicion = posicion;
        this.longitud = longitud;
        // Guardar el texto que se va a eliminar para poder restaurarlo
        this.textoEliminado = editor.obtenerTexto(posicion, longitud);
    }

    @Override
    public void ejecutar() {
        editor.borrar(posicion, longitud);
    }

    @Override
    public void deshacer() {
        editor.insertar(textoEliminado, posicion);
    }

    @Override
    public String getDescripcion() {
        return "Borrar: '" + textoEliminado + "' desde posición " + posicion;
    }
}
