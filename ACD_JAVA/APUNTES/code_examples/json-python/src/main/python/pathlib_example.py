# pathlib es un módulo de la librería estándar de Python que permite trabajar con rutas de archivos y directorios 
# de forma orientada a objetos, más clara y segura que concatenar cadenas.
# # El operador / está redefinido en pathlib para unir directorios y ficheros.
# No significa división, sino concatenación de rutas.
# Métodos útiles:
#       exists() → comprueba si la ruta existe.
#       mkdir(parents=True, exist_ok=True) → crea un directorio (y subdirectorios si no existen).
#       resolve() → devuelve la ruta absoluta.
#       is_file() / is_dir() → comprueba si es fichero o carpeta.


from pathlib import Path

# Carpeta base
carpeta = Path("src/main/data")

# Forma 1: con el operador "/"
ruta1 = carpeta / "alumnos.json"

# Forma 2: con joinpath()
ruta2 = carpeta.joinpath("alumnos.json")

print(ruta1)  # src/main/data/alumnos.json
print(ruta2)  # src/main/data/alumnos.json
