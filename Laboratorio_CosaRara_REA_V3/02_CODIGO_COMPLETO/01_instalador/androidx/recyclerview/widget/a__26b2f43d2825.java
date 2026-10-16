// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

/* JADX INFO: renamed from: androidx.recyclerview.widget.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0083a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1890d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0083a)) {
            return false;
        }
        C0083a c0083a = (C0083a) obj;
        int i2 = this.f1887a;
        if (i2 != c0083a.f1887a) {
            return false;
        }
        if (i2 == 8 && Math.abs(this.f1890d - this.f1888b) == 1 && this.f1890d == c0083a.f1888b && this.f1888b == c0083a.f1890d) {
            return true;
        }
        if (this.f1890d != c0083a.f1890d || this.f1888b != c0083a.f1888b) {
            return false;
        }
        Object obj2 = this.f1889c;
        if (obj2 != null) {
            if (!obj2.equals(c0083a.f1889c)) {
                return false;
            }
        } else if (c0083a.f1889c != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f1887a * 31) + this.f1888b) * 31) + this.f1890d;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i2 = this.f1887a;
        if (i2 == 1) {
            str = "add";
        } else if (i2 == 2) {
            str = "rm";
        } else if (i2 != 4) {
            str = i2 != 8 ? "??" : "mv";
        } else {
            str = "up";
        }
        sb.append(str);
        sb.append(",s:");
        sb.append(this.f1888b);
        sb.append("c:");
        sb.append(this.f1890d);
        sb.append(",p:");
        sb.append(this.f1889c);
        sb.append("]");
        return sb.toString();
    }
}
