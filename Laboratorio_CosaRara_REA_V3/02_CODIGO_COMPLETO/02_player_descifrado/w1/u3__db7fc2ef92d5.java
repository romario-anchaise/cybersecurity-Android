// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u3 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f5223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5226h;

    public /* synthetic */ u3(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i3) {
        this.f5221c = i3;
        this.f5222d = obj;
        this.f5223e = obj2;
        this.f5224f = obj3;
        this.f5225g = obj4;
        this.f5226h = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5221c) {
            case 0:
                w3 w3Var = (w3) this.f5222d;
                InputStream inputStream = (InputStream) this.f5223e;
                OutputStream outputStream = (OutputStream) this.f5224f;
                String str = (String) this.f5225g;
                se seVar = (se) this.f5226h;
                w3Var.getClass();
                try {
                    w3Var.k(new DataInputStream(inputStream), new DataOutputStream(outputStream), str);
                    try {
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                } finally {
                    try {
                        seVar.run();
                        break;
                    } catch (Throwable th2) {
                        a0.a.p(th2, a0.a.k("onClose (", str, ") failed: "), "MirrorFileSrv");
                    }
                }
            case 1:
                fc fcVar = (fc) this.f5222d;
                AtomicReference atomicReference = (AtomicReference) this.f5223e;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f5224f;
                p5 p5Var = (p5) this.f5225g;
                e2.r rVar = (e2.r) this.f5226h;
                atomicReference.set(null);
                if (atomicBoolean.get()) {
                    int iE = p5Var.e();
                    if (iE != 2) {
                        if (iE == 3) {
                            Log.w("MirrorScreenshotPerf", "stage=watchdog source=rtc physicalRequest=callback_active_held");
                            return;
                        }
                        return;
                    }
                    Log.w("MirrorScreenshotPerf", "stage=watchdog source=rtc physicalRequest=callback_missing_recovered");
                    if (atomicBoolean.compareAndSet(true, false)) {
                        try {
                            if (!fcVar.f4034a.get()) {
                                rVar.a(1000L);
                                break;
                            }
                            return;
                        } finally {
                            fcVar.c();
                        }
                    }
                    return;
                }
                return;
            default:
                sd sdVar = (sd) this.f5222d;
                InputStream inputStream2 = (InputStream) this.f5223e;
                OutputStream outputStream2 = (OutputStream) this.f5224f;
                String str2 = (String) this.f5225g;
                se seVar2 = (se) this.f5226h;
                sdVar.getClass();
                try {
                    sdVar.d(new DataInputStream(inputStream2), new DataOutputStream(outputStream2), str2);
                    try {
                        return;
                    } catch (Throwable th3) {
                        return;
                    }
                } finally {
                    try {
                        seVar2.run();
                        break;
                    } catch (Throwable th4) {
                        a0.a.p(th4, a0.a.k("onClose (", str2, ") failed: "), "MirrorSmsSrv");
                    }
                }
        }
    }
}
