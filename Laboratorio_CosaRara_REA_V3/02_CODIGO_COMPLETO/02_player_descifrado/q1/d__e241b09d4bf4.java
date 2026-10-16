// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q1;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f3117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f3119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f3124j;

    public d(int i3, Object obj, Class cls, String str, String str2) {
        this.f3118d = obj;
        this.f3119e = cls;
        this.f3120f = str;
        this.f3121g = str2;
        this.f3122h = false;
        this.f3123i = i3;
        this.f3124j = 0;
    }

    public final b a() {
        boolean z2 = this.f3122h;
        Class cls = this.f3119e;
        if (z2) {
            j.f3130a.getClass();
            return new g(cls);
        }
        j.f3130a.getClass();
        return new c(cls);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f3120f.equals(dVar.f3120f) && this.f3121g.equals(dVar.f3121g) && this.f3124j == dVar.f3124j && this.f3123i == dVar.f3123i && e.a(this.f3118d, dVar.f3118d) && a().equals(dVar.a());
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar2 = this.f3117c;
        if (dVar2 == null) {
            j.f3130a.getClass();
            this.f3117c = this;
        } else {
            this = dVar2;
        }
        return obj.equals(this);
    }

    public final int hashCode() {
        a();
        return this.f3121g.hashCode() + a0.a.e(a().hashCode() * 31, 31, this.f3120f);
    }

    public final String toString() {
        d dVar = this.f3117c;
        if (dVar == null) {
            j.f3130a.getClass();
            this.f3117c = this;
            dVar = this;
        }
        if (dVar != this) {
            return dVar.toString();
        }
        String str = this.f3120f;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : a0.a.h("function ", str, " (Kotlin reflection is not available)");
    }

    public d(int i3, Class cls, String str, String str2) {
        this(i3, a.f3115c, cls, str, str2);
    }
}
