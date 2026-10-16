// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import A.C0005e;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/* JADX INFO: renamed from: m1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0199c extends AbstractC0208l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3839a;

    public /* synthetic */ C0199c(int i2) {
        this.f3839a = i2;
    }

    @Override // m1.AbstractC0208l
    public InterfaceC0209m a(Type type) {
        switch (this.f3839a) {
            case 0:
                if (X0.B.class.isAssignableFrom(W.h(type))) {
                    return C0198b.f3835d;
                }
                return null;
            default:
                return super.a(type);
        }
    }

    @Override // m1.AbstractC0208l
    public final InterfaceC0209m b(Type type, Annotation[] annotationArr, V.a aVar) {
        switch (this.f3839a) {
            case 0:
                if (type == X0.G.class) {
                    return W.l(annotationArr, o1.w.class) ? C0198b.f3836e : C0198b.f3834c;
                }
                if (type == Void.class) {
                    return C0198b.g;
                }
                if (W.m(type)) {
                    return C0198b.f3837f;
                }
                return null;
            default:
                if (W.h(type) != Optional.class) {
                    return null;
                }
                return new C0005e(23, aVar.i(W.g(0, (ParameterizedType) type), annotationArr));
        }
    }
}
