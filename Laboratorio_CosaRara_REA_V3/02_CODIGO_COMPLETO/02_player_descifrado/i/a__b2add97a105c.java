// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i;

import java.util.Locale;
import q2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2076g;

    public a(String str, String str2, boolean z2, int i3, String str3, int i4) {
        this.f2070a = str;
        this.f2071b = str2;
        this.f2072c = z2;
        this.f2073d = i3;
        this.f2074e = str3;
        this.f2075f = i4;
        Locale locale = Locale.US;
        locale.getClass();
        String upperCase = str2.toUpperCase(locale);
        upperCase.getClass();
        this.f2076g = v1.d.B(upperCase, "INT") ? 3 : (v1.d.B(upperCase, "CHAR") || v1.d.B(upperCase, "CLOB") || v1.d.B(upperCase, "TEXT")) ? 2 : v1.d.B(upperCase, "BLOB") ? 5 : (v1.d.B(upperCase, "REAL") || v1.d.B(upperCase, "FLOA") || v1.d.B(upperCase, "DOUB")) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            String str = aVar.f2074e;
            int i3 = aVar.f2075f;
            if (this.f2073d != aVar.f2073d || !this.f2070a.equals(aVar.f2070a) || this.f2072c != aVar.f2072c) {
                return false;
            }
            String str2 = this.f2074e;
            int i4 = this.f2075f;
            if (i4 == 1 && i3 == 2 && str2 != null && !k.e(str2, str)) {
                return false;
            }
            if (i4 == 2 && i3 == 1 && str != null && !k.e(str, str2)) {
                return false;
            }
            if (i4 != 0 && i4 == i3) {
                if (str2 != null) {
                    if (!k.e(str2, str)) {
                        return false;
                    }
                } else if (str != null) {
                    return false;
                }
            }
            if (this.f2076g != aVar.f2076g) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f2070a.hashCode() * 31) + this.f2076g) * 31) + (this.f2072c ? 1231 : 1237)) * 31) + this.f2073d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Column{name='");
        sb.append(this.f2070a);
        sb.append("', type='");
        sb.append(this.f2071b);
        sb.append("', affinity='");
        sb.append(this.f2076g);
        sb.append("', notNull=");
        sb.append(this.f2072c);
        sb.append(", primaryKeyPosition=");
        sb.append(this.f2073d);
        sb.append(", defaultValue='");
        String str = this.f2074e;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }
}
