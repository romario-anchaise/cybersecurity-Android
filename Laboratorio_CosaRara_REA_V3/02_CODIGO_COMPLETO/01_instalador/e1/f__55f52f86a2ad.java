// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import H.C0028c;
import k1.C0196l;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0196l f2300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f2303d;

    static {
        C0196l c0196l = C0196l.f3483d;
        f2300a = C0028c.p("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f2301b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f2302c = new String[64];
        String[] strArr = new String[256];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            F0.i.d(binaryString, "toBinaryString(it)");
            String strReplace = Y0.b.i("%8s", binaryString).replace(' ', '0');
            F0.i.d(strReplace, "replace(...)");
            strArr[i2] = strReplace;
        }
        f2303d = strArr;
        String[] strArr2 = f2302c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i3 = iArr[0];
        strArr2[i3 | 8] = strArr2[i3] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            String[] strArr3 = f2302c;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            strArr3[i7 | 8] = strArr3[i6] + '|' + strArr3[i5] + "|PADDED";
        }
        int length = f2302c.length;
        for (int i8 = 0; i8 < length; i8++) {
            String[] strArr4 = f2302c;
            if (strArr4[i8] == null) {
                strArr4[i8] = f2303d[i8];
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    public static String a(int i2, int i3, int i4, int i5, boolean z2) {
        String strP;
        String str;
        String[] strArr = f2301b;
        String strI = i4 < strArr.length ? strArr[i4] : Y0.b.i("0x%02x", Integer.valueOf(i4));
        if (i5 == 0) {
            strP = "";
        } else {
            String[] strArr2 = f2303d;
            if (i4 == 2 || i4 == 3) {
                strP = strArr2[i5];
            } else if (i4 == 4 || i4 == 6) {
                strP = i5 == 1 ? "ACK" : strArr2[i5];
            } else if (i4 == 7 || i4 == 8) {
                strP = strArr2[i5];
            } else {
                String[] strArr3 = f2302c;
                if (i5 < strArr3.length) {
                    str = strArr3[i5];
                    F0.i.b(str);
                } else {
                    str = strArr2[i5];
                }
                if (i4 != 5 || (i5 & 4) == 0) {
                    strP = (i4 != 0 || (i5 & 32) == 0) ? str : M0.m.P(str, "PRIORITY", "COMPRESSED");
                } else {
                    strP = M0.m.P(str, "HEADERS", "PUSH_PROMISE");
                }
            }
        }
        return Y0.b.i("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i3), strI, strP);
    }
}
