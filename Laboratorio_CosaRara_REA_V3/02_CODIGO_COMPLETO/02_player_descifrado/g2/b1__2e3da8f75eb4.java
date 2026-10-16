// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1545a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1546b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f1547c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d2.o f1549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1550f;

    public b1(long j3, d2.o oVar) {
        if (j3 <= 0) {
            o2.i("generation");
            throw null;
        }
        this.f1548d = j3;
        this.f1549e = oVar;
    }

    public static boolean e(int i3) {
        return i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 8 || i3 == 11 || i3 == 255;
    }

    public static JSONObject g(String str, long j3) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("version", 1);
            if (str == null) {
                str = "";
            }
            return jSONObjectPut.put("requestId", str).put("generation", j3);
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static JSONObject i(long j3, String str, String str2, String str3) {
        JSONObject jSONObjectG = g(str, j3);
        try {
            jSONObjectG.put("ok", false);
            JSONObject jSONObjectPut = new JSONObject().put("code", str2);
            if (str3 == null) {
                str3 = "logical stream rejected";
            }
            jSONObjectG.put("error", jSONObjectPut.put("message", str3));
            return jSONObjectG;
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static int k(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if (!(objOpt instanceof Number)) {
            o2.l(str.concat(" must be an integer"));
            return 0;
        }
        Number number = (Number) objOpt;
        long jLongValue = number.longValue();
        if (jLongValue >= -2147483648L && jLongValue <= 2147483647L && number.doubleValue() == jLongValue) {
            return (int) jLongValue;
        }
        o2.l(str.concat(" must be an integer"));
        return 0;
    }

    public static long l(JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt("generation");
        if (!(objOpt instanceof Number)) {
            o2.l("generation must be an integer");
            return 0L;
        }
        Number number = (Number) objOpt;
        long jLongValue = number.longValue();
        if (number.doubleValue() == jLongValue) {
            return jLongValue;
        }
        o2.l("generation must be an integer");
        return 0L;
    }

    public static String m(JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt("requestId");
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        o2.l("requestId must be a string");
        return null;
    }

    public final void a(IOException iOException) {
        synchronized (this.f1545a) {
            try {
                if (this.f1550f) {
                    return;
                }
                this.f1550f = true;
                ArrayList arrayList = new ArrayList(this.f1546b.values());
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((d0) obj).d(iOException, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(long j3, String str, String str2) {
        if (j3 != this.f1548d) {
            return;
        }
        JSONObject jSONObjectG = g(str, j3);
        try {
            if (!str2.isEmpty()) {
                if (str2.length() > 256) {
                    str2 = str2.substring(0, 256);
                }
                jSONObjectG.put("reason", str2);
            }
            this.f1549e.g("stream:close", new Object[]{jSONObjectG});
        } catch (IOException | JSONException unused) {
        }
    }

    public final void c(String str, long j3, byte[] bArr) throws IOException {
        if (j3 != this.f1548d || !q2.c.s(bArr.length)) {
            o2.l("invalid logical stream data");
        } else {
            this.f1549e.g("stream:data", new Object[]{g(str, j3), bArr});
        }
    }

    public final void d(String str, long j3, IOException iOException) {
        d0 d0VarF;
        if (j3 == this.f1548d && (d0VarF = f(str)) != null && d0VarF.f1573f == j3) {
            d0VarF.d(iOException, true);
        }
    }

    public final d0 f(String str) {
        d0 d0Var;
        synchronized (this.f1545a) {
            d0Var = (d0) this.f1546b.get(str);
        }
        return d0Var;
    }

    public final a1 h(JSONObject jSONObject, boolean z2) throws IOException {
        int iK = k("version", jSONObject);
        String strM = m(jSONObject);
        long jL = l(jSONObject);
        int iK2 = z2 ? k("channel", jSONObject) : -1;
        if (iK != 1) {
            o2.l("unsupported logical stream version");
            return null;
        }
        boolean zEquals = false;
        if (!strM.isEmpty() && strM.length() <= 128) {
            try {
                zEquals = UUID.fromString(strM).toString().equals(strM.toLowerCase(Locale.ROOT));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (!zEquals) {
            o2.l("invalid logical stream requestId");
            return null;
        }
        if (jL == this.f1548d) {
            return new a1(iK2, jL, strM);
        }
        o2.l("logical stream generation mismatch");
        return null;
    }

    public final void j(d0 d0Var, String str) {
        synchronized (this.f1545a) {
            try {
                if (this.f1546b.get(str) == d0Var) {
                    this.f1546b.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(y.e eVar, JSONObject jSONObject) throws IOException {
        d0 d0Var = (d0) eVar.f5977d;
        if (jSONObject == null) {
            o2.l("logical stream open ack missing");
            return;
        }
        int iK = k("version", jSONObject);
        String strM = m(jSONObject);
        long jL = l(jSONObject);
        Object objOpt = jSONObject.opt("ok");
        if (iK != 1 || !d0Var.f1571d.equals(strM) || jL != this.f1548d || !(objOpt instanceof Boolean)) {
            o2.l("invalid logical stream open ack");
            return;
        }
        if (((Boolean) objOpt).booleanValue()) {
            if (f(strM) == d0Var) {
                return;
            }
            o2.l("logical stream closed before open ack");
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("error");
        throw new IOException("logical stream open rejected: " + (jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("code", "rejected") : "rejected") + ": " + (jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("message", "logical stream rejected") : "logical stream rejected"));
    }
}
