// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f3784x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f3785y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V.a f3786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Annotation[] f3788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Annotation[][] f3789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type[] f3790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3791f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3796l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3797m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3798n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3799o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3800p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3801q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f3802r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public X0.n f3803s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public X0.s f3804t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinkedHashSet f3805u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public W[] f3806v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3807w;

    public M(V.a aVar, Method method) {
        this.f3786a = aVar;
        this.f3787b = method;
        this.f3788c = method.getAnnotations();
        this.f3790e = method.getGenericParameterTypes();
        this.f3789d = method.getParameterAnnotations();
    }

    public static Class a(Class cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }

    public final void b(String str, String str2, boolean z2) {
        String str3 = this.f3798n;
        Method method = this.f3787b;
        if (str3 != null) {
            throw W.n(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.f3798n = str;
        this.f3799o = z2;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        Pattern pattern = f3784x;
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (pattern.matcher(strSubstring).find()) {
                throw W.n(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.f3802r = str2;
        Matcher matcher = pattern.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.f3805u = linkedHashSet;
    }

    public final void c(int i2, Type type) {
        if (W.j(type)) {
            throw W.o(this.f3787b, i2, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
