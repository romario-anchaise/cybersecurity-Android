// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.IdentityHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4025c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ j2 f4028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InputStream f4029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f4031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4033k;

    public /* synthetic */ fb(ScreenMirrorService screenMirrorService, int i3, j2 j2Var, InputStream inputStream, AtomicReference atomicReference, OutputStream outputStream, String str, fb fbVar) {
        this.f4026d = screenMirrorService;
        this.f4027e = i3;
        this.f4028f = j2Var;
        this.f4029g = inputStream;
        this.f4030h = atomicReference;
        this.f4031i = outputStream;
        this.f4032j = str;
        this.f4033k = fbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4025c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f4026d;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f4031i;
                int i3 = this.f4027e;
                AtomicReference atomicReference = this.f4030h;
                InputStream inputStream = this.f4029g;
                j2 j2Var = this.f4028f;
                cf cfVar = (cf) this.f4032j;
                z9 z9Var = (z9) this.f4033k;
                rd rdVar = ScreenMirrorService.n6;
                if (atomicBoolean.compareAndSet(false, true)) {
                    a0.a.o(a0.a.i(i3, "[CtrlLifecycle] stage=close generation=", " reason="), (String) atomicReference.get(), "ScreenMirror");
                    a1.d dVar = screenMirrorService.W;
                    synchronized (dVar) {
                        ((IdentityHashMap) dVar.f42d).remove(inputStream);
                    }
                    if (j2Var != null) {
                        j2Var.f(i3, inputStream);
                    }
                    cfVar.f3702f.execute(new ba(z9Var, atomicReference, 3));
                    return;
                }
                return;
            default:
                ScreenMirrorService screenMirrorService2 = this.f4026d;
                int i4 = this.f4027e;
                j2 j2Var2 = this.f4028f;
                InputStream inputStream2 = this.f4029g;
                AtomicReference atomicReference2 = this.f4030h;
                OutputStream outputStream = (OutputStream) this.f4031i;
                String str = (String) this.f4032j;
                fb fbVar = (fb) this.f4033k;
                AtomicBoolean atomicBoolean2 = screenMirrorService2.f2537s;
                try {
                    try {
                        Log.i("ScreenMirror", "[CtrlLifecycle] stage=open generation=" + i4);
                        gb gbVar = new gb(j2Var2, i4, inputStream2);
                        for (int i5 = 0; i5 < 120 && !atomicBoolean2.get() && gbVar.getAsBoolean(); i5++) {
                            Thread.sleep(250L);
                        }
                        if (atomicBoolean2.get() && gbVar.getAsBoolean()) {
                            screenMirrorService2.t5(inputStream2, outputStream, str, new g2(2, gbVar));
                            while (!atomicReference2.compareAndSet("open", "reader_ended") && atomicReference2.get() == "open") {
                            }
                        } else {
                            while (!atomicReference2.compareAndSet("open", "server_not_running") && atomicReference2.get() == "open") {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            fbVar.run();
                            break;
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    String str2 = "reader_" + e3.getClass().getSimpleName();
                    while (!atomicReference2.compareAndSet("open", str2) && atomicReference2.get() == "open") {
                    }
                    Log.w("ScreenMirror", "[CtrlLifecycle] stage=reader_error generation=" + i4 + " reason=" + ((String) atomicReference2.get()));
                }
                try {
                    fbVar.run();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
        }
    }

    public /* synthetic */ fb(ScreenMirrorService screenMirrorService, AtomicBoolean atomicBoolean, int i3, AtomicReference atomicReference, InputStream inputStream, j2 j2Var, cf cfVar, z9 z9Var) {
        this.f4026d = screenMirrorService;
        this.f4031i = atomicBoolean;
        this.f4027e = i3;
        this.f4030h = atomicReference;
        this.f4029g = inputStream;
        this.f4028f = j2Var;
        this.f4032j = cfVar;
        this.f4033k = z9Var;
    }
}
