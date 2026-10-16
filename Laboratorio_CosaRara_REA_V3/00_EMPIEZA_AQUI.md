# Laboratorio CosaRara — REA V3

Código recuperado y mapas de análisis. Abre **Abrir_Laboratorio.code-workspace** con VS Code; empieza por esta página. Los Java y C son archivos con sus extensiones reales y finales de línea normalizados. Los registros JSON están en una carpeta separada y con sangría.

## Ruta de lectura

1. [Qué añade esta pasada](05_GUIAS/01_RESULTADOS_Y_CORRECCIONES.md).
2. [Automatizaciones: disparadores y condiciones](05_GUIAS/02_AUTOMATIZACIONES.md).
3. [Del valor introducido al envío](05_GUIAS/03_RECORRIDO_DE_DATOS.md).
4. [Conexiones y protocolo](05_GUIAS/04_CONEXIONES.md).
5. [Código incompleto y límites](05_GUIAS/05_CALIDAD_Y_LIMITES.md).
6. [Inventario de lo descifrado](07_CONFIGURACION_DESCIFRADA/INVENTARIO_126_PERFILES.json).

## Abre Java, no el JSON de evidencia

| Qué quieres ver | Archivo |
|---|---|
| Entrada desde la pantalla que imita un bloqueo | [y5.e](01_CODIGO_CLAVE/NUEVOS/A07_origen_captura.java) |
| Ramas para PIN, patrón y contraseña | [Guardar valores](01_CODIGO_CLAVE/01_Guardar_PIN_patron_password.java) |
| Historial y bucle de 50 entradas | [Historial](01_CODIGO_CLAVE/03_Historial_y_cola.java) |
| Bucle que prepara un lote y sus límites | [Serializador](01_CODIGO_CLAVE/NUEVOS/A01_historial_serializador.java) |
| Escritura al canal | [Transporte](01_CODIGO_CLAVE/05_Escribir_al_canal.java) |
| Qué hace al confirmar recepción | [Marcar sincronizados](01_CODIGO_CLAVE/NUEVOS/A09_marcar_sincronizados.java) |
| Eventos del sistema al arrancar | [BootReceiver](01_CODIGO_CLAVE/NUEVOS/A06_arranque.java) |
| Método cuyo Java no se recuperó | [Smali original del método](01_CODIGO_CLAVE/NUEVOS/A14_instalador_llamador.smali) |

Los archivos de **01_CODIGO_CLAVE** son fragmentos seleccionados para lectura, no clases independientes compilables. En **02_CODIGO_COMPLETO** están las clases completas reconstruidas, sin reparar. **03_NATIVO_ARM64_Y_OTRAS_ABI** contiene pseudocódigo de las tres arquitecturas. **04_EVIDENCIAS_REA** conserva evidencia anterior y 16 consultas nuevas. **06_MANIFIESTOS_RECURSOS** reúne manifiestos, componentes, permisos, certificados y XML.

## Qué no representa

No es el proyecto original ni una reconstrucción lista para compilar. No se han corregido ni vuelto operativas las funciones de captura/control. No contiene APK, DEX ejecutables, bibliotecas nativas ejecutables ni configuración de compilación. Tampoco contiene el servidor ni registros de tu celular. Ver código que podría ejecutarse no demuestra que lo hiciera en tu teléfono.

REA 6.5.0 se utilizó mediante CLI con JADX 0.7.1. Las fuentes completas conservan la exportación previa del mismo motor. Ghidra se usó directamente para las bibliotecas ELF, debido a la limitación de REA en Windows. Se reutilizó evidencia anterior cuando el artefacto era idéntico, sin fingir nuevas extracciones de lo mismo.
