// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.i;
import java.util.Arrays;
import p023n.a;
import p036u0.e;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f3690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f3691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f3692c;

    public j() {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f3690a = new int[i5];
        this.f3691b = new Object[i5];
    }

    public final void b(int i2, Object obj) {
        int i3 = this.f3692c;
        if (i3 == 0 || i2 > this.f3690a[i3 - 1]) {
            if (i3 >= this.f3690a.length) {
                int i4 = (i3 + 1) * 4;
                for (int i5 = 4; i5 < 32; i5++) {
                    int i6 = (1 << i5) - 12;
                    if (i4 <= i6) {
                        i4 = i6;
                        break;
                    }
                }
                int i7 = i4 / 4;
                int[] iArrCopyOf = Arrays.copyOf(this.f3690a, i7);
                i.d(iArrCopyOf, "copyOf(this, newSize)");
                this.f3690a = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.f3691b, i7);
                i.d(objArrCopyOf, "copyOf(this, newSize)");
                this.f3691b = objArrCopyOf;
            }
            this.f3690a[i3] = i2;
            this.f3691b[i3] = obj;
            this.f3692c = i3 + 1;
            return;
        }
        int iA = a.a(this.f3692c, i2, this.f3690a);
        if (iA >= 0) {
            this.f3691b[iA] = obj;
            return;
        }
        int i8 = ~iA;
        int i9 = this.f3692c;
        if (i8 < i9) {
            Object[] objArr = this.f3691b;
            if (objArr[i8] == h.f3686b) {
                this.f3690a[i8] = i2;
                objArr[i8] = obj;
                return;
            }
        }
        if (i9 >= this.f3690a.length) {
            int i10 = (i9 + 1) * 4;
            for (int i11 = 4; i11 < 32; i11++) {
                int i12 = (1 << i11) - 12;
                if (i10 <= i12) {
                    i10 = i12;
                    break;
                }
            }
            int i13 = i10 / 4;
            int[] iArrCopyOf2 = Arrays.copyOf(this.f3690a, i13);
            i.d(iArrCopyOf2, "copyOf(this, newSize)");
            this.f3690a = iArrCopyOf2;
            Object[] objArrCopyOf2 = Arrays.copyOf(this.f3691b, i13);
            i.d(objArrCopyOf2, "copyOf(this, newSize)");
            this.f3691b = objArrCopyOf2;
        }
        int i14 = this.f3692c;
        if (i14 - i8 != 0) {
            int[] iArr = this.f3690a;
            int i15 = i8 + 1;
            e.s(i15, i8, i14, iArr, iArr);
            Object[] objArr2 = this.f3691b;
            e.t(objArr2, objArr2, i15, i8, this.f3692c);
        }
        this.f3690a[i8] = i2;
        this.f3691b[i8] = obj;
        this.f3692c++;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        i.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        j jVar = (j) objClone;
        jVar.f3690a = (int[]) this.f3690a.clone();
        jVar.f3691b = (Object[]) this.f3691b.clone();
        return jVar;
    }

    public final String toString() {
        int i2 = this.f3692c;
        if (i2 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i2 * 28);
        sb.append('{');
        int i3 = this.f3692c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(this.f3690a[i4]);
            sb.append('=');
            Object obj = this.f3691b[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        i.d(string, "buffer.toString()");
        return string;
    }
}
