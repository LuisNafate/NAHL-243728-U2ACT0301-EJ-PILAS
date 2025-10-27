# Script de compilacion y ejecucion para Windows PowerShell

Write-Host "===============================================" -ForegroundColor Cyan
Write-Host "  PROYECTO: Ejemplos de Pilas" -ForegroundColor Cyan
Write-Host "===============================================" -ForegroundColor Cyan
Write-Host ""

# Limpiar archivos compilados anteriores
Write-Host "Limpiando archivos compilados anteriores..." -ForegroundColor Yellow
Get-ChildItem -Path src -Include *.class -Recurse | Remove-Item -Force -ErrorAction SilentlyContinue

# Compilar el proyecto
Write-Host "Compilando el proyecto..." -ForegroundColor Yellow
Push-Location src
javac com\pilas\*.java com\pilas\command\*.java com\pilas\editor\*.java com\pilas\navegacion\*.java

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilacion exitosa!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Ejecutando el programa..." -ForegroundColor Yellow
    Write-Host "===============================================" -ForegroundColor Cyan
    Write-Host ""
    
    # Ejecutar el programa
    java com.pilas.Main
    
    Write-Host ""
    Write-Host "===============================================" -ForegroundColor Cyan
    Write-Host "Ejecucion completada!" -ForegroundColor Green
} else {
    Write-Host "Error en la compilacion" -ForegroundColor Red
}

Pop-Location
