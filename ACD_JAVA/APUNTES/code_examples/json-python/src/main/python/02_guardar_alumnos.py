# guardar_alumnos.py
# Ejemplo con la librería estándar json de Python.
# Objetivo:
#   - Crear una lista de alumnos (cada alumno es un diccionario).
#   - Guardar esa lista en un fichero JSON dentro del directorio "data".

import json
from pathlib import Path #En Python, el módulo pathlib redefine el operador / para unir rutas de forma segura y multiplataforma.

def main():
    # 1. Crear una lista de diccionarios (equivalente a una lista de objetos Alumno en Java)
    alumnos = [
        {"nombre": "Ana", "edad": 20},
        {"nombre": "Luis", "edad": 22},
        {"nombre": "Marta", "edad": 19}
    ]

    # 2. Definir la ruta de la carpeta "data" dentro de src/main
    data_dir = Path("src/main/data")
    # Si la carpeta no existe, se crea automáticamente
    data_dir.mkdir(parents=True, exist_ok=True)

    # 3. Definir el fichero donde se guardarán los alumnos
    fichero = data_dir / "alumnos.json" # linea equivale a fichero = data_dir.joinpath("alumnos.json")

    # 4. Guardar la lista en el fichero JSON
    # json.dump(objeto, fichero) convierte el objeto Python → JSON y lo escribe en el fichero
    # indent=4 para formato legible (pretty printing)
    # ensure_ascii=False para que se vean bien acentos y eñes
    with fichero.open("w", encoding="utf-8") as f:
        json.dump(alumnos, f, indent=4, ensure_ascii=False)

    # 5. Confirmación por consola
    print(f"Fichero creado correctamente en: {fichero.resolve()}")

if __name__ == "__main__":
    main()
