# 2º DAM · Ejercicios y prácticas

Código de los ejercicios y prácticas de **2º de Desarrollo de Aplicaciones Multiplataforma** (curso 2026/27).

## Módulos

| Carpeta | Módulo | Tecnologías |
|---|---|---|
| [`ACD_JAVA`](ACD_JAVA) | Acceso a Datos | Java · NIO · JSON (Gson, Jackson, org.json) · Maven |
| [`PSP_JAVA`](PSP_JAVA) | Programación de Servicios y Procesos | Java · procesos (`ProcessBuilder`) |
| [`PMDM_C#`](PMDM_C%23) | Programación Multimedia y Dispositivos Móviles | C# · .NET |
| [`cybersec2627`](cybersec2627) | Ciberseguridad | Python · cifrado simétrico/asimétrico · hashes · firma digital |

## Cómo ejecutar

- **Java (Maven):** `mvn compile exec:java` en la carpeta que contiene `pom.xml`, o ábrelo en VS Code / IntelliJ.
- **Java (ficheros sueltos):** `java Ejercicio1.java`
- **C#:** `dotnet run` en la carpeta del `.csproj`.
- **Python:** `python -m venv .venv`, activa el entorno, `pip install cryptography` y ejecuta el script.
