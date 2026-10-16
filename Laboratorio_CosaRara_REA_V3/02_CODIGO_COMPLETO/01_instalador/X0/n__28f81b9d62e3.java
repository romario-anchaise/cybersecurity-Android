// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import A.C0005e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class n implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f1012a;

    public n(String[] strArr) {
        this.f1012a = strArr;
    }

    public final String a(String str) {
        F0.i.e(str, "name");
        String[] strArr = this.f1012a;
        int length = strArr.length - 2;
        int iK = p029q.j.k(length, 0, -2);
        if (iK <= length) {
            while (!str.equalsIgnoreCase(strArr[length])) {
                if (length != iK) {
                    length -= 2;
                }
            }
            return strArr[length + 1];
        }
        return null;
    }

    public final String b(int i2) {
        return this.f1012a[i2 * 2];
    }

    public final C0005e c() {
        C0005e c0005e = new C0005e(10);
        ArrayList arrayList = (ArrayList) c0005e.f34b;
        F0.i.e(arrayList, "<this>");
        String[] strArr = this.f1012a;
        F0.i.e(strArr, "elements");
        arrayList.addAll(p036u0.e.p(strArr));
        return c0005e;
    }

    public final String d(int i2) {
        return this.f1012a[(i2 * 2) + 1];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            if (Arrays.equals(this.f1012a, ((n) obj).f1012a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1012a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        p034t0.d[] dVarArr = new p034t0.d[size];
        for (int i2 = 0; i2 < size; i2++) {
            dVarArr[i2] = new p034t0.d(b(i2), d(i2));
        }
        return new F0.a(dVarArr);
    }

    public final int size() {
        return this.f1012a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String strB = b(i2);
            String strD = d(i2);
            sb.append(strB);
            sb.append(": ");
            if (Y0.b.q(strB)) {
                strD = "██";
            }
            sb.append(strD);
            sb.append("\n");
        }
        String string = sb.toString();
        F0.i.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
