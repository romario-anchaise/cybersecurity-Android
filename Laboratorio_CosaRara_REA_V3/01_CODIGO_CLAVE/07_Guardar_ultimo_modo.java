// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Guarda el nombre del último modo de desbloqueo, no la contraseña.
// ev_bd5696c3733e2d14e7607a7cd4792c5bfc8497cb0a1b60d0ed7dfecf9ed6f9cf
// {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'lyr.stable.runtime.ScreenMirrorService', 'method_name': 'm6'}

public final void m6(String str) {
    if (str == null || str.isEmpty()) {
        return;
    }
    getSharedPreferences("unlock_seq", 0).edit().putString("last_unlock_mode", str).apply();
    Log.i("ScreenMirror", "[Unlock] last mode committed=".concat(str));
}
