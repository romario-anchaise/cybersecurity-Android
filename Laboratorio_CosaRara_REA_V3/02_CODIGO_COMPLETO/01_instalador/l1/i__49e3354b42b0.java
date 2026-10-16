// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import E0.p;
import F0.j;
import F0.n;
import java.io.IOException;
import k1.C;

/* JADX INFO: loaded from: classes.dex */
public final class i extends j implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C f3562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f3563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f3564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n f3565e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(C c2, n nVar, n nVar2, n nVar3) {
        super(2);
        this.f3562b = c2;
        this.f3563c = nVar;
        this.f3564d = nVar2;
        this.f3565e = nVar3;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 21589) {
            if (jLongValue < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            C c2 = this.f3562b;
            byte bJ = c2.j();
            boolean z2 = (bJ & 1) == 1;
            boolean z3 = (bJ & 2) == 2;
            boolean z4 = (bJ & 4) == 4;
            long j2 = z2 ? 5L : 1L;
            if (z3) {
                j2 += 4;
            }
            if (z4) {
                j2 += 4;
            }
            if (jLongValue < j2) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z2) {
                this.f3563c.f180a = Long.valueOf(((long) c2.t()) * 1000);
            }
            if (z3) {
                this.f3564d.f180a = Long.valueOf(((long) c2.t()) * 1000);
            }
            if (z4) {
                this.f3565e.f180a = Long.valueOf(((long) c2.t()) * 1000);
            }
        }
        return p034t0.h.f4132b;
    }
}
