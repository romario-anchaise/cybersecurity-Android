// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3641c;

    public /* synthetic */ c(int i3, int i4, long j3) {
        this.f3639a = i4;
        this.f3640b = i3;
        this.f3641c = j3;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    @Override // w1.d
    public final e a(e eVar) {
        long j3;
        switch (this.f3639a) {
            case 0:
                int i3 = eVar.f3826d;
                if (i3 <= 0 || i3 == this.f3640b) {
                    return new e(true, false, eVar.f3825c, 0, eVar.f3827e, this.f3641c, eVar.f3829g, eVar.f3830h, eVar.f3831i);
                }
                return eVar;
            case 1:
                long j4 = eVar.f3825c;
                long jMax = j4 != Long.MAX_VALUE ? Math.max(1L, j4 + 1) : 1L;
                int i4 = eVar.f3830h;
                long j5 = eVar.f3831i;
                int i5 = this.f3640b;
                long j6 = this.f3641c;
                return new e(true, true, jMax, i5, j6, j6, 0L, i4, j5);
            default:
                long jMax2 = eVar.f3825c;
                int i6 = eVar.f3826d;
                boolean z2 = eVar.f3824b;
                int i7 = this.f3640b;
                if (!z2 || i6 != i7) {
                    jMax2 = jMax2 == Long.MAX_VALUE ? 1L : Math.max(1L, jMax2 + 1);
                }
                long j7 = jMax2;
                long j8 = this.f3641c;
                if (i6 == i7) {
                    long j9 = eVar.f3828f;
                    if (j9 > 0) {
                        j3 = j9;
                    } else {
                        j3 = j8;
                    }
                } else {
                    j3 = j8;
                }
                return new e(true, true, j7, i7, j8, j3, 0L, eVar.f3830h, eVar.f3831i);
        }
    }
}
