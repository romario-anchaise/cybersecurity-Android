// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.io.EOFException;
import java.lang.reflect.Method;
import java.util.Objects;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class F extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f3761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3763f;
    public final C0198b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3764h;

    public F(Method method, int i2, String str, boolean z2) {
        C0198b c0198b = C0198b.f3833b;
        this.f3761d = method;
        this.f3762e = i2;
        Objects.requireNonNull(str, "name == null");
        this.f3763f = str;
        this.g = c0198b;
        this.f3764h = z2;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) throws EOFException {
        String strJ;
        String str = this.f3763f;
        if (obj == null) {
            throw W.o(this.f3761d, this.f3762e, F0.h.e("Path parameter \"", str, "\" value must not be null."), new Object[0]);
        }
        this.g.getClass();
        String string = obj.toString();
        if (l2.f3776c == null) {
            throw new AssertionError();
        }
        int length = string.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                strJ = string;
                break;
            }
            int iCodePointAt = string.codePointAt(iCharCount);
            boolean z2 = this.f3764h;
            int i2 = 47;
            int i3 = -1;
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                C0193i c0193i = new C0193i();
                c0193i.V(string, 0, iCharCount);
                C0193i c0193i2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = string.codePointAt(iCharCount);
                    if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != i3 || (!z2 && (iCodePointAt2 == i2 || iCodePointAt2 == 37))) {
                            if (c0193i2 == null) {
                                c0193i2 = new C0193i();
                            }
                            c0193i2.W(iCodePointAt2);
                            while (!c0193i2.w()) {
                                byte B2 = c0193i2.B();
                                c0193i.Q(37);
                                char[] cArr = L.f3772l;
                                c0193i.Q(cArr[((B2 & 255) >> 4) & 15]);
                                c0193i.Q(cArr[B2 & 15]);
                            }
                        } else {
                            c0193i.W(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i2 = 47;
                    i3 = -1;
                }
                strJ = c0193i.J();
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strReplace = l2.f3776c.replace("{" + str + "}", strJ);
        if (L.f3773m.matcher(strReplace).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): ".concat(string));
        }
        l2.f3776c = strReplace;
    }
}
