// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f1856g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a0 f1857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HandlerThread f1858i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1859a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile p0.e f1861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0.a f1862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1864f;

    public a0(Context context, Looper looper) {
        z zVar = new z(this);
        this.f1860b = context.getApplicationContext();
        p0.e eVar = new p0.e(looper, zVar);
        Looper.getMainLooper();
        this.f1861c = eVar;
        this.f1862d = k0.a.a();
        this.f1863e = 5000L;
        this.f1864f = 300000L;
    }

    public final e0.b a(x xVar, t tVar, String str) {
        e0.b bVarA;
        HashMap map = this.f1859a;
        synchronized (map) {
            try {
                y yVar = (y) map.get(xVar);
                if (yVar == null) {
                    yVar = new y(this, xVar);
                    yVar.f1938a.put(tVar, tVar);
                    bVarA = yVar.a(str, null);
                    map.put(xVar, yVar);
                } else {
                    this.f1861c.removeMessages(0, xVar);
                    if (yVar.f1938a.containsKey(tVar)) {
                        String string = xVar.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(string);
                        throw new IllegalStateException(sb.toString());
                    }
                    yVar.f1938a.put(tVar, tVar);
                    int i3 = yVar.f1939b;
                    if (i3 == 1) {
                        tVar.onServiceConnected(yVar.f1943f, yVar.f1941d);
                    } else if (i3 == 2) {
                        bVarA = yVar.a(str, null);
                    }
                    bVarA = null;
                }
                if (yVar.f1940c) {
                    return e0.b.f657h;
                }
                if (bVarA == null) {
                    bVarA = new e0.b(-1, null, null);
                }
                return bVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String str, ServiceConnection serviceConnection, boolean z2) {
        x xVar = new x(str, z2);
        o.d(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.f1859a;
        synchronized (map) {
            try {
                y yVar = (y) map.get(xVar);
                if (yVar == null) {
                    String string = xVar.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 50);
                    sb.append("Nonexistent connection status for service config: ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                if (!yVar.f1938a.containsKey(serviceConnection)) {
                    String string2 = xVar.toString();
                    StringBuilder sb2 = new StringBuilder(string2.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(string2);
                    throw new IllegalStateException(sb2.toString());
                }
                yVar.f1938a.remove(serviceConnection);
                if (yVar.f1938a.isEmpty()) {
                    this.f1861c.sendMessageDelayed(this.f1861c.obtainMessage(0, xVar), this.f1863e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
