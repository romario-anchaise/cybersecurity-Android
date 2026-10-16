# Conexiones previstas por el cliente

No se visitaron los servidores. Esta guía describe configuración y llamadas estáticas, no una conexión establecida en el teléfono.

| Indicador obtenido del perfil de la muestra | Papel previsto |
|---|---|
| `moregold[.]co/tunnel` | Gateway configurado con esquema WSS. |
| `moregold[.]co/api/telemetry/install` | Telemetría de instalación configurada. |
| `app[.]dicktok[.]vip` | URL de portada configurada. |

Estas direcciones vienen de la extracción anterior del perfil interno; no identifican a su titular u operador. Tampoco prueban que todos los datos usen exactamente el mismo canal.

## Resolución y transporte

- A03 (`cf.o0`) consulta `gatewayUrl` en configuración, valida la dirección y contempla un valor alternativo. La configuración efectiva puede depender del estado del cliente.
- A08 (`g2.a0.x`) configura Socket.IO, ruta interna `/socket.io/`, transporte WebSocket y rol de dispositivo. La ruta del gateway y la ruta interna del protocolo son conceptos distintos; no se ha observado la URL final negociada en ejecución.
- El Java completo de `cf.G0` contiene controles de red/generación y crea el cliente de control. El constructor de `g2.a0` incluye registro del dispositivo y callbacks para registro, heartbeat, streams y demanda de medios. Sus grandes bloques duplicados por el descompilador requieren revisión cautelosa.
- El registro previsto puede incluir Android ID, fabricante, modelo, versión y capacidades. Eso no demuestra que los haya enviado el teléfono del usuario.
- `cf.x0` entrega texto al flujo de metadatos, hace flush y lee una respuesta. El serializador y procesador del lote están en A01 y A02.

## Qué falta

No hay código del servidor. La semántica completa de todos los comandos, la configuración dinámica, las conexiones efectivas y sus contenidos siguen sin comprobarse. No se ha realizado ensayo dinámico ni captura de tráfico. Los endpoints se muestran desactivados con `[.]` para que no sean enlaces.
