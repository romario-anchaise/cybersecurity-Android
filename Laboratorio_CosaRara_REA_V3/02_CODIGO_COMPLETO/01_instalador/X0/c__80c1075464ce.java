// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: X0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0056c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0056c f947n = new C0056c(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0056c f948o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f954f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f960m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        F0.i.e(timeUnit, "timeUnit");
        long seconds = timeUnit.toSeconds(Integer.MAX_VALUE);
        f948o = new C0056c(false, false, -1, -1, false, false, false, seconds <= 2147483647L ? (int) seconds : Integer.MAX_VALUE, -1, true, false, false, null);
    }

    public C0056c(boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, boolean z6, int i4, int i5, boolean z7, boolean z8, boolean z9, String str) {
        this.f949a = z2;
        this.f950b = z3;
        this.f951c = i2;
        this.f952d = i3;
        this.f953e = z4;
        this.f954f = z5;
        this.g = z6;
        this.f955h = i4;
        this.f956i = i5;
        this.f957j = z7;
        this.f958k = z8;
        this.f959l = z9;
        this.f960m = str;
    }

    public final String toString() {
        String str = this.f960m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f949a) {
            sb.append("no-cache, ");
        }
        if (this.f950b) {
            sb.append("no-store, ");
        }
        int i2 = this.f951c;
        if (i2 != -1) {
            sb.append("max-age=");
            sb.append(i2);
            sb.append(", ");
        }
        int i3 = this.f952d;
        if (i3 != -1) {
            sb.append("s-maxage=");
            sb.append(i3);
            sb.append(", ");
        }
        if (this.f953e) {
            sb.append("private, ");
        }
        if (this.f954f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        int i4 = this.f955h;
        if (i4 != -1) {
            sb.append("max-stale=");
            sb.append(i4);
            sb.append(", ");
        }
        int i5 = this.f956i;
        if (i5 != -1) {
            sb.append("min-fresh=");
            sb.append(i5);
            sb.append(", ");
        }
        if (this.f957j) {
            sb.append("only-if-cached, ");
        }
        if (this.f958k) {
            sb.append("no-transform, ");
        }
        if (this.f959l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        F0.i.d(string, "StringBuilder().apply(builderAction).toString()");
        this.f960m = string;
        return string;
    }
}
