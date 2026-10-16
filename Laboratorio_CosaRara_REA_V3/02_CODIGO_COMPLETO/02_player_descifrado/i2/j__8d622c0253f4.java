// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f2171j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f2172k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f2173l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f2174m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2183i;

    public j(String str, String str2, long j3, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f2175a = str;
        this.f2176b = str2;
        this.f2177c = j3;
        this.f2178d = str3;
        this.f2179e = str4;
        this.f2180f = z2;
        this.f2181g = z3;
        this.f2182h = z4;
        this.f2183i = z5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f2175a.equals(this.f2175a) && jVar.f2176b.equals(this.f2176b) && jVar.f2177c == this.f2177c && jVar.f2178d.equals(this.f2178d) && jVar.f2179e.equals(this.f2179e) && jVar.f2180f == this.f2180f && jVar.f2181g == this.f2181g && jVar.f2182h == this.f2182h && jVar.f2183i == this.f2183i;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f2183i) + ((Boolean.hashCode(this.f2182h) + ((Boolean.hashCode(this.f2181g) + ((Boolean.hashCode(this.f2180f) + a0.a.e(a0.a.e(j4.b(a0.a.e(a0.a.e(527, 31, this.f2175a), 31, this.f2176b), 31, this.f2177c), 31, this.f2178d), 31, this.f2179e)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2175a);
        sb.append('=');
        sb.append(this.f2176b);
        if (this.f2182h) {
            long j3 = this.f2177c;
            if (j3 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String str = ((DateFormat) n2.d.f2762a.get()).format(new Date(j3));
                str.getClass();
                sb.append(str);
            }
        }
        if (!this.f2183i) {
            sb.append("; domain=");
            sb.append(this.f2178d);
        }
        sb.append("; path=");
        sb.append(this.f2179e);
        if (this.f2180f) {
            sb.append("; secure");
        }
        if (this.f2181g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
