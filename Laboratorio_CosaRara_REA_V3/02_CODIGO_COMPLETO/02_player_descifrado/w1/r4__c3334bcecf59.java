// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.KeyguardManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r4 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile r4 f4976i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile o2 f4978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScreenMirrorService f4981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4982f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4984h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f4977a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4983g = new LinkedHashMap();

    public static r4 b() {
        r4 r4Var;
        r4 r4Var2 = f4976i;
        if (r4Var2 != null) {
            return r4Var2;
        }
        synchronized (r4.class) {
            try {
                r4Var = f4976i;
                if (r4Var == null) {
                    r4Var = new r4();
                    f4976i = r4Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r4Var;
    }

    public static void d(String str) {
        try {
            cf.K().w0(str);
        } catch (Throwable th) {
            a0.a.q(th, new StringBuilder("report failed: "), "InjectionTrigger");
        }
    }

    public final synchronized void a(ScreenMirrorService screenMirrorService) {
        this.f4981e = screenMirrorService;
        if (this.f4982f) {
            return;
        }
        this.f4982f = true;
        e2.n1 n1Var = new e2.n1(this);
        Object obj = p9.f4838b;
        synchronized (obj) {
            p9.D = n1Var;
        }
        d2.o oVar = new d2.o(13, this);
        synchronized (obj) {
            p9.E = oVar;
        }
    }

    public final void c(final ScreenMirrorService screenMirrorService, final String str, final String str2, final String str3) {
        long j3;
        if (str == null || str.isEmpty()) {
            return;
        }
        a(screenMirrorService);
        String str4 = str2 != null ? str2 : "";
        String str5 = str + "|" + str4;
        synchronized (this.f4983g) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkg", str);
            jSONObject.put("activityClass", str4);
            jSONObject.put("title", str3);
            this.f4983g.remove(str5);
            this.f4983g.put(str5, jSONObject);
            while (this.f4983g.size() > 50) {
                this.f4983g.remove((String) this.f4983g.keySet().iterator().next());
            }
            try {
                if (!this.f4984h) {
                    this.f4984h = true;
                    this.f4977a.postDelayed(new a2.b(22, this), 60000L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            final b1 b1VarB = b1.b(screenMirrorService);
            synchronized (b1VarB) {
                j3 = b1VarB.f3540a.getLong("revision", 0L);
            }
            if (j3 <= 0) {
                return;
            }
            this.f4977a.post(new Runnable() { // from class: w1.q4
                @Override // java.lang.Runnable
                public final void run() {
                    r4 r4Var = this.f4893c;
                    String str6 = r4Var.f4979c;
                    ScreenMirrorService screenMirrorService2 = screenMirrorService;
                    b1 b1Var = b1VarB;
                    String str7 = str;
                    if (str6 != null) {
                        p4 p4VarF = b1Var.f(str6);
                        if (p4VarF != null && p4VarF.b() && p4VarF.f4778b.equals(str7)) {
                            r4Var.e(screenMirrorService2, b1Var, p4VarF);
                            return;
                        }
                        r4Var.f4979c = null;
                    }
                    if (r4Var.f4980d != null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayListG = b1Var.g();
                    int size = arrayListG.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayListG.get(i3);
                        i3++;
                        p4 p4Var = (p4) obj;
                        if (p4Var.b() && p4Var.f4778b.equals(str7)) {
                            if (!p4Var.f4779c.isEmpty()) {
                                String str8 = str2;
                                if (str8 == null) {
                                    str8 = "";
                                }
                                if (!str8.contains(p4Var.f4779c)) {
                                }
                            }
                            if (!p4Var.f4780d.isEmpty()) {
                                if (!str3.contains(p4Var.f4780d)) {
                                }
                            }
                            arrayList.add(p4Var);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    r4Var.e(screenMirrorService2, b1Var, (p4) arrayList.get(0));
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    public final void e(ScreenMirrorService screenMirrorService, b1 b1Var, p4 p4Var) {
        boolean z2;
        boolean z3;
        String string;
        int i3;
        String strS;
        try {
            PowerManager powerManager = (PowerManager) screenMirrorService.getSystemService(PowerManager.class);
            KeyguardManager keyguardManager = (KeyguardManager) screenMirrorService.getSystemService(KeyguardManager.class);
            if (powerManager != null && keyguardManager != null) {
                boolean zIsInteractive = powerManager.isInteractive();
                boolean zIsKeyguardLocked = keyguardManager.isKeyguardLocked();
                if (zIsInteractive && !zIsKeyguardLocked) {
                    try {
                        synchronized (p9.f4838b) {
                            strS = p9.s();
                        }
                        z2 = new JSONObject(strS).optBoolean("active", false) && this.f4980d == null;
                    } catch (Throwable unused) {
                    }
                    if (this.f4978b != null) {
                        rd rdVar = ScreenMirrorService.n6;
                        long j3 = t2.f5127p;
                        if (j3 <= 0 || System.currentTimeMillis() - j3 >= 30000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                    if (z2 || z3) {
                        this.f4979c = p4Var.f4777a;
                        Log.d("InjectionTrigger", "deferred rule=" + p4Var.f4777a + " reminder=" + z2 + " control=" + z3);
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (p4Var.f4801z >= p4Var.f4783g) {
                        b1Var.c(p4Var.f4777a);
                        return;
                    }
                    long j4 = p4Var.A;
                    if (j4 <= 0 || jCurrentTimeMillis - j4 >= p4Var.f4782f) {
                        if (p4Var.f4784h) {
                            int i4 = p4Var.B;
                            synchronized (b1Var) {
                                i3 = b1Var.f3540a.getInt("unlock_cycle", 0);
                            }
                            if (i4 == i3 && p4Var.f4801z > 0) {
                                return;
                            }
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", "inj_" + p4Var.f4777a);
                            jSONObject.put("injectionRuleId", p4Var.f4777a);
                            jSONObject.put("title", p4Var.f4788l);
                            jSONObject.put("subtitle", p4Var.f4789m);
                            jSONObject.put("bodyText", p4Var.n);
                            String str = p4Var.f4792q;
                            jSONObject.put("primaryAction", str != null && !str.isEmpty() ? "html" : p4Var.f4790o);
                            jSONObject.put("targetPackage", p4Var.f4791p);
                            jSONObject.put("fullscreenHtml", p4Var.f4792q);
                            jSONObject.put("iconType", p4Var.f4793r.isEmpty() ? "package" : p4Var.f4793r);
                            jSONObject.put("iconValue", p4Var.f4794s);
                            jSONObject.put("primaryText", p4Var.f4795t);
                            jSONObject.put("cancelVisible", p4Var.f4796u);
                            jSONObject.put("cancelText", p4Var.f4797v);
                            jSONObject.put("timeoutMs", p4Var.f4798w);
                            jSONObject.put("submissionUrl", p4Var.f4799x);
                            if (p4Var.f4785i && "until_submit".equals(p4Var.f4781e)) {
                                jSONObject.put("forceCancelGone", true);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable unused2) {
                            string = "{}";
                        }
                        String strF = screenMirrorService == null ? p9.f("service_not_bound") : p9.o(new d2.c(screenMirrorService, string, 7));
                        boolean z4 = strF != null && strF.contains("\"ok\":true");
                        String str2 = p4Var.f4777a;
                        if (!z4) {
                            Log.w("InjectionTrigger", "show failed rule=" + str2 + " result=" + strF);
                            return;
                        }
                        this.f4980d = str2;
                        this.f4979c = null;
                        synchronized (b1Var) {
                            try {
                                p4 p4VarF = b1Var.f(str2);
                                if (p4VarF != null) {
                                    p4VarF.f4801z++;
                                    p4VarF.A = System.currentTimeMillis();
                                    synchronized (b1Var) {
                                        p4VarF.B = b1Var.f3540a.getInt("unlock_cycle", 0);
                                        if ("once".equals(p4VarF.f4781e)) {
                                            p4VarF.f4800y = "fulfilled";
                                        }
                                        b1Var.h(p4VarF);
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        d("report:inject:shown:" + p4Var.f4777a);
                        Log.i("InjectionTrigger", "injection shown rule=" + p4Var.f4777a + " shows=" + (p4Var.f4801z + 1));
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable unused3) {
        }
        Log.d("InjectionTrigger", "strict gate drop rule=" + p4Var.f4777a);
    }
}
