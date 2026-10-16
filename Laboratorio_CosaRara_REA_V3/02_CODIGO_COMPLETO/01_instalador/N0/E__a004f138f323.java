// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: loaded from: classes.dex */
public final class E implements L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f387a;

    public E(boolean z2) {
        this.f387a = z2;
    }

    @Override // N0.L
    public final boolean a() {
        return this.f387a;
    }

    @Override // N0.L
    public final b0 b() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f387a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
