// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f4102e = new c(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4106d;

    public c(int i2, int i3, int i4, int i5) {
        this.f4103a = i2;
        this.f4104b = i3;
        this.f4105c = i4;
        this.f4106d = i5;
    }

    public static c a(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f4102e : new c(i2, i3, i4, i5);
    }

    public static c b(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets c() {
        return b.a(this.f4103a, this.f4104b, this.f4105c, this.f4106d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f4106d == cVar.f4106d && this.f4103a == cVar.f4103a && this.f4105c == cVar.f4105c && this.f4104b == cVar.f4104b;
    }

    public final int hashCode() {
        return (((((this.f4103a * 31) + this.f4104b) * 31) + this.f4105c) * 31) + this.f4106d;
    }

    public final String toString() {
        return "Insets{left=" + this.f4103a + ", top=" + this.f4104b + ", right=" + this.f4105c + ", bottom=" + this.f4106d + '}';
    }
}
