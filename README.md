# Proyecto: Ejemplos de Pilas (Stacks) - Estructuras de Datos

**Universidad:** Universidad Politécnica de Chiapas  
**Carrera:** Ingeniería en Tecnologías de la Información y Desarrollo (TIID)  
**Estudiante:** Luis Alberto Nafate Hernández  
**Actividad:** U2ACT0301 - EJ PILAS  
**Grado y Grupo:** 4-B

---

## Resumen Ejecutivo

Este proyecto implementa y demuestra el uso práctico de la estructura de datos **Pila (Stack)** en Java, aplicando el principio LIFO (Last In, First Out) en dos casos de uso del mundo real:

1. **Sistema de Navegación Web** - Implementación de botones Atrás/Adelante
2. **Editor de Texto con Undo/Redo** - Sistema de deshacer/rehacer usando el patrón Command

### Logros del Proyecto

✅ **Implementación Completa** de estructura de datos Pila  
✅ **Patrón de Diseño Command** aplicado correctamente  
✅ **Organización Profesional** con paquetes Java  
✅ **Documentación Exhaustiva** con JavaDoc  
✅ **Casos de Uso Reales** completamente funcionales  
✅ **Código Limpio** siguiendo mejores prácticas de Java

---

## Descripción
Este proyecto demuestra el uso práctico de **Pilas (Stacks)** mediante dos casos de uso reales:
1. **Historial de Navegación Web** (Back/Forward)
2. **Sistema de Deshacer/Rehacer** en un editor de texto (Undo/Redo)

## Estructura del Proyecto

```
src/
└── com/
    └── pilas/
        ├── Main.java                      # Clase principal con demostraciones
        ├── command/                       # Paquete del Patrón Command
        │   ├── Comando.java              # Interfaz del patrón Command
        │   ├── ComandoInsertar.java      # Comando para insertar texto
        │   └── ComandoBorrar.java        # Comando para borrar texto
        ├── editor/                        # Paquete del Editor de Texto
        │   ├── EditorTexto.java          # Editor de texto simple
        │   └── GestorDeshacerRehacer.java # Gestor de Undo/Redo
        └── navegacion/                    # Paquete de Navegación
            └── HistorialNavegacion.java   # Historial de navegador web
```

## Características Principales

### Módulo 1: Historial de Navegación
- **HU-01**: Botón "Atrás" - Regresar a páginas anteriores
- **HU-02**: Botón "Adelante" - Avanzar a páginas siguientes
- **HU-03**: Visitar nueva URL limpia el historial adelante

### Módulo 2: Gestor Deshacer/Rehacer
- **HU-04**: Deshacer (Ctrl+Z) - Revierte la última acción
- **HU-05**: Rehacer (Ctrl+Y) - Rehace la acción deshecha
- **HU-06**: Nueva acción limpia la pila de rehacer

## Patrones de Diseño Utilizados

### Patrón Command
El proyecto implementa el **Patrón Command** para encapsular acciones como objetos, permitiendo:
- Deshacer y rehacer operaciones
- Almacenar historial de comandos
- Separar la invocación de la ejecución

## Compilación y Ejecución

### Método Rápido (Recomendado):
```bash
# Windows CMD
run.bat

# PowerShell
.\run.ps1
```

### Método Manual:
```bash
# Compilar
cd src
javac com\pilas\*.java com\pilas\command\*.java com\pilas\editor\*.java com\pilas\navegacion\*.java

# Ejecutar
cd src
java com.pilas.Main
```

## Tecnologías Utilizadas
- **Java SE** (versión 8 o superior)
- **java.util.Stack** - Implementación de pilas en Java

## Conceptos de Estructuras de Datos

### ¿Qué es una Pila (Stack)?
Una **pila** es una estructura de datos que sigue el principio **LIFO** (Last In, First Out):
- El último elemento en entrar es el primero en salir
- Operaciones principales: `push()` (apilar) y `pop()` (desapilar)

### Casos de Uso en la Vida Real
1. **Historial de Navegación**: Back/Forward en navegadores
2. **Undo/Redo**: Deshacer/Rehacer en editores de texto
3. **Expresiones matemáticas**: Evaluación de notación postfija
4. **Call Stack**: Pila de llamadas en programación

## Mejoras Implementadas

### ✅ Organización del Código
- **Estructura en paquetes** (`com.pilas.*`) siguiendo convenciones de Java
- **Separación de responsabilidades** por módulos:
  - `command`: Implementación del patrón Command
  - `editor`: Lógica del editor de texto y gestor de undo/redo
  - `navegacion`: Sistema de historial de navegación web

### ✅ Calidad del Código
- **Documentación JavaDoc completa** en todas las clases y métodos
- **Uso de `final`** en campos inmutables para mayor seguridad
- **Manejo de casos límite** y validaciones
- **Código compilable sin errores ni warnings**

### ✅ Funcionalidad Implementada

#### Módulo de Navegación Web
- **HU-01**: Botón "Atrás" - Navegar a páginas anteriores usando pila
- **HU-02**: Botón "Adelante" - Avanzar después de retroceder
- **HU-03**: Limpiar historial adelante al visitar nueva URL

#### Módulo Editor de Texto
- **HU-04**: Deshacer (Ctrl+Z) - Revertir última acción usando pila
- **HU-05**: Rehacer (Ctrl+Y) - Rehacer acción deshecha
- **HU-06**: Limpiar pila de rehacer al ejecutar nueva acción

