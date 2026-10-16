// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f296d;

    public c(byte[] bArr, int i2, int i3) {
        this(-1L, bArr, i2, i3);
    }

    public static c a(long j2, ByteOrder byteOrder) {
        long[] jArr = {j2};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g.f305C[4]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putInt((int) jArr[0]);
        return new c(byteBufferWrap.array(), 4, 1);
    }

    public static c b(e eVar, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g.f305C[5]]);
        byteBufferWrap.order(byteOrder);
        e eVar2 = new e[]{eVar}[0];
        byteBufferWrap.putInt((int) eVar2.f301a);
        byteBufferWrap.putInt((int) eVar2.f302b);
        return new c(byteBufferWrap.array(), 5, 1);
    }

    public static c c(int i2, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g.f305C[3]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putShort((short) new int[]{i2}[0]);
        return new c(byteBufferWrap.array(), 3, 1);
    }

    public final double d(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objG instanceof String) {
            return Double.parseDouble((String) objG);
        }
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            if (jArr.length == 1) {
                return jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objG instanceof int[]) {
            int[] iArr = (int[]) objG;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objG instanceof double[]) {
            double[] dArr = (double[]) objG;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objG instanceof e[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        e[] eVarArr = (e[]) objG;
        if (eVarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        e eVar = eVarArr[0];
        return eVar.f301a / eVar.f302b;
    }

    public final int e(ByteOrder byteOrder) {
        Object objG = g(byteOrder);
        if (objG == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objG instanceof String) {
            return Integer.parseInt((String) objG);
        }
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objG instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objG;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String f(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            return null;
        }
        if (objG instanceof String) {
            return (String) objG;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            while (i2 < jArr.length) {
                sb.append(jArr[i2]);
                i2++;
                if (i2 != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objG instanceof int[]) {
            int[] iArr = (int[]) objG;
            while (i2 < iArr.length) {
                sb.append(iArr[i2]);
                i2++;
                if (i2 != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objG instanceof double[]) {
            double[] dArr = (double[]) objG;
            while (i2 < dArr.length) {
                sb.append(dArr[i2]);
                i2++;
                if (i2 != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objG instanceof e[])) {
            return null;
        }
        e[] eVarArr = (e[]) objG;
        while (i2 < eVarArr.length) {
            sb.append(eVarArr[i2].f301a);
            sb.append('/');
            sb.append(eVarArr[i2].f302b);
            i2++;
            if (i2 != eVarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:148:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0032: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
    /* JADX WARN: Type inference failed for: r15v23, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v24, types: [java.io.Serializable, long[]] */
    /* JADX WARN: Type inference failed for: r15v25, types: [K.e[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v26, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v27, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v28, types: [K.e[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v29, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v30, types: [double[], java.io.Serializable] */
    public final Serializable g(ByteOrder byteOrder) throws Throwable {
        b bVar;
        InputStream inputStream;
        byte b2;
        int length = 0;
        byte[] bArr = this.f296d;
        InputStream inputStream2 = null;
        try {
            try {
                bVar = new b(bArr);
                try {
                    bVar.f290c = byteOrder;
                    int i2 = this.f293a;
                    int i3 = this.f294b;
                    switch (i2) {
                        case 1:
                        case 6:
                            if (bArr.length != 1 || (b2 = bArr[0]) < 0 || b2 > 1) {
                                String str = new String(bArr, g.f314L);
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e2) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (b2 + 48)});
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (i3 >= g.f306D.length) {
                                int i4 = 0;
                                while (true) {
                                    byte[] bArr2 = g.f306D;
                                    if (i4 >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (bArr[i4] == bArr2[i4]) {
                                        i4++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            try {
                                while (length < i3) {
                                    byte b3 = bArr[length];
                                    if (b3 == 0) {
                                        String string = sb.toString();
                                        bVar.close();
                                        return string;
                                    }
                                    if (b3 >= 32) {
                                        sb.append((char) b3);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                bVar.close();
                                break;
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            String string2 = sb.toString();
                            return string2;
                        case 3:
                            ?? r15 = new int[i3];
                            while (length < i3) {
                                r15[length] = bVar.readUnsignedShort();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return r15;
                        case 4:
                            ?? r16 = new long[i3];
                            while (length < i3) {
                                r16[length] = ((long) bVar.readInt()) & 4294967295L;
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return r16;
                        case 5:
                            ?? r17 = new e[i3];
                            while (length < i3) {
                                r17[length] = new e(((long) bVar.readInt()) & 4294967295L, ((long) bVar.readInt()) & 4294967295L);
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return r17;
                        case 8:
                            ?? r18 = new int[i3];
                            while (length < i3) {
                                r18[length] = bVar.readShort();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return r18;
                        case 9:
                            ?? r19 = new int[i3];
                            while (length < i3) {
                                r19[length] = bVar.readInt();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return r19;
                        case 10:
                            ?? r110 = new e[i3];
                            while (length < i3) {
                                r110[length] = new e(bVar.readInt(), bVar.readInt());
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return r110;
                        case 11:
                            ?? r111 = new double[i3];
                            while (length < i3) {
                                r111[length] = bVar.readFloat();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return r111;
                        case 12:
                            ?? r112 = new double[i3];
                            while (length < i3) {
                                r112[length] = bVar.readDouble();
                                length++;
                            }
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return r112;
                        default:
                            try {
                                bVar.close();
                                break;
                            } catch (IOException e13) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                            }
                            return null;
                    }
                } catch (IOException e14) {
                    e = e14;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e15) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e16) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                    }
                }
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public final String toString() {
        return "(" + g.f304B[this.f293a] + ", data length:" + this.f296d.length + ")";
    }

    public c(long j2, byte[] bArr, int i2, int i3) {
        this.f293a = i2;
        this.f294b = i3;
        this.f295c = j2;
        this.f296d = bArr;
    }
}
