// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f2199j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f2205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2208i;

    public q(String str, String str2, String str3, String str4, int i3, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        str.getClass();
        str4.getClass();
        this.f2200a = str;
        this.f2201b = str2;
        this.f2202c = str3;
        this.f2203d = str4;
        this.f2204e = i3;
        this.f2205f = arrayList2;
        this.f2206g = str5;
        this.f2207h = str6;
        this.f2208i = str.equals("https");
    }

    public final String a() {
        if (this.f2202c.length() == 0) {
            return "";
        }
        int length = this.f2200a.length() + 3;
        String str = this.f2207h;
        return str.substring(v1.d.D(str, ':', length, 4) + 1, v1.d.D(str, '@', 0, 6));
    }

    public final String b() {
        int length = this.f2200a.length() + 3;
        String str = this.f2207h;
        int iD = v1.d.D(str, '/', length, 4);
        return str.substring(iD, j2.b.f(iD, str.length(), str, "?#"));
    }

    public final ArrayList c() {
        int length = this.f2200a.length() + 3;
        String str = this.f2207h;
        int iD = v1.d.D(str, '/', length, 4);
        int iF = j2.b.f(iD, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iD < iF) {
            int i3 = iD + 1;
            int iG = j2.b.g(str, '/', i3, iF);
            arrayList.add(str.substring(i3, iG));
            iD = iG;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f2205f == null) {
            return null;
        }
        String str = this.f2207h;
        int iD = v1.d.D(str, '?', 0, 6) + 1;
        return str.substring(iD, j2.b.g(str, '#', iD, str.length()));
    }

    public final String e() {
        if (this.f2201b.length() == 0) {
            return "";
        }
        int length = this.f2200a.length() + 3;
        String str = this.f2207h;
        return str.substring(length, j2.b.f(length, str.length(), str, ":@"));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q) && ((q) obj).f2207h.equals(this.f2207h);
    }

    public final String f() {
        p pVar;
        try {
            pVar = new p();
            pVar.d(this, "/...");
        } catch (IllegalArgumentException unused) {
            pVar = null;
        }
        pVar.getClass();
        pVar.f2194e = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        pVar.f2195f = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        return pVar.a().f2207h;
    }

    public final URI g() {
        String strSubstring;
        String strReplaceAll;
        p pVar = new p();
        String str = this.f2200a;
        pVar.f2193d = str;
        pVar.f2194e = e();
        pVar.f2195f = a();
        pVar.f2196g = this.f2203d;
        str.getClass();
        int i3 = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i4 = this.f2204e;
        pVar.f2191b = i4 != i3 ? i4 : -1;
        ArrayList arrayList = pVar.f2192c;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        pVar.f2198i = strD != null ? b.f(b.b(strD, 0, 0, " \"'<>#", 211)) : null;
        if (this.f2206g == null) {
            strSubstring = null;
        } else {
            String str2 = this.f2207h;
            strSubstring = str2.substring(v1.d.D(str2, '#', 0, 6) + 1);
        }
        pVar.f2197h = strSubstring;
        String str3 = (String) pVar.f2196g;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            strReplaceAll.getClass();
        } else {
            strReplaceAll = null;
        }
        pVar.f2196g = strReplaceAll;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.set(i5, b.b((String) arrayList.get(i5), 0, 0, "[]", 227));
        }
        ArrayList arrayList2 = (ArrayList) pVar.f2198i;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                String str4 = (String) arrayList2.get(i6);
                arrayList2.set(i6, str4 != null ? b.b(str4, 0, 0, "\\^`{|}", 195) : null);
            }
        }
        String str5 = (String) pVar.f2197h;
        pVar.f2197h = str5 != null ? b.b(str5, 0, 0, " \"#<>\\^`{|}", 163) : null;
        String string = pVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e3) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                patternCompile2.getClass();
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                strReplaceAll2.getClass();
                URI uriCreate = URI.create(strReplaceAll2);
                uriCreate.getClass();
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final int hashCode() {
        return this.f2207h.hashCode();
    }

    public final String toString() {
        return this.f2207h;
    }
}
