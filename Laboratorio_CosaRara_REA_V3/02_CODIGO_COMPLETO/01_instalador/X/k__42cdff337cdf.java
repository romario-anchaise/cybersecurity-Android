// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import R0.h;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f4186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f4187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f4188c;

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        try {
            objCall = this.f4186a.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.f4188c.post(new h(this.f4187b, 6, objCall));
    }
}
