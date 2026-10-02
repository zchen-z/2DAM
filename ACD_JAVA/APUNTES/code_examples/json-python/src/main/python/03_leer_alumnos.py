# leer_alumnos.py
# Ejemplo con la librería estándar json de Python.
# Objetivo:
#   - Leer un fichero JSON con una lista de alumnos.
#   - Convertirlo en una lista de diccionarios.
#   - Recorrer y mostrar los datos por consola.

import json
from pathlib import Path

def main():
    # 1. Definir la ruta del fichero JSON
    fichero = Path("src/main/data/alumnos.json")

    # 2. Comprobar si existe antes de leerlo
    if not fichero.exists():
        print("El fichero 'alumnos.json' no existe. Ejecuta primero guardar_alumnos.py")
        return

    # 3. Abrir el fichero en modo lectura
    # json.load(fichero) convierte el contenido del JSON → objeto Python (lista de diccionarios)
    with fichero.open("r", encoding="utf-8") as f:
        alumnos = json.load(f)

    # 4. Recorrer la lista de alumnos y mostrar sus datos
    print("Alumnos leídos desde el fichero:")
    for a in alumnos:
        # Accedemos a los valores por clave como en un diccionario
        nombre = a.get("nombre", "(sin nombre)")
        edad = a.get("edad", "(sin edad)")
        print(f"- {nombre} ({edad} años)")

if __name__ == "__main__":
    main()
