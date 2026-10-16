> Nota: revisión auxiliar con rutas y líneas de la exportación anterior. Las evidencias A10/A14/A15 de la nueva pasada prevalecen cuando resuelven una duda. No es fuente original.

# Red y salida de datos — revisión estática

Alcance: lectura de Java aproximado ya recuperado por JADX y evidencia previa de REA. No se ejecutó el APK, no se contactaron servidores ni se reparó/recompiló código. Las líneas citadas pertenecen a los archivos `.java.txt` originales, incluida su cabecera, bajo `outputs/Ampliacion_REA/Java_JADX_verificado/`.

## Configuración y conexión

- **Observado:** `01_instalador/apk/builder/target/Profile__93af071c4452.java.txt`, `Profile.decode`, líneas 18–23, transforma arrays de bytes mediante XOR. `value`, líneas 43–44, 71–76, contiene GATEWAY_URL, TELEMETRY_URL y HOME_URL codificados. El informe previo identifica `moregold[.]co/tunnel`, `moregold[.]co/api/telemetry/install` y `app[.]dicktok[.]vip`; esos indicadores se heredan de aquella extracción, sin volver a verificarlos en la red.
- **Observado:** `02_player_descifrado/w1/cf__b3b0d46ce06c.java.txt`, `cf.o0`, líneas 3163–3185, obtiene `gatewayUrl` mediante `c2.u.n` y lo valida. No depende solamente de una cadena literal en el archivo Java. `w1/a4__427758b79103.java.txt`, `a4.a`, líneas 16–65, exige esquema WSS, sin credenciales en la URL ni fragmento y con validaciones del host.
- **Observado:** `cf.G0`, líneas 1320–1446, usa estado de red y número de generación para establecer cliente de control Socket.IO; crea `g2.a0` y programa una tarea periódica de un segundo (línea 1434). Esto no prueba que la conexión se estableciera en el móvil del usuario.
- **Observado:** `g2/a0__364d7ea62176.java.txt`, `a0.x`, líneas 7409–7431, configura `/socket.io/`, transporte `websocket` y atributo de rol `device`. La ruta configurada del gateway y la ruta interna de Socket.IO son conceptos distintos; no se ha demostrado el URL HTTP final en ejecución.

## Registro y categorías del protocolo

En `g2.a0` (constructor y callbacks descompilados), líneas 285–342, se forma `device:register` con `deviceId`, huella `androidId`/fabricante/modelo, versión, identificadores de compilación y capacidades. La rama opcional `controlResume` incluye prueba de continuidad y sesión previa. Son datos programados para registro, no una captura observada.

El constructor registra callbacks `device:registered` (2546), `heartbeat:ack` (3682), `stream:open` (4250), `stream:data` (4818), `stream:close` (5386), `server:busy` (5954) y `media:demand` (6522). Su Java repite enormes bloques de callbacks: no deben interpretarse las repeticiones como múltiples envíos independientes. Falta cotejar todas esas ramas con DEX antes de afirmar cobertura exhaustiva.

Otros productores previstos aparecen en `cf`: WebP (2359–2370), nodos de interfaz (2373–2381, evento `nodes:packet` en 4322), cámara (2531–2584) y H264 (2617–2687). La conexión depende de medios/servicios registrados y condiciones de estado. La existencia del productor no demuestra que cámara o video fueran transmitidos.

## Flujo de credenciales: observación concreta

1. `w1/y2__e5762d984f19.java.txt`, `y2.A`, líneas 54–70, guarda una entrada en SQLite con `id`, `secret`, `mode`, `provenance`, `captured_at_ms`, `sync_state=0`.
2. `y2.D`, líneas 130–157, consulta `commitments` pendientes, ordenadas de antiguas a nuevas, máximo 20. No es solamente la lista histórica de 50 registros de `y2.w`.
3. `w1/x2__3aacf808cdb0.java.txt`, `x2.run`, líneas 35–124, filtra registros, serializa y los entrega a `cf.x0`.
4. `w1/n__7ff050a74939.java.txt`, `n.s`, líneas 2402–2444, codifica hasta 20 registros con campos `id`, `secret`, `mode`, `provenance`, `capturedAtMs` y prefijo `report:credential_batch:`. Rechaza lotes mayores de 16384 bytes.
5. `cf.x0`, líneas 4128–4186, valida tamaño/estado/generación, abre un flujo, escribe una línea UTF-8, hace flush y espera respuesta; `cf.g0`, líneas 2699–2724, aplica timeout de cinco segundos.
6. `n.f0`, líneas 1750–1782, interpreta `credential_ack:` con `accepted`, `retryable`, `reason`, `saved`, `ids`.
7. `x2.run`, ramas de ACK, conserva pendientes ante ausencia/respuesta reintentable o fallo de parseo. Los aceptados coincidentes pasan por `y2.E`, líneas 160–182, que **marca sync_state=1; no los borra**. `y2.F`, líneas 185–214, marca rechazo permanente con `sync_state=3` y motivo.

La tarea `a2/i__66219d8325fa.java.txt`, `i.run`, caso 14, líneas 357–364, llama al vaciado y vuelve a programarse a 60000 ms si el reporter sigue activo. `q/t__636a47f812a7.java.txt`, `t.b`, líneas 107–115, entrega el trabajo a un executor. El disparo automático es por callbacks/tareas, no solamente por un bucle continuo.

## Límites e inferencias

**Inferencia respaldada:** existe un diseño de salida persistente de secretos con estados, confirmación y reintentos. **No observado:** tráfico real, ACK reales, datos del dispositivo del usuario, disponibilidad actual de servidores o identidad de responsables. No hay fundamento para afirmar que todos los secretos fueran contraseñas de Google; `mode` y la procedencia deben seguirse hasta cada productor. Tampoco se reconstruye el código del servidor desde el cliente.

El Java es una representación derivada: nombres ofuscados, callbacks duplicados y errores de compilación no se corrigen en esta revisión. Faltan revisión completa de telemetría, resolución del perfil y cobertura de cada canal; no se presenta este mapa como exhaustivo.

**Corrección de una imprecisión anterior:** describir el ACK como «borrar» los registros es incorrecto. `y2.E` solamente actualiza `commitments.sync_state` de 0 a 1 y conserva la fila; `y2.F` cambia el estado a 3 y añade `rejection_reason`. Tampoco debe confundirse el historial limitado a 50 elementos de `y2.w` con el lote de salida: `y2.D` consulta hasta 20 pendientes y `n.s` impone de nuevo el máximo de 20. El temporizador de 60 segundos está en la rama 14 de `a2.i.run`, no dentro de `x2.run`.

## Selectores recomendados para nueva verificación REA

1. `w1.n.s` — serializador, tamaño y campos del lote.
2. `w1.n.f0` — interpretación de confirmaciones.
3. `g2.a0.x` — opciones de Socket.IO, método corto.
4. `w1.cf.o0` — origen efectivo de gatewayUrl.
5. `w1.cf.G0` — activación y control de generación de conexión.
6. `w1.y2.E` — efecto real de una confirmación: marcar sincronizado.

Evitar exportar completo el constructor `g2.a0`: tiene miles de líneas repetidas por descompilación; es preferible inspeccionar callbacks/selectores pequeños o DEX en una revisión posterior.
