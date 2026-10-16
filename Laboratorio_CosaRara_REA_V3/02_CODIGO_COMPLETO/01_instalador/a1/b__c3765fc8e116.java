// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a1;

import F0.i;
import b1.m;
import b1.n;
import e1.k;
import e1.o;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1228f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, Object obj, int i2) {
        super(str, true);
        this.f1227e = i2;
        this.f1228f = obj;
    }

    @Override // a1.a
    public final long a() {
        switch (this.f1227e) {
            case 0:
                ((k) this.f1228f).a();
                return -1L;
            case 1:
                n nVar = (n) this.f1228f;
                long jNanoTime = System.nanoTime();
                int i2 = 0;
                long j2 = Long.MIN_VALUE;
                m mVar = null;
                int i3 = 0;
                for (m mVar2 : nVar.f2167d) {
                    i.d(mVar2, "connection");
                    synchronized (mVar2) {
                        if (nVar.b(mVar2, jNanoTime) > 0) {
                            i3++;
                        } else {
                            i2++;
                            long j3 = jNanoTime - mVar2.f2163q;
                            if (j3 > j2) {
                                mVar = mVar2;
                                j2 = j3;
                            }
                        }
                    }
                }
                long j4 = nVar.f2164a;
                if (j2 < j4 && i2 <= 5) {
                    if (i2 > 0) {
                        return j4 - j2;
                    }
                    if (i3 > 0) {
                        return j4;
                    }
                    return -1L;
                }
                i.b(mVar);
                synchronized (mVar) {
                    if (!mVar.f2162p.isEmpty()) {
                        return 0L;
                    }
                    if (mVar.f2163q + j2 != jNanoTime) {
                        return 0L;
                    }
                    mVar.f2156j = true;
                    nVar.f2167d.remove(mVar);
                    Socket socket = mVar.f2151d;
                    i.b(socket);
                    Y0.b.e(socket);
                    if (!nVar.f2167d.isEmpty()) {
                        return 0L;
                    }
                    nVar.f2165b.a();
                    return 0L;
                }
            default:
                o oVar = (o) this.f1228f;
                oVar.getClass();
                try {
                    oVar.f2341w.t(2, 0, false);
                    return -1L;
                } catch (IOException e2) {
                    oVar.a(2, 2, e2);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar, String str) {
        super(str, true);
        this.f1227e = 1;
        this.f1228f = nVar;
    }
}
