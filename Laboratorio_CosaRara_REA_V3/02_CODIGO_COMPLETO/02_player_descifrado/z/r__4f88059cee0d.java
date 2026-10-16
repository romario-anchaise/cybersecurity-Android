// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y.r f6270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q.h f6271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.p f6272c;

    static {
        p.m.f("WMFgUpdater");
    }

    public r(WorkDatabase workDatabase, q.h hVar, y.r rVar) {
        this.f6271b = hVar;
        this.f6270a = rVar;
        this.f6272c = workDatabase.t();
    }
}
