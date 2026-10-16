// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaCodec f4044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e2.n1 f4045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4047e;

    public final void a() {
        int iB = b();
        e2.n1 n1Var = this.f4045c;
        if (n1Var == null || this.f4046d == iB) {
            return;
        }
        this.f4046d = iB;
        try {
            try {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("video-bitrate", iB);
                    ((MediaCodec) n1Var.f905c).setParameters(bundle);
                    this.f4047e = iB;
                    c(iB);
                    try {
                        e2.n1 n1Var2 = this.f4045c;
                        n1Var2.getClass();
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("request-sync", 0);
                        ((MediaCodec) n1Var2.f905c).setParameters(bundle2);
                    } catch (IllegalStateException e3) {
                        m0.m("requestSyncFrame", iB, e3);
                    } catch (Throwable th) {
                        m0.m("requestSyncFrame", iB, th);
                    }
                } catch (Throwable th2) {
                    m0.m("setParameters", iB, th2);
                }
            } catch (IllegalStateException e4) {
                m0.m("setParameters", iB, e4);
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized int b() {
        return this.f4043a ? 1500000 : 500000;
    }

    public final void c(int i3) {
        try {
            Log.i("ScreenMirror", "H.264 bitrate applied=" + i3 + "bps");
        } catch (Throwable unused) {
        }
    }
}
