# Resultados y correcciones de esta pasada

Los hashes de los APK originales vuelven a coincidir con el primer análisis. La identidad del código recuperado es estable. Se reutiliza el código completo ya extraído y se añade verificación enfocada de funciones y referencias.

## Mejoras comprobables

- 16 nuevas consultas REA, con su ID de evidencia, selector, hash de sujeto y tipo de representación.
- Nuevo origen de captura seguido desde `w1.y5.e`: recibe un valor de la vista de bloqueo imitada, llama a `ScreenMirrorService.j` en la primera rama y modifica la vista. No es extracción automática de todas las contraseñas guardadas de Google.
- Formato y confirmación de lotes verificados: máximo 20 registros y 16384 bytes. Se distingue del historial de 50.
- Perfil de conexión y resolución de `gatewayUrl` examinados por REA.
- Una llamada al instalador que no aparecía en Java legible quedó confirmada por referencia DEX.
- Se descifró como datos el recurso `76c6854504.enc`: 126 entradas JSON de perfiles de permisos/dispositivos y familias. El inventario consigna nombres, tamaño, hash y secciones; no se ejecutaron esos perfiles.
- Análisis nativo ampliado de ARM64 a las tres variantes incluidas: ARM64, ARM de 32 bits y x86-64. Los cuerpos externos importados no forman parte de las bibliotecas y no se recuperan por descompilación.
- Índice de avisos de descompilación para localizar métodos que no debes interpretar como fuente exacto.

## Correcciones importantes

**Confirmación no equivale a borrar.** `w1.y2.E` actualiza `sync_state=1`; conserva la fila. La descripción anterior de retirar/borrar registros tras un ACK era imprecisa. Evidencia nueva: A09.

**La búsqueda textual no veía una llamada existente.** El Java de `w1.cf.B` era un stub por fallo de descompilación. REA A10 demuestra un `INVOKE_STATIC` desde `cf.B` a `z0.a`, y A14 devuelve el método en smali como fallback. El método usa una ruta de archivo local y comprobaciones de estado/autorización; no se observó una instalación real ni una descarga dentro de ese método. Tampoco se afirma que la autorización solicitada suprima las restricciones de Android.

**Disponible no significa Java exacto.** Para A14 el motor informa `available`, pero la representación es `smali` y `fell_back=true`. Por eso se entrega como smali y no como Java inventado o reparado.

## Cobertura que sigue abierta

Las referencias entrantes acotan productores, no prueban todos los caminos reflejados o dinámicos. REA identifica `w1.aa.a` como llamador de `j5.B`; todavía no se ha verificado cada rama entre todos los eventos de accesibilidad y cada salida. La creación de la superposición tiene referencias desde `L6` y `ua.run`, sin convertir esta observación en prueba de activación en el dispositivo del usuario.

No se han medido conexiones, permisos realmente concedidos, ejecución de tareas ni ACK en el teléfono. Ninguna versión de este laboratorio identifica a los operadores o recupera su servidor.
