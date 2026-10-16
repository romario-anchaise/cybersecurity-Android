// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import X0.C0054a;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.c f2165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.b f2166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2167d;

    public n(a1.d dVar, TimeUnit timeUnit) {
        F0.i.e(dVar, "taskRunner");
        this.f2164a = timeUnit.toNanos(5L);
        this.f2165b = dVar.e();
        this.f2166c = new a1.b(this, Y0.b.g + " ConnectionPool");
        this.f2167d = new ConcurrentLinkedQueue();
    }

    public final boolean a(C0054a c0054a, j jVar, ArrayList arrayList, boolean z2) {
        F0.i.e(jVar, "call");
        Iterator it = this.f2167d.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            m mVar = (m) it.next();
            F0.i.d(mVar, "connection");
            synchronized (mVar) {
                if (z2) {
                    if (!(mVar.g != null)) {
                        continue;
                    }
                }
                if (mVar.h(c0054a, arrayList)) {
                    jVar.c(mVar);
                    return true;
                }
            }
        }
    }

    public final int b(m mVar, long j2) {
        byte[] bArr = Y0.b.f1119a;
        ArrayList arrayList = mVar.f2162p;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                String str = "A connection to " + mVar.f2149b.f926a.f941h + " was leaked. Did you forget to close a response body?";
                f1.n nVar = f1.n.f2736a;
                f1.n.f2736a.j(((h) reference).f2129a, str);
                arrayList.remove(i2);
                mVar.f2156j = true;
                if (arrayList.isEmpty()) {
                    mVar.f2163q = j2 - this.f2164a;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
