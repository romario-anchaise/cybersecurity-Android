// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

/* JADX INFO: loaded from: classes.dex */
public final class j extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3713a;

    public j(String str) {
        this.f3713a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f3713a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            return this.f3713a.equals(((j) obj).f3713a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f3713a);
    }

    public final int hashCode() {
        return this.f3713a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f3713a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return d.i(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f3713a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return d.i(str).longValue();
        }
    }

    public final String toString() {
        return this.f3713a;
    }
}
