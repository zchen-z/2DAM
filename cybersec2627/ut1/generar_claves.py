from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
from pathlib import Path

privada = rsa.generate_private_key(public_exponent=65537, key_size=2048)

# Guardar la clave PRIVADA (secreta, no se comparte)
Path("luis_privada.pem").write_bytes(privada.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption(),
))

# Guardar la clave PÚBLICA (esta sí se reparte)
Path("Yo_publica.pem").write_bytes(privada.public_key().public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo,
))

print("Creados: luis_privada.pem (secreta) y luis_publica.pem (para repartir)")