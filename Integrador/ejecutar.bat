@echo off
echo ========================================
echo  Sistema de Gestion de Biblioteca
echo  Con PostgreSQL en Render.com
echo ========================================
echo.

REM Verificar si existe el driver PostgreSQL (acepta cualquier version 42.7.x)
SET POSTGRES_JAR=
for %%f in (postgresql-42.7.*.jar) do SET POSTGRES_JAR=%%f

if "%POSTGRES_JAR%"=="" (
    echo ADVERTENCIA: No se encontro el driver PostgreSQL ^(postgresql-42.7.*.jar^)
    echo.
    echo La aplicacion funcionara SIN persistencia ^(solo en memoria^).
    echo Para activar la base de datos PostgreSQL:
    echo   1. Descarga el driver desde:
    echo      https://jdbc.postgresql.org/download/
    echo      ^(Cualquier version 42.7.x funciona: 42.7.1, 42.7.8, etc.^)
    echo   2. Copia el archivo JAR a esta carpeta
    echo   3. Lee GUIA_POSTGRESQL_RENDER.md para mas informacion
    echo.
    SET CLASSPATH=.
) else (
    echo Driver PostgreSQL encontrado: %POSTGRES_JAR%
    SET CLASSPATH=.;%POSTGRES_JAR%
)

echo.
echo Compilando archivos...
javac -cp "%CLASSPATH%" *.java

if %errorlevel% neq 0 (
    echo.
    echo ERROR: No se pudo compilar el proyecto
    pause
    exit /b 1
)

echo.
echo Compilacion exitosa!
echo Iniciando aplicacion...
echo.
java -cp "%CLASSPATH%" BibliotecaGUI

