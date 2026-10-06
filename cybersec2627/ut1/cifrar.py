from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes, serialization
from pathlib import Path

OAEP = padding.OAEP(mgf=padding.MGF1(hashes.SHA256()), algorithm=hashes.SHA256(), label=None)

publica_luis = serialization.load_pem_public_key(Path("Yo_publica.pem").read_bytes())
cifrado = publica_luis.encrypt(b"Me voy a dormir", OAEP)
Path("mensaje.bin").write_bytes(cifrado)

print("Mensaje cifrado y guardado en mensaje.bin")