// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import H.C0028c;
import H.s;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0028c f268b;

    public e(KeyListener keyListener) {
        C0028c c0028c = new C0028c(6);
        this.f267a = keyListener;
        this.f268b = c0028c;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i2) {
        this.f267a.clearMetaKeyState(view, editable, i2);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f267a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
        boolean zO;
        boolean z2;
        this.f268b.getClass();
        if (i2 != 67) {
            zO = i2 != 112 ? false : s.o(editable, keyEvent, true);
        } else {
            zO = s.o(editable, keyEvent, false);
        }
        if (zO) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z2 = true;
        } else {
            z2 = false;
        }
        return z2 || this.f267a.onKeyDown(view, editable, i2, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f267a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f267a.onKeyUp(view, editable, i2, keyEvent);
    }
}
