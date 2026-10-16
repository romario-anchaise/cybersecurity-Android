// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f2910g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, Object obj, Object obj2, int i3) {
        super(str, true);
        this.f2908e = i3;
        this.f2909f = obj;
        this.f2910g = obj2;
    }

    @Override // l2.a
    public final long a() {
        long jA;
        v[] vVarArr;
        switch (this.f2908e) {
            case 0:
                n nVar = (n) this.f2909f;
                nVar.f2925c.a(nVar, (a0) ((q1.i) this.f2910g).f3129d);
                return -1L;
            case 1:
                try {
                    ((n) this.f2909f).f2925c.b((v) this.f2910g);
                    break;
                } catch (IOException e3) {
                    q2.m mVar = q2.m.f3156a;
                    q2.m mVar2 = q2.m.f3156a;
                    String str = "Http2Connection.Listener failure for " + ((n) this.f2909f).f2927e;
                    mVar2.getClass();
                    q2.m.g(str, 4, e3);
                    try {
                        ((v) this.f2910g).c(2, e3);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return -1L;
            default:
                y.l lVar = (y.l) this.f2909f;
                a0 a0Var = (a0) this.f2910g;
                int i3 = 0;
                q1.i iVar = new q1.i(0);
                n nVar2 = (n) lVar.f5992d;
                synchronized (nVar2.f2946y) {
                    try {
                        synchronized (nVar2) {
                            try {
                                a0 a0Var2 = nVar2.f2940s;
                                a0 a0Var3 = new a0();
                                a0Var2.getClass();
                                for (int i4 = 0; i4 < 10; i4++) {
                                    if (((1 << i4) & a0Var2.f2874a) != 0) {
                                        a0Var3.b(i4, ((int[]) a0Var2.f2875b)[i4]);
                                    }
                                }
                                for (int i5 = 0; i5 < 10; i5++) {
                                    if (((1 << i5) & a0Var.f2874a) != 0) {
                                        a0Var3.b(i5, ((int[]) a0Var.f2875b)[i5]);
                                    }
                                }
                                iVar.f3129d = a0Var3;
                                jA = ((long) a0Var3.a()) - ((long) a0Var2.a());
                                vVarArr = (jA == 0 || nVar2.f2926d.isEmpty()) ? null : (v[]) nVar2.f2926d.values().toArray(new v[0]);
                                a0 a0Var4 = (a0) iVar.f3129d;
                                a0Var4.getClass();
                                nVar2.f2940s = a0Var4;
                                nVar2.f2934l.c(new i(nVar2.f2927e + " onSettings", nVar2, iVar, i3), 0L);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        try {
                            nVar2.f2946y.d((a0) iVar.f3129d);
                        } catch (IOException e4) {
                            nVar2.d(2, 2, e4);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                if (vVarArr != null) {
                    int length = vVarArr.length;
                    while (i3 < length) {
                        v vVar = vVarArr[i3];
                        synchronized (vVar) {
                            vVar.f2982f += jA;
                            if (jA > 0) {
                                vVar.notifyAll();
                            }
                            break;
                        }
                        i3++;
                    }
                }
                return -1L;
        }
    }
}
