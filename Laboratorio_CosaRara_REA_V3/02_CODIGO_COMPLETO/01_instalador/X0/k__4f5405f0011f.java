// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f993j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f994k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f995l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f996m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1002f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1004i;

    public k(String str, String str2, long j2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f997a = str;
        this.f998b = str2;
        this.f999c = j2;
        this.f1000d = str3;
        this.f1001e = str4;
        this.f1002f = z2;
        this.g = z3;
        this.f1003h = z4;
        this.f1004i = z5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (F0.i.a(kVar.f997a, this.f997a) && F0.i.a(kVar.f998b, this.f998b) && kVar.f999c == this.f999c && F0.i.a(kVar.f1000d, this.f1000d) && F0.i.a(kVar.f1001e, this.f1001e) && kVar.f1002f == this.f1002f && kVar.g == this.g && kVar.f1003h == this.f1003h && kVar.f1004i == this.f1004i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1004i) + ((Boolean.hashCode(this.f1003h) + ((Boolean.hashCode(this.g) + ((Boolean.hashCode(this.f1002f) + ((this.f1001e.hashCode() + ((this.f1000d.hashCode() + ((Long.hashCode(this.f999c) + ((this.f998b.hashCode() + ((this.f997a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f997a);
        sb.append('=');
        sb.append(this.f998b);
        if (this.f1003h) {
            long j2 = this.f999c;
            if (j2 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String str = ((DateFormat) c1.c.f2181a.get()).format(new Date(j2));
                F0.i.d(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(str);
            }
        }
        if (!this.f1004i) {
            sb.append("; domain=");
            sb.append(this.f1000d);
        }
        sb.append("; path=");
        sb.append(this.f1001e);
        if (this.f1002f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        F0.i.d(string, "toString()");
        return string;
    }
}
