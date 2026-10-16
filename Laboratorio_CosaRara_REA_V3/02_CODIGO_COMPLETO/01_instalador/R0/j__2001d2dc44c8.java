// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.AbstractC0049v;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j extends F0.c implements E0.a, K0.a {
    public final boolean g;

    public j(k kVar) {
        super(kVar, AbstractC0049v.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.g = false;
    }

    @Override // E0.a
    public final Object a() {
        return this.f166b.getClass().getSimpleName();
    }

    public final K0.a d() {
        if (!this.g) {
            K0.a aVar = this.f165a;
            if (aVar != null) {
                return aVar;
            }
            F0.o.f181a.getClass();
            this.f165a = this;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return b().equals(jVar.b()) && this.f168d.equals(jVar.f168d) && this.f169e.equals(jVar.f169e) && this.f166b.equals(jVar.f166b);
        }
        if (obj instanceof j) {
            return obj.equals(d());
        }
        return false;
    }

    public final int hashCode() {
        return this.f169e.hashCode() + ((this.f168d.hashCode() + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        K0.a aVarD = d();
        if (aVarD != this) {
            return aVarD.toString();
        }
        return "property " + this.f168d + " (Kotlin reflection is not available)";
    }
}
