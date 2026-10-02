# basico_en_memoria.py
# Ejemplo básico con la librería estándar 'json' de Python.
# Convierte un diccionario a JSON (cadena) y viceversa, sin tocar ficheros.

import json

def main():
    # Diccionario de ejemplo (equivalente a un objeto Alumno en Java)
    alumno = {
        "nombre": "Ana",
        "edad": 20
    }

    # 1) Python (dict) -> JSON (str)
    # json.dumps() Convierte un objeto Python en una cadena JSON
    # Diferencia con dumps:
    #     json.dump(obj, fichero) → Escribe en un fichero.
    #     json.dumps(obj) → Convierte a una cadena JSON en memoria.
    # indent=4 para formato legible (pretty printing)
    json_str = json.dumps(alumno, indent=4, ensure_ascii=False)
    print("Diccionario a JSON:")
    print(json_str)

    # 2) JSON (str) -> Python (dict)
    # json.load() Lee un fichero JSON y lo convierte en un objeto Python (diccionario o lista)
    # Diferencia con loads:
    #     json.load(fichero) → Lee desde un fichero.
    #     json.loads(cadena) → Lee desde una cadena en memoria.
    alumno2 = json.loads(json_str)
    print("\nJSON a diccionario:")
    print(alumno2)
    print(f"Nombre: {alumno2['nombre']} - Edad: {alumno2['edad']}")

if __name__ == "__main__":
    main()
 