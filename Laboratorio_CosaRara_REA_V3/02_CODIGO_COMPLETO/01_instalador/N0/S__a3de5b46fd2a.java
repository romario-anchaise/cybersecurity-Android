// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import p018k0.m;
import p018k0.y;
import p018k0.z;
import p032r0.a;

/* JADX INFO: loaded from: classes.dex */
public final class S implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f3880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f3881c;

    public /* synthetic */ S(Class cls, y yVar, int i2) {
        this.f3879a = i2;
        this.f3880b = cls;
        this.f3881c = yVar;
    }

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        switch (this.f3879a) {
            case 0:
                if (aVar.f4029a == this.f3880b) {
                    return this.f3881c;
                }
                return null;
            default:
                Class cls = this.f3880b;
                Class<?> cls2 = aVar.f4029a;
                if (cls.isAssignableFrom(cls2)) {
                    return new C0221c(this, cls2);
                }
                return null;
        }
    }

    public final String toString() {
        switch (this.f3879a) {
            case 0:
                return "Factory[type=" + this.f3880b.getName() + ",adapter=" + this.f3881c + "]";
            default:
                return "Factory[typeHierarchy=" + this.f3880b.getName() + ",adapter=" + this.f3881c + "]";
        }
    }
}
