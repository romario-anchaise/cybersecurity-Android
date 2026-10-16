// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f1020k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f1026f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f1029j;

    public p(String str, String str2, String str3, String str4, int i2, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        F0.i.e(str, "scheme");
        F0.i.e(str4, "host");
        this.f1021a = str;
        this.f1022b = str2;
        this.f1023c = str3;
        this.f1024d = str4;
        this.f1025e = i2;
        this.f1026f = arrayList;
        this.g = arrayList2;
        this.f1027h = str5;
        this.f1028i = str6;
        this.f1029j = str.equals("https");
    }

    public final String a() {
        if (this.f1023c.length() == 0) {
            return "";
        }
        int length = this.f1021a.length() + 3;
        String str = this.f1028i;
        String strSubstring = str.substring(M0.e.X(str, ':', length, false, 4) + 1, M0.e.X(str, '@', 0, false, 6));
        F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f1021a.length() + 3;
        String str = this.f1028i;
        int iX = M0.e.X(str, '/', length, false, 4);
        String strSubstring = str.substring(iX, Y0.b.g(str, iX, str.length(), "?#"));
        F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f1021a.length() + 3;
        String str = this.f1028i;
        int iX = M0.e.X(str, '/', length, false, 4);
        int iG = Y0.b.g(str, iX, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iX < iG) {
            int i2 = iX + 1;
            int iF = Y0.b.f(str, '/', i2, iG);
            String strSubstring = str.substring(i2, iF);
            F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iX = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.g == null) {
            return null;
        }
        String str = this.f1028i;
        int iX = M0.e.X(str, '?', 0, false, 6) + 1;
        String strSubstring = str.substring(iX, Y0.b.f(str, '#', iX, str.length()));
        F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.f1022b.length() == 0) {
            return "";
        }
        int length = this.f1021a.length() + 3;
        String str = this.f1028i;
        String strSubstring = str.substring(length, Y0.b.g(str, length, str.length(), ":@"));
        F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && F0.i.a(((p) obj).f1028i, this.f1028i);
    }

    public final o f(String str) {
        F0.i.e(str, "link");
        try {
            o oVar = new o();
            oVar.c(this, str);
            return oVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String g() {
        o oVarF = f("/...");
        F0.i.b(oVarF);
        oVarF.f1014b = C0055b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        oVarF.f1015c = C0055b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        return oVarF.a().f1028i;
    }

    public final URI h() {
        String strSubstring;
        String strReplaceAll;
        o oVar = new o();
        String str = this.f1021a;
        oVar.f1013a = str;
        oVar.f1014b = e();
        oVar.f1015c = a();
        oVar.f1016d = this.f1024d;
        F0.i.e(str, "scheme");
        int i2 = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i3 = this.f1025e;
        oVar.f1017e = i3 != i2 ? i3 : -1;
        ArrayList arrayList = oVar.f1018f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        oVar.g = strD != null ? C0055b.f(C0055b.b(strD, 0, 0, " \"'<>#", true, false, true, false, 211)) : null;
        if (this.f1027h == null) {
            strSubstring = null;
        } else {
            String str2 = this.f1028i;
            strSubstring = str2.substring(M0.e.X(str2, '#', 0, false, 6) + 1);
            F0.i.d(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        oVar.f1019h = strSubstring;
        String str3 = oVar.f1016d;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            F0.i.d(patternCompile, "compile(...)");
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            F0.i.d(strReplaceAll, "replaceAll(...)");
        } else {
            strReplaceAll = null;
        }
        oVar.f1016d = strReplaceAll;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.set(i4, C0055b.b((String) arrayList.get(i4), 0, 0, "[]", true, true, false, false, 227));
        }
        ArrayList arrayList2 = oVar.g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                String str4 = (String) arrayList2.get(i5);
                arrayList2.set(i5, str4 != null ? C0055b.b(str4, 0, 0, "\\^`{|}", true, true, true, false, 195) : null);
            }
        }
        String str5 = oVar.f1019h;
        oVar.f1019h = str5 != null ? C0055b.b(str5, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 163) : null;
        String string = oVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                F0.i.d(patternCompile2, "compile(...)");
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                F0.i.d(strReplaceAll2, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll2);
                F0.i.d(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final int hashCode() {
        return this.f1028i.hashCode();
    }

    public final String toString() {
        return this.f1028i;
    }
}
