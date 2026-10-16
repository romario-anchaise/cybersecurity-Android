// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f6358h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f6361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f6362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f6363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f6364f;

    static {
        String str = t9.f5173d;
        f6357g = str;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String strC = c(str);
        if (!strC.isEmpty()) {
            linkedHashSet.add(strC);
        }
        f6358h = Collections.unmodifiableSet(linkedHashSet);
    }

    public p(boolean z2, String str, Set set, Set set2, Set set3, Set set4) {
        this.f6359a = z2;
        this.f6360b = str;
        this.f6361c = set;
        this.f6362d = set2;
        this.f6363e = set3;
        this.f6364f = set4;
    }

    public static p a(String str, String str2, List list, ArrayList arrayList, List list2) {
        boolean z2;
        String strC = c(str2);
        String str3 = strC.isEmpty() ? "und" : strC;
        if (!f6357g.equals(c(str))) {
            String strC2 = c(str3);
            String str4 = strC2.isEmpty() ? "und" : strC2;
            Set set = Collections.EMPTY_SET;
            return new p(false, str4, set, set, set, set);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i3 = 0;
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                String strM = m0.a.m(c((String) it.next()));
                if (strM.codePointCount(0, strM.length()) >= 2) {
                    linkedHashSet.add(strM);
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        Set set2 = f6358h;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String strC3 = c((String) it2.next());
                if (!strC3.isEmpty()) {
                    String lowerCase = strC3.toLowerCase(Locale.ROOT);
                    if (!(set2.contains(lowerCase) ? false : lowerCase.matches("[a-z][a-z0-9_]*(\\.[a-z0-9_]+){2,}"))) {
                        String strM2 = m0.a.m(strC3);
                        if (strM2.codePointCount(0, strM2.length()) >= 2) {
                            Iterator it3 = linkedHashSet.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (((String) it3.next()).contains(strM2)) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (!z2) {
                                linkedHashSet2.add(strC3);
                                linkedHashSet3.add(strM2);
                            }
                        }
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            o oVarI = i((String) obj);
            String str5 = oVarI.f6354b;
            if (set2.contains(oVarI.f6353a) && !str5.isEmpty()) {
                b(linkedHashSet4, linkedHashSet5, oVarI.f6355c);
                b(linkedHashSet4, linkedHashSet5, oVarI.f6356d);
                b(linkedHashSet4, linkedHashSet5, str5);
            }
        }
        return new p(true, str3, Collections.unmodifiableSet(new LinkedHashSet(linkedHashSet2)), Collections.unmodifiableSet(new LinkedHashSet(linkedHashSet3)), Collections.unmodifiableSet(new LinkedHashSet(linkedHashSet4)), Collections.unmodifiableSet(new LinkedHashSet(linkedHashSet5)));
    }

    public static void b(LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        linkedHashSet.add(strTrim);
        linkedHashSet2.add(m0.a.m(strTrim));
    }

    public static String c(String str) {
        return str == null ? "" : str.trim();
    }

    public static o i(String str) {
        int iIndexOf;
        String strC = c(str);
        boolean zIsEmpty = strC.isEmpty();
        o oVar = o.f6352e;
        if (!zIsEmpty && (iIndexOf = strC.indexOf(47)) >= 1 && iIndexOf < strC.length() - 1) {
            String strTrim = strC.substring(0, iIndexOf).trim();
            String strTrim2 = strC.substring(iIndexOf + 1).trim();
            if (strTrim2.startsWith(".")) {
                strTrim2 = strTrim + strTrim2;
            }
            if (!strTrim.isEmpty() && !strTrim2.isEmpty()) {
                return new o(strTrim, strTrim2, strTrim + "/" + strTrim2, strTrim + "/" + (strTrim2.startsWith(strTrim.concat(".")) ? strTrim2.substring(strTrim.length()) : strTrim2));
            }
        }
        return oVar;
    }

    public final int d(String str, String str2) {
        if (!this.f6359a) {
            return 1;
        }
        if (c(str).isEmpty()) {
            return (c(str2).isEmpty() || !f(str2)) ? 1 : 3;
        }
        return g(str) ? 4 : 1;
    }

    public final int e(CharSequence charSequence) {
        if (!this.f6359a || charSequence == null || charSequence.length() == 0) {
            return 1;
        }
        String strM = m0.a.m(charSequence);
        if (strM.isEmpty()) {
            return 1;
        }
        for (String str : this.f6364f) {
            if (!str.isEmpty() && strM.contains(str)) {
                return 3;
            }
        }
        Iterator it = f6358h.iterator();
        while (it.hasNext()) {
            String strM2 = m0.a.m((String) it.next());
            if (!strM2.isEmpty() && strM.contains(strM2)) {
                return 4;
            }
        }
        for (String str2 : this.f6362d) {
            if (!str2.isEmpty() && strM.contains(str2)) {
                return 2;
            }
        }
        return 1;
    }

    public final boolean f(String str) {
        if (!this.f6359a) {
            return false;
        }
        o oVarI = i(str);
        if (!f6358h.contains(oVarI.f6353a)) {
            return false;
        }
        Set set = this.f6363e;
        return set.isEmpty() || set.contains(oVarI.f6355c) || set.contains(oVarI.f6354b) || set.contains(oVarI.f6356d);
    }

    public final boolean g(String str) {
        return this.f6359a && f6358h.contains(c(str));
    }

    public final boolean h(CharSequence charSequence) {
        return e(charSequence) != 1;
    }
}
