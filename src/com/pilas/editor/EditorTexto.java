package com.pilas.editor;

/**
 * Clase que representa un editor de texto simple
 * Proporciona operaciones básicas de inserción y borrado
 */
public class EditorTexto {
    private final StringBuilder contenido;

    /**
     * Constructor del editor
     */
    public EditorTexto() {
        this.contenido = new StringBuilder();
    }

    /**
     * Inserta texto en una posición específica
     * @param texto Texto a insertar
     * @param posicion Posición donde insertar
     */
    public void insertar(String texto, int posicion) {
        if (posicion < 0 || posicion > contenido.length()) {
            posicion = contenido.length();
        }
        contenido.insert(posicion, texto);
    }

    /**
     * Borra texto desde una posición
     * @param posicion Posición inicial
     * @param longitud Cantidad de caracteres a borrar
     */
    public void borrar(int posicion, int longitud) {
        if (posicion >= 0 && posicion < contenido.length()) {
            int fin = Math.min(posicion + longitud, contenido.length());
            contenido.delete(posicion, fin);
        }
    }

    /**
     * Obtiene texto desde una posición
     * @param posicion Posición inicial
     * @param longitud Cantidad de caracteres a obtener
     * @return El texto obtenido
     */
    public String obtenerTexto(int posicion, int longitud) {
        if (posicion < 0 || posicion >= contenido.length()) {
            return "";
        }
        int fin = Math.min(posicion + longitud, contenido.length());
        return contenido.substring(posicion, fin);
    }

    /**
     * Obtiene todo el contenido del editor
     * @return Contenido completo
     */
    public String getContenido() {
        return contenido.toString();
    }

    /**
     * Muestra el contenido del editor por consola
     */
    public void mostrarContenido() {
        System.out.println("Contenido del editor: \"" + contenido.toString() + "\"");
    }
}
