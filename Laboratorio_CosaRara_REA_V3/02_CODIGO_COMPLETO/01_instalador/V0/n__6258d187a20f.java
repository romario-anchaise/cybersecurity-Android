// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import java.net.URI;
import p022m0.w;

/* JADX INFO: loaded from: classes.dex */
public final class n implements p022m0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f715a;

    public /* synthetic */ n(Class cls) {
        this.f715a = cls;
    }

    public String a(String str) {
        String strF = f(64, str);
        if (!o.f718c.matcher(strF).matches() || strF.contains("..") || strF.contains("/") || strF.contains("\\")) {
            throw new IllegalStateException("target profile asset name invalid: ".concat(str));
        }
        return strF;
    }

    public int b(String str) {
        Object objH = h(str);
        if (objH instanceof Integer) {
            return ((Integer) objH).intValue();
        }
        throw new IllegalStateException("target profile field is not int: ".concat(str));
    }

    public int c(String str, int i2, int i3) {
        int iB = b(str);
        if (iB < i2 || iB > i3) {
            throw new IllegalStateException("target profile integer out of range: ".concat(str));
        }
        return iB;
    }

    public String d(String str) {
        String strF = f(160, str);
        if (o.f716a.matcher(strF).matches()) {
            return strF;
        }
        throw new IllegalStateException("target profile package invalid: ".concat(str));
    }

    public String e(String str) {
        String strF = f(64, str);
        if (o.f717b.matcher(strF).matches()) {
            return strF;
        }
        throw new IllegalStateException("target profile digest invalid: ".concat(str));
    }

    public String f(int i2, String str) {
        Object objH = h(str);
        if (!(objH instanceof String)) {
            throw new IllegalStateException("target profile field is not text: ".concat(str));
        }
        String str2 = (String) objH;
        if (str2.isEmpty() || str2.length() > i2) {
            throw new IllegalStateException("target profile field length invalid: ".concat(str));
        }
        for (int i3 = 0; i3 < str2.length(); i3++) {
            if (Character.isISOControl(str2.charAt(i3))) {
                throw new IllegalStateException("target profile field contains controls: ".concat(str));
            }
        }
        return str2;
    }

    public String g(String str, String str2) {
        String strF = f(2048, str);
        try {
            URI uriCreate = URI.create(strF);
            if (str2.equals(uriCreate.getScheme()) && uriCreate.getHost() != null && uriCreate.getUserInfo() == null && uriCreate.getFragment() == null) {
                return strF;
            }
            throw new IllegalStateException("target profile URL invalid: ".concat(str));
        } catch (IllegalArgumentException e2) {
            throw new IllegalStateException("target profile URL invalid: ".concat(str), e2);
        }
    }

    public Object h(String str) {
        try {
            return this.f715a.getMethod("value", String.class).invoke(null, str);
        } catch (ReflectiveOperationException e2) {
            throw new IllegalStateException("target profile field unavailable: ".concat(str), e2);
        }
    }

    @Override // p022m0.o
    public Object o() {
        Class cls = this.f715a;
        try {
            return w.f3744a.a(cls);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
        }
    }
}
