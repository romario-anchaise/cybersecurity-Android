// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p039w;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f4154b = new g(new h(f.a(new Locale[0])));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f4155a;

    public g(h hVar) {
        this.f4155a = hVar;
    }

    public static g a(String str) {
        if (str == null || str.isEmpty()) {
            return f4154b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i2 = 0; i2 < length; i2++) {
            localeArr[i2] = e.a(strArrSplit[i2]);
        }
        return new g(new h(f.a(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            if (this.f4155a.equals(((g) obj).f4155a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4155a.f4156a.hashCode();
    }

    public final String toString() {
        return this.f4155a.f4156a.toString();
    }
}
