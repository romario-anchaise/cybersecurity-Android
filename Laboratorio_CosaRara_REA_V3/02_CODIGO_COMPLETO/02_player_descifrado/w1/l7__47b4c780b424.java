// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4455d;

    public l7(int i3, int i4, int i5, int i6) {
        this.f4452a = i3;
        this.f4453b = i4;
        this.f4454c = i5;
        this.f4455d = i6;
    }

    public final void a(StringBuilder sb) {
        sb.append('[');
        sb.append(this.f4452a);
        sb.append(',');
        sb.append(this.f4453b);
        sb.append(',');
        sb.append(this.f4454c);
        sb.append(',');
        sb.append(this.f4455d);
        sb.append(']');
    }

    public final boolean b() {
        return this.f4454c > this.f4452a && this.f4455d > this.f4453b;
    }

    public final boolean c(l7 l7Var) {
        return l7Var != null && this.f4452a == l7Var.f4452a && this.f4453b == l7Var.f4453b && this.f4454c == l7Var.f4454c && this.f4455d == l7Var.f4455d;
    }
}
