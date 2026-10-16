// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import e2.n1;
import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f2194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f2195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f2196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f2197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f2198i;

    public p(a aVar, n1 n1Var, m2.i iVar, m mVar) {
        List listL;
        this.f2190a = 1;
        n1Var.getClass();
        mVar.getClass();
        this.f2193d = aVar;
        this.f2194e = n1Var;
        this.f2195f = iVar;
        this.f2196g = mVar;
        i1.q qVar = i1.q.f2104c;
        this.f2197h = qVar;
        this.f2198i = qVar;
        this.f2192c = new ArrayList();
        q qVar2 = aVar.f2114h;
        qVar2.getClass();
        URI uriG = qVar2.g();
        if (uriG.getHost() == null) {
            listL = j2.b.l(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = aVar.f2113g.select(uriG);
            listL = (listSelect == null || listSelect.isEmpty()) ? j2.b.l(Proxy.NO_PROXY) : j2.b.x(listSelect);
        }
        this.f2197h = listL;
        this.f2191b = 0;
    }

    public q a() {
        ArrayList arrayList;
        String str = (String) this.f2193d;
        if (str == null) {
            o2.k("scheme == null");
            return null;
        }
        String strE = b.e((String) this.f2194e, 0, 0, 7);
        String strE2 = b.e((String) this.f2195f, 0, 0, 7);
        String str2 = (String) this.f2196g;
        if (str2 == null) {
            o2.k("host == null");
            return null;
        }
        int iB = b();
        ArrayList arrayList2 = this.f2192c;
        ArrayList arrayList3 = new ArrayList(i1.k.A(arrayList2));
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            arrayList3.add(b.e((String) obj, 0, 0, 7));
        }
        ArrayList arrayList4 = (ArrayList) this.f2198i;
        if (arrayList4 != null) {
            ArrayList arrayList5 = new ArrayList(i1.k.A(arrayList4));
            int size2 = arrayList4.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList4.get(i4);
                i4++;
                String str3 = (String) obj2;
                arrayList5.add(str3 != null ? b.e(str3, 0, 0, 3) : null);
            }
            arrayList = arrayList5;
        } else {
            arrayList = null;
        }
        String str4 = (String) this.f2197h;
        return new q(str, strE, strE2, str2, iB, arrayList3, arrayList, str4 != null ? b.e(str4, 0, 0, 7) : null, toString());
    }

    public int b() {
        int i3 = this.f2191b;
        if (i3 != -1) {
            return i3;
        }
        String str = (String) this.f2193d;
        str.getClass();
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public boolean c() {
        return this.f2191b < ((List) this.f2197h).size() || !this.f2192c.isEmpty();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    public void d(q qVar, String str) {
        int i3;
        int i4;
        int iF;
        int i5;
        int i6;
        char cCharAt;
        str.getClass();
        byte[] bArr = j2.b.f2361a;
        int iN = j2.b.n(0, str.length(), str);
        int iO = j2.b.o(iN, str.length(), str);
        byte b3 = -1;
        if (iO - iN >= 2) {
            char cCharAt2 = str.charAt(iN);
            if ((q1.e.b(cCharAt2, 97) >= 0 && q1.e.b(cCharAt2, 122) <= 0) || (q1.e.b(cCharAt2, 65) >= 0 && q1.e.b(cCharAt2, 90) <= 0)) {
                i3 = iN + 1;
                while (true) {
                    if (i3 < iO) {
                        char cCharAt3 = str.charAt(i3);
                        if (('a' > cCharAt3 || cCharAt3 >= '{') && (('A' > cCharAt3 || cCharAt3 >= '[') && !(('0' <= cCharAt3 && cCharAt3 < ':') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                            if (cCharAt3 == ':') {
                                break;
                            } else {
                                break;
                            }
                        }
                        i3++;
                    }
                    i3 = -1;
                    break;
                }
            } else {
                i3 = -1;
                break;
            }
        } else {
            i3 = -1;
            break;
        }
        int i7 = 1;
        if (i3 != -1) {
            if (v1.l.y(str, "https:", iN, true)) {
                this.f2193d = "https";
                iN += 6;
            } else {
                if (!v1.l.y(str, "http:", iN, true)) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, i3) + '\'');
                }
                this.f2193d = "http";
                iN += 5;
            }
        } else {
            if (qVar == null) {
                o2.i("Expected URL scheme 'http' or 'https' but no scheme was found for ".concat(str.length() > 6 ? v1.d.I(str, 6).concat("...") : str));
                return;
            }
            this.f2193d = qVar.f2200a;
        }
        int i8 = iN;
        int i9 = 0;
        while (true) {
            i4 = i7;
            if (i8 >= iO || !((cCharAt = str.charAt(i8)) == '\\' || cCharAt == '/')) {
                break;
            }
            i9++;
            i8++;
            i7 = i4;
        }
        ArrayList arrayList = this.f2192c;
        byte b4 = 35;
        if (i9 >= 2 || qVar == null || !q1.e.a(qVar.f2200a, (String) this.f2193d)) {
            int i10 = iN + i9;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                iF = j2.b.f(i10, iO, str, "@/\\?#");
                byte bCharAt = iF != iO ? str.charAt(iF) : b3;
                if (bCharAt == b3 || bCharAt == b4 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                    break;
                }
                if (bCharAt == 64) {
                    if (i11 == 0) {
                        int iG = j2.b.g(str, ':', i10, iF);
                        String strB = b.b(str, i10, iG, " \"':;<=>@[]^`{}|/\\?#", 240);
                        if (i12 != 0) {
                            strB = ((String) this.f2194e) + "%40" + strB;
                        }
                        this.f2194e = strB;
                        if (iG != iF) {
                            this.f2195f = b.b(str, iG + 1, iF, " \"':;<=>@[]^`{}|/\\?#", 240);
                            i11 = i4;
                        }
                        i12 = i4;
                    } else {
                        this.f2195f = ((String) this.f2195f) + "%40" + b.b(str, i10, iF, " \"':;<=>@[]^`{}|/\\?#", 240);
                    }
                    i10 = iF + 1;
                    b3 = -1;
                    b4 = 35;
                }
            }
            int i13 = i10;
            while (true) {
                if (i13 >= iF) {
                    i13 = iF;
                    break;
                }
                char cCharAt4 = str.charAt(i13);
                if (cCharAt4 == '[') {
                    do {
                        i13++;
                        if (i13 >= iF) {
                            break;
                        }
                    } while (str.charAt(i13) != ']');
                } else if (cCharAt4 == ':') {
                    break;
                }
                i13++;
            }
            int i14 = i13 + 1;
            if (i14 < iF) {
                this.f2196g = q2.c.C(b.e(str, i10, i13, 4));
                try {
                    i6 = Integer.parseInt(b.b(str, i14, iF, "", 248));
                    if (i4 > i6 || i6 >= 65536) {
                        i6 = -1;
                    }
                } catch (NumberFormatException unused) {
                }
                this.f2191b = i6;
                if (i6 == -1) {
                    b2.a.j(str.substring(i14, iF), "Invalid URL port: \"");
                    return;
                }
            } else {
                this.f2196g = q2.c.C(b.e(str, i10, i13, 4));
                String str2 = (String) this.f2193d;
                str2.getClass();
                if (str2.equals("http")) {
                    i5 = 80;
                } else {
                    i5 = str2.equals("https") ? 443 : -1;
                }
                this.f2191b = i5;
            }
            if (((String) this.f2196g) == null) {
                b2.a.j(str.substring(i10, i13), "Invalid URL host: \"");
                return;
            }
            iN = iF;
        } else {
            this.f2194e = qVar.e();
            this.f2195f = qVar.a();
            this.f2196g = qVar.f2203d;
            this.f2191b = qVar.f2204e;
            arrayList.clear();
            arrayList.addAll(qVar.c());
            if (iN == iO || str.charAt(iN) == '#') {
                String strD = qVar.d();
                this.f2198i = strD != null ? b.f(b.b(strD, 0, 0, " \"'<>#", 211)) : null;
            }
        }
        int iF2 = j2.b.f(iN, iO, str, "?#");
        if (iN != iF2) {
            char cCharAt5 = str.charAt(iN);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                arrayList.clear();
                arrayList.add("");
                iN++;
            } else {
                arrayList.set(arrayList.size() - 1, "");
            }
            while (iN < iF2) {
                int iF3 = j2.b.f(iN, iF2, str, "/\\");
                boolean z2 = iF3 < iF2;
                String strB2 = b.b(str, iN, iF3, " \"<>^`{}|/\\?#", 240);
                if (!strB2.equals(".") && !strB2.equalsIgnoreCase("%2e")) {
                    if (!strB2.equals("..") && !strB2.equalsIgnoreCase("%2e.") && !strB2.equalsIgnoreCase(".%2e") && !strB2.equalsIgnoreCase("%2e%2e")) {
                        if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
                            arrayList.set(arrayList.size() - 1, strB2);
                        } else {
                            arrayList.add(strB2);
                        }
                        if (z2) {
                            arrayList.add("");
                        }
                    } else if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                        arrayList.add("");
                    } else {
                        arrayList.set(arrayList.size() - 1, "");
                    }
                }
                iN = z2 ? iF3 + 1 : iF3;
            }
        }
        if (iF2 < iO && str.charAt(iF2) == '?') {
            int iG2 = j2.b.g(str, '#', iF2, iO);
            this.f2198i = b.f(b.b(str, iF2 + 1, iG2, " \"'<>#", 208));
            iF2 = iG2;
        }
        if (iF2 >= iO || str.charAt(iF2) != '#') {
            return;
        }
        this.f2197h = b.b(str, iF2 + 1, iO, "", 176);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ab  */
    public String toString() {
        switch (this.f2190a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                String str = (String) this.f2193d;
                if (str != null) {
                    sb.append(str);
                    sb.append("://");
                } else {
                    sb.append("//");
                }
                if (((String) this.f2194e).length() > 0 || ((String) this.f2195f).length() > 0) {
                    sb.append((String) this.f2194e);
                    if (((String) this.f2195f).length() > 0) {
                        sb.append(':');
                        sb.append((String) this.f2195f);
                    }
                    sb.append('@');
                }
                String str2 = (String) this.f2196g;
                if (str2 != null) {
                    if (v1.d.A(str2, ':')) {
                        sb.append('[');
                        sb.append((String) this.f2196g);
                        sb.append(']');
                    } else {
                        sb.append((String) this.f2196g);
                    }
                }
                int i3 = -1;
                if (this.f2191b != -1 || ((String) this.f2193d) != null) {
                    int iB = b();
                    String str3 = (String) this.f2193d;
                    if (str3 == null) {
                        sb.append(':');
                        sb.append(iB);
                    } else {
                        if (str3.equals("http")) {
                            i3 = 80;
                        } else if (str3.equals("https")) {
                            i3 = 443;
                        }
                        if (iB != i3) {
                            sb.append(':');
                            sb.append(iB);
                        }
                    }
                }
                ArrayList arrayList = this.f2192c;
                arrayList.getClass();
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    sb.append('/');
                    sb.append((String) arrayList.get(i4));
                }
                if (((ArrayList) this.f2198i) != null) {
                    sb.append('?');
                    ArrayList arrayList2 = (ArrayList) this.f2198i;
                    arrayList2.getClass();
                    s1.a aVarM = y.f.m(y.f.o(0, arrayList2.size()), 2);
                    int i5 = aVarM.f3229c;
                    int i6 = aVarM.f3230d;
                    int i7 = aVarM.f3231e;
                    if ((i7 > 0 && i5 <= i6) || (i7 < 0 && i6 <= i5)) {
                        while (true) {
                            String str4 = (String) arrayList2.get(i5);
                            String str5 = (String) arrayList2.get(i5 + 1);
                            if (i5 > 0) {
                                sb.append('&');
                            }
                            sb.append(str4);
                            if (str5 != null) {
                                sb.append('=');
                                sb.append(str5);
                            }
                            if (i5 != i6) {
                                i5 += i7;
                            }
                        }
                    }
                }
                if (((String) this.f2197h) != null) {
                    sb.append('#');
                    sb.append((String) this.f2197h);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public p() {
        this.f2190a = 0;
        this.f2194e = "";
        this.f2195f = "";
        this.f2191b = -1;
        ArrayList arrayList = new ArrayList();
        this.f2192c = arrayList;
        arrayList.add("");
    }
}
