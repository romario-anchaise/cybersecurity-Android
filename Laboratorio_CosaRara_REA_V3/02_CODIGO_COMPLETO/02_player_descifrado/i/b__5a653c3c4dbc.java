// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2081e;

    public b(String str, String str2, String str3, List list, List list2) {
        list.getClass();
        list2.getClass();
        this.f2077a = str;
        this.f2078b = str2;
        this.f2079c = str3;
        this.f2080d = list;
        this.f2081e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2077a.equals(bVar.f2077a) && this.f2078b.equals(bVar.f2078b) && this.f2079c.equals(bVar.f2079c) && q1.e.a(this.f2080d, bVar.f2080d)) {
            return q1.e.a(this.f2081e, bVar.f2081e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2081e.hashCode() + ((this.f2080d.hashCode() + a0.a.e(a0.a.e(this.f2077a.hashCode() * 31, 31, this.f2078b), 31, this.f2079c)) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.f2077a + "', onDelete='" + this.f2078b + " +', onUpdate='" + this.f2079c + "', columnNames=" + this.f2080d + ", referenceColumnNames=" + this.f2081e + '}';
    }
}
