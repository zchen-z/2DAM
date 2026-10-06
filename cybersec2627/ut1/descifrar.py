from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes, serialization
from pathlib import Path

OAEP = padding.OAEP(mgf=padding.MGF1(hashes.SHA256()), algorithm=hashes.SHA256(), label=None)

privada_luis = serialization.load_pem_private_key(Path("luis_privada.pem").read_bytes(), password=None)
mensaje = privada_luis.decrypt(Path("mensaje.bin").read_bytes(), OAEP)

print("Luis lee:", mensaje.decode())