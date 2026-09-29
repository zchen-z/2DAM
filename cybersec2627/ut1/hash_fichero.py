import hashlib, hmac
from pathlib import Path

def hash_fichero(ruta: Path, algoritmo: str = "sha256") -> str:
    """Hashea leyendo por bloques: funciona igual de bien con 1 KB que con 10 GB."""
    h = hashlib.new(algoritmo)
    with open(ruta, "rb") as f:
        for bloque in iter(lambda: f.read(8192), b""):   # 8 KiB por lectura
            h.update(bloque)
    return h.hexdigest()

def integro(esperado: str, actual: str) -> bool:
    """Comparación en tiempo constante: no filtra información por temporización."""
    return hmac.compare_digest(esperado, actual)