// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import p018k0.m;
import p018k0.y;
import p018k0.z;
import p032r0.a;

/* JADX INFO: loaded from: classes.dex */
public final class T implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f3883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f3884c;

    public T(Class cls, Class cls2, y yVar) {
        this.f3882a = cls;
        this.f3883b = cls2;
        this.f3884c = yVar;
    }

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        Class cls = this.f3882a;
        Class cls2 = aVar.f4029a;
        if (cls2 == cls || cls2 == this.f3883b) {
            return this.f3884c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f3883b.getName() + "+" + this.f3882a.getName() + ",adapter=" + this.f3884c + "]";
    }
}
