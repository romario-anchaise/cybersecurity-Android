// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: m1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0207k extends AbstractC0202f {
    @Override // m1.AbstractC0202f
    public final InterfaceC0203g a(Type type, Annotation[] annotationArr) {
        if (W.h(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeG = W.g(0, (ParameterizedType) type);
        if (W.h(typeG) != O.class) {
            return new p022m0.f(2, typeG);
        }
        if (typeG instanceof ParameterizedType) {
            return new p022m0.f(3, W.g(0, (ParameterizedType) typeG));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
