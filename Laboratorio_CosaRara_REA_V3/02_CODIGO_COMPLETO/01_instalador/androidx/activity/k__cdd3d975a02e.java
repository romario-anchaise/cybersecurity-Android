// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import android.window.OnBackInvokedCallback;
import p009f.z;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1253b;

    public /* synthetic */ k(int i2, Object obj) {
        this.f1252a = i2;
        this.f1253b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch (this.f1252a) {
            case 0:
                ((Runnable) this.f1253b).run();
                break;
            default:
                ((z) this.f1253b).E();
                break;
        }
    }
}
