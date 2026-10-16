// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Escribe bytes al flujo del canal cuando el estado lo permite y procesa una respuesta.
// ev_1e5cf5a4cd8ad634713c68fac68eb849964eba32aad69376879d63c566fc64ec
// {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.cf', 'method_name': 'x0'}

/* JADX WARN: Code duplicated, block: B:45:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
public final String x0(String str) throws Throwable {
    g2.d0 d0VarW;
    g2.d0 d0Var = null;
    if (Q(str)) {
        g2.a0 a0Var = this.f3727s0;
        int i3 = this.f3708i.get();
        if (a0Var != null && M(i3, a0Var, this.f3708i.get(), this.f3727s0, this.f3694b.get())) {
            try {
                d0VarW = a0Var.w();
                try {
                    try {
                        d0VarW.f1578k.write(str.concat("\n").getBytes(StandardCharsets.UTF_8));
                        d0VarW.f1578k.flush();
                        String strG0 = g0(d0VarW);
                        try {
                            d0VarW.close();
                            return strG0;
                        } catch (IOException e3) {
                            a0.a.m(e3, new StringBuilder("meta exchange stream close failed: "), "TunnelManager");
                            return strG0;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        Log.w("TunnelManager", "meta exchange failed: " + e.getMessage());
                        if (d0VarW != null) {
                            try {
                                d0VarW.close();
                            } catch (IOException e5) {
                                a0.a.m(e5, new StringBuilder("meta exchange stream close failed: "), "TunnelManager");
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    d0Var = d0VarW;
                    if (d0Var != null) {
                        try {
                            d0Var.close();
                        } catch (IOException e6) {
                            a0.a.m(e6, new StringBuilder("meta exchange stream close failed: "), "TunnelManager");
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                d0VarW = null;
            } catch (Throwable th2) {
                th = th2;
                if (d0Var != null) {
                    d0Var.close();
                }
                throw th;
            }
        }
    }
    return null;
}
