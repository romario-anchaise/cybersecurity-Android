// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f3 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f3964q = Pattern.compile("[A-Za-z][A-Za-z0-9_]*(?:\\.[A-Za-z][A-Za-z0-9_]*)+\\z");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2.o f3965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oa f3966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oa f3967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oa f3968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e2.n1 f3969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oe f3970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b2.m f3971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o2 f3972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q.n f3973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f3974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f3975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e2.g f3976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e2.g f3977m;
    public boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f3979p;

    public f3(Context context, oa oaVar, oa oaVar2, oa oaVar3, oe oeVar) {
        d2.o oVar = new d2.o(11, new b2.m(context, 3));
        e2.n1 n1Var = new e2.n1(17);
        b2.m mVar = new b2.m(context, (char) 0);
        o2 o2Var = new o2(2);
        q.n nVar = new q.n(context);
        this.f3974j = new Object();
        this.f3975k = new Object();
        this.f3965a = oVar;
        this.f3966b = oaVar;
        this.f3967c = oaVar2;
        this.f3968d = oaVar3;
        this.f3969e = n1Var;
        this.f3970f = oeVar;
        this.f3971g = mVar;
        this.f3972h = o2Var;
        this.f3973i = nVar;
    }

    public static String a(String str) {
        String strTrim = str == null ? "" : str.trim();
        return (strTrim.isEmpty() || "unknown".equalsIgnoreCase(strTrim) || strTrim.codePointCount(0, strTrim.length()) > 255 || !f3964q.matcher(strTrim).matches()) ? "" : strTrim;
    }

    public final y.l b() throws Throwable {
        JSONObject jSONObjectD;
        boolean zZ0;
        ScreenMirrorService screenMirrorService = this.f3966b.f4744a.f3731u0;
        String str = screenMirrorService == null ? "" : screenMirrorService.j4;
        String str2 = "";
        ScreenMirrorService screenMirrorService2 = this.f3968d.f4744a.f3731u0;
        if (screenMirrorService2 != null) {
            String string = screenMirrorService2.getSharedPreferences("unlock_seq", 0).getString("last_unlock_mode", "");
            if ("pin".equals(string) || "pattern".equals(string) || "password".equals(string)) {
                str2 = string;
            }
        }
        d2.o oVar = this.f3965a;
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        z2 z2VarA = ((b2.m) oVar.f603d).a(str, str2);
        b2.m mVar = this.f3971g;
        if (mVar != null) {
            String str3 = z2VarA.K;
            if (("errored".equals(str3) || "ignored".equals(str3)) && !z2VarA.f5683x) {
                String str4 = "";
                try {
                    String string2 = mVar.f358a.getSharedPreferences("restricted_settings_signal", 0).getString("last_signaled_op", "");
                    if (string2 != null) {
                        str4 = string2;
                    }
                } catch (Throwable unused) {
                }
                if (!str3.equals(str4)) {
                    try {
                        oe oeVar = this.f3970f;
                        zZ0 = ((cf) oeVar.f4764c).z0(oeVar.f4765d, "event:restricted_settings_detected\t{\"op\":\"" + str3 + "\"}", new o2(3));
                    } catch (Exception e3) {
                        Log.w("TelemetryReporter", "restricted settings event failed: " + e3.getMessage());
                        zZ0 = false;
                    }
                    if (zZ0) {
                        mVar.g(str3);
                    }
                }
            } else {
                String str5 = "";
                try {
                    String string3 = mVar.f358a.getSharedPreferences("restricted_settings_signal", 0).getString("last_signaled_op", "");
                    if (string3 != null) {
                        str5 = string3;
                    }
                } catch (Throwable unused2) {
                }
                if (!"".equals(str5)) {
                    mVar.g("");
                }
            }
        }
        JSONObject jSONObjectE = z2VarA.e();
        ScreenMirrorService screenMirrorService3 = this.f3967c.f4744a.f3731u0;
        String strA = a(screenMirrorService3 == null ? "" : a(screenMirrorService3.k4));
        if (!strA.isEmpty()) {
            try {
                jSONObjectE.put("foregroundAppPackage", strA);
            } catch (JSONException unused3) {
            }
        }
        y.r rVar = null;
        if (this.f3972h != null) {
            synchronized (this.f3975k) {
                try {
                    if (!this.f3978o) {
                        sd sdVarG = o2.g();
                        if (((JSONObject) sdVarG.f5096b).length() == 0) {
                            sdVarG.a(false);
                        } else {
                            this.f3978o = true;
                            rVar = new y.r();
                            rVar.f6034c = this;
                            rVar.f6033b = new AtomicBoolean(false);
                            rVar.f6032a = sdVarG;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (rVar != null) {
            try {
                JSONObject jSONObject = (JSONObject) ((sd) rVar.f6032a).f5096b;
                if (jSONObject != null && jSONObject.length() > 0) {
                    try {
                        jSONObjectE.put("captureHealth", jSONObject);
                    } catch (JSONException unused4) {
                    }
                }
            } catch (Error | RuntimeException e4) {
                if (rVar != null) {
                    rVar.a(false);
                }
                throw e4;
            }
        }
        q.n nVar = this.f3973i;
        if (nVar != null && (jSONObjectD = e9.d(nVar.f3049a)) != null && jSONObjectD.length() > 0) {
            try {
                jSONObjectE.put("processExit", jSONObjectD);
            } catch (JSONException unused5) {
            }
        }
        return new y.l("report:telemetry:" + jSONObjectE, rVar);
    }

    public final void c(long j3) {
        try {
            ScreenMirrorService screenMirrorService = this.f3966b.f4744a.f3731u0;
            String strSubstring = screenMirrorService == null ? "" : screenMirrorService.j4;
            JSONObject jSONObject = new JSONObject();
            if (strSubstring == null || strSubstring.isEmpty()) {
                strSubstring = "";
            } else if (strSubstring.codePointCount(0, strSubstring.length()) > 128) {
                strSubstring = strSubstring.substring(0, strSubstring.offsetByCodePoints(0, 128));
            }
            JSONObject jSONObjectPut = jSONObject.put("foregroundAppName", strSubstring).put("collectedAtMs", System.currentTimeMillis());
            ScreenMirrorService screenMirrorService2 = this.f3967c.f4744a.f3731u0;
            String strA = a(screenMirrorService2 == null ? "" : a(screenMirrorService2.k4));
            if (!strA.isEmpty()) {
                try {
                    jSONObjectPut.put("foregroundAppPackage", strA);
                } catch (JSONException unused) {
                }
            }
            synchronized (this.f3974j) {
                if (this.f3976l != null && this.f3979p == j3) {
                    oe oeVar = this.f3970f;
                    ((cf) oeVar.f4764c).z0(oeVar.f4765d, "report:foreground:" + jSONObjectPut, new o2(3));
                }
            }
        } catch (Exception e3) {
            Log.w("TelemetryReporter", "foreground report failed: " + e3.getMessage());
        }
    }

    public final void d() {
        y.l lVarB;
        try {
            lVarB = b();
            try {
                f(lVarB);
            } catch (Exception e3) {
                e = e3;
                if (lVarB != null) {
                    lVarB.g(false);
                }
                Log.w("TelemetryReporter", "telemetry report failed: " + e.getMessage());
            }
        } catch (Exception e4) {
            e = e4;
            lVarB = null;
        }
    }

    public final void e(long j3) {
        this.f3977m = new e2.g(((ScheduledThreadPoolExecutor) this.f3969e.f905c).schedule(new d3(this, j3, 1), 350L, TimeUnit.MILLISECONDS), 4);
    }

    public final void f(y.l lVar) {
        try {
            oe oeVar = this.f3970f;
            if (((cf) oeVar.f4764c).z0(oeVar.f4765d, (String) lVar.f5991c, new d2.o(12, lVar))) {
                return;
            }
            lVar.g(false);
        } catch (Throwable th) {
            lVar.g(false);
            throw th;
        }
    }
}
