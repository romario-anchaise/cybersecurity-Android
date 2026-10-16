// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.I;
import A.X;
import A.h0;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: f.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0126p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f2512b;

    public /* synthetic */ RunnableC0126p(z zVar, int i2) {
        this.f2511a = i2;
        this.f2512b = zVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        ViewGroup viewGroup;
        z zVar = this.f2512b;
        int i2 = 0;
        switch (this.f2511a) {
            case 0:
                if ((1 & zVar.f2572Z) != 0) {
                    zVar.w(0);
                }
                if ((zVar.f2572Z & 4096) != 0) {
                    zVar.w(108);
                }
                zVar.f2571Y = false;
                zVar.f2572Z = 0;
                break;
            default:
                zVar.f2593w.showAtLocation(zVar.f2592v, 55, 0, 0);
                h0 h0Var = zVar.f2595y;
                if (h0Var != null) {
                    h0Var.b();
                }
                if (zVar.f2596z && (viewGroup = zVar.f2548A) != null) {
                    WeakHashMap weakHashMap = X.f14a;
                    z2 = I.c(viewGroup);
                }
                if (!z2) {
                    zVar.f2592v.setAlpha(1.0f);
                    zVar.f2592v.setVisibility(0);
                } else {
                    zVar.f2592v.setAlpha(0.0f);
                    h0 h0VarA = X.a(zVar.f2592v);
                    h0VarA.a(1.0f);
                    zVar.f2595y = h0VarA;
                    h0VarA.d(new r(i2, this));
                }
                break;
        }
    }
}
