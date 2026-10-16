// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Build;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;
import w1.dc;
import w1.fc;
import w1.h4;
import w1.lc;
import w1.n2;
import w1.n3;
import w1.n5;
import w1.p5;
import w1.rd;
import w1.rf;
import w1.s2;
import w1.sf;
import w1.t2;
import w1.wf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements p1.p, p1.l, g2.u, h4, rf, x1.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f812e;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3) {
        this.f810c = obj;
        this.f811d = obj2;
        this.f812e = obj3;
    }

    @Override // w1.rf
    public void a(sf sfVar, int i3) {
        ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f810c;
        p5 p5Var = (p5) this.f811d;
        n5 n5Var = (n5) this.f812e;
        rd rdVar = ScreenMirrorService.n6;
        if (screenMirrorService.N3(p5Var)) {
            n5Var.f4625e.c(6, i3);
            screenMirrorService.p(p5Var, "punch_fail_closed:" + i3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:214:0x037d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v19 */
    @Override // w1.h4
    public int b(d2.t tVar) {
        int i3;
        int i4;
        sf sfVarL;
        int i5;
        sf sfVar;
        long j3;
        float f3;
        int size;
        float f4;
        ?? A1;
        int i6;
        float f5;
        float[] fArr;
        float[] fArr2;
        boolean zPerformGlobalAction;
        t2 t2Var = (t2) this.f810c;
        s2 s2Var = (s2) this.f811d;
        float[] fArr3 = (float[]) this.f812e;
        int iA = t2.a(s2Var.f5039a);
        int iF = t2Var.f(s2Var);
        if (iF != 0) {
            t2Var.j(s2Var, 5, iA, iF);
            return 4;
        }
        if (s2Var.f5039a.f4599a == 6) {
            w1.p1 p1VarA = w1.q1.a();
            try {
                dc dcVar = t2Var.f5132b;
                int i7 = s2Var.f5039a.f4610l;
                ScreenMirrorService screenMirrorService = dcVar.f3821a;
                rd rdVar = ScreenMirrorService.n6;
                if (i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4 || i7 == 8 || i7 == 9 || (Build.VERSION.SDK_INT >= 33 && (i7 == 16 || i7 == 17 || i7 == 18 || i7 == 19 || i7 == 20))) {
                    zPerformGlobalAction = screenMirrorService.performGlobalAction(i7);
                    screenMirrorService.Z5(i7 == 3 ? 600L : 64L, zPerformGlobalAction);
                } else {
                    zPerformGlobalAction = false;
                }
                int i8 = zPerformGlobalAction ? 2 : 4;
                p1VarA.close();
                return i8;
            } catch (Throwable th) {
                try {
                    p1VarA.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        synchronized (t2Var) {
            try {
                sf sfVar2 = t2Var.f5142l;
                if (sfVar2 == null || !sfVar2.isOpen()) {
                    t2Var.f5142l = null;
                    t2.e(sfVar2);
                    try {
                        dc dcVar2 = t2Var.f5132b;
                        j3 = t2Var.f5139i;
                        int i9 = s2Var.f5040b.f4877a.f4769a;
                        t2Var.f5134d.getClass();
                        i4 = 0;
                        try {
                            long jMax = Math.max(0L, SystemClock.uptimeMillis() - s2Var.f5041c);
                            i3 = 1;
                            try {
                                long j4 = s2Var.f5042d;
                                long jMax2 = j4 == Long.MAX_VALUE ? 8000L : Math.max(1L, j4 - jMax);
                                long jMax3 = Math.max(0L, s2Var.f5039a.b());
                                sfVarL = wf.l(dcVar2.f3821a, j3, i9, 0L, Math.max(1L, Math.min(8000L, (jMax2 >= 8000 || jMax3 >= 8000 || jMax2 > 9223372036854773807L - jMax3) ? 8000L : jMax2 + jMax3 + 2000)), new d2.o(17, new d2.o(10, t2Var)));
                                i5 = 0;
                            } catch (Throwable unused) {
                                sfVarL = null;
                                i5 = 4;
                            }
                        } catch (Throwable unused2) {
                            i3 = 1;
                        }
                    } catch (Throwable unused3) {
                        i3 = 1;
                        i4 = 0;
                    }
                    if (sfVarL == null || !sfVarL.isOpen()) {
                        if (i5 == 0) {
                            if (sfVarL == null) {
                                i5 = i4;
                            } else {
                                try {
                                    i5 = sfVarL.f5105g.get();
                                } catch (Throwable unused4) {
                                    i5 = 4;
                                }
                            }
                        }
                        if (i5 != 0) {
                            synchronized (t2Var) {
                                try {
                                    if (t2Var.f5141k == s2Var && s2Var.f5040b.f4878b != 2) {
                                        s2Var.f5045g = i5;
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                        }
                        t2.e(sfVarL);
                    } else {
                        synchronized (t2Var) {
                            try {
                                if (t2Var.n || t2Var.f5141k != s2Var || s2Var.f5040b.f4878b == 2) {
                                    t2.e(sfVarL);
                                } else {
                                    sf sfVar3 = t2Var.f5142l;
                                    if (sfVar3 == null) {
                                        t2Var.f5142l = sfVarL;
                                    } else {
                                        t2.e(sfVarL);
                                        sfVarL = sfVar3.isOpen() ? sfVar3 : null;
                                    }
                                    sfVar = sfVarL;
                                }
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                    }
                    sfVar = null;
                } else {
                    sfVar = sfVar2;
                    i3 = 1;
                    i4 = 0;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        if (sfVar == null || !sfVar.isOpen()) {
            f3 = 5.6E-45f;
        } else {
            dc dcVar3 = t2Var.f5132b;
            int i10 = s2Var.f5040b.f4877a.f4769a;
            n2 n2Var = s2Var.f5039a;
            float f6 = fArr3[i4];
            float f7 = fArr3[i3];
            synchronized (t2Var) {
                size = (t2Var.f5141k == null ? i4 : i3) + t2Var.f5140j.size();
            }
            ScreenMirrorService screenMirrorService2 = dcVar3.f3821a;
            rd rdVar2 = ScreenMirrorService.n6;
            n3 n3Var = screenMirrorService2.R3;
            if (n3Var == null) {
                f5 = 5.6E-45f;
            } else {
                try {
                    GestureDescription.Builder builder = new GestureDescription.Builder();
                    int i11 = n2Var.f4599a;
                    try {
                        try {
                            try {
                                if (i11 == i3 || i11 == 2) {
                                    f4 = 5.6E-45f;
                                    f4 = 5.6E-45f;
                                    Path path = new Path();
                                    path.moveTo(n3.a(f6, n3Var.f4617a), n3.a(f7, n3Var.f4618b));
                                    i6 = 1;
                                    try {
                                        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, Math.max(1, n2Var.b())));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        i4 = i4;
                                        i3 = i6;
                                        a0.a.p(th, new StringBuilder("[ControlAction] gesture dispatch failed: "), "ScreenMirror");
                                        A1 = i4;
                                        f3 = f4;
                                        if (A1 != 0) {
                                            return i3;
                                        }
                                        return f3 == true ? 1 : 0;
                                    }
                                } else if (i11 == 3) {
                                    try {
                                        int iA2 = n3.a(f6, n3Var.f4617a);
                                        int iA3 = n3.a(f7, n3Var.f4618b);
                                        Path path2 = new Path();
                                        float f8 = iA2;
                                        float f9 = iA3;
                                        path2.moveTo(f8, f9);
                                        Path path3 = new Path();
                                        path3.moveTo(f8, f9);
                                        builder.addStroke(new GestureDescription.StrokeDescription(path2, 0L, n2Var.f4611m));
                                        int i12 = n2Var.f4611m;
                                        builder.addStroke(new GestureDescription.StrokeDescription(path3, n2Var.n + i12, i12));
                                        i6 = 1;
                                        f4 = 5.6E-45f;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        f4 = 5.6E-45f;
                                        i3 = 1;
                                        a0.a.p(th, new StringBuilder("[ControlAction] gesture dispatch failed: "), "ScreenMirror");
                                        A1 = i4;
                                        f3 = f4;
                                        if (A1 != 0) {
                                            return i3;
                                        }
                                        return f3 == true ? 1 : 0;
                                    }
                                } else {
                                    float f10 = 0.95f;
                                    f5 = 5.6E-45f;
                                    f4 = 5.6E-45f;
                                    f5 = 5.6E-45f;
                                    f5 = 5.6E-45f;
                                    f5 = 5.6E-45f;
                                    f5 = 5.6E-45f;
                                    if (i11 == 4) {
                                        float f11 = n2Var.f4605g;
                                        float f12 = n2Var.f4607i;
                                        if (f11 <= f12 || f11 <= 0.95f) {
                                            f10 = f11;
                                        }
                                        screenMirrorService2.C4(f10, f12, screenMirrorService2.I0());
                                        Path path4 = new Path();
                                        path4.moveTo(n3.a(n2Var.f4604f, n3Var.f4617a), n3.a(f10, n3Var.f4618b));
                                        path4.lineTo(n3.a(n2Var.f4606h, n3Var.f4617a), n3.a(n2Var.f4607i, n3Var.f4618b));
                                        builder.addStroke(new GestureDescription.StrokeDescription(path4, 0L, n2Var.f4601c));
                                    } else {
                                        if (i11 == 5 && (fArr = n2Var.f4608j) != null && (fArr2 = n2Var.f4609k) != null && fArr.length >= 2 && fArr.length == fArr2.length) {
                                            float f13 = fArr2[i4];
                                            if (f13 <= fArr2[fArr2.length - 1] || f13 <= 0.95f) {
                                                f10 = f13;
                                            }
                                            screenMirrorService2.C4(f10, fArr2[fArr2.length - 1], screenMirrorService2.I0());
                                            Path path5 = new Path();
                                            path5.moveTo(n3.a(n2Var.f4608j[i4], n3Var.f4617a), n3.a(f10, n3Var.f4618b));
                                            int i13 = 1;
                                            while (true) {
                                                float[] fArr4 = n2Var.f4608j;
                                                if (i13 >= fArr4.length) {
                                                    break;
                                                }
                                                path5.lineTo(n3.a(fArr4[i13], n3Var.f4617a), n3.a(n2Var.f4609k[i13], n3Var.f4618b));
                                                i13++;
                                            }
                                            builder.addStroke(new GestureDescription.StrokeDescription(path5, 0L, n2Var.f4601c));
                                        }
                                        if (A1 != 0) {
                                            return i3;
                                        }
                                    }
                                    i6 = 1;
                                }
                                A1 = screenMirrorService2.a1(builder.build(), new lc(screenMirrorService2, n2Var, i4), screenMirrorService2.f2541t, tVar, new d2.c(screenMirrorService2, n2Var, 12), i10, 0L, size, sfVar);
                                f3 = f4;
                            } catch (Throwable th8) {
                                th = th8;
                                a0.a.p(th, new StringBuilder("[ControlAction] gesture dispatch failed: "), "ScreenMirror");
                                A1 = i4;
                                f3 = f4;
                            }
                            i3 = i6;
                        } catch (Throwable th9) {
                            th = th9;
                            i3 = i6;
                            a0.a.p(th, new StringBuilder("[ControlAction] gesture dispatch failed: "), "ScreenMirror");
                            A1 = i4;
                            f3 = f4;
                            if (A1 != 0) {
                                return i3;
                            }
                            return f3 == true ? 1 : 0;
                        }
                        i4 = i4;
                    } catch (Throwable th10) {
                        th = th10;
                        f4 = j3;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    i4 = i4;
                    f4 = 5.6E-45f;
                }
                if (A1 != 0) {
                    return i3;
                }
            }
            A1 = i4;
            i3 = 1;
            f3 = f5;
            if (A1 != 0) {
                return i3;
            }
        }
        return f3 == true ? 1 : 0;
    }

    @Override // p1.p
    public Object e(Object obj, Object obj2) {
        b bVar = b.f712c;
        fc fcVar = (fc) this.f810c;
        d2.o oVar = (d2.o) this.f811d;
        fc fcVar2 = (fc) this.f812e;
        c cVar = (c) obj;
        r rVar = (r) obj2;
        if (fcVar != null) {
            fcVar.d(cVar, (d) oVar.f(cVar.f727a), rVar);
        } else if (fcVar2 instanceof fc) {
            fcVar2.d(new c(bVar, 0L), (d) oVar.f(cVar.f727a), rVar);
        } else {
            n3 n3Var = fcVar2.f4042i.R3;
            if (n3Var == null) {
                rVar.b();
            } else {
                try {
                    e0 e0VarH = b1.h(n3Var.f4617a, n3Var.f4618b, 10);
                    fcVar2.d(new c(bVar, 0L), new d(e0VarH.f781a, e0VarH.f782b), rVar);
                } catch (Throwable unused) {
                    rVar.b();
                }
            }
        }
        return h1.e.f1953c;
    }

    @Override // p1.l
    public Object f(Object obj) {
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f810c;
        v0 v0Var = (v0) this.f811d;
        u0 u0Var = (u0) this.f812e;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (atomicBoolean.compareAndSet(false, true)) {
            v0Var.a(u0Var, zBooleanValue);
        }
        return h1.e.f1953c;
    }

    @Override // g2.u
    public void run() {
        g2.a0 a0Var = (g2.a0) this.f810c;
        JSONObject jSONObject = (JSONObject) this.f811d;
        g2.p pVar = (g2.p) this.f812e;
        if (a0Var.f1528s.get() && a0Var.f1514g.f3425b) {
            a0Var.f1514g.a("capabilities:update", jSONObject, new g2.i(a0Var, pVar, 0));
        }
    }

    @Override // x1.m
    /* JADX INFO: renamed from: run */
    public boolean mo0run() {
        return ((AccessibilityService) this.f810c).dispatchGesture((GestureDescription) this.f811d, (AccessibilityService.GestureResultCallback) this.f812e, null);
    }
}
