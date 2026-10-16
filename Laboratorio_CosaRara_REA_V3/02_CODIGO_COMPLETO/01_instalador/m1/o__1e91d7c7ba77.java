// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: m1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0211o extends AbstractC0202f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorC0197a f3845a;

    public C0211o(ExecutorC0197a executorC0197a) {
        this.f3845a = executorC0197a;
    }

    @Override // m1.AbstractC0202f
    public final InterfaceC0203g a(Type type, Annotation[] annotationArr) {
        if (W.h(type) != InterfaceC0201e.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new H.s(W.g(0, (ParameterizedType) type), 13, W.l(annotationArr, Q.class) ? null : this.f3845a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
