// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f6244a;

    public f(WorkDatabase workDatabase, int i3) {
        switch (i3) {
            case 1:
                this.f6244a = workDatabase;
                break;
            default:
                workDatabase.getClass();
                this.f6244a = workDatabase;
                break;
        }
    }
}
