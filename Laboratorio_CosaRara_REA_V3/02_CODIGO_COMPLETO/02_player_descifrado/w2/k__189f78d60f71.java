// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class k implements Serializable, Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f5778f = new k(new byte[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f5779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f5780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f5781e;

    public k(byte[] bArr) {
        bArr.getClass();
        this.f5779c = bArr;
    }

    public String a() {
        byte[] bArr = a.f5753a;
        byte[] bArr2 = this.f5779c;
        bArr2.getClass();
        bArr.getClass();
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte b3 = bArr2[i3];
            int i5 = i3 + 2;
            byte b4 = bArr2[i3 + 1];
            i3 += 3;
            byte b5 = bArr2[i5];
            bArr3[i4] = bArr[(b3 & 255) >> 2];
            bArr3[i4 + 1] = bArr[((b3 & 3) << 4) | ((b4 & 255) >> 4)];
            int i6 = i4 + 3;
            bArr3[i4 + 2] = bArr[((b4 & 15) << 2) | ((b5 & 255) >> 6)];
            i4 += 4;
            bArr3[i6] = bArr[b5 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b6 = bArr2[i3];
            bArr3[i4] = bArr[(b6 & 255) >> 2];
            bArr3[i4 + 1] = bArr[(b6 & 3) << 4];
            bArr3[i4 + 2] = 61;
            bArr3[i4 + 3] = 61;
        } else if (length2 == 2) {
            int i7 = i3 + 1;
            byte b7 = bArr2[i3];
            byte b8 = bArr2[i7];
            bArr3[i4] = bArr[(b7 & 255) >> 2];
            bArr3[i4 + 1] = bArr[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr3[i4 + 2] = bArr[(b8 & 15) << 2];
            bArr3[i4 + 3] = 61;
        }
        return new String(bArr3, v1.a.f3277a);
    }

    public k b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f5779c, 0, c());
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new k(bArrDigest);
    }

    public int c() {
        return this.f5779c.length;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        k kVar = (k) obj;
        kVar.getClass();
        int iC = c();
        int iC2 = kVar.c();
        int iMin = Math.min(iC, iC2);
        for (int i3 = 0; i3 < iMin; i3++) {
            int iF = f(i3) & 255;
            int iF2 = kVar.f(i3) & 255;
            if (iF != iF2) {
                return iF < iF2 ? -1 : 1;
            }
        }
        if (iC == iC2) {
            return 0;
        }
        return iC < iC2 ? -1 : 1;
    }

    public String d() {
        byte[] bArr = this.f5779c;
        char[] cArr = new char[bArr.length * 2];
        int i3 = 0;
        for (byte b3 : bArr) {
            int i4 = i3 + 1;
            char[] cArr2 = x2.b.f5967a;
            cArr[i3] = cArr2[(b3 >> 4) & 15];
            i3 += 2;
            cArr[i4] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    public byte[] e() {
        return this.f5779c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            int iC = kVar.c();
            byte[] bArr = this.f5779c;
            if (iC == bArr.length && kVar.h(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte f(int i3) {
        return this.f5779c[i3];
    }

    public boolean g(int i3, k kVar) {
        kVar.getClass();
        return kVar.h(0, this.f5779c, 0, i3);
    }

    public boolean h(int i3, byte[] bArr, int i4, int i5) {
        bArr.getClass();
        if (i3 >= 0) {
            byte[] bArr2 = this.f5779c;
            if (i3 <= bArr2.length - i5 && i4 >= 0 && i4 <= bArr.length - i5) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (bArr2[i6 + i3] == bArr[i6 + i4]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f5780d;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = Arrays.hashCode(this.f5779c);
        this.f5780d = iHashCode;
        return iHashCode;
    }

    public k i() {
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f5779c;
            if (i3 >= bArr.length) {
                return this;
            }
            byte b3 = bArr[i3];
            if (b3 >= 65 && b3 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                bArrCopyOf[i3] = (byte) (b3 + 32);
                for (int i4 = i3 + 1; i4 < bArrCopyOf.length; i4++) {
                    byte b4 = bArrCopyOf[i4];
                    if (b4 >= 65 && b4 <= 90) {
                        bArrCopyOf[i4] = (byte) (b4 + 32);
                    }
                }
                return new k(bArrCopyOf);
            }
            i3++;
        }
    }

    public byte[] j() {
        byte[] bArr = this.f5779c;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final String k() {
        String str = this.f5781e;
        if (str != null) {
            return str;
        }
        byte[] bArrE = e();
        bArrE.getClass();
        String str2 = new String(bArrE, v1.a.f3277a);
        this.f5781e = str2;
        return str2;
    }

    public void l(h hVar, int i3) {
        hVar.G(i3, this.f5779c);
    }

    /* JADX WARN: Code duplicated, block: B:179:0x01b6 A[EDGE_INSN: B:179:0x01b6->B:180:0x01b7 BREAK  A[LOOP:0: B:7:0x000e->B:241:0x000e]] */
    public String toString() {
        byte b3;
        int i3;
        k kVar = this;
        byte[] bArr = kVar.f5779c;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        loop0: while (i4 < length) {
            byte b4 = bArr[i4];
            if (b4 < 0) {
                if ((b4 >> 5) != -2) {
                    if ((b4 >> 4) != -2) {
                        if ((b4 >> 3) != -2) {
                            if (i6 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                        int i7 = i4 + 3;
                        if (length > i7) {
                            byte b5 = bArr[i4 + 1];
                            if ((b5 & 192) != 128) {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            byte b6 = bArr[i4 + 2];
                            if ((b6 & 192) != 128) {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            byte b7 = bArr[i7];
                            if ((b7 & 192) != 128) {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            int i8 = (((b7 ^ 3678080) ^ (b6 << 6)) ^ (b5 << 12)) ^ (b4 << 18);
                            if (i8 <= 1114111) {
                                if (55296 <= i8 && i8 < 57344) {
                                    if (i6 == 64) {
                                        break;
                                    }
                                    i5 = -1;
                                    break;
                                }
                                if (i8 >= 65536) {
                                    i3 = i6 + 1;
                                    if (i6 == 64) {
                                        break;
                                    }
                                    if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                                        i5 = -1;
                                        break;
                                    }
                                    i5 += i8 < 65536 ? 1 : 2;
                                    i4 += 4;
                                    i6 = i3;
                                } else {
                                    if (i6 == 64) {
                                        break;
                                    }
                                    i5 = -1;
                                    break;
                                }
                            } else {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                        } else {
                            if (i6 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                    } else {
                        int i9 = i4 + 2;
                        if (length > i9) {
                            byte b8 = bArr[i4 + 1];
                            if ((b8 & 192) != 128) {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            byte b9 = bArr[i9];
                            if ((b9 & 192) != 128) {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                            int i10 = ((b9 ^ (-123008)) ^ (b8 << 6)) ^ (b4 << 12);
                            if (i10 >= 2048) {
                                if (55296 <= i10 && i10 < 57344) {
                                    if (i6 == 64) {
                                        break;
                                    }
                                    i5 = -1;
                                    break;
                                }
                                i3 = i6 + 1;
                                if (i6 == 64) {
                                    break;
                                }
                                if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                    i5 = -1;
                                    break;
                                }
                                i5 += i10 < 65536 ? 1 : 2;
                                i4 += 3;
                                i6 = i3;
                            } else {
                                if (i6 == 64) {
                                    break;
                                }
                                i5 = -1;
                                break;
                            }
                        } else {
                            if (i6 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                    }
                } else {
                    int i11 = i4 + 1;
                    if (length > i11) {
                        byte b10 = bArr[i11];
                        if ((b10 & 192) != 128) {
                            if (i6 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                        int i12 = (b10 ^ 3968) ^ (b4 << 6);
                        if (i12 >= 128) {
                            i3 = i6 + 1;
                            if (i6 == 64) {
                                break;
                            }
                            if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                                i5 = -1;
                                break;
                            }
                            i5 += i12 < 65536 ? 1 : 2;
                            i4 += 2;
                            i6 = i3;
                        } else {
                            if (i6 == 64) {
                                break;
                            }
                            i5 = -1;
                            break;
                        }
                    } else {
                        if (i6 == 64) {
                            break;
                        }
                        i5 = -1;
                        break;
                    }
                }
            } else {
                int i13 = i6 + 1;
                if (i6 == 64) {
                    break;
                }
                if ((b4 == 10 || b4 == 13 || ((b4 < 0 || b4 >= 32) && (127 > b4 || b4 >= 160))) && b4 != 65533) {
                    i5 += b4 < 65536 ? 1 : 2;
                    i4++;
                    while (true) {
                        i6 = i13;
                        if (i4 < length && (b3 = bArr[i4]) >= 0) {
                            i4++;
                            i13 = i6 + 1;
                            if (i6 == 64) {
                                break loop0;
                            }
                            if ((b3 == 10 || b3 == 13 || ((b3 < 0 || b3 >= 32) && (127 > b3 || b3 >= 160))) && b3 != 65533) {
                                i5 += b3 < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i5 = -1;
                break;
            }
        }
        if (i5 != -1) {
            String strK = kVar.k();
            String strX = v1.l.x(v1.l.x(v1.l.x(strK.substring(0, i5), "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i5 >= strK.length()) {
                return "[text=" + strX + ']';
            }
            return "[size=" + bArr.length + " text=" + strX + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + kVar.d() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 <= bArr.length) {
            if (64 != bArr.length) {
                kVar = new k(i1.h.u(bArr, 0, 64));
            }
            sb.append(kVar.d());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }
}
