#!/bin/bash
PROJECT_DIR="tp3-safelogistic-project"
BIN_DIR="$PROJECT_DIR/bin"
SRC_DIR="$PROJECT_DIR/src"

echo "--- Compilation de SafeLogistic depuis TP-POO ---"
mkdir -p "$BIN_DIR"

# Recherche des fichiers sources dans le sous-dossier
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$BIN_DIR" @sources.txt
rm sources.txt

echo "--- Lancement de l'application ---"
# Exécution avec le chemin vers la classe Main
java -cp "$BIN_DIR" fr.univlemans.safelogistic.Main