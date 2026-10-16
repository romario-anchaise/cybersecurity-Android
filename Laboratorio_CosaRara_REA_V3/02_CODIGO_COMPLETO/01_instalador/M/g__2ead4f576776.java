// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.h;
import F0.i;
import java.util.Arrays;
import p023n.a;
import p036u0.e;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f3681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f3682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f3683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f3684d;

    public g() {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 80;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (80 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 8;
        this.f3682b = new long[i5];
        this.f3683c = new Object[i5];
    }

    public final void b(long j2, Object obj) {
        int iB = a.b(this.f3682b, this.f3684d, j2);
        if (iB >= 0) {
            this.f3683c[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i3 = this.f3684d;
        Object obj2 = h.f3685a;
        if (i2 < i3) {
            Object[] objArr = this.f3683c;
            if (objArr[i2] == obj2) {
                this.f3682b[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f3681a) {
            long[] jArr = this.f3682b;
            if (i3 >= jArr.length) {
                Object[] objArr2 = this.f3683c;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj3 = objArr2[i5];
                    if (obj3 != obj2) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr2[i4] = obj3;
                            objArr2[i5] = null;
                        }
                        i4++;
                    }
                }
                this.f3681a = false;
                this.f3684d = i4;
                i2 = ~a.b(this.f3682b, i4, j2);
            }
        }
        int i6 = this.f3684d;
        if (i6 >= this.f3682b.length) {
            int i7 = (i6 + 1) * 8;
            for (int i8 = 4; i8 < 32; i8++) {
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
            }
            int i10 = i7 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f3682b, i10);
            i.d(jArrCopyOf, "copyOf(this, newSize)");
            this.f3682b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3683c, i10);
            i.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f3683c = objArrCopyOf;
        }
        int i11 = this.f3684d - i2;
        if (i11 != 0) {
            long[] jArr2 = this.f3682b;
            int i12 = i2 + 1;
            i.e(jArr2, "<this>");
            System.arraycopy(jArr2, i2, jArr2, i12, i11);
            Object[] objArr3 = this.f3683c;
            e.t(objArr3, objArr3, i12, i2, this.f3684d);
        }
        this.f3682b[i2] = j2;
        this.f3683c[i2] = obj;
        this.f3684d++;
    }

    public final int c() {
        if (this.f3681a) {
            int i2 = this.f3684d;
            long[] jArr = this.f3682b;
            Object[] objArr = this.f3683c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != h.f3685a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f3681a = false;
            this.f3684d = i3;
        }
        return this.f3684d;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        i.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        g gVar = (g) objClone;
        gVar.f3682b = (long[]) this.f3682b.clone();
        gVar.f3683c = (Object[]) this.f3683c.clone();
        return gVar;
    }

    public final Object d(int i2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.f3684d)) {
            throw new IllegalArgumentException(h.b(i2, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f3681a) {
            long[] jArr = this.f3682b;
            Object[] objArr = this.f3683c;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = objArr[i5];
                if (obj != h.f3685a) {
                    if (i5 != i4) {
                        jArr[i4] = jArr[i5];
                        objArr[i4] = obj;
                        objArr[i5] = null;
                    }
                    i4++;
                }
            }
            this.f3681a = false;
            this.f3684d = i4;
        }
        return this.f3683c[i2];
    }

    public final String toString() {
        int i2;
        if (c() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3684d * 28);
        sb.append('{');
        int i3 = this.f3684d;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            if (i4 < 0 || i4 >= (i2 = this.f3684d)) {
                throw new IllegalArgumentException(h.b(i4, "Expected index to be within 0..size()-1, but was ").toString());
            }
            if (this.f3681a) {
                long[] jArr = this.f3682b;
                Object[] objArr = this.f3683c;
                int i5 = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    Object obj = objArr[i6];
                    if (obj != h.f3685a) {
                        if (i6 != i5) {
                            jArr[i5] = jArr[i6];
                            objArr[i5] = obj;
                            objArr[i6] = null;
                        }
                        i5++;
                    }
                }
                this.f3681a = false;
                this.f3684d = i5;
            }
            sb.append(this.f3682b[i4]);
            sb.append('=');
            Object objD = d(i4);
            if (objD != sb) {
                sb.append(objD);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        i.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
