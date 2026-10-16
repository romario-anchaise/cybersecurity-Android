// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o2 implements e3, g4, n9, l4, l3, dd, md, of {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4701c;

    public /* synthetic */ o2(int i3) {
        this.f4701c = i3;
    }

    public static sd g() {
        sd sdVar;
        long j3;
        long jF;
        long j4;
        long j5;
        long jL;
        int i3;
        long j6;
        long j7;
        long j8;
        long j9;
        sd sdVar2;
        cf cfVarK = cf.K();
        ScreenMirrorService screenMirrorService = cfVarK.f3731u0;
        if (screenMirrorService == null) {
            sdVar2 = null;
        } else {
            synchronized (ScreenMirrorService.B6) {
                try {
                    if (ScreenMirrorService.E6) {
                        sdVar = null;
                    } else {
                        if (ScreenMirrorService.D6 == null) {
                            ScreenMirrorService.D6 = new d2.y(ScreenMirrorService.C6.d(), screenMirrorService.r4(), screenMirrorService.t4(), screenMirrorService.B2.get());
                        }
                        d2.y yVar = ScreenMirrorService.D6;
                        ScreenMirrorService.E6 = true;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            rd rdVar = ScreenMirrorService.n6;
                            SystemClock.uptimeMillis();
                            synchronized (rdVar) {
                                try {
                                    j3 = rdVar.f5019a;
                                    jF = rdVar.f();
                                    j4 = rdVar.f5023e;
                                    j5 = rdVar.f5021c ? rdVar.f5020b : 0L;
                                    jL = rdVar.l();
                                    i3 = rdVar.f5025g;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            jSONObject.put("intervalMs", ScreenMirrorService.P(j3));
                            jSONObject.put("postControlIntervalMs", ScreenMirrorService.P(jF));
                            jSONObject.put("oemFloorMs", ScreenMirrorService.P(j4));
                            jSONObject.put("captureLatencyEmaMs", ScreenMirrorService.P(j5));
                            jSONObject.put("captureWatchdogMs", ScreenMirrorService.P(jL));
                            jSONObject.put("captureWatchdogStreak", i3);
                            m4 m4Var = screenMirrorService.f2547v;
                            synchronized (m4Var) {
                                j6 = m4Var.f4521s;
                            }
                            jSONObject.put("gestureWatchdogFires", j6);
                            m4 m4Var2 = screenMirrorService.f2547v;
                            synchronized (m4Var2) {
                                j7 = m4Var2.f4522t;
                            }
                            jSONObject.put("gestureLateCallbacks", j7);
                            jSONObject.put("honorKeyguardControlBlocks", screenMirrorService.I.get());
                            jSONObject.put("wakeGestureQueued", screenMirrorService.P.get());
                            jSONObject.put("wakeGestureDispatched", screenMirrorService.Q.get());
                            jSONObject.put("wakeGestureCompleted", screenMirrorService.R.get());
                            jSONObject.put("wakeGestureCancelled", screenMirrorService.S.get());
                            jSONObject.put("wakeGestureTimedOut", screenMirrorService.T.get());
                            jSONObject.put("wakeGestureRejected", screenMirrorService.U.get());
                            nd ndVar = (nd) yVar.f654d;
                            long j10 = ndVar == null ? 0L : ndVar.f4658a;
                            long j11 = (ndVar == null || j10 == 0) ? 0L : ndVar.f4659b / j10;
                            jSONObject.put("nodeSignatureSamples", j10);
                            jSONObject.put("nodeSignatureAvgUs", ScreenMirrorService.Q(j11));
                            jSONObject.put("nodeSignatureMaxUs", ScreenMirrorService.Q(ndVar == null ? 0L : ndVar.f4660c));
                            ScreenMirrorService.r5(jSONObject, ScreenMirrorService.K6.g());
                            jSONObject.put("a11yIngressMutes", screenMirrorService.F2.f5553d);
                            jSONObject.put("a11yIngressSuppressed", screenMirrorService.F2.f5554e);
                            jSONObject.put("a11yIngressCallbackFailures", screenMirrorService.I2.get());
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            c2.t tVar = screenMirrorService.f2500h1;
                            synchronized (tVar) {
                                j8 = tVar.f459b;
                            }
                            jSONObject.put("keyguardTreePollIntervalMs", j8);
                            g2.e eVar = screenMirrorService.f2496g1;
                            synchronized (eVar) {
                                j9 = eVar.f1585b;
                            }
                            jSONObject.put("keyguardTreePollTrips", j9);
                            jSONObject.put("keyguardTreePollLastDurationMs", ScreenMirrorService.P(screenMirrorService.f2496g1.a()));
                            jSONObject.put("keyguardTreePollMaxDurationMs", ScreenMirrorService.P(screenMirrorService.f2496g1.b()));
                            jSONObject.put("keyguardTreePollBackoffMs", ScreenMirrorService.P(screenMirrorService.f2496g1.c(jUptimeMillis)));
                            w wVar = (w) yVar.f651a;
                            if (wVar != null) {
                                ScreenMirrorService.p5(jSONObject, wVar);
                            }
                            ScreenMirrorService.q5(jSONObject, (f6) yVar.f652b, yVar.f653c);
                            e2.s1 s1Var = screenMirrorService.a4;
                            e2.b0 b0VarK = s1Var == null ? null : s1Var.k();
                            if (b0VarK != null) {
                                e2.v vVar = b0VarK.f716a;
                                e2.d2 d2Var = b0VarK.f717b;
                                jSONObject.put("encodeActive", vVar.f1024e);
                                jSONObject.put("encodePending", vVar.f1025f);
                                jSONObject.put("encodeDropped", vVar.f1021b + vVar.f1022c + vVar.f1023d);
                                jSONObject.put("publishInFlight", d2Var.f763f);
                                jSONObject.put("publishPending", d2Var.f764g);
                                jSONObject.put("publishQueueWaitMs", ScreenMirrorService.P(d2Var.f765h));
                                jSONObject.put("publishSendDurationMs", ScreenMirrorService.P(d2Var.f766i));
                                jSONObject.put("publishDropped", d2Var.f762e + d2Var.f768k);
                            }
                        } catch (Throwable th2) {
                            a0.a.p(th2, new StringBuilder("[CaptureHealth] snapshot failed: "), "ScreenMirror");
                        }
                        sdVar = new sd(jSONObject, new v8(3, yVar), new d2.r(21));
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            sdVar2 = sdVar;
        }
        JSONObject jSONObject2 = sdVar2 == null ? new JSONObject() : (JSONObject) sdVar2.f5096b;
        try {
            long j12 = cf.D0;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - cf.E0;
            if (jSONObject2 != null) {
                jSONObject2.put("processEpoch", Math.max(1L, j12));
                jSONObject2.put("processUptimeMs", Math.max(0L, jElapsedRealtime));
            }
        } catch (Throwable th4) {
            a0.a.p(th4, new StringBuilder("process telemetry clock snapshot failed: "), "TunnelManager");
        }
        g2.k0 k0Var = cfVarK.D;
        if (k0Var != null) {
            try {
                g2.j0 j0VarR = k0Var.R();
                jSONObject2.put("mediaQueuedPackets", j0VarR.f1642d);
                jSONObject2.put("mediaQueuedBytes", j0VarR.f1643e);
                jSONObject2.put("mediaInFlightPackets", j0VarR.f1644f);
                jSONObject2.put("mediaInFlightBytes", j0VarR.f1645g);
                g2.i0 i0Var = (g2.i0) j0VarR.f1646h.get("webp");
                if (i0Var != null) {
                    jSONObject2.put("mediaWebpAckP95Ms", ScreenMirrorService.P(i0Var.n));
                    jSONObject2.put("mediaWebpDropped", i0Var.f1616e + i0Var.f1617f);
                    jSONObject2.put("mediaWebpTimeouts", i0Var.f1625o);
                    jSONObject2.put("mediaWebpNacks", i0Var.f1626p);
                }
                cf.c0(jSONObject2, "Nodes", (g2.i0) j0VarR.f1646h.get("nodes"));
                cf.c0(jSONObject2, "Camera", (g2.i0) j0VarR.f1646h.get("camera"));
            } catch (Throwable th5) {
                a0.a.p(th5, new StringBuilder("capture health media snapshot failed: "), "TunnelManager");
            }
        }
        Context context = cfVarK.B0;
        if (context != null) {
            try {
                jSONObject2.put("a11yOutboxOmissionDebt", Math.max(0L, h0.R(context).g0()));
            } catch (Throwable th6) {
                a0.a.p(th6, new StringBuilder("a11y outbox debt snapshot failed: "), "TunnelManager");
            }
        }
        return sdVar2 != null ? sdVar2 : new sd(jSONObject2, null, null);
    }

    public static /* synthetic */ void h(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    public static /* synthetic */ void i(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void j(String str, long j3) {
        throw new IllegalArgumentException((str + j3).toString());
    }

    public static /* synthetic */ void k(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void l(String str) throws IOException {
        throw new IOException(str);
    }

    public static String n() {
        AccessibilityNodeInfo rootInActiveWindow;
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        String string = null;
        if (screenMirrorServiceU2 == null) {
            return null;
        }
        AccessibilityNodeInfo accessibilityNodeInfoFindFocus = screenMirrorServiceU2.findFocus(1);
        if (accessibilityNodeInfoFindFocus == null && (rootInActiveWindow = screenMirrorServiceU2.getRootInActiveWindow()) != null) {
            try {
                accessibilityNodeInfoFindFocus = ScreenMirrorService.Z1(rootInActiveWindow);
                try {
                    rootInActiveWindow.recycle();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                try {
                    rootInActiveWindow.recycle();
                } catch (Throwable unused2) {
                }
                throw th;
            }
        }
        if (accessibilityNodeInfoFindFocus != null) {
            try {
                accessibilityNodeInfoFindFocus.refresh();
            } catch (Throwable unused3) {
            }
            try {
                CharSequence text = accessibilityNodeInfoFindFocus.getText();
                if (text == null || text.length() <= 0) {
                    CharSequence contentDescription = accessibilityNodeInfoFindFocus.getContentDescription();
                    if (contentDescription != null && contentDescription.length() > 0) {
                        string = contentDescription.toString();
                    }
                } else {
                    string = text.toString();
                }
            } finally {
                try {
                    accessibilityNodeInfoFindFocus.recycle();
                } catch (Throwable unused4) {
                }
            }
        }
        return string;
    }

    @Override // w1.dd
    public boolean a(eb ebVar) {
        return ebVar.getAsBoolean();
    }

    @Override // w1.e3
    public void b(boolean z2) {
        switch (this.f4701c) {
            case 3:
                break;
            default:
                Pattern pattern = cf.F0;
                break;
        }
    }

    @Override // w1.g4
    public c4 c(long j3, Runnable runnable) {
        return new b4(m4.f4502v.schedule(runnable, Math.max(0L, j3), TimeUnit.MILLISECONDS), 0);
    }

    @Override // w1.l3
    public void cancel() {
        rd rdVar = ScreenMirrorService.n6;
    }

    @Override // w1.md
    public boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        switch (this.f4701c) {
            case 16:
                rd rdVar = ScreenMirrorService.n6;
                try {
                    return accessibilityNodeInfo.isPassword() && accessibilityNodeInfo.isEditable();
                } catch (Throwable unused) {
                    return false;
                }
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                try {
                    return accessibilityNodeInfo.isPassword();
                } catch (Throwable unused2) {
                    return false;
                }
        }
    }

    @Override // w1.l4
    public k4 e() {
        return k4.f4389c;
    }

    public long m() {
        switch (this.f4701c) {
            case 4:
                return System.currentTimeMillis();
            default:
                return SystemClock.uptimeMillis();
        }
    }

    @Override // w1.n9, w1.of
    public String run() {
        String strJ0;
        String strJ1;
        switch (this.f4701c) {
            case 7:
                p9.g("remote");
                return p9.s();
            case 21:
                wf.o();
                wf.F("remote");
                return wf.j0();
            case 22:
                synchronized (wf.f5439b) {
                    try {
                        wf.W();
                        if (!wf.f5455s) {
                            wf.f5443f = null;
                        }
                        strJ0 = wf.j0();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return strJ0;
            default:
                Object obj = wf.f5439b;
                synchronized (obj) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        r1 r1VarS = wf.S(jCurrentTimeMillis);
                        if (r1VarS.a(jCurrentTimeMillis)) {
                            wf.d(r1VarS);
                            wf.f5455s = true;
                            wf.f5460x = "black";
                            wf.D = r1VarS.f4973a;
                            wf.b0(jCurrentTimeMillis);
                            if (wf.f5443f != null && !wf.G(wf.f5446i)) {
                                wf.X(wf.f5443f, "status");
                            }
                        } else if (wf.f5459w) {
                            wf.o();
                            wf.E("black", "timeout");
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                synchronized (obj) {
                    strJ1 = wf.j0();
                    break;
                }
                return strJ1;
        }
    }

    private final void f(boolean z2) {
    }
}
