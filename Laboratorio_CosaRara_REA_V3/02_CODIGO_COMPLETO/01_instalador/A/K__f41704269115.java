// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class K implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f6a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f7b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0024y f8c;

    public K(View view, InterfaceC0024y interfaceC0024y) {
        this.f7b = view;
        this.f8c = interfaceC0024y;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        z0 z0VarC = z0.c(windowInsets, view);
        int i2 = Build.VERSION.SDK_INT;
        InterfaceC0024y interfaceC0024y = this.f8c;
        if (i2 < 30) {
            L.a(windowInsets, this.f7b);
            if (z0VarC.equals(this.f6a)) {
                return interfaceC0024y.b(view, z0VarC).b();
            }
        }
        this.f6a = z0VarC;
        z0 z0VarB = interfaceC0024y.b(view, z0VarC);
        if (i2 >= 30) {
            return z0VarB.b();
        }
        WeakHashMap weakHashMap = X.f14a;
        J.c(view);
        return z0VarB.b();
    }
}
