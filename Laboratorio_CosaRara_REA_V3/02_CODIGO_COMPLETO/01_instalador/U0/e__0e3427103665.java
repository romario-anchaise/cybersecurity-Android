// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import F0.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import p028p0.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends a {
    public static List p(Object[] objArr) {
        i.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        i.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static boolean q(Object[] objArr, Object obj) {
        int i2;
        i.e(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i2 = 0;
            while (i2 < length) {
                if (objArr[i2] != null) {
                    i2++;
                }
            }
            i2 = -1;
        } else {
            int length2 = objArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (obj.equals(objArr[i3])) {
                    i2 = i3;
                }
            }
            i2 = -1;
        }
        return i2 >= 0;
    }

    public static void r(int i2, int i3, int i4, byte[] bArr, byte[] bArr2) {
        i.e(bArr, "<this>");
        i.e(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
    }

    public static void s(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        i.e(iArr, "<this>");
        i.e(iArr2, "destination");
        System.arraycopy(iArr, i3, iArr2, i2, i4 - i3);
    }

    public static void t(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        i.e(objArr, "<this>");
        i.e(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
    }

    public static /* synthetic */ void u(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        t(objArr, objArr2, 0, i2, i3);
    }

    public static byte[] v(byte[] bArr, int i2, int i3) {
        i.e(bArr, "<this>");
        a.d(i3, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        i.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static void w(Object[] objArr, int i2, int i3) {
        i.e(objArr, "<this>");
        Arrays.fill(objArr, i2, i3, (Object) null);
    }

    public static ArrayList x(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static char y(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }
}
