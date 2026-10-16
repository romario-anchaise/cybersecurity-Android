// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l2;

import d2.y;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import m2.m;
import p2.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2413f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(y yVar, String str) {
        super(str, true);
        this.f2412e = 1;
        this.f2413f = yVar;
    }

    @Override // l2.a
    public final long a() {
        switch (this.f2412e) {
            case 0:
                ((p1.a) this.f2413f).d();
                return -1L;
            case 1:
                y yVar = (y) this.f2413f;
                long jNanoTime = System.nanoTime();
                int i3 = 0;
                long j3 = Long.MIN_VALUE;
                m mVar = null;
                int i4 = 0;
                for (m mVar2 : (ConcurrentLinkedQueue) yVar.f652b) {
                    mVar2.getClass();
                    synchronized (mVar2) {
                        if (yVar.g(mVar2, jNanoTime) > 0) {
                            i4++;
                        } else {
                            i3++;
                            long j4 = jNanoTime - mVar2.f2755q;
                            if (j4 > j3) {
                                mVar = mVar2;
                                j3 = j4;
                            }
                        }
                    }
                }
                long j5 = yVar.f653c;
                if (j3 < j5 && i3 <= 5) {
                    if (i3 > 0) {
                        return j5 - j3;
                    }
                    if (i4 > 0) {
                        return j5;
                    }
                    return -1L;
                }
                mVar.getClass();
                synchronized (mVar) {
                    if (!mVar.f2754p.isEmpty()) {
                        return 0L;
                    }
                    if (mVar.f2755q + j3 != jNanoTime) {
                        return 0L;
                    }
                    mVar.f2749j = true;
                    ((ConcurrentLinkedQueue) yVar.f652b).remove(mVar);
                    Socket socket = mVar.f2743d;
                    socket.getClass();
                    j2.b.e(socket);
                    if (!((ConcurrentLinkedQueue) yVar.f652b).isEmpty()) {
                        return 0L;
                    }
                    ((c) yVar.f654d).a();
                    return 0L;
                }
            default:
                n nVar = (n) this.f2413f;
                nVar.getClass();
                try {
                    nVar.f2946y.B(false, 2, 0);
                    return -1L;
                } catch (IOException e3) {
                    nVar.d(2, 2, e3);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, Object obj, int i3) {
        super(str, true);
        this.f2412e = i3;
        this.f2413f = obj;
    }
}
