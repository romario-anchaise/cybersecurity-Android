// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f2209c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f2210d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f2212b;

    public s(String str, String[] strArr) {
        this.f2211a = str;
        this.f2212b = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.f2212b;
        int i3 = 0;
        int i4 = m0.a.i(0, strArr.length - 1, 2);
        if (i4 < 0) {
            str = null;
            break;
        }
        while (true) {
            if (!v1.l.w(strArr[i3], "charset")) {
                if (i3 == i4) {
                    str = null;
                    break;
                }
                i3 += 2;
            } else {
                str = strArr[i3 + 1];
                break;
            }
        }
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && q1.e.a(((s) obj).f2211a, this.f2211a);
    }

    public final int hashCode() {
        return this.f2211a.hashCode();
    }

    public final String toString() {
        return this.f2211a;
    }
}
