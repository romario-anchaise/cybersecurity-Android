// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p013i.n;
import p013i.p;

/* JADX INFO: loaded from: classes.dex */
public final class O0 extends I0 implements J0 {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final Method f3093C;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public C0005e f3094B;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f3093C = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // p015j.J0
    public final void h(n nVar, p pVar) {
        C0005e c0005e = this.f3094B;
        if (c0005e != null) {
            c0005e.h(nVar, pVar);
        }
    }

    @Override // p015j.J0
    public final void n(n nVar, p pVar) {
        C0005e c0005e = this.f3094B;
        if (c0005e != null) {
            c0005e.n(nVar, pVar);
        }
    }

    @Override // p015j.I0
    public final C0178w0 q(Context context, boolean z2) {
        N0 n2 = new N0(context, z2);
        n2.setHoverListener(this);
        return n2;
    }
}
