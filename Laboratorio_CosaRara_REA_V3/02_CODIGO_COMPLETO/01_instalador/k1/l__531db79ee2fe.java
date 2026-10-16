// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: renamed from: k1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0196l implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0196l f3483d = new C0196l(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f3485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f3486c;

    public C0196l(byte[] bArr) {
        F0.i.e(bArr, "data");
        this.f3484a = bArr;
    }

    public static int f(C0196l c0196l, C0196l c0196l2) {
        c0196l.getClass();
        F0.i.e(c0196l2, "other");
        return c0196l.e(c0196l2.f3484a, 0);
    }

    public static int j(C0196l c0196l, C0196l c0196l2) {
        c0196l.getClass();
        F0.i.e(c0196l2, "other");
        return c0196l.i(c0196l2.f3484a, -1234567890);
    }

    public static /* synthetic */ C0196l n(C0196l c0196l, int i2, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = -1234567890;
        }
        return c0196l.m(i2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compareTo(k1.C0196l r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            F0.i.e(r10, r0)
            int r0 = r9.c()
            int r1 = r10.c()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.h(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.h(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.C0196l.compareTo(k1.l):int");
    }

    public C0196l b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f3484a, 0, c());
        byte[] bArrDigest = messageDigest.digest();
        F0.i.b(bArrDigest);
        return new C0196l(bArrDigest);
    }

    public int c() {
        return this.f3484a.length;
    }

    public String d() {
        byte[] bArr = this.f3484a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = l1.b.f3535a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 += 2;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int e(byte[] bArr, int i2) {
        F0.i.e(bArr, "other");
        byte[] bArr2 = this.f3484a;
        int length = bArr2.length - bArr.length;
        int iMax = Math.max(i2, 0);
        if (iMax <= length) {
            while (!f1.d.c(iMax, 0, bArr.length, bArr2, bArr)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0196l) {
            C0196l c0196l = (C0196l) obj;
            int iC = c0196l.c();
            byte[] bArr = this.f3484a;
            if (iC == bArr.length && c0196l.l(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte[] g() {
        return this.f3484a;
    }

    public byte h(int i2) {
        return this.f3484a[i2];
    }

    public int hashCode() {
        int i2 = this.f3485b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f3484a);
        this.f3485b = iHashCode;
        return iHashCode;
    }

    public int i(byte[] bArr, int i2) {
        F0.i.e(bArr, "other");
        if (i2 == -1234567890) {
            i2 = c();
        }
        byte[] bArr2 = this.f3484a;
        for (int iMin = Math.min(i2, bArr2.length - bArr.length); -1 < iMin; iMin--) {
            if (f1.d.c(iMin, 0, bArr.length, bArr2, bArr)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean k(int i2, C0196l c0196l, int i3) {
        F0.i.e(c0196l, "other");
        return c0196l.l(0, this.f3484a, i2, i3);
    }

    public boolean l(int i2, byte[] bArr, int i3, int i4) {
        F0.i.e(bArr, "other");
        if (i2 >= 0) {
            byte[] bArr2 = this.f3484a;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && f1.d.c(i2, i3, i4, bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public C0196l m(int i2, int i3) {
        if (i3 == -1234567890) {
            i3 = c();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f3484a;
        if (i3 <= bArr.length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == bArr.length) ? this : new C0196l(p036u0.e.v(bArr, i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }

    public C0196l o() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f3484a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                F0.i.d(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b3 = bArrCopyOf[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArrCopyOf[i3] = (byte) (b3 + 32);
                    }
                }
                return new C0196l(bArrCopyOf);
            }
            i2++;
        }
    }

    public final String p() {
        String str = this.f3486c;
        if (str != null) {
            return str;
        }
        byte[] bArrG = g();
        F0.i.e(bArrG, "<this>");
        String str2 = new String(bArrG, M0.a.f360a);
        this.f3486c = str2;
        return str2;
    }

    public void q(C0193i c0193i, int i2) {
        F0.i.e(c0193i, "buffer");
        c0193i.O(this.f3484a, 0, i2);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c A[EDGE_INSN: B:22:0x003c->B:180:0x01a6 BREAK  A[LOOP:0: B:6:0x000f->B:238:0x000f]] */
    public String toString() {
        byte b2;
        int i2;
        byte[] bArr = this.f3484a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (i3 < length) {
            byte b3 = bArr[i3];
            if (b3 < 0) {
                if ((b3 >> 5) != -2) {
                    if ((b3 >> 4) != -2) {
                        if ((b3 >> 3) != -2) {
                            if (i5 == 64) {
                                break;
                            }
                            i4 = -1;
                            break;
                        }
                        int i6 = i3 + 3;
                        if (length > i6) {
                            byte b4 = bArr[i3 + 1];
                            if ((b4 & 192) != 128) {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                            byte b5 = bArr[i3 + 2];
                            if ((b5 & 192) != 128) {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                            byte b6 = bArr[i6];
                            if ((b6 & 192) != 128) {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                            int i7 = (((b6 ^ 3678080) ^ (b5 << 6)) ^ (b4 << 12)) ^ (b3 << 18);
                            if (i7 <= 1114111) {
                                if (55296 <= i7 && i7 < 57344) {
                                    if (i5 == 64) {
                                        break;
                                    }
                                    i4 = -1;
                                    break;
                                }
                                if (i7 >= 65536) {
                                    i2 = i5 + 1;
                                    if (i5 == 64) {
                                        break;
                                    }
                                    if ((i7 != 10 && i7 != 13 && ((i7 >= 0 && i7 < 32) || (127 <= i7 && i7 < 160))) || i7 == 65533) {
                                        i4 = -1;
                                        break;
                                    }
                                    i4 += i7 < 65536 ? 1 : 2;
                                    i3 += 4;
                                    i5 = i2;
                                } else {
                                    if (i5 == 64) {
                                        break;
                                    }
                                    i4 = -1;
                                    break;
                                }
                            } else {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                        } else {
                            if (i5 == 64) {
                                break;
                            }
                            i4 = -1;
                            break;
                        }
                    } else {
                        int i8 = i3 + 2;
                        if (length > i8) {
                            byte b7 = bArr[i3 + 1];
                            if ((b7 & 192) != 128) {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                            byte b8 = bArr[i8];
                            if ((b8 & 192) != 128) {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                            int i9 = ((b8 ^ (-123008)) ^ (b7 << 6)) ^ (b3 << 12);
                            if (i9 >= 2048) {
                                if (55296 <= i9 && i9 < 57344) {
                                    if (i5 == 64) {
                                        break;
                                    }
                                    i4 = -1;
                                    break;
                                }
                                i2 = i5 + 1;
                                if (i5 == 64) {
                                    break;
                                }
                                if ((i9 != 10 && i9 != 13 && ((i9 >= 0 && i9 < 32) || (127 <= i9 && i9 < 160))) || i9 == 65533) {
                                    i4 = -1;
                                    break;
                                }
                                i4 += i9 < 65536 ? 1 : 2;
                                i3 += 3;
                                i5 = i2;
                            } else {
                                if (i5 == 64) {
                                    break;
                                }
                                i4 = -1;
                                break;
                            }
                        } else {
                            if (i5 == 64) {
                                break;
                            }
                            i4 = -1;
                            break;
                        }
                    }
                } else {
                    int i10 = i3 + 1;
                    if (length > i10) {
                        byte b9 = bArr[i10];
                        if ((b9 & 192) != 128) {
                            if (i5 == 64) {
                                break;
                            }
                            i4 = -1;
                            break;
                        }
                        int i11 = (b9 ^ 3968) ^ (b3 << 6);
                        if (i11 >= 128) {
                            i2 = i5 + 1;
                            if (i5 == 64) {
                                break;
                            }
                            if ((i11 != 10 && i11 != 13 && ((i11 >= 0 && i11 < 32) || (127 <= i11 && i11 < 160))) || i11 == 65533) {
                                i4 = -1;
                                break;
                            }
                            i4 += i11 < 65536 ? 1 : 2;
                            i3 += 2;
                            i5 = i2;
                        } else {
                            if (i5 == 64) {
                                break;
                            }
                            i4 = -1;
                            break;
                        }
                    } else {
                        if (i5 == 64) {
                            break;
                        }
                        i4 = -1;
                        break;
                    }
                }
            } else {
                int i12 = i5 + 1;
                if (i5 == 64) {
                    break;
                }
                if ((b3 == 10 || b3 == 13 || ((b3 < 0 || b3 >= 32) && (127 > b3 || b3 >= 160))) && b3 != 65533) {
                    i4 += b3 < 65536 ? 1 : 2;
                    i3++;
                    while (true) {
                        i5 = i12;
                        if (i3 < length && (b2 = bArr[i3]) >= 0) {
                            i3++;
                            i12 = i5 + 1;
                            if (i5 == 64) {
                                break loop0;
                            }
                            if ((b2 == 10 || b2 == 13 || ((b2 < 0 || b2 >= 32) && (127 > b2 || b2 >= 160))) && b2 != 65533) {
                                i4 += b2 < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            String strP = p();
            String strSubstring = strP.substring(0, i4);
            F0.i.d(strSubstring, "substring(...)");
            String strP2 = M0.m.P(M0.m.P(M0.m.P(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i4 >= strP.length()) {
                return "[text=" + strP2 + ']';
            }
            return "[size=" + bArr.length + " text=" + strP2 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + d() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 <= bArr.length) {
            sb.append((64 == bArr.length ? this : new C0196l(p036u0.e.v(bArr, 0, 64))).d());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }
}
