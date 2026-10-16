// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import A.InterfaceC0013m;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.C;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0077o;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.w;
import f1.d;
import p021m.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends Activity implements InterfaceC0082u, InterfaceC0013m {
    private i mExtraDataMap = new i(0);
    private w mLifecycleRegistry = new w(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !d.l(decorView, keyEvent)) {
            return d.m(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !d.l(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends g> T getExtraData(Class<T> cls) {
        if (this.mExtraDataMap.get(cls) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = E.f1634b;
        C.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        w wVar = this.mLifecycleRegistry;
        wVar.getClass();
        wVar.e("markState");
        EnumC0077o enumC0077o = EnumC0077o.f1683c;
        wVar.e("setCurrentState");
        wVar.g(enumC0077o);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(g gVar) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    public final boolean shouldDumpInternalState(String[] strArr) {
        boolean z2 = false;
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            str.getClass();
            switch (str) {
                case "--translation":
                    if (Build.VERSION.SDK_INT >= 31) {
                        z2 = true;
                        break;
                    }
                    break;
                case "--dump-dumpable":
                case "--list-dumpables":
                    if (Build.VERSION.SDK_INT >= 33) {
                        z2 = true;
                        break;
                    }
                    break;
                case "--contentcapture":
                    if (Build.VERSION.SDK_INT >= 29) {
                        z2 = true;
                        break;
                    }
                    break;
                case "--autofill":
                    if (Build.VERSION.SDK_INT >= 26) {
                        z2 = true;
                        break;
                    }
                    break;
            }
        }
        return !z2;
    }

    @Override // A.InterfaceC0013m
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
