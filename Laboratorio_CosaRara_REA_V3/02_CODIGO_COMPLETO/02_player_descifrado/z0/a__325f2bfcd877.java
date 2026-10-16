// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import g0.j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f6281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f6282c;

    public /* synthetic */ a(int[] iArr, j jVar, int i3) {
        this.f6280a = i3;
        this.f6281b = iArr;
        this.f6282c = jVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f6280a) {
            case 0:
                b.f6283o.fine("pre-pause polling complete");
                int[] iArr = this.f6281b;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 == 0) {
                    this.f6282c.run();
                }
                break;
            default:
                b.f6283o.fine("pre-pause writing complete");
                int[] iArr2 = this.f6281b;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 == 0) {
                    this.f6282c.run();
                }
                break;
        }
    }
}
