// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import A.C0005e;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC0082u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final B f1626i = new B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1628b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f1631e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1629c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1630d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f1632f = new w(this);
    public final H.t g = new H.t(6, this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0005e f1633h = new C0005e(12, this);

    public final void a() {
        int i2 = this.f1628b + 1;
        this.f1628b = i2;
        if (i2 == 1) {
            if (this.f1629c) {
                this.f1632f.f(EnumC0076n.ON_RESUME);
                this.f1629c = false;
            } else {
                Handler handler = this.f1631e;
                F0.i.b(handler);
                handler.removeCallbacks(this.g);
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0082u
    public final AbstractC0078p getLifecycle() {
        return this.f1632f;
    }
}
