// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import A.C0005e;
import X0.InterfaceC0057d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f3850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0057d f3851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0209m f3852c;

    public r(N n2, InterfaceC0057d interfaceC0057d, InterfaceC0209m interfaceC0209m) {
        this.f3850a = n2;
        this.f3851b = interfaceC0057d;
        this.f3852c = interfaceC0209m;
    }

    /* JADX WARN: Code duplicated, block: B:390:0x08f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:391:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:576:0x0913 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v65, types: [int] */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v67, types: [int] */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static r b(V.a aVar, Method method) {
        Type genericReturnType;
        boolean z2;
        boolean zM;
        boolean z3;
        Annotation[][] annotationArr;
        int i2;
        int i3;
        W[] wArr;
        String str;
        boolean z4;
        W w2;
        String str2;
        W[] wArr2;
        boolean z5;
        W i4;
        W a2;
        z zVar;
        z zVar2;
        int i5;
        int i6 = -1;
        boolean z6 = false;
        boolean z7 = true;
        M m2 = new M(aVar, method);
        Annotation[] annotationArr2 = m2.f3788c;
        int length = annotationArr2.length;
        int i7 = 0;
        while (true) {
            Method method2 = m2.f3787b;
            String str3 = "HEAD";
            if (i7 >= length) {
                if (m2.f3798n == null) {
                    throw W.n(method2, null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
                }
                if (!m2.f3799o) {
                    if (m2.f3801q) {
                        throw W.n(method2, null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                    if (m2.f3800p) {
                        throw W.n(method2, null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                Annotation[][] annotationArr3 = m2.f3789d;
                int length2 = annotationArr3.length;
                m2.f3806v = new W[length2];
                int i8 = length2 - 1;
                int i9 = 0;
                while (i9 < length2) {
                    W[] wArr3 = m2.f3806v;
                    Type type = m2.f3790e[i9];
                    Annotation[] annotationArr4 = annotationArr3[i9];
                    boolean z8 = i9 == i8 ? z7 : false;
                    if (annotationArr4 != null) {
                        int length3 = annotationArr4.length;
                        int i10 = 0;
                        w2 = null;
                        while (true) {
                            annotationArr = annotationArr3;
                            if (i10 >= length3) {
                                i2 = length2;
                                i3 = i8;
                                wArr = wArr3;
                                str = str3;
                                z4 = z8;
                                break;
                            }
                            Annotation annotation = annotationArr4[i10];
                            int i11 = length2;
                            int i12 = i8;
                            int i13 = length3;
                            if (annotation instanceof o1.y) {
                                m2.c(i9, type);
                                if (m2.f3797m) {
                                    throw W.o(method2, i9, "Multiple @Url method annotations found.", new Object[0]);
                                }
                                if (m2.f3793i) {
                                    throw W.o(method2, i9, "@Path parameters may not be used with @Url.", new Object[0]);
                                }
                                if (m2.f3794j) {
                                    throw W.o(method2, i9, "A @Url parameter must not come after a @Query.", new Object[0]);
                                }
                                if (m2.f3795k) {
                                    throw W.o(method2, i9, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                                }
                                if (m2.f3796l) {
                                    throw W.o(method2, i9, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                                }
                                if (m2.f3802r != null) {
                                    throw W.o(method2, i9, "@Url cannot be used with @%s URL", m2.f3798n);
                                }
                                m2.f3797m = true;
                                if (type != X0.p.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                    throw W.o(method2, i9, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                }
                                i4 = new D(method2, i9, 1);
                                wArr2 = wArr3;
                                str2 = str3;
                            } else {
                                boolean z9 = annotation instanceof o1.s;
                                str2 = str3;
                                V.a aVar2 = m2.f3786a;
                                if (z9) {
                                    m2.c(i9, type);
                                    if (m2.f3794j) {
                                        throw W.o(method2, i9, "A @Path parameter must not come after a @Query.", new Object[0]);
                                    }
                                    if (m2.f3795k) {
                                        throw W.o(method2, i9, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                                    }
                                    if (m2.f3796l) {
                                        throw W.o(method2, i9, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                                    }
                                    if (m2.f3797m) {
                                        throw W.o(method2, i9, "@Path parameters may not be used with @Url.", new Object[0]);
                                    }
                                    if (m2.f3802r == null) {
                                        throw W.o(method2, i9, "@Path can only be used with relative url on @%s", m2.f3798n);
                                    }
                                    m2.f3793i = true;
                                    o1.s sVar = (o1.s) annotation;
                                    String strValue = sVar.value();
                                    if (!M.f3785y.matcher(strValue).matches()) {
                                        throw W.o(method2, i9, "@Path parameter name must match %s. Found: %s", M.f3784x.pattern(), strValue);
                                    }
                                    if (!m2.f3805u.contains(strValue)) {
                                        throw W.o(method2, i9, "URL \"%s\" does not contain \"{%s}\".", m2.f3802r, strValue);
                                    }
                                    aVar2.j(type, annotationArr4);
                                    i4 = new F(method2, i9, strValue, sVar.encoded());
                                    wArr2 = wArr3;
                                } else {
                                    if (annotation instanceof o1.t) {
                                        m2.c(i9, type);
                                        o1.t tVar = (o1.t) annotation;
                                        String strValue2 = tVar.value();
                                        boolean zEncoded = tVar.encoded();
                                        Class clsH = W.h(type);
                                        wArr2 = wArr3;
                                        m2.f3794j = true;
                                        if (Iterable.class.isAssignableFrom(clsH)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw W.o(method2, i9, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
                                            }
                                            aVar2.j(W.g(0, (ParameterizedType) type), annotationArr4);
                                            zVar2 = new z(new B(2, strValue2, zEncoded), 0);
                                        } else if (clsH.isArray()) {
                                            aVar2.j(M.a(clsH.getComponentType()), annotationArr4);
                                            zVar2 = new z(new B(2, strValue2, zEncoded), 1);
                                        } else {
                                            aVar2.j(type, annotationArr4);
                                            i4 = new B(2, strValue2, zEncoded);
                                        }
                                        i4 = zVar2;
                                    } else {
                                        wArr2 = wArr3;
                                        if (annotation instanceof o1.v) {
                                            m2.c(i9, type);
                                            boolean zEncoded2 = ((o1.v) annotation).encoded();
                                            Class clsH2 = W.h(type);
                                            m2.f3795k = true;
                                            if (Iterable.class.isAssignableFrom(clsH2)) {
                                                if (!(type instanceof ParameterizedType)) {
                                                    throw W.o(method2, i9, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
                                                }
                                                aVar2.j(W.g(0, (ParameterizedType) type), annotationArr4);
                                                zVar2 = new z(new G(zEncoded2), 0);
                                                i4 = zVar2;
                                            } else if (clsH2.isArray()) {
                                                aVar2.j(M.a(clsH2.getComponentType()), annotationArr4);
                                                i4 = new z(new G(zEncoded2), 1);
                                            } else {
                                                aVar2.j(type, annotationArr4);
                                                i4 = new G(zEncoded2);
                                            }
                                        } else {
                                            z5 = z8;
                                            if (annotation instanceof o1.u) {
                                                m2.c(i9, type);
                                                Class clsH3 = W.h(type);
                                                m2.f3796l = true;
                                                if (!Map.class.isAssignableFrom(clsH3)) {
                                                    throw W.o(method2, i9, "@QueryMap parameter type must be Map.", new Object[0]);
                                                }
                                                Type typeI = W.i(type, clsH3);
                                                if (!(typeI instanceof ParameterizedType)) {
                                                    throw W.o(method2, i9, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                }
                                                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                                                Type typeG = W.g(0, parameterizedType);
                                                if (String.class != typeG) {
                                                    throw W.o(method2, i9, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
                                                }
                                                aVar2.j(W.g(1, parameterizedType), annotationArr4);
                                                i4 = new C(method2, i9, ((o1.u) annotation).encoded(), 2);
                                            } else if (annotation instanceof o1.i) {
                                                m2.c(i9, type);
                                                o1.i iVar = (o1.i) annotation;
                                                String strValue3 = iVar.value();
                                                Class clsH4 = W.h(type);
                                                if (Iterable.class.isAssignableFrom(clsH4)) {
                                                    if (!(type instanceof ParameterizedType)) {
                                                        throw W.o(method2, i9, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
                                                    }
                                                    aVar2.j(W.g(0, (ParameterizedType) type), annotationArr4);
                                                    zVar = new z(new B(1, strValue3, iVar.allowUnsafeNonAsciiValues()), 0);
                                                    i4 = zVar;
                                                } else if (clsH4.isArray()) {
                                                    aVar2.j(M.a(clsH4.getComponentType()), annotationArr4);
                                                    i4 = new z(new B(1, strValue3, iVar.allowUnsafeNonAsciiValues()), 1);
                                                } else {
                                                    aVar2.j(type, annotationArr4);
                                                    i4 = new B(1, strValue3, iVar.allowUnsafeNonAsciiValues());
                                                }
                                            } else if (annotation instanceof o1.j) {
                                                if (type == X0.n.class) {
                                                    i4 = new D(method2, i9, 0);
                                                } else {
                                                    m2.c(i9, type);
                                                    Class clsH5 = W.h(type);
                                                    if (!Map.class.isAssignableFrom(clsH5)) {
                                                        throw W.o(method2, i9, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
                                                    }
                                                    Type typeI2 = W.i(type, clsH5);
                                                    if (!(typeI2 instanceof ParameterizedType)) {
                                                        throw W.o(method2, i9, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                    }
                                                    ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                                                    Type typeG2 = W.g(0, parameterizedType2);
                                                    if (String.class != typeG2) {
                                                        throw W.o(method2, i9, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
                                                    }
                                                    aVar2.j(W.g(1, parameterizedType2), annotationArr4);
                                                    i4 = new C(method2, i9, ((o1.j) annotation).allowUnsafeNonAsciiValues(), 1);
                                                }
                                            } else if (annotation instanceof o1.c) {
                                                m2.c(i9, type);
                                                if (!m2.f3800p) {
                                                    throw W.o(method2, i9, "@Field parameters can only be used with form encoding.", new Object[0]);
                                                }
                                                o1.c cVar = (o1.c) annotation;
                                                String strValue4 = cVar.value();
                                                boolean zEncoded3 = cVar.encoded();
                                                m2.f3791f = true;
                                                Class clsH6 = W.h(type);
                                                if (Iterable.class.isAssignableFrom(clsH6)) {
                                                    if (!(type instanceof ParameterizedType)) {
                                                        throw W.o(method2, i9, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
                                                    }
                                                    aVar2.j(W.g(0, (ParameterizedType) type), annotationArr4);
                                                    zVar = new z(new B(0, strValue4, zEncoded3), 0);
                                                } else if (clsH6.isArray()) {
                                                    aVar2.j(M.a(clsH6.getComponentType()), annotationArr4);
                                                    zVar = new z(new B(0, strValue4, zEncoded3), 1);
                                                } else {
                                                    aVar2.j(type, annotationArr4);
                                                    i4 = new B(0, strValue4, zEncoded3);
                                                }
                                                i4 = zVar;
                                            } else if (annotation instanceof o1.d) {
                                                m2.c(i9, type);
                                                if (!m2.f3800p) {
                                                    throw W.o(method2, i9, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                                }
                                                Class clsH7 = W.h(type);
                                                if (!Map.class.isAssignableFrom(clsH7)) {
                                                    throw W.o(method2, i9, "@FieldMap parameter type must be Map.", new Object[0]);
                                                }
                                                Type typeI3 = W.i(type, clsH7);
                                                if (!(typeI3 instanceof ParameterizedType)) {
                                                    throw W.o(method2, i9, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                }
                                                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                                                Type typeG3 = W.g(0, parameterizedType3);
                                                if (String.class != typeG3) {
                                                    throw W.o(method2, i9, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
                                                }
                                                aVar2.j(W.g(1, parameterizedType3), annotationArr4);
                                                m2.f3791f = true;
                                                i4 = new C(method2, i9, ((o1.d) annotation).encoded(), 0);
                                            } else {
                                                i10 = i10;
                                                if (annotation instanceof o1.q) {
                                                    m2.c(i9, type);
                                                    if (!m2.f3801q) {
                                                        throw W.o(method2, i9, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                                    }
                                                    o1.q qVar = (o1.q) annotation;
                                                    m2.g = true;
                                                    String strValue5 = qVar.value();
                                                    Class clsH8 = W.h(type);
                                                    if (strValue5.isEmpty()) {
                                                        boolean zIsAssignableFrom = Iterable.class.isAssignableFrom(clsH8);
                                                        H h2 = H.f3766d;
                                                        if (zIsAssignableFrom) {
                                                            if (!(type instanceof ParameterizedType)) {
                                                                throw W.o(method2, i9, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
                                                            }
                                                            int i14 = 0;
                                                            if (!X0.t.class.isAssignableFrom(W.h(W.g(0, (ParameterizedType) type)))) {
                                                                throw W.o(method2, i9, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                                            }
                                                            i4 = new z(h2, i14);
                                                        } else if (clsH8.isArray()) {
                                                            if (!X0.t.class.isAssignableFrom(clsH8.getComponentType())) {
                                                                throw W.o(method2, i9, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                                            }
                                                            i4 = new z(h2, 1);
                                                        } else {
                                                            if (!X0.t.class.isAssignableFrom(clsH8)) {
                                                                throw W.o(method2, i9, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                                            }
                                                            i4 = h2;
                                                        }
                                                    } else {
                                                        X0.n nVarG = f1.l.G("Content-Disposition", F0.h.e("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", qVar.encoding());
                                                        if (Iterable.class.isAssignableFrom(clsH8)) {
                                                            if (!(type instanceof ParameterizedType)) {
                                                                throw W.o(method2, i9, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
                                                            }
                                                            int i15 = 0;
                                                            Type typeG4 = W.g(0, (ParameterizedType) type);
                                                            if (X0.t.class.isAssignableFrom(W.h(typeG4))) {
                                                                throw W.o(method2, i9, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                                            }
                                                            i4 = new z(new E(method2, i9, nVarG, aVar2.h(typeG4, annotationArr4, annotationArr2)), i15);
                                                        } else if (clsH8.isArray()) {
                                                            Class clsA = M.a(clsH8.getComponentType());
                                                            if (X0.t.class.isAssignableFrom(clsA)) {
                                                                throw W.o(method2, i9, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                                            }
                                                            i4 = new z(new E(method2, i9, nVarG, aVar2.h(clsA, annotationArr4, annotationArr2)), 1);
                                                        } else {
                                                            if (X0.t.class.isAssignableFrom(clsH8)) {
                                                                throw W.o(method2, i9, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                                            }
                                                            i4 = new E(method2, i9, nVarG, aVar2.h(type, annotationArr4, annotationArr2));
                                                        }
                                                    }
                                                } else {
                                                    if (annotation instanceof o1.r) {
                                                        m2.c(i9, type);
                                                        if (!m2.f3801q) {
                                                            throw W.o(method2, i9, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                                        }
                                                        m2.g = true;
                                                        Class clsH9 = W.h(type);
                                                        if (!Map.class.isAssignableFrom(clsH9)) {
                                                            throw W.o(method2, i9, "@PartMap parameter type must be Map.", new Object[0]);
                                                        }
                                                        Type typeI4 = W.i(type, clsH9);
                                                        if (!(typeI4 instanceof ParameterizedType)) {
                                                            throw W.o(method2, i9, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                                        }
                                                        ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                                                        Type typeG5 = W.g(0, parameterizedType4);
                                                        if (String.class != typeG5) {
                                                            throw W.o(method2, i9, "@PartMap keys must be of type String: " + typeG5, new Object[0]);
                                                        }
                                                        Type typeG6 = W.g(1, parameterizedType4);
                                                        if (X0.t.class.isAssignableFrom(W.h(typeG6))) {
                                                            throw W.o(method2, i9, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                                        }
                                                        a2 = new E(method2, i9, aVar2.h(typeG6, annotationArr4, annotationArr2), ((o1.r) annotation).encoding());
                                                    } else if (annotation instanceof o1.a) {
                                                        m2.c(i9, type);
                                                        if (m2.f3800p || m2.f3801q) {
                                                            throw W.o(method2, i9, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                                        }
                                                        if (m2.f3792h) {
                                                            throw W.o(method2, i9, "Multiple @Body method annotations found.", new Object[0]);
                                                        }
                                                        try {
                                                            InterfaceC0209m interfaceC0209mH = aVar2.h(type, annotationArr4, annotationArr2);
                                                            m2.f3792h = true;
                                                            a2 = new A(method2, i9, interfaceC0209mH);
                                                        } catch (RuntimeException e2) {
                                                            throw W.p(method2, e2, i9, "Unable to create @Body converter for %s", type);
                                                        }
                                                    } else if (annotation instanceof o1.x) {
                                                        m2.c(i9, type);
                                                        Class clsH10 = W.h(type);
                                                        for (int i16 = i9 - 1; i16 >= 0; i16--) {
                                                            W w3 = m2.f3806v[i16];
                                                            if ((w3 instanceof I) && ((I) w3).f3767d.equals(clsH10)) {
                                                                throw W.o(method2, i9, "@Tag type " + clsH10.getName() + " is duplicate of " + J.f3769b.c(method2, i16) + " and would always overwrite its value.", new Object[0]);
                                                            }
                                                        }
                                                        i4 = new I(clsH10);
                                                    } else {
                                                        i4 = null;
                                                    }
                                                    i4 = a2;
                                                }
                                            }
                                            i10 = i10;
                                        }
                                    }
                                    if (i4 != null) {
                                        if (w2 == null) {
                                            throw W.o(method2, i9, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                                        }
                                        w2 = i4;
                                    }
                                    i10++;
                                    annotationArr3 = annotationArr;
                                    length2 = i11;
                                    i8 = i12;
                                    length3 = i13;
                                    str3 = str2;
                                    wArr3 = wArr2;
                                    z8 = z5;
                                }
                            }
                            z5 = z8;
                            if (i4 != null) {
                                if (w2 == null) {
                                    throw W.o(method2, i9, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                                }
                                w2 = i4;
                            }
                            i10++;
                            annotationArr3 = annotationArr;
                            length2 = i11;
                            i8 = i12;
                            length3 = i13;
                            str3 = str2;
                            wArr3 = wArr2;
                            z8 = z5;
                        }
                    } else {
                        annotationArr = annotationArr3;
                        i2 = length2;
                        i3 = i8;
                        wArr = wArr3;
                        str = str3;
                        z4 = z8;
                        w2 = null;
                    }
                    if (w2 == null) {
                        if (z4) {
                            try {
                                if (W.h(type) == p040w0.d.class) {
                                    m2.f3807w = true;
                                    w2 = null;
                                }
                            } catch (NoClassDefFoundError unused) {
                            }
                        }
                        throw W.o(method2, i9, "No Retrofit annotation found.", new Object[0]);
                    }
                    wArr[i9] = w2;
                    i9++;
                    z7 = true;
                    annotationArr3 = annotationArr;
                    length2 = i2;
                    i8 = i3;
                    str3 = str;
                }
                String str4 = str3;
                if (m2.f3802r == null && !m2.f3797m) {
                    throw W.n(method2, null, "Missing either @%s URL or @Url parameter.", m2.f3798n);
                }
                boolean z10 = m2.f3800p;
                if (!z10 && !m2.f3801q && !m2.f3799o && m2.f3792h) {
                    throw W.n(method2, null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (z10 && !m2.f3791f) {
                    throw W.n(method2, null, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (m2.f3801q && !m2.g) {
                    throw W.n(method2, null, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                N n2 = new N(m2);
                Type genericReturnType2 = method.getGenericReturnType();
                if (W.j(genericReturnType2)) {
                    throw W.n(method, null, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
                }
                if (genericReturnType2 == Void.TYPE) {
                    throw W.n(method, null, "Service methods cannot return void.", new Object[0]);
                }
                Annotation[] annotations = method.getAnnotations();
                boolean z11 = n2.f3817k;
                if (z11) {
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    Type typeG7 = ((ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]).getActualTypeArguments()[0];
                    if (typeG7 instanceof WildcardType) {
                        typeG7 = ((WildcardType) typeG7).getLowerBounds()[0];
                    }
                    if (W.h(typeG7) == O.class && (typeG7 instanceof ParameterizedType)) {
                        typeG7 = W.g(0, (ParameterizedType) typeG7);
                        zM = false;
                        z3 = true;
                    } else {
                        if (W.h(typeG7) == InterfaceC0201e.class) {
                            throw W.n(method, null, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", W.g(0, (ParameterizedType) typeG7));
                        }
                        zM = W.m(typeG7);
                        z3 = false;
                    }
                    genericReturnType = new U(null, InterfaceC0201e.class, typeG7);
                    if (!W.l(annotations, Q.class)) {
                        Annotation[] annotationArr5 = new Annotation[annotations.length + 1];
                        annotationArr5[0] = S.f3822a;
                        System.arraycopy(annotations, 0, annotationArr5, 1, annotations.length);
                        annotations = annotationArr5;
                    }
                    z2 = z3;
                } else {
                    genericReturnType = method.getGenericReturnType();
                    z2 = false;
                    zM = false;
                }
                try {
                    InterfaceC0203g interfaceC0203gE = aVar.e(genericReturnType, annotations);
                    Type typeD = interfaceC0203gE.d();
                    if (typeD == X0.D.class) {
                        throw W.n(method, null, "'" + W.h(typeD).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
                    }
                    if (typeD == O.class) {
                        throw W.n(method, null, "Response must include generic type (e.g., Response<String>)", new Object[0]);
                    }
                    if (n2.f3810c.equals(str4) && !Void.class.equals(typeD) && !W.m(typeD)) {
                        throw W.n(method, null, "HEAD method must use Void or Unit as response type.", new Object[0]);
                    }
                    try {
                        InterfaceC0209m interfaceC0209mI = aVar.i(typeD, method.getAnnotations());
                        InterfaceC0057d interfaceC0057d = (InterfaceC0057d) aVar.f651c;
                        if (z11) {
                            return z2 ? new C0212p(n2, interfaceC0057d, interfaceC0209mI, interfaceC0203gE, 1) : new C0213q(n2, interfaceC0057d, interfaceC0209mI, interfaceC0203gE, zM);
                        }
                        return new C0212p(n2, interfaceC0057d, interfaceC0209mI, interfaceC0203gE, 0);
                    } catch (RuntimeException e3) {
                        throw W.n(method, e3, "Unable to create converter for %s", typeD);
                    }
                } catch (RuntimeException e4) {
                    throw W.n(method, e4, "Unable to create call adapter for %s", genericReturnType);
                }
            }
            Annotation annotation2 = annotationArr2[i7];
            if (annotation2 instanceof o1.b) {
                m2.b("DELETE", ((o1.b) annotation2).value(), z6);
            } else if (annotation2 instanceof o1.f) {
                m2.b("GET", ((o1.f) annotation2).value(), z6);
            } else if (annotation2 instanceof o1.g) {
                m2.b("HEAD", ((o1.g) annotation2).value(), z6);
            } else if (annotation2 instanceof o1.n) {
                m2.b("PATCH", ((o1.n) annotation2).value(), true);
            } else if (annotation2 instanceof o1.o) {
                m2.b("POST", ((o1.o) annotation2).value(), true);
            } else if (annotation2 instanceof o1.p) {
                m2.b("PUT", ((o1.p) annotation2).value(), true);
            } else if (annotation2 instanceof o1.m) {
                m2.b("OPTIONS", ((o1.m) annotation2).value(), z6);
            } else {
                if (annotation2 instanceof o1.h) {
                    o1.h hVar = (o1.h) annotation2;
                    m2.b(hVar.method(), hVar.path(), hVar.hasBody());
                } else if (annotation2 instanceof o1.k) {
                    o1.k kVar = (o1.k) annotation2;
                    String[] strArrValue = kVar.value();
                    if (strArrValue.length == 0) {
                        throw W.n(method2, null, "@Headers annotation is empty.", new Object[z6]);
                    }
                    boolean zAllowUnsafeNonAsciiValues = kVar.allowUnsafeNonAsciiValues();
                    C0005e c0005e = new C0005e(10);
                    int length4 = strArrValue.length;
                    for (?? r3 = z6; r3 < length4; r3++) {
                        String str5 = strArrValue[r3];
                        int iIndexOf = str5.indexOf(58);
                        if (iIndexOf == i6 || iIndexOf == 0 || iIndexOf == str5.length() - 1) {
                            throw W.n(method2, null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str5);
                        }
                        int i17 = length;
                        String strSubstring = str5.substring(0, iIndexOf);
                        String strTrim = str5.substring(iIndexOf + 1).trim();
                        if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                            try {
                                Pattern pattern = X0.s.f1030d;
                                m2.f3804t = f1.d.q(strTrim);
                            } catch (IllegalArgumentException e5) {
                                throw W.n(method2, e5, "Malformed content type: %s", strTrim);
                            }
                        } else if (zAllowUnsafeNonAsciiValues) {
                            c0005e.A(strSubstring, strTrim);
                        } else {
                            c0005e.y(strSubstring, strTrim);
                        }
                        length = i17;
                        i6 = -1;
                    }
                    i5 = length;
                    m2.f3803s = c0005e.B();
                } else {
                    i5 = length;
                    if (annotation2 instanceof o1.l) {
                        if (m2.f3800p) {
                            throw W.n(method2, null, "Only one encoding annotation is allowed.", new Object[0]);
                        }
                        m2.f3801q = true;
                    } else if (!(annotation2 instanceof o1.e)) {
                        continue;
                    } else {
                        if (m2.f3801q) {
                            throw W.n(method2, null, "Only one encoding annotation is allowed.", new Object[0]);
                        }
                        m2.f3800p = true;
                    }
                }
                i7++;
                length = i5;
                i6 = -1;
                z6 = false;
            }
            i5 = length;
            i7++;
            length = i5;
            i6 = -1;
            z6 = false;
        }
    }

    public abstract Object a(y yVar, Object[] objArr);
}
