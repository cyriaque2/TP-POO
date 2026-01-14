@echo off
set PROJECT_DIR=tp3-safelogistic-project
set BIN_DIR=%PROJECT_DIR%\bin
set SRC_DIR=%PROJECT_DIR%\src

echo --- Compilation de SafeLogistic depuis TP-POO ---
if not exist %BIN_DIR% mkdir %BIN_DIR%

:: Recherche tous les fichiers .java dans le sous-dossier src
dir /s /b %SRC_DIR%\*.java > sources.txt
javac -d %BIN_DIR% @sources.txt
del sources.txt

echo --- Lancement de l'application ---
:: On pointe le classpath vers le dossier bin du sous-projet
java -cp %BIN_DIR% fr.univlemans.safelogistic.Main
pause