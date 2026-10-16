// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_9ab1cb8c0e2cadeca364f250604b1958492f7e3beb6c49fd7f8a94cb50520299
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.cf', 'method_name': 'o0'}

public final String o0() {
    Context context = this.B0;
    if (context == null) {
        String strA = a4.a(this.A0);
        if (strA != null) {
            return strA;
        }
    } else {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String strA2 = a4.a(c2.u.n(context, "gatewayUrl"));
        if (strA2 == null || strA2.isEmpty()) {
            strA2 = this.A0;
        }
        String strA3 = a4.a(strA2);
        if (strA3 != null) {
            return strA3;
        }
    }
    return "";
}
