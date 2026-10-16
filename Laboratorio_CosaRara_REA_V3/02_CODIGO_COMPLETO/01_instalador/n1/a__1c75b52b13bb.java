// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n1;

import A.C0005e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import m1.AbstractC0208l;
import m1.InterfaceC0209m;
import p018k0.m;

/* JADX INFO: loaded from: classes.dex */
public final class a extends AbstractC0208l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3965a;

    public a(m mVar) {
        this.f3965a = mVar;
    }

    @Override // m1.AbstractC0208l
    public final InterfaceC0209m a(Type type) {
        p032r0.a aVar = new p032r0.a(type);
        m mVar = this.f3965a;
        return new b(mVar, mVar.b(aVar));
    }

    @Override // m1.AbstractC0208l
    public final InterfaceC0209m b(Type type, Annotation[] annotationArr, V.a aVar) {
        p032r0.a aVar2 = new p032r0.a(type);
        m mVar = this.f3965a;
        return new C0005e(mVar, mVar.b(aVar2));
    }
}
