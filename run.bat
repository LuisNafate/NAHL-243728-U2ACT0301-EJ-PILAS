@echo off
REM Script de compilación y ejecución para Windows CMD

echo ===============================================
echo   PROYECTO: Ejemplos de Pilas
echo ===============================================
echo.

echo Limpiando archivos compilados anteriores...
cd src
del /s /q *.class 2>nul

echo Compilando el proyecto...
javac com\pilas\*.java com\pilas\command\*.java com\pilas\editor\*.java com\pilas\navegacion\*.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilacion exitosa!
    echo.
    echo Ejecutando el programa...
    echo ===============================================
    echo.
    
    java com.pilas.Main
    
    echo.
    echo ===============================================
    echo Ejecucion completada!
) else (
    echo.
    echo Error en la compilacion
)

cd ..
pause
