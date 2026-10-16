// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6296c = new a(3, i.f6328a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f6298b;

    public a(int i3, i iVar) {
        if (i3 < 1) {
            o2.i("cleanScansToStop < 1");
            throw null;
        }
        if (iVar == null) {
            o2.i("scanLimits == null");
            throw null;
        }
        this.f6297a = i3;
        this.f6298b = iVar;
    }
}
