// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient e f3106e;

    public c(e eVar) {
        this.f3106e = eVar;
    }

    @Override // q0.e, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f3106e.contains(obj);
    }

    @Override // q0.e
    public final e e() {
        return this.f3106e;
    }

    @Override // q0.e, java.util.List
    /* JADX INFO: renamed from: f */
    public final e subList(int i3, int i4) {
        e eVar = this.f3106e;
        y.f.q(i3, i4, eVar.size());
        return eVar.subList(eVar.size() - i4, eVar.size() - i3).e();
    }

    @Override // java.util.List
    public final Object get(int i3) {
        e eVar = this.f3106e;
        y.f.p(i3, eVar.size());
        return eVar.get((eVar.size() - 1) - i3);
    }

    @Override // q0.e, java.util.List
    public final int indexOf(Object obj) {
        e eVar = this.f3106e;
        int iLastIndexOf = eVar.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (eVar.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // q0.e, java.util.List
    public final int lastIndexOf(Object obj) {
        e eVar = this.f3106e;
        int iIndexOf = eVar.indexOf(obj);
        if (iIndexOf >= 0) {
            return (eVar.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3106e.size();
    }
}