### ✅ Herramientas y Automatización
- Scripts de compilación automatizados (`run.bat`, `run.ps1`)
- Configuración `.gitignore` para archivos Java
- Documentación completa del proyecto

---

## Arquitectura del Proyecto

### Patrón de Diseño: Command Pattern
```
Comando (Interface)
    ↓
    ├── ComandoInsertar (Concrete Command)
    └── ComandoBorrar (Concrete Command)
         ↓
    EditorTexto (Receiver)
         ↓
    GestorDeshacerRehacer (Invoker con Pilas)
```

### Estructura de Datos: Stack (LIFO)
- **Historial de Navegación**: 2 pilas (atrás y adelante)
- **Sistema Undo/Redo**: 2 pilas (deshacer y rehacer)

---

## Características Técnicas

- **Lenguaje:** Java SE 8+
- **Estructura de Datos:** `java.util.Stack<E>`
- **Paradigma:** Programación Orientada a Objetos
- **Patrón:** Command Pattern para operaciones reversibles
- **Organización:** Paquetes modulares
- **Documentación:** JavaDoc estándar

---

## Mejoras Implementadas

✅ **Organización en paquetes** para mejor estructura
✅ **Documentación JavaDoc** en todas las clases
✅ **Uso de `final`** en campos inmutables
✅ **Separación de responsabilidades** por paquetes:
  - `command`: Patrón Command y comandos concretos
  - `editor`: Lógica del editor de texto
  - `navegacion`: Lógica del historial de navegación

## Documentación Adicional

### Documentos Incluidos en el Repositorio:

1. **INFORME_ACTIVIDAD.md** (→ PDF)
   - Informe completo de la actividad
   - Diagramas de clases UML
   - Ejemplos de código detallados
   - Explicación del principio LIFO
   - Referencias bibliográficas

2. **MEJORAS_IMPLEMENTADAS.md**
   - Comparación antes/después
   - Detalle técnico de mejoras
   - Beneficios de la reorganización

3. **GUIA_CONVERTIR_PDF.md**
   - Instrucciones para generar PDF
   - Múltiples métodos explicados

4. **INSTRUCCIONES_GITHUB.md**
   - Guía para subir el proyecto a GitHub
   - Configuración de Git

5. **PROYECTO_COMPLETO.md**
   - Resumen ejecutivo del proyecto
   - Checklist de entrega

---

## Ejecución del Proyecto

### Resultado Esperado:
Al ejecutar el proyecto, se demuestran:
- ✅ Navegación web con pilas (visitar, atrás, adelante)
- ✅ Editor de texto con undo/redo
- ✅ Visualización del estado de las pilas
- ✅ Manejo de casos límite

### Output del Programa:
```
===========================================
EJEMPLOS DE PILAS - ESTRUCTURAS DE DATOS
===========================================

╔════════════════════════════════════════╗
║  MÓDULO 1: HISTORIAL DE NAVEGACIÓN    ║
╚════════════════════════════════════════╝
[Demostración de Back/Forward...]

╔════════════════════════════════════════╗
║  MÓDULO 2: GESTOR DESHACER/REHACER    ║
╚════════════════════════════════════════╝
[Demostración de Undo/Redo...]
```

---

## Contenido del Repositorio

```
U2ACT0301-EJ-PILAS/
├── src/                           # Código fuente
│   └── com/pilas/                # Paquete principal
│       ├── Main.java            # Punto de entrada
│       ├── command/             # Patrón Command
│       ├── editor/              # Sistema de edición
│       └── navegacion/          # Sistema de navegación
├── README.md                      # Este archivo
├── INFORME_ACTIVIDAD.md          # Informe completo (→ PDF)
├── MEJORAS_IMPLEMENTADAS.md      # Documentación técnica
├── run.bat                       # Script Windows CMD
├── run.ps1                       # Script PowerShell
└── .gitignore                    # Configuración Git
```

---

## Aprendizajes Clave

### Conceptos Implementados:
1. **Principio LIFO** - Last In, First Out
2. **Patrón Command** - Encapsulación de operaciones
3. **Gestión de memoria** con pilas
4. **Reversibilidad de operaciones** (Undo/Redo)
5. **Organización modular** de código

### Habilidades Desarrolladas:
- ✅ Implementación de estructuras de datos
- ✅ Aplicación de patrones de diseño
- ✅ Documentación técnica profesional
- ✅ Organización de proyectos Java
- ✅ Control de versiones con Git

---

## Documentación Adicional

- **INFORME_ACTIVIDAD.md**: Informe completo con diagramas de clases y ejemplos de uso
- **MEJORAS_IMPLEMENTADAS.md**: Detalle de todas las mejoras aplicadas al proyecto

---

## Repositorio

**URL:** https://github.com/LuisNafate/NAHL-243728-U2ACT0301-EJ-PILAS

**Repositorio GitHub:** LuisNafate/NAHL-243728-U2ACT0301-EJ-PILAS

---

## Autor

**Luis Alberto Nafate Hernández**  
Estudiante de Ingeniería en Tecnologías de la Información y Desarrollo (TIID)  
Universidad Politécnica de Chiapas  
Grado: 4-B

**Docente:** Elias Beltrán Naturi  
**Materia:** Estructuras de Datos

---

## Fecha

Octubre 2025

---

## Licencia

Proyecto académico - Universidad Politécnica de Chiapas

---

## Agradecimientos

Este proyecto fue desarrollado como parte de la asignatura de Estructuras de Datos, aplicando conocimientos teóricos en casos de uso prácticos del mundo real.
 
 