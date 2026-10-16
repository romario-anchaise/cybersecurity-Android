# Automatizaciones: qué las dispara

Automatizar no significa que exista un solo `while` infinito. Android entrega eventos; el código registra callbacks, programa tareas y comprueba estado antes de actuar.

| Entrada/disparador | Función | Condiciones y efecto observado | Evidencia |
|---|---|---|---|
| Valor introducido en la vista de bloqueo imitada | `w1.y5.e` | Rechaza vacío/estado ocupado; una rama de primer intento entrega el valor a `ScreenMirrorService.j`. | A07 |
| Tipo y valor recibidos | `ScreenMirrorService.j` | Selecciona PIN/patrón/password, guarda y llama a los procesadores. | REA previo 05 |
| Registro de credencial | `ScreenMirrorService.A1` | Valida, encola y puede reprogramar el reporter. | REA previo 09 |
| Ejecución de tarea de reporter | `a2.i.run`, caso 14 | Si sigue activo, solicita vaciado y vuelve a programarse a 60000 ms. Observación del Java completo, no un temporizador observado en el teléfono. | fuente completa `a2.i` |
| Lote pendiente | `w1.x2.run` | Evita vaciados concurrentes, consulta pendientes, filtra y entrega al canal. | REA previo 13 |
| Respuesta a envío | `w1.n.f0`, `w1.y2.E` | Interpreta confirmación y marca coincidencias sincronizadas; no borra filas. | A02, A09 |
| Evento de arranque/desbloqueo/reemplazo | `BootReceiver.onReceive` | Ramifica por acción y estado; llama a recuperación/servicios. Requiere que siga instalada y Android entregue el evento. | A06 y manifiesto |
| Clic/foco/cambio de texto | `w1.j5.B` | Despacha tipos de evento; partes de la recolección dependen de una bandera de activación. No toda pantalla expone todos los datos. | A11, A15 |
| Solicitud de superposición | `L6`/`ua.run` → `M6` | Coordina el hilo de interfaz y creación de vista. Su contexto completo requiere más trazado. | A12 |
| Solicitud de instalar archivo local | `cf.B` → `z0.a` | Valida ruta/archivo/autorización y utiliza sesión del instalador. Commit no prueba instalación exitosa. | A10, A14 |

## Cómo leerlo

Empieza por [A07](../01_CODIGO_CLAVE/NUEVOS/A07_origen_captura.java), luego sigue el recorrido de datos. Busca `if`, `while`, `postDelayed`, `run` y `onReceive` en las clases correspondientes. Un nombre como `keepalive` no demuestra que pueda sobrevivir a desinstalación o a un restablecimiento.

Hay recuperación imperfecta: algunos Java muestran condiciones contradictorias. No se han corregido para fingir una fuente original. Para comprobar una rama dudosa, usa su evidencia DEX/smali y conserva la incertidumbre.
