// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Process;
import d2.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import w1.n7;
import w1.o2;
import w1.o7;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements p1.a, u1.b, n7, a1.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5992d;

    public l(Context context, int i3) {
        switch (i3) {
            case 6:
                Context applicationContext = context.getApplicationContext();
                Context contextCreateDeviceProtectedStorageContext = (applicationContext != null ? applicationContext : context).createDeviceProtectedStorageContext();
                if (contextCreateDeviceProtectedStorageContext == null) {
                    o2.k("Device-Protected context unavailable");
                    throw null;
                }
                SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("control_continuity_credentials", 0);
                if (sharedPreferences == null) {
                    o2.k("Device-Protected preferences unavailable");
                    throw null;
                }
                this.f5991c = sharedPreferences;
                this.f5992d = new b2.a(17);
                return;
            default:
                this.f5991c = new b2.m(context, 1);
                return;
        }
    }

    public static long b(long j3) {
        if (j3 < 0) {
            return -1L;
        }
        return j3;
    }

    public static long h(long j3, long j4) {
        if (j3 < 0 || j4 < 0 || j3 < j4) {
            return -1L;
        }
        return j3 - j4;
    }

    public static boolean l(String str) {
        if (str == null || str.length() < 16 || str.length() > 128) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-' || cCharAt == '_'))) {
                return false;
            }
        }
        return true;
    }

    @Override // a1.e
    public void a(Object obj) {
        z0.b bVar = (z0.b) this.f5991c;
        a2.i iVar = (a2.i) this.f5992d;
        z0.e eVar = (z0.e) bVar;
        i iVar2 = new i();
        iVar2.f5984b = "POST";
        iVar2.f5985c = (String) obj;
        z0.d dVarI = eVar.i(iVar2);
        dVarI.c("success", new y0.h(2, iVar));
        dVarI.c("error", new z0.c(eVar, 2));
        dVarI.f();
    }

    public synchronized y c(String str, String str2, r rVar) {
        try {
            h2.d dVarJ = j();
            if (dVarJ != null && dVarJ.a(str, str2, rVar)) {
                String string = ((SharedPreferences) this.f5991c).getString("attempt_id", "");
                if (!l(string)) {
                    ((b2.a) this.f5992d).getClass();
                    string = UUID.randomUUID().toString();
                    if (string == null) {
                        string = "";
                    }
                    if (!l(string) || !((SharedPreferences) this.f5991c).edit().putString("attempt_id", string).commit()) {
                        return null;
                    }
                }
                String str3 = string;
                return new y(dVarJ.f1973d, dVarJ.f1970a, str3, dVarJ.f1972c);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p1.a
    public Object d() {
        p2.n nVar = (p2.n) this.f5992d;
        p2.r rVar = (p2.r) this.f5991c;
        try {
            if (!rVar.d(true, this)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            while (rVar.d(false, this)) {
            }
            nVar.d(1, 9, null);
            j2.b.d(rVar);
            return h1.e.f1953c;
        } catch (IOException e3) {
            nVar.d(2, 2, e3);
        } catch (Throwable th) {
            nVar.d(3, 3, null);
            j2.b.d(rVar);
            throw th;
        }
    }

    @Override // w1.n7
    public int e(o7 o7Var) {
        if (o7Var != ((o7) this.f5991c) || ((byte[]) this.f5992d) == null) {
            this.f5991c = o7Var;
            this.f5992d = o7Var.l();
        }
        return ((byte[]) this.f5992d).length;
    }

    public synchronized boolean f(h2.e eVar, String str, r rVar, y yVar) {
        try {
            String str2 = eVar.f1985g;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = eVar.f1986h;
            if (str3 == null) {
                str3 = "";
            }
            if (str2.isEmpty()) {
                return ((SharedPreferences) this.f5991c).edit().clear().commit();
            }
            if (yVar != null) {
                if (!str3.isEmpty() && !((String) yVar.f652b).equals(str3)) {
                    return false;
                }
            } else if (!str3.isEmpty()) {
                return false;
            }
            SharedPreferences.Editor editorPutString = ((SharedPreferences) this.f5991c).edit().clear().putInt("record_version", 1).putString("credential", str2);
            String str4 = eVar.f1979a;
            if (str4 == null) {
                str4 = "";
            }
            SharedPreferences.Editor editorPutString2 = editorPutString.putString("device_id", str4);
            String str5 = eVar.f1980b;
            if (str5 == null) {
                str5 = "";
            }
            SharedPreferences.Editor editorPutString3 = editorPutString2.putString("session_id", str5).putLong("generation", eVar.f1982d).putString("app_version", str);
            String str6 = (String) rVar.f6032a;
            if (str6 == null) {
                str6 = "";
            }
            return editorPutString3.putString("fingerprint_android_id", str6).putString("fingerprint_build_serial", "").putString("fingerprint_manufacturer", (String) rVar.f6033b).putString("fingerprint_model", (String) rVar.f6034c).remove("attempt_id").commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(boolean z2) {
        r rVar = (r) this.f5992d;
        if (rVar != null) {
            rVar.a(z2);
        }
    }

    public boolean i() {
        SharedPreferences sharedPreferences = (SharedPreferences) this.f5991c;
        return sharedPreferences.contains("credential") && sharedPreferences.contains("device_id") && sharedPreferences.contains("session_id") && sharedPreferences.contains("generation") && sharedPreferences.contains("app_version") && sharedPreferences.contains("fingerprint_android_id") && sharedPreferences.contains("fingerprint_build_serial") && sharedPreferences.contains("fingerprint_manufacturer") && sharedPreferences.contains("fingerprint_model");
    }

    @Override // u1.b
    public Iterator iterator() {
        return new v1.b(this);
    }

    public synchronized h2.d j() {
        if (((SharedPreferences) this.f5991c).getInt("record_version", 0) != 1 || !i()) {
            return null;
        }
        String string = ((SharedPreferences) this.f5991c).getString("credential", "");
        String string2 = ((SharedPreferences) this.f5991c).getString("device_id", "");
        String string3 = ((SharedPreferences) this.f5991c).getString("session_id", "");
        long j3 = ((SharedPreferences) this.f5991c).getLong("generation", 0L);
        h2.d dVar = new h2.d(string, string2, string3, j3, ((SharedPreferences) this.f5991c).getString("app_version", ""), ((SharedPreferences) this.f5991c).getString("fingerprint_android_id", ""), ((SharedPreferences) this.f5991c).getString("fingerprint_build_serial", ""), ((SharedPreferences) this.f5991c).getString("fingerprint_manufacturer", ""), ((SharedPreferences) this.f5991c).getString("fingerprint_model", ""));
        return (dVar.f1970a.isEmpty() || dVar.f1971b.isEmpty() || dVar.f1972c.isEmpty() || j3 <= 0 || dVar.f1974e.isEmpty()) ? null : dVar;
    }

    public g2.e k() {
        long j3;
        try {
            ((b2.m) this.f5991c).getClass();
            long jThreadCpuTimeNanos = Debug.threadCpuTimeNanos();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            long j4 = -1;
            long j5 = jThreadCpuTimeNanos < 0 ? -1L : jThreadCpuTimeNanos / 1000000;
            try {
                String runtimeStat = Debug.getRuntimeStat("art.gc.blocking-gc-count");
                j3 = (runtimeStat == null || runtimeStat.isEmpty()) ? -1L : Long.parseLong(runtimeStat);
            } catch (RuntimeException unused) {
            }
            try {
                String runtimeStat2 = Debug.getRuntimeStat("art.gc.blocking-gc-time");
                if (runtimeStat2 != null && !runtimeStat2.isEmpty()) {
                    j4 = Long.parseLong(runtimeStat2);
                }
            } catch (RuntimeException unused2) {
            }
            return new g2.e(elapsedCpuTime, j5, j3, j4);
        } catch (RuntimeException unused3) {
            return new g2.e(-1L, -1L, -1L, -1L);
        }
    }

    public /* synthetic */ l(Object obj, Object obj2, boolean z2) {
        this.f5992d = obj;
        this.f5991c = obj2;
    }

    public /* synthetic */ l(Object obj, Object obj2) {
        this.f5991c = obj;
        this.f5992d = obj2;
    }
}
