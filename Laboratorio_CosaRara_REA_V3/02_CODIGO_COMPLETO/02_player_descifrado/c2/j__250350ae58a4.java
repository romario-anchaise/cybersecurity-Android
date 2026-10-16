// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import e2.h0;
import e2.i0;
import e2.j0;
import e2.k0;
import e2.l0;
import e2.m1;
import e2.v1;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.keepalive.ConnectionRecoveryReceiver;
import w1.cc;
import w1.f9;
import w1.rd;
import w1.sd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f430c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Serializable f432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f435h;

    public /* synthetic */ j(Context context, String str, long j3, int i3, BroadcastReceiver.PendingResult pendingResult) {
        this.f434g = context;
        this.f432e = str;
        this.f431d = j3;
        this.f433f = i3;
        this.f435h = pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x018b  */
    @Override // java.lang.Runnable
    public final void run() {
        char c3;
        boolean z2;
        v1 v1Var;
        boolean zI;
        boolean z3;
        switch (this.f430c) {
            case 0:
                Context context = this.f434g;
                String str = (String) this.f432e;
                long j3 = this.f431d;
                int i3 = this.f433f;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f435h;
                ThreadPoolExecutor threadPoolExecutor = ConnectionRecoveryReceiver.f2631a;
                try {
                    p.q(context, str, j3, i3);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 1:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f434g;
                long j4 = this.f431d;
                String str2 = (String) this.f432e;
                int i4 = this.f433f;
                Intent intent = (Intent) this.f435h;
                rd rdVar = ScreenMirrorService.n6;
                try {
                    f9 f9Var = new f9(str2, j4);
                    d2.t tVar = screenMirrorService.e4;
                    synchronized (tVar) {
                        if (j4 == tVar.f612c) {
                            if (((LinkedHashSet) tVar.f614e).contains(f9Var)) {
                                c3 = 3;
                            } else {
                                LinkedHashSet linkedHashSet = (LinkedHashSet) tVar.f614e;
                                linkedHashSet.add(f9Var);
                                while (linkedHashSet.size() > 128) {
                                    Iterator it = linkedHashSet.iterator();
                                    it.next();
                                    it.remove();
                                }
                                if (f9Var.equals((f9) tVar.f613d)) {
                                    tVar.f613d = null;
                                    c3 = 1;
                                }
                            }
                        }
                        c3 = 2;
                    }
                    if (c3 == 3) {
                        return;
                    }
                    if (c3 == 2) {
                        if (i4 != -1 || intent == null) {
                            return;
                        }
                        screenMirrorService.I5(intent, i4);
                        return;
                    }
                    g2.m mVar = screenMirrorService.f4;
                    if (mVar != null) {
                        (screenMirrorService.T3 != null ? screenMirrorService.T3 : new Handler(Looper.getMainLooper())).removeCallbacks(mVar);
                    }
                    screenMirrorService.f4 = null;
                    w1.n.D0(screenMirrorService, false, -1L, "", SystemClock.elapsedRealtime());
                    m1 m1Var = screenMirrorService.b4;
                    if (i4 != -1 || intent == null) {
                        if (m1Var != null) {
                            m1Var.g(j4, str2, l0.f852e);
                            return;
                        }
                        return;
                    }
                    if (!screenMirrorService.P7()) {
                        if (m1Var != null) {
                            m1Var.g(j4, str2, l0.f852e);
                            return;
                        }
                        return;
                    }
                    if (m1Var != null) {
                        Intent intent2 = new Intent(intent);
                        synchronized (m1Var) {
                            if (!m1Var.n && j4 == m1Var.f875f && str2.equals(m1Var.f887s) && m1Var.f883o == j0.f829f && m1Var.f888t == k0.f842e) {
                                m1Var.f888t = k0.f843f;
                                m1Var.f889u = l0.f851d;
                                m1Var.f890v = i0.f819d;
                                m1Var.f892x = h0.f813d;
                                v1Var = m1Var.f876g;
                            } else {
                                v1Var = null;
                            }
                            break;
                        }
                        if (v1Var == null) {
                            zI = false;
                        } else {
                            m1Var.j();
                            m1Var.f873d.f3821a.N2();
                            zI = m1Var.f870a.i(v1Var.f1051a, intent2);
                            if (!zI) {
                                synchronized (m1Var) {
                                    if (m1Var.f875f == j4 && q1.e.a(m1Var.f887s, str2)) {
                                        m1Var.f888t = k0.f844g;
                                        m1Var.f889u = l0.f856i;
                                        m1Var.f892x = null;
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    m1Var.j();
                                }
                            }
                        }
                        if (zI) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    screenMirrorService.I5(intent, i4);
                    return;
                } catch (IllegalArgumentException unused) {
                    if (i4 != -1 || intent == null) {
                        return;
                    }
                    screenMirrorService.I5(intent, i4);
                    return;
                }
            case 2:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) this.f434g;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f432e;
                long j5 = this.f431d;
                IntConsumer intConsumer = (IntConsumer) this.f435h;
                int i5 = this.f433f;
                rd rdVar2 = ScreenMirrorService.n6;
                if (atomicBoolean.compareAndSet(false, true)) {
                    screenMirrorService2.B2.incrementAndGet();
                    screenMirrorService2.d3(j5, intConsumer, i5, screenMirrorService2.o4(false));
                    return;
                }
                return;
            default:
                ScreenMirrorService screenMirrorService3 = (ScreenMirrorService) this.f434g;
                long j6 = this.f431d;
                float[] fArr = (float[]) this.f432e;
                float[] fArr2 = (float[]) this.f435h;
                int i6 = this.f433f;
                rd rdVar3 = ScreenMirrorService.n6;
                String str3 = "dots";
                Handler handler = screenMirrorService3.f2541t;
                if (handler == null || fArr.length < 2 || fArr.length != fArr2.length) {
                    return;
                }
                handler.post(new cc(screenMirrorService3, fArr, fArr2, 1400, str3, i6, j6));
                return;
        }
    }

    public /* synthetic */ j(ScreenMirrorService screenMirrorService, long j3, String str, int i3, Intent intent) {
        this.f434g = screenMirrorService;
        this.f431d = j3;
        this.f432e = str;
        this.f433f = i3;
        this.f435h = intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ j(ScreenMirrorService screenMirrorService, long j3, float[] fArr, float[] fArr2, sd sdVar, int i3) {
        this.f434g = screenMirrorService;
        this.f431d = j3;
        this.f432e = fArr;
        this.f435h = fArr2;
        this.f433f = i3;
    }

    public /* synthetic */ j(ScreenMirrorService screenMirrorService, AtomicBoolean atomicBoolean, long j3, IntConsumer intConsumer, int i3) {
        this.f434g = screenMirrorService;
        this.f432e = atomicBoolean;
        this.f431d = j3;
        this.f435h = intConsumer;
        this.f433f = i3;
    }
}
