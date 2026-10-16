// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final /* synthetic */ int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f2140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f2141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f2142m;

    static {
        TimeUnit.SECONDS.getClass();
    }

    public d(boolean z2, boolean z3, int i3, int i4, boolean z4, boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, boolean z9, String str) {
        this.f2130a = z2;
        this.f2131b = z3;
        this.f2132c = i3;
        this.f2133d = i4;
        this.f2134e = z4;
        this.f2135f = z5;
        this.f2136g = z6;
        this.f2137h = i5;
        this.f2138i = i6;
        this.f2139j = z7;
        this.f2140k = z8;
        this.f2141l = z9;
        this.f2142m = str;
    }

    public final String toString() {
        String str = this.f2142m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f2130a) {
            sb.append("no-cache, ");
        }
        if (this.f2131b) {
            sb.append("no-store, ");
        }
        int i3 = this.f2132c;
        if (i3 != -1) {
            sb.append("max-age=");
            sb.append(i3);
            sb.append(", ");
        }
        int i4 = this.f2133d;
        if (i4 != -1) {
            sb.append("s-maxage=");
            sb.append(i4);
            sb.append(", ");
        }
        if (this.f2134e) {
            sb.append("private, ");
        }
        if (this.f2135f) {
            sb.append("public, ");
        }
        if (this.f2136g) {
            sb.append("must-revalidate, ");
        }
        int i5 = this.f2137h;
        if (i5 != -1) {
            sb.append("max-stale=");
            sb.append(i5);
            sb.append(", ");
        }
        int i6 = this.f2138i;
        if (i6 != -1) {
            sb.append("min-fresh=");
            sb.append(i6);
            sb.append(", ");
        }
        if (this.f2139j) {
            sb.append("only-if-cached, ");
        }
        if (this.f2140k) {
            sb.append("no-transform, ");
        }
        if (this.f2141l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        this.f2142m = string;
        return string;
    }
}
