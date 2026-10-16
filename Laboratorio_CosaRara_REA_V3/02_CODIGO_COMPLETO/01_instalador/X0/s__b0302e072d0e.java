// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f1030d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f1031e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f1034c;

    public s(String str, String str2, String[] strArr) {
        this.f1032a = str;
        this.f1033b = str2;
        this.f1034c = strArr;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && F0.i.a(((s) obj).f1032a, this.f1032a);
    }

    public final int hashCode() {
        return this.f1032a.hashCode();
    }

    public final String toString() {
        return this.f1032a;
    }
}
