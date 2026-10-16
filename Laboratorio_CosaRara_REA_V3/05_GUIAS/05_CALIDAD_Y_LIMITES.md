# Calidad, procedencia y límites

## Qué es cada cosa

- Java de clases completas: reconstrucción previa con la API JADX del mismo JAR auditado que usa REA.
- Métodos nuevos: respuestas de REA 6.5.0 / JADX headless MCP 0.7.1. No se sustituyen nombres ofuscados por nombres inventados.
- A14: fallback **smali**, porque el Java era incompleto. Se preserva el resultado sin repararlo ni transformarlo en una implementación nueva.
- Nativo de las tres arquitecturas: Ghidra 12.1.4 usado directamente. REA de Windows rechazó la biblioteca ELF; no se afirma que el análisis nativo lo produjera REA.
- Recurso cifrado: lectura y descifrado como datos con la lógica identificada en `f2.j`; se entrega inventario analítico de 126 perfiles, no un paquete listo para activar la app.

## Errores conocidos

La exportación JADX anterior contabilizó 8 errores para el instalador y 10 para Player. Esto no implica que solo existan 18 defectos de reconstrucción ni que todos los demás métodos sean compilables. `08_AUDITORIA/AVISOS_DECOMPILACION.json` lista marcadores visibles en los archivos entregados; es una búsqueda de avisos, no una validación completa del lenguaje o del comportamiento.

Se conservaron todos los archivos Java de nivel superior de la exportación anterior, con nombres hash para evitar colisiones en Windows. No se añadió configuración Gradle ni se intentó compilar, instalar o ejecutar el malware.

## Identidad de las muestras

Original Player SHA-256:
`c98ebae4ff74d236b494c90782c91bb1c3d44d462a065a83ab33b75a88f59795`

Original instalador SHA-256:
`165205d8889e8e279d72f571f6ab7d2008247ccf80742a88f1092c6bc2ae1d1f`

El APK de análisis descifrado es un **derivado sin firma**, con sus DEX reemplazados por las clases ya recuperadas. Su hash es distinto y está en las evidencias. No se presenta como si fuera el APK original. Los certificados del paquete son metadatos declarados, no una identidad verificada del autor.

## Límites de esta pasada

No se recuperó el proyecto original ni el servidor. No se verificaron todos los caminos reflejados/dinámicos ni cada orden remota. No se recuperó información del celular y no se midió actividad real. No se ejecutaron muestras ni se contactó infraestructura asociada. Las consultas y herramientas de análisis sí se ejecutaron localmente.

Una versión operativa de la app que conserve captura de credenciales o control remoto no forma parte de este laboratorio. El resultado está diseñado para lectura, trazabilidad y estudio defensivo.
