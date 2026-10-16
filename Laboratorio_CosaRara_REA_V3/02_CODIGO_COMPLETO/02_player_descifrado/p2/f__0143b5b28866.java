// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w2.k f2903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f2906d;

    static {
        w2.k kVar = w2.k.f5778f;
        f2903a = e0.i.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f2904b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f2905c = new String[64];
        String[] strArr = new String[256];
        for (int i3 = 0; i3 < 256; i3++) {
            String binaryString = Integer.toBinaryString(i3);
            binaryString.getClass();
            String strReplace = j2.b.i("%8s", binaryString).replace(' ', '0');
            strReplace.getClass();
            strArr[i3] = strReplace;
        }
        f2906d = strArr;
        String[] strArr2 = f2905c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i4 = iArr[0];
        strArr2[i4 | 8] = strArr2[i4] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            int i7 = iArr[0];
            String[] strArr3 = f2905c;
            int i8 = i7 | i6;
            strArr3[i8] = strArr3[i7] + '|' + strArr3[i6];
            strArr3[i8 | 8] = strArr3[i7] + '|' + strArr3[i6] + "|PADDED";
        }
        int length = f2905c.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr4 = f2905c;
            if (strArr4[i9] == null) {
                strArr4[i9] = f2906d[i9];
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    public static String a(boolean z2, int i3, int i4, int i5, int i6) {
        String strX;
        String str;
        String[] strArr = f2904b;
        String strI = i5 < strArr.length ? strArr[i5] : j2.b.i("0x%02x", Integer.valueOf(i5));
        if (i6 == 0) {
            strX = "";
        } else {
            String[] strArr2 = f2906d;
            if (i5 == 2 || i5 == 3) {
                strX = strArr2[i6];
            } else if (i5 == 4 || i5 == 6) {
                strX = i6 == 1 ? "ACK" : strArr2[i6];
            } else if (i5 == 7 || i5 == 8) {
                strX = strArr2[i6];
            } else {
                String[] strArr3 = f2905c;
                if (i6 < strArr3.length) {
                    str = strArr3[i6];
                    str.getClass();
                } else {
                    str = strArr2[i6];
                }
                if (i5 != 5 || (i6 & 4) == 0) {
                    strX = (i5 != 0 || (i6 & 32) == 0) ? str : v1.l.x(str, "PRIORITY", "COMPRESSED");
                } else {
                    strX = v1.l.x(str, "HEADERS", "PUSH_PROMISE");
                }
            }
        }
        return j2.b.i("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i3), Integer.valueOf(i4), strI, strX);
    }
}
