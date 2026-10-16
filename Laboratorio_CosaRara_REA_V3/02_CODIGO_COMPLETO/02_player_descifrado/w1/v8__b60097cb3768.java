// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.PermissionRequestActivity;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.SequentialPermissionActivity;
import lyr.stable.runtime.UnlockActivity;
import lyr.stable.runtime.WakeActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5319d;

    public /* synthetic */ v8(int i3, Object obj) {
        this.f5318c = i3;
        this.f5319d = obj;
    }

    private final void a() {
        d2.y yVar = (d2.y) this.f5319d;
        synchronized (ScreenMirrorService.B6) {
            if (ScreenMirrorService.D6 == yVar) {
                p5 p5Var = ScreenMirrorService.C6;
                nd ndVar = (nd) yVar.f654d;
                synchronized (p5Var) {
                    if (((nd) p5Var.f4805d) == ndVar) {
                        p5Var.f4805d = null;
                    }
                }
                y.c cVar = ScreenMirrorService.H6;
                w wVar = (w) yVar.f651a;
                synchronized (cVar) {
                    if (((w) cVar.f5972d) == wVar) {
                        cVar.f5972d = null;
                    }
                }
                ScreenMirrorService.D6 = null;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i3;
        long j3;
        int i4;
        boolean z2;
        boolean z3;
        y1.a aVarL;
        boolean z4 = true;
        switch (this.f5318c) {
            case 0:
                PermissionRequestActivity permissionRequestActivity = (PermissionRequestActivity) this.f5319d;
                int i5 = PermissionRequestActivity.f2461e;
                try {
                    try {
                        permissionRequestActivity.finishAndRemoveTask();
                        return;
                    } catch (Throwable unused) {
                        permissionRequestActivity.finish();
                        return;
                    }
                } catch (Throwable unused2) {
                    return;
                }
            case 1:
                ta taVar = (ta) this.f5319d;
                rd rdVar = ScreenMirrorService.n6;
                taVar.run();
                return;
            case 2:
                ie ieVar = (ie) this.f5319d;
                rd rdVar2 = ScreenMirrorService.n6;
                ieVar.run();
                return;
            case 3:
                a();
                return;
            case 4:
                ((ExecutorService) this.f5319d).shutdown();
                return;
            case 5:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) ((d2.t) this.f5319d).f614e;
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService.Y();
                screenMirrorService.W();
                Log.w("ScreenMirror", "RTC control stream lost; publisher generation preserved");
                return;
            case 6:
                vc vcVar = (vc) this.f5319d;
                ScreenMirrorService screenMirrorService2 = vcVar.f5333a;
                rd rdVar4 = ScreenMirrorService.n6;
                screenMirrorService2.P6();
                vcVar.f5333a.m4 = null;
                vcVar.f5333a.X6();
                return;
            case 7:
                bd bdVar = (bd) this.f5319d;
                try {
                    bdVar.f3611g = new DataOutputStream(bdVar.f3605a);
                    if (bdVar.b()) {
                        bdVar.f3611g.write(ScreenMirrorService.p6);
                        bdVar.f3611g.write(bdVar.f3615k.g4);
                        bdVar.f3611g.writeInt(bdVar.f3615k.h4);
                        bdVar.f3611g.writeInt(bdVar.f3615k.i4);
                        bdVar.f3611g.flush();
                        if (Arrays.equals(bdVar.f3615k.g4, ScreenMirrorService.q6) && bdVar.f3615k.s4 != null) {
                            byte[] bArr = bdVar.f3615k.s4;
                            bdVar.f3611g.writeInt(bArr.length);
                            bdVar.f3611g.writeLong(0L);
                            bdVar.f3611g.writeInt(2);
                            bdVar.f3611g.write(bArr);
                            bdVar.f3611g.flush();
                        }
                        if (Arrays.equals(bdVar.f3615k.g4, ScreenMirrorService.r6) && bdVar.f3615k.K4 != null) {
                            byte[] bArr2 = bdVar.f3615k.K4;
                            long j4 = bdVar.f3615k.L4;
                            bdVar.f3611g.writeInt(bArr2.length);
                            bdVar.f3611g.writeLong(j4);
                            bdVar.f3611g.writeInt(1);
                            bdVar.f3611g.write(bArr2);
                            bdVar.f3611g.flush();
                        }
                        while (bdVar.f3613i && bdVar.f3615k.f2537s.get() && bdVar.b()) {
                            byte[] bArr3 = (byte[]) bdVar.f3612h.poll(500L, TimeUnit.MILLISECONDS);
                            if (bArr3 != null) {
                                bdVar.f3611g.write(bArr3);
                                bdVar.f3611g.flush();
                            }
                        }
                    }
                    break;
                } catch (Exception unused3) {
                } finally {
                    bdVar.a();
                }
                return;
            case 8:
                SequentialPermissionActivity sequentialPermissionActivity = (SequentialPermissionActivity) this.f5319d;
                AtomicBoolean atomicBoolean = SequentialPermissionActivity.f2565h;
                sequentialPermissionActivity.c();
                return;
            case 9:
                ee eeVar = (ee) this.f5319d;
                synchronized (eeVar.f3928c) {
                    try {
                        eeVar.n = false;
                        if (!eeVar.f3939o && eeVar.f3937l == null) {
                            vd vdVar = (vd) eeVar.f3933h.pollFirst();
                            if (vdVar == null) {
                                return;
                            }
                            eeVar.f3937l = vdVar;
                            eeVar.z(vdVar);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            case 10:
                cf.q((e3) this.f5319d, false);
                return;
            case 11:
                UnlockActivity unlockActivity = (UnlockActivity) this.f5319d;
                int i6 = UnlockActivity.f2573b;
                try {
                    PowerManager.WakeLock wakeLock = unlockActivity.f2574a;
                    if (wakeLock != null && wakeLock.isHeld()) {
                        unlockActivity.f2574a.release();
                    }
                    break;
                } catch (Throwable unused4) {
                }
                try {
                    unlockActivity.finish();
                    unlockActivity.overridePendingTransition(0, 0);
                    return;
                } catch (Throwable unused5) {
                    return;
                }
            case 12:
                sf sfVar = (sf) this.f5319d;
                d8 d8Var = wf.P;
                b8 b8Var = sfVar.f5107i;
                LinkedHashSet linkedHashSet = d8Var.f3799b;
                d8Var.r();
                if (b8Var == null || b8Var.f3582g) {
                    return;
                }
                b8Var.f3582g = true;
                b8Var.f3579d = null;
                b8Var.f3580e = null;
                b8Var.f3581f = null;
                linkedHashSet.remove(b8Var);
                if (b8Var == d8Var.f3803f) {
                    b8Var.f3583h = false;
                    d8Var.f3803f = null;
                }
                if (!linkedHashSet.isEmpty()) {
                    if (d8Var.f3803f == null && d8Var.f3800c == 3) {
                        d8Var.p();
                        return;
                    }
                    return;
                }
                int i7 = d8Var.f3800c;
                if (i7 == 2 && d8Var.f3804g == null) {
                    d8Var.a();
                    d8Var.f3800c = 1;
                    d8Var.y();
                    return;
                } else {
                    if (i7 == 2 || i7 == 3 || i7 == 4 || i7 == 5 || i7 == 6) {
                        d8Var.x();
                        return;
                    }
                    return;
                }
            case 13:
                WakeActivity wakeActivity = (WakeActivity) this.f5319d;
                int i8 = WakeActivity.f2576b;
                try {
                    PowerManager.WakeLock wakeLock2 = wakeActivity.f2577a;
                    if (wakeLock2 != null && wakeLock2.isHeld()) {
                        wakeActivity.f2577a.release();
                    }
                    break;
                } catch (Throwable unused6) {
                }
                try {
                    wakeActivity.finish();
                    wakeActivity.overridePendingTransition(0, 0);
                    return;
                } catch (Throwable unused7) {
                    return;
                }
            case 14:
                x1.i iVar = (x1.i) this.f5319d;
                if (iVar.f5886h) {
                    iVar.f5888j = false;
                    iVar.f5886h = false;
                    x1.x xVar = x1.x.f5960m;
                    iVar.f5880b.x(xVar != null && xVar.h());
                    iVar.f5881c.f6155o = false;
                    Log.w("DefenseOrchestrator", "expected grant launch hold expired before matching page event");
                    return;
                }
                return;
            case 15:
                ((x1.r) this.f5319d).k();
                return;
            case 16:
                Context context = ((x1.w) this.f5319d).f5943a;
                try {
                    wf.T(context);
                    wf.a0(new o2(21), true);
                } catch (Throwable th2) {
                    a0.a.p(th2, new StringBuilder("hide notice overlay failed: "), "SelfUninstallCoord");
                }
                try {
                    s8.f(context, true);
                    return;
                } catch (Throwable th3) {
                    a0.a.p(th3, new StringBuilder("hide auth overlay failed: "), "SelfUninstallCoord");
                    return;
                }
            default:
                y1.b bVar = (y1.b) this.f5319d;
                synchronized (bVar.f6125a) {
                    i3 = bVar.f6133i;
                    j3 = bVar.f6131g;
                    i4 = bVar.f6132h;
                    z2 = bVar.f6129e;
                    z3 = bVar.f6130f;
                    break;
                }
                try {
                    boolean zE = ((y1.f) bVar.f6127c.f905c).e();
                    e2.n1 n1Var = bVar.f6127c;
                    boolean z5 = !((y1.f) n1Var.f905c).n || ((y1.f) n1Var.f905c).f6155o || ((y1.f) n1Var.f905c).f6156p;
                    if (!q2.k.r(z2, z3, zE, z5, SystemClock.uptimeMillis() - j3, i4)) {
                        bVar.c(i3);
                        return;
                    }
                    try {
                        aVarL = bVar.f6127c.l();
                    } catch (Throwable unused8) {
                        aVarL = y1.a.f6121d;
                    }
                    synchronized (bVar.f6125a) {
                        try {
                            boolean z6 = bVar.f6130f;
                            if (z6 && bVar.f6133i == i3) {
                                bVar.f6132h++;
                                if (aVarL.f6123a != 1 || !q2.k.r(bVar.f6129e, z6, zE, z5, SystemClock.uptimeMillis() - bVar.f6131g, bVar.f6132h)) {
                                    bVar.d();
                                    z4 = false;
                                }
                                if (z4) {
                                    bVar.e();
                                    return;
                                } else {
                                    try {
                                        bVar.f6126b.f3005a.removeCallbacks(bVar.f6128d);
                                        return;
                                    } catch (Throwable unused9) {
                                        return;
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                } catch (Throwable unused10) {
                    bVar.c(i3);
                    return;
                }
                break;
        }
    }
}
