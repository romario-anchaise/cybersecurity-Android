// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import e2.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f2189c;

    public o(String[] strArr) {
        this.f2189c = strArr;
    }

    public final String a(String str) {
        str.getClass();
        String[] strArr = this.f2189c;
        int length = strArr.length - 2;
        int i3 = m0.a.i(length, 0, -2);
        if (i3 > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == i3) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final String b(int i3) {
        return this.f2189c[i3 * 2];
    }

    public final n1 c() {
        n1 n1Var = new n1(9);
        ArrayList arrayList = (ArrayList) n1Var.f905c;
        arrayList.getClass();
        String[] strArr = this.f2189c;
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        arrayList.addAll(listAsList);
        return n1Var;
    }

    public final TreeMap d() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        comparator.getClass();
        TreeMap treeMap = new TreeMap(comparator);
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            String strB = b(i3);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strB.toLowerCase(locale);
            lowerCase.getClass();
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(e(i3));
        }
        return treeMap;
    }

    public final String e(int i3) {
        return this.f2189c[(i3 * 2) + 1];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return Arrays.equals(this.f2189c, ((o) obj).f2189c);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2189c);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        h1.b[] bVarArr = new h1.b[size];
        for (int i3 = 0; i3 < size; i3++) {
            bVarArr[i3] = new h1.b(b(i3), e(i3));
        }
        return new i1.a(bVarArr);
    }

    public final int size() {
        return this.f2189c.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            String strB = b(i3);
            String strE = e(i3);
            sb.append(strB);
            sb.append(": ");
            if (j2.b.q(strB)) {
                strE = "██";
            }
            sb.append(strE);
            sb.append("\n");
        }
        return sb.toString();
    }
}
