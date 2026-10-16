// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f1705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d2.o f1708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f1709e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1710f;

    public p0(u0 u0Var, String str, List list, d2.o oVar) {
        this.f1705a = u0Var;
        this.f1706b = str;
        this.f1708d = oVar;
        List<byte[]> arrayList = list == null ? Collections.EMPTY_LIST : new ArrayList(list);
        long length = 0;
        for (byte[] bArr : arrayList) {
            length += bArr == null ? 0L : bArr.length;
        }
        this.f1707c = Collections.unmodifiableList(arrayList);
        this.f1710f = length;
    }

    public final void a(boolean z2) {
        d2.o oVar = this.f1708d;
        if (oVar == null || !this.f1709e.compareAndSet(false, true)) {
            return;
        }
        try {
            oVar.b(z2);
        } catch (RuntimeException unused) {
        }
    }
}
