// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends c implements f, K0.a {
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f174h;

    public g(int i2, Class cls, String str, String str2, int i3) {
        super(b.f164a, cls, str, str2, (i3 & 1) == 1);
        this.g = i2;
        this.f174h = 0;
    }

    public final K0.a d() {
        o.f181a.getClass();
        return this;
    }

    @Override // F0.f
    public final int e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f168d.equals(gVar.f168d) && this.f169e.equals(gVar.f169e) && this.f174h == gVar.f174h && this.g == gVar.g && this.f166b.equals(gVar.f166b) && b().equals(gVar.b());
        }
        if (!(obj instanceof g)) {
            return false;
        }
        K0.a aVar = this.f165a;
        if (aVar == null) {
            d();
            this.f165a = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    public final int hashCode() {
        b();
        return this.f169e.hashCode() + ((this.f168d.hashCode() + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        K0.a aVar = this.f165a;
        if (aVar == null) {
            d();
            this.f165a = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f168d;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : h.e("function ", str, " (Kotlin reflection is not available)");
    }
}
