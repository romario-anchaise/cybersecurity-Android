// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

/* JADX INFO: loaded from: classes.dex */
public final class u implements p022m0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f575b;

    public /* synthetic */ u(int i2, String str) {
        this.f574a = i2;
        this.f575b = str;
    }

    @Override // p022m0.o
    public Object o() {
        switch (this.f574a) {
            case 1:
                throw new p018k0.p(this.f575b);
            default:
                throw new p018k0.p(this.f575b);
        }
    }

    public String toString() {
        switch (this.f574a) {
            case 0:
                return "<" + this.f575b + '>';
            default:
                return super.toString();
        }
    }
}
