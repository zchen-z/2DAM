import os
from cryptography.fernet import Fernet

nombre_archivo = "documento.txt"
mensaje_original = "Este es un mensaje"

with open(nombre_archivo, "w", encoding="utf-8") as f:
    f.write(mensaje_original)

print(f"Texto original: {mensaje_original}\n")

clave = Fernet.generate_key()
fernet = Fernet(clave)

with open(nombre_archivo, "rb") as archivo:
    datos_originales = archivo.read()

datos_cifrados = fernet.encrypt(datos_originales)

with open(nombre_archivo, "wb") as archivo:
    archivo.write(datos_cifrados)

print(f"Contenido cifrado: {datos_cifrados}\n")

with open(nombre_archivo, "rb") as archivo:
    contenido_cifrado_leido = archivo.read()

datos_descifrados = fernet.decrypt(contenido_cifrado_leido)

with open(nombre_archivo, "wb") as archivo:
    archivo.write(datos_descifrados)

with open(nombre_archivo, "r", encoding="utf-8") as f:
    texto_final = f.read()

print(f"Texto restaurado: {texto_final}")

