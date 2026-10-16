// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2085f;

    public c(int i3, int i4, String str, String str2) {
        this.f2082c = i3;
        this.f2083d = i4;
        this.f2084e = str;
        this.f2085f = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c cVar = (c) obj;
        cVar.getClass();
        int i3 = this.f2082c - cVar.f2082c;
        return i3 == 0 ? this.f2083d - cVar.f2083d : i3;
    }
}
