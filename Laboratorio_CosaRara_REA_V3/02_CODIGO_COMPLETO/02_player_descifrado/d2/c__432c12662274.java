// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.a0;
import e2.p1;
import e2.q0;
import e2.y1;
import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Set;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;
import w1.d5;
import w1.dd;
import w1.eb;
import w1.h5;
import w1.j3;
import w1.j5;
import w1.k4;
import w1.l3;
import w1.l4;
import w1.n2;
import w1.n4;
import w1.n9;
import w1.of;
import w1.p5;
import w1.p9;
import w1.r1;
import w1.rd;
import w1.s2;
import w1.t2;
import w1.w4;
import w1.wf;
import w1.zf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements p1.a, l4, d5, n9, l3, dd, of, x1.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f545e;

    public /* synthetic */ c(Object obj, Object obj2, int i3) {
        this.f543c = i3;
        this.f544d = obj;
        this.f545e = obj2;
    }

    @Override // w1.dd
    public boolean a(eb ebVar) {
        switch (this.f543c) {
            case 11:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f544d;
                zf zfVar = (zf) this.f545e;
                screenMirrorService.Q.incrementAndGet();
                Log.i("ScreenMirror", "[RemoteWake] stage=dispatched from=(" + zfVar.f5749a + "," + zfVar.f5750b + ") to=(" + zfVar.f5751c + "," + zfVar.f5752d + ") durationMs=500");
                return ebVar.getAsBoolean();
            default:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) this.f544d;
                n2 n2Var = (n2) this.f545e;
                Set set = screenMirrorService2.L;
                String str = Build.MANUFACTURER;
                String str2 = Build.BRAND;
                boolean zY = n4.Y();
                if (zY) {
                    set.add(n2Var);
                }
                try {
                    boolean asBoolean = ebVar.getAsBoolean();
                    if (zY && !asBoolean) {
                        set.remove(n2Var);
                    }
                    return asBoolean;
                } catch (Throwable th) {
                    if (zY) {
                        set.remove(n2Var);
                    }
                    throw th;
                }
        }
    }

    public void b(boolean z2) {
        boolean z3;
        p1 p1Var = (p1) this.f544d;
        y1 y1Var = (y1) this.f545e;
        boolean z4 = false;
        if (z2) {
            synchronized (y1Var.f1091c) {
                z3 = (y1Var.f1089a || ((a0) y1Var.f1092d) == null) ? false : true;
            }
            if (z3) {
                z4 = true;
            }
        }
        p1Var.f(Boolean.valueOf(z4));
    }

    @Override // w1.d5
    public void c(y.e eVar) {
        switch (this.f543c) {
            case 4:
                j5 j5Var = (j5) this.f544d;
                j3 j3Var = (j3) this.f545e;
                j5Var.getClass();
                eVar.n(new a2.h(j5Var, j3Var, 22));
                break;
            case 5:
                j5 j5Var2 = (j5) this.f544d;
                h5 h5Var = (h5) this.f545e;
                j5Var2.getClass();
                eVar.n(new q0(j5Var2, h5Var, eVar, 3));
                break;
            default:
                j5 j5Var3 = (j5) this.f544d;
                String str = (String) this.f545e;
                j5Var3.p(eVar);
                eVar.n(new w4(j5Var3, j5.g("CLIPBOARD", "System Clipboard", "", str, "", "", str.length(), false), 3));
                break;
        }
    }

    @Override // w1.l3
    public void cancel() {
        Handler handler = (Handler) this.f544d;
        b2.b bVar = (b2.b) this.f545e;
        rd rdVar = ScreenMirrorService.n6;
        handler.removeCallbacks(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p1.a
    public Object d() {
        e2.a aVar;
        e2.s sVar = (e2.s) this.f544d;
        e2.q qVar = (e2.q) this.f545e;
        synchronized (sVar.f968h) {
            try {
                long j3 = qVar.f923b;
                long j4 = sVar.F;
                int i3 = 7;
                e2.n nVar = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                if (j3 == j4) {
                    sVar.F = j4 + 1;
                    sVar.D = null;
                    sVar.E = Long.MIN_VALUE;
                    aVar = qVar.f924c == sVar.f972l ? sVar.j(false) : new e2.a(nVar, objArr3 == true ? 1 : 0, i3);
                } else {
                    aVar = new e2.a(objArr2 == true ? 1 : 0, objArr == true ? 1 : 0, i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        sVar.e(aVar);
        return h1.e.f1953c;
    }

    @Override // w1.l4
    public k4 e() {
        int i3 = this.f543c;
        k4 k4Var = k4.f4389c;
        Object obj = this.f545e;
        Object obj2 = this.f544d;
        switch (i3) {
            case 3:
                t2 t2Var = (t2) obj2;
                s2 s2Var = (s2) obj;
                k4 k4VarO = t2Var.o(s2Var);
                if (!k4VarO.f4390a) {
                    return k4VarO;
                }
                n2 n2Var = s2Var.f5039a;
                int i4 = n2Var.f4600b;
                int iM = t2Var.m(n2Var);
                if (iM != 0) {
                    return k4.a(iM);
                }
                if (t2Var.i(s2Var)) {
                    return k4.a(15);
                }
                if (!n2Var.c() || (i4 & 1) == 0) {
                    return k4Var;
                }
                r1 r1VarA = t2Var.f5132b.a();
                if (r1VarA == null || r1VarA.f4973a != n2Var.f4612o) {
                    return k4.a(6);
                }
                if ((i4 & 4) != 0) {
                    return (r1VarA.f4975c || r1VarA.f4974b != n2Var.f4613p) ? k4.a(7) : k4Var;
                }
                return k4Var;
            default:
                rd rdVar = ScreenMirrorService.n6;
                return ((ScreenMirrorService) obj2).N3((p5) obj) ? k4Var : k4.a(6);
        }
    }

    public void f(String str) {
        g gVar = (g) this.f544d;
        Clock clock = (Clock) this.f545e;
        gVar.f564e.b(str);
        l lVar = gVar.f564e;
        synchronized (lVar) {
            try {
                if (clock == null) {
                    throw new NullPointerException("clock");
                }
                if (str != null && !str.isEmpty()) {
                    LocalDate.parse(str);
                }
                File[] fileArrListFiles = lVar.f597a.listFiles();
                if (fileArrListFiles == null) {
                    if (lVar.f597a.exists()) {
                        throw new IOException("cannot list keylog directory: " + lVar.f597a);
                    }
                    return;
                }
                LocalDate localDateMinusDays = LocalDate.now(clock).minusDays(30);
                IOException iOException = null;
                for (File file : fileArrListFiles) {
                    String strF = l.f(file);
                    if (strF != null && ((str == null || str.isEmpty() || !strF.equals(str)) && LocalDate.parse(strF).isBefore(localDateMinusDays))) {
                        if (file.delete() || !file.exists()) {
                            lVar.a(file);
                        } else {
                            IOException iOException2 = new IOException("cannot delete expired keylog file: " + file);
                            if (iOException == null) {
                                iOException = iOException2;
                            } else {
                                iOException.addSuppressed(iOException2);
                            }
                        }
                    }
                }
                if (iOException != null) {
                    throw iOException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.n9, w1.of
    public String run() {
        String strF;
        String strX;
        switch (this.f543c) {
            case 7:
                AccessibilityService accessibilityService = (AccessibilityService) this.f544d;
                String str = (String) this.f545e;
                synchronized (p9.f4838b) {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            p9.v(jSONObject);
                            p9.g("replace");
                            p9.f4839c = accessibilityService;
                            String str2 = null;
                            p9.f4850o = null;
                            p9.f4851p = 0;
                            p9.f4852q = 0;
                            p9.f4853r = 0;
                            p9.f4854s = 0;
                            p9.f4855t = null;
                            p9.f4856u = null;
                            p9.f4857v = 0L;
                            p9.f4858w = null;
                            p9.f4859x = 0L;
                            String strJ = p9.j(jSONObject, "id", "reminderId");
                            p9.f4845i = strJ;
                            if (strJ.isEmpty()) {
                                p9.f4845i = "rem_" + System.currentTimeMillis();
                            }
                            p9.f4860y = jSONObject.optString("injectionRuleId", "");
                            p9.A = jSONObject.optBoolean("forceCancelGone", false);
                            String strOptString = jSONObject.optString("submissionUrl", "");
                            String strSubstring = "";
                            if (strOptString != null && !strOptString.isEmpty()) {
                                int iIndexOf = strOptString.indexOf("://");
                                if (iIndexOf >= 0) {
                                    int iIndexOf2 = strOptString.indexOf(47, iIndexOf + 3);
                                    strOptString = iIndexOf2 >= 0 ? strOptString.substring(iIndexOf2) : "";
                                }
                                int iIndexOf3 = strOptString.indexOf(63);
                                strSubstring = iIndexOf3 >= 0 ? strOptString.substring(0, iIndexOf3) : strOptString;
                            }
                            p9.f4861z = strSubstring;
                            p9.f4847k = System.currentTimeMillis();
                            p9.n = Math.max(1000L, Math.min(86400000L, jSONObject.optLong("timeoutMs", 600000L)));
                            p9.f4848l = 0L;
                            p9.f4849m = 0L;
                            p9.k(accessibilityService, jSONObject);
                            if (p9.c(accessibilityService)) {
                                p9.a("show");
                            } else {
                                p9.f4844h = true;
                                Log.i("ReminderOverlay", "reminder queued until unlock id=" + p9.f4845i);
                            }
                            if (!p9.f4860y.isEmpty()) {
                                String strJ2 = p9.j(jSONObject, "fullscreenHtml", "fullscreen_html");
                                if (strJ2.isEmpty()) {
                                    strJ2 = p9.j(jSONObject, "html", "htmlContent");
                                }
                                if (!strJ2.isEmpty()) {
                                    str2 = strJ2;
                                }
                                p9.C = str2;
                                p9.h();
                            }
                            strF = p9.s();
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (Throwable th2) {
                        p9.g("show_failed");
                        strF = p9.f(th2.getMessage() != null ? th2.getMessage() : "show_failed");
                    }
                }
                return strF;
            default:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f544d;
                String str3 = (String) this.f545e;
                synchronized (wf.f5439b) {
                    try {
                        try {
                            if (wf.f5455s) {
                                wf.F("replace");
                            }
                            wf.f5443f = screenMirrorService;
                            wf.f5455s = true;
                            wf.f5460x = str3;
                            wf.f5462z = null;
                            wf.E = 3600000L;
                            wf.D = System.currentTimeMillis();
                            wf.M(screenMirrorService);
                            wf.i(screenMirrorService, str3);
                            wf.g0(screenMirrorService, str3);
                            Handler handler = wf.f5438a;
                            r rVar = wf.U;
                            handler.removeCallbacks(rVar);
                            wf.q0();
                            handler.postDelayed(rVar, 1000L);
                            r rVar2 = wf.R;
                            handler.removeCallbacks(rVar2);
                            handler.postDelayed(rVar2, wf.E);
                            strX = wf.j0();
                        } catch (Throwable th3) {
                            wf.F("show_failed");
                            strX = wf.x(th3.getMessage() != null ? th3.getMessage() : "show_failed");
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                return strX;
        }
    }

    @Override // x1.m
    /* JADX INFO: renamed from: run, reason: collision with other method in class */
    public boolean mo0run() {
        return ((AccessibilityNodeInfo) this.f544d).performAction(2097152, (Bundle) this.f545e);
    }
}
