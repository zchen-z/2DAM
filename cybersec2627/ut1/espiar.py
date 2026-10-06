from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import hashes, serialization
from pathlib import Path

OAEP = padding.OAEP(mgf=padding.MGF1(hashes.SHA256()), algorithm=hashes.SHA256(), label=None)
cifrado = Path("mensaje.bin").read_bytes()
publica_luis = serialization.load_pem_public_key(Path("luis_publica.pem").read_bytes())

# 1) Una clave pública ni siquiera tiene método para descifrar
print("¿La pública puede descifrar?:", hasattr(publica_luis, "decrypt"))

# 2) Eva prueba con la única privada que tiene (la suya): falla
privada_eva = rsa.generate_private_key(public_exponent=65537, key_size=2048)
try:
    privada_eva.decrypt(cifrado, OAEP)
    print("Eva ha leído el mensaje (esto NO debería pasar)")
except ValueError:
    print("Eva NO puede leer el mensaje: no tiene la privada de Luis")