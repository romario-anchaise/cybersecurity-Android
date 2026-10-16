// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends f1.d {
    /* JADX WARN: Code duplicated, block: B:14:0x0069 A[PHI: r8
  0x0069: PHI (r8v2 java.lang.String) = (r8v1 java.lang.String), (r8v3 java.lang.String) binds: [B:13:0x0067, B:29:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    public static String I(String str) {
        F0.i.e(str, "<this>");
        if (m.N("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        e.d0(0);
        List listI = L0.e.I(new L0.j(new c(str, 0, 0, new n(p036u0.e.p(new String[]{"\r\n", "\n", "\r"}), false, 1)), new o(0, str)));
        int length = str.length();
        listI.size();
        int iP = p036u0.g.p(listI);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listI) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == iP) && m.N(str2)) {
                str2 = strSubstring;
            } else {
                int length2 = str2.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i4 = -1;
                        break;
                    }
                    char cCharAt = str2.charAt(i4);
                    if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                        break;
                    }
                    i4++;
                }
                if (i4 != -1 && m.Q(str2, "|", i4, false)) {
                    strSubstring = str2.substring("|".length() + i4);
                    F0.i.d(strSubstring, "substring(...)");
                }
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder(length);
        p036u0.f.v(arrayList, sb, "\n", "", "", -1, "...", null);
        String string = sb.toString();
        F0.i.d(string, "toString(...)");
        return string;
    }
}
