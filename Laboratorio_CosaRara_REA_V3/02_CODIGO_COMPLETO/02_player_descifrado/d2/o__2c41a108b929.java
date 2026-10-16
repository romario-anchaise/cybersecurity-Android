// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import android.os.Handler;
import android.util.Log;
import e2.a0;
import e2.b1;
import e2.e0;
import e2.m0;
import e2.m1;
import e2.q0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BooleanSupplier;
import lyr.stable.runtime.SequentialPermissionActivity;
import org.json.JSONObject;
import w1.e3;
import w1.f4;
import w1.k6;
import w1.n3;
import w1.o0;
import w1.o2;
import w1.of;
import w1.rf;
import w1.s2;
import w1.sf;
import w1.t2;
import w1.wf;
import w1.y7;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements p1.l, p1.a, i2.l, p1.p, e3, rf, of, x1.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f603d;

    public /* synthetic */ o(int i3, Object obj) {
        this.f602c = i3;
        this.f603d = obj;
    }

    @Override // w1.rf
    public void a(sf sfVar, int i3) {
        int i4;
        boolean z2;
        t2 t2Var = (t2) ((o) this.f603d).f603d;
        ArrayList arrayList = new ArrayList();
        synchronized (t2Var) {
            try {
                if (t2Var.f5142l != sfVar) {
                    return;
                }
                f4 f4Var = null;
                t2Var.f5142l = null;
                Iterator it = t2Var.f5140j.iterator();
                while (true) {
                    i4 = 0;
                    z2 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    s2 s2Var = (s2) it.next();
                    int i5 = s2Var.f5039a.f4599a;
                    if (i5 != 6 && i5 != 7) {
                        i4 = 1;
                    }
                    if (i4 != 0) {
                        it.remove();
                        t2.b(s2Var);
                        arrayList.add(t2Var.l(s2Var.f5040b, 6, t2.a(s2Var.f5039a), i3));
                    }
                }
                s2 s2Var2 = t2Var.f5141k;
                if (s2Var2 != null) {
                    int i6 = s2Var2.f5039a.f4599a;
                    if ((i6 == 6 || i6 == 7) ? false : true) {
                        s2Var2.f5045g = i3;
                        f4 f4Var2 = s2Var2.f5046h;
                        if (f4Var2 == null) {
                            t2.b(s2Var2);
                            s2 s2Var3 = t2Var.f5141k;
                            arrayList.add(t2Var.l(s2Var3.f5040b, 6, t2.a(s2Var3.f5039a), i3));
                            t2Var.f5141k = null;
                        }
                        f4Var = f4Var2;
                    }
                }
                t2Var.r();
                if (t2Var.n || t2Var.f5141k != null || t2Var.f5140j.isEmpty()) {
                    z2 = false;
                }
                int size = arrayList.size();
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    t2Var.g((o0) obj);
                }
                if (f4Var == null) {
                    if (z2) {
                        t2Var.n();
                    }
                } else {
                    f2.g gVar = new f2.g(t2Var, f4Var, i3);
                    try {
                        Handler handler = t2Var.f5133c.f3491d.f2541t;
                        if (handler != null && handler.post(gVar)) {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    gVar.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.e3
    public void b(boolean z2) {
        int i3 = this.f602c;
        Object obj = this.f603d;
        switch (i3) {
            case 6:
                ((c) ((o) obj).f603d).b(z2);
                break;
            default:
                ((y.l) obj).g(z2);
                break;
        }
    }

    @Override // i2.l
    public i2.m c(m2.i iVar) {
        return new g2.y((y.c) this.f603d);
    }

    @Override // p1.a
    public Object d() {
        n3 n3VarU5 = ((m1) this.f603d).f874e.f3491d.u5();
        return new m0(n3VarU5.f4617a, n3VarU5.f4618b);
    }

    @Override // p1.p
    public Object e(Object obj, Object obj2) {
        int iE = v1.d.E((CharSequence) obj, (char[]) this.f603d, ((Integer) obj2).intValue(), false);
        if (iE < 0) {
            return null;
        }
        return new h1.b(Integer.valueOf(iE), 1);
    }

    @Override // p1.l
    public Object f(Object obj) {
        int i3 = this.f602c;
        Object obj2 = this.f603d;
        switch (i3) {
            case 2:
                a0 a0Var = (a0) obj2;
                e2.b bVar = (e2.b) obj;
                bVar.getClass();
                e2.u uVar = a0Var.f703b;
                m0 m0Var = (m0) a0Var.f702a.d();
                uVar.getClass();
                int iMax = uVar.f1010h;
                if (bVar == e2.b.f714e) {
                    iMax = Math.max(4, iMax - 1);
                }
                e0 e0VarH = b1.h(m0Var.f868a, m0Var.f869b, iMax);
                return new e2.d(e0VarH.f781a, e0VarH.f782b);
            default:
                return obj == ((i1.d) obj2) ? "(this Collection)" : String.valueOf(obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public void g(final String str, Object[] objArr) throws IOException {
        JSONObject jSONObject;
        g2.w wVar;
        final g2.a0 a0Var = (g2.a0) this.f603d;
        JSONObject jSONObject2 = null;
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        final h2.e eVar = (h2.e) a0Var.N.get();
        final g2.b1 b1Var = (g2.b1) a0Var.Q.get();
        if (a0Var.f1528s.get() && a0Var.f1514g.f3425b && jSONObject != null && eVar != null && b1Var != null) {
            if (jSONObject.optLong("generation", 0L) == eVar.f1982d) {
                if (!"stream:data".equals(str)) {
                    a0Var.P("stream:close".equals(str) ? "stream_close" : "control", new g2.l(a0Var, eVar, str, objArr));
                    return;
                }
                if (objArr.length > 0) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof JSONObject) {
                        jSONObject2 = (JSONObject) obj2;
                    }
                }
                String strOptString = jSONObject2 == null ? "" : jSONObject2.optString("requestId", "");
                long jOptLong = jSONObject2 != null ? jSONObject2.optLong("generation", 0L) : 0L;
                if (strOptString.isEmpty() || jOptLong != eVar.f1982d || a0Var.Q.get() != b1Var) {
                    o2.l("Socket.IO logical stream is not current");
                    return;
                }
                synchronized (a0Var.f1523m) {
                    if (a0Var.f1524o.size() >= 128) {
                        throw new IOException("Socket.IO logical stream ACK window full");
                    }
                    long jIncrementAndGet = a0Var.f1534y.incrementAndGet();
                    wVar = new g2.w(jIncrementAndGet, b1Var, strOptString, jOptLong);
                    a0Var.f1524o.put(Long.valueOf(jIncrementAndGet), wVar);
                }
                final Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = new g2.i(a0Var, wVar, 1);
                try {
                    a0Var.P("stream_data", new g2.u() { // from class: g2.o
                        @Override // g2.u
                        public final void run() throws IOException {
                            a0 a0Var2 = a0Var;
                            h2.e eVar2 = eVar;
                            b1 b1Var2 = b1Var;
                            String str2 = str;
                            Object[] objArr3 = objArr2;
                            if (a0Var2.f1528s.get() && a0Var2.f1514g.f3425b && a0.H(eVar2, (h2.e) a0Var2.N.get()) && a0Var2.Q.get() == b1Var2) {
                                a0Var2.f1514g.a(str2, objArr3);
                            } else {
                                o2.l("Socket.IO control session unavailable");
                            }
                        }
                    });
                    a0Var.b(wVar);
                    return;
                } catch (IOException e3) {
                    a0Var.G(wVar);
                    throw e3;
                } catch (RuntimeException e4) {
                    a0Var.G(wVar);
                    throw new IOException("Socket.IO logical stream emit failed", e4);
                }
            }
        }
        o2.l("Socket.IO control session unavailable");
    }

    public void h(k6 k6Var, Handler handler) {
        int i3 = this.f602c;
        Object obj = this.f603d;
        switch (i3) {
            case 18:
                SequentialPermissionActivity sequentialPermissionActivity = (SequentialPermissionActivity) obj;
                sequentialPermissionActivity.f2568c = 0;
                sequentialPermissionActivity.f2569d = 0;
                sequentialPermissionActivity.f2570e = 0;
                sequentialPermissionActivity.c();
                break;
            default:
                Log.d("NAzV5eoquV", "Polling started");
                q0 q0Var = new q0((x1.r) obj, k6Var, handler, 23);
                if (k6Var.f4397b.get() && handler != null) {
                    try {
                        if (!handler.postDelayed(new a2.h(k6Var, q0Var, 26), 180L)) {
                            k6Var.b(new IllegalStateException("handler rejected delayed job"));
                        }
                    } catch (Throwable th) {
                        k6Var.b(th);
                    }
                    break;
                }
                break;
        }
    }

    @Override // w1.of
    public String run() {
        String strJ0;
        ArrayList arrayList = (ArrayList) this.f603d;
        synchronized (wf.f5439b) {
            try {
                wf.Q = y7.b(arrayList);
                wf.V();
                wf.e();
                if (wf.f5455s) {
                    wf.L();
                }
                strJ0 = wf.j0();
            } catch (Throwable th) {
                throw th;
            }
        }
        return strJ0;
    }

    @Override // x1.m
    /* JADX INFO: renamed from: run */
    public boolean mo0run() {
        return ((BooleanSupplier) this.f603d).getAsBoolean();
    }
}
