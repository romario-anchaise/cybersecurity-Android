// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4902d;

    public final String a() {
        this.f4902d = false;
        this.f4899a = false;
        this.f4901c = false;
        this.f4900b = false;
        return "";
    }

    public final String b() {
        if (this.f4899a && !this.f4902d) {
            this.f4899a = false;
        }
        if (!this.f4899a && this.f4901c) {
            this.f4901c = false;
            this.f4900b = false;
        }
        return "";
    }
}
