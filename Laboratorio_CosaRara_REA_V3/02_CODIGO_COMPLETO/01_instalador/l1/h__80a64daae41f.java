// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import E0.p;
import F0.j;
import F0.l;
import F0.m;
import java.io.IOException;
import k1.C;

/* JADX INFO: loaded from: classes.dex */
public final class h extends j implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f3559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C f3560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f3561f;
    public final /* synthetic */ m g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(l lVar, long j2, m mVar, C c2, m mVar2, m mVar3) {
        super(2);
        this.f3557b = lVar;
        this.f3558c = j2;
        this.f3559d = mVar;
        this.f3560e = c2;
        this.f3561f = mVar2;
        this.g = mVar3;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 1) {
            l lVar = this.f3557b;
            if (lVar.f178a) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            lVar.f178a = true;
            if (jLongValue < this.f3558c) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            m mVar = this.f3559d;
            long jU = mVar.f179a;
            C c2 = this.f3560e;
            if (jU == 4294967295L) {
                jU = c2.u();
            }
            mVar.f179a = jU;
            m mVar2 = this.f3561f;
            mVar2.f179a = mVar2.f179a == 4294967295L ? c2.u() : 0L;
            m mVar3 = this.g;
            mVar3.f179a = mVar3.f179a == 4294967295L ? c2.u() : 0L;
        }
        return p034t0.h.f4132b;
    }
}
