import hashlib

def hash_de_texto(texto : str) -> str:
    return hashlib.sha256(texto.encode("utf-8")).hexdigest()

print(hash_de_texto("hola"))