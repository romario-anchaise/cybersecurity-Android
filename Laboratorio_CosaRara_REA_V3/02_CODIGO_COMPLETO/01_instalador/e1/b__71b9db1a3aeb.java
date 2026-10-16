// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import H.C0028c;
import k1.C0196l;

/* JADX INFO: renamed from: e1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0109b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0196l f2276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0196l f2277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0196l f2278f;
    public static final C0196l g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0196l f2279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0196l f2280i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0196l f2281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0196l f2282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2283c;

    static {
        C0196l c0196l = C0196l.f3483d;
        f2276d = C0028c.p(":");
        f2277e = C0028c.p(":status");
        f2278f = C0028c.p(":method");
        g = C0028c.p(":path");
        f2279h = C0028c.p(":scheme");
        f2280i = C0028c.p(":authority");
    }

    public C0109b(C0196l c0196l, C0196l c0196l2) {
        F0.i.e(c0196l, "name");
        F0.i.e(c0196l2, "value");
        this.f2281a = c0196l;
        this.f2282b = c0196l2;
        this.f2283c = c0196l2.c() + c0196l.c() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0109b)) {
            return false;
        }
        C0109b c0109b = (C0109b) obj;
        return F0.i.a(this.f2281a, c0109b.f2281a) && F0.i.a(this.f2282b, c0109b.f2282b);
    }

    public final int hashCode() {
        return this.f2282b.hashCode() + (this.f2281a.hashCode() * 31);
    }

    public final String toString() {
        return this.f2281a.p() + ": " + this.f2282b.p();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0109b(String str, String str2) {
        this(C0028c.p(str), C0028c.p(str2));
        F0.i.e(str, "name");
        F0.i.e(str2, "value");
        C0196l c0196l = C0196l.f3483d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0109b(C0196l c0196l, String str) {
        this(c0196l, C0028c.p(str));
        F0.i.e(c0196l, "name");
        F0.i.e(str, "value");
        C0196l c0196l2 = C0196l.f3483d;
    }
}
