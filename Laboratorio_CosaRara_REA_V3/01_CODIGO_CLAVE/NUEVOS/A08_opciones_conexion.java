// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_ec02318774d19050d1a46e63a8db90f3183c13d27b75eef217b0a699325f7b6b
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'g2.a0', 'method_name': 'x'}

public static w0.b x(SocketFactory socketFactory, y.c cVar, y.c cVar2) {
    w0.b bVar = new w0.b();
    bVar.f6099b = "/socket.io/";
    bVar.f6069k = new String[]{"websocket"};
    bVar.f3376s = true;
    bVar.n = false;
    bVar.f3372o = 0;
    bVar.f3375r = Collections.singletonMap("role", "device");
    i2.t tVar = new i2.t();
    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    timeUnit.getClass();
    tVar.f2234w = j2.b.b(0L, timeUnit);
    timeUnit.getClass();
    tVar.f2235x = j2.b.b(0L, timeUnit);
    tVar.f2217e = new d2.o(5, cVar);
    if (socketFactory != null) {
        tVar.a(socketFactory);
    }
    i2.u uVar = new i2.u(tVar);
    bVar.f6107j = uVar;
    bVar.f6106i = new y.e(uVar, cVar2);
    return bVar;
}
