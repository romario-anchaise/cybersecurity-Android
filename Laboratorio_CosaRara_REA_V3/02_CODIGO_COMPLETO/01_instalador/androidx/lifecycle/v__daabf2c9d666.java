// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0077o f1688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0080s f1689b;

    public final void a(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        EnumC0077o enumC0077oA = enumC0076n.a();
        EnumC0077o enumC0077o = this.f1688a;
        F0.i.e(enumC0077o, "state1");
        if (enumC0077oA.compareTo(enumC0077o) < 0) {
            enumC0077o = enumC0077oA;
        }
        this.f1688a = enumC0077o;
        this.f1689b.g(interfaceC0082u, enumC0076n);
        this.f1688a = enumC0077oA;
    }
}
