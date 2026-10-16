// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

import i1.q;
import java.util.ArrayList;
import java.util.List;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends q2.k {
    /* JADX WARN: Code duplicated, block: B:25:0x006f A[PHI: r8
  0x006f: PHI (r8v2 java.lang.String) = (r8v1 java.lang.String), (r8v3 java.lang.String) binds: [B:24:0x006d, B:39:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    public static String u(String str) {
        List listK;
        if (d.F("|")) {
            o2.i("marginPrefix must be non-blank string.");
            return null;
        }
        c cVar = new c(str);
        if (cVar.hasNext()) {
            Object next = cVar.next();
            if (cVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (cVar.hasNext()) {
                    arrayList.add(cVar.next());
                }
                listK = arrayList;
            } else {
                listK = m0.a.k(next);
            }
        } else {
            listK = q.f2104c;
        }
        int length = str.length();
        listK.size();
        int size = listK.size() - 1;
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (Object obj : listK) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i3 == 0 || i3 == size) && d.F(str2)) {
                str2 = strSubstring;
            } else {
                int length2 = str2.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        i5 = -1;
                        break;
                    }
                    if (!q2.c.u(str2.charAt(i5))) {
                        break;
                    }
                    i5++;
                }
                if (i5 != -1 && l.y(str2, "|", i5, false)) {
                    strSubstring = str2.substring("|".length() + i5);
                }
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
            i3 = i4;
        }
        StringBuilder sb = new StringBuilder(length);
        i1.i.C(arrayList2, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}
