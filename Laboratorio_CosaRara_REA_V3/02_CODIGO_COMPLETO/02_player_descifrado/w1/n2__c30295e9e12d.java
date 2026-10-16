// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f4605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f4607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f4608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f4609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4611m;
    public final int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f4612o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f4613p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f4614q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f4615r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f4616s;

    public n2(int i3, int i4, int i5, int i6, long j3, float f3, float f4, float f5, float f6, float[] fArr, float[] fArr2, int i7, int i8, int i9, long j4, long j5, String str, int i10, String str2) {
        this.f4599a = i3;
        this.f4600b = i4;
        this.f4601c = i5;
        this.f4602d = i6;
        this.f4603e = j3;
        this.f4604f = f3;
        this.f4605g = f4;
        this.f4606h = f5;
        this.f4607i = f6;
        this.f4608j = fArr;
        this.f4609k = fArr2;
        this.f4610l = i7;
        this.f4611m = i8;
        this.n = i9;
        this.f4612o = j4;
        this.f4613p = j5;
        this.f4614q = str;
        this.f4615r = i10;
        this.f4616s = str2;
    }

    public static float a(ByteBuffer byteBuffer) throws m2 {
        float f3 = byteBuffer.getFloat();
        if (!Float.isFinite(f3) || f3 < 0.0f || f3 > 1.0f) {
            throw new m2("invalid coordinate");
        }
        return f3;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0255  */
    /* JADX WARN: Code duplicated, block: B:106:0x0259  */
    /* JADX WARN: Code duplicated, block: B:107:0x025b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0261  */
    /* JADX WARN: Code duplicated, block: B:111:0x0263  */
    /* JADX WARN: Code duplicated, block: B:113:0x0267 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:179:0x0314  */
    /* JADX WARN: Code duplicated, block: B:181:0x031c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0324  */
    /* JADX WARN: Code duplicated, block: B:195:0x0245 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x023d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01e9 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x022d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x0225 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0197  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01af  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:74:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f6 A[ADDED_TO_REGION] */
    public static n2 d(byte[] bArr) throws m2 {
        float fA;
        float fA2;
        float fA3;
        float fA4;
        int i3;
        int i4;
        int i5;
        int i6;
        float f3;
        float[] fArr;
        int i7;
        int i8;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (bArr.length < 17 || bArr.length > 8192) {
            throw new m2("invalid payload size");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        int i15 = byteBufferOrder.get() & 255;
        int i16 = byteBufferOrder.get() & 255;
        short s3 = byteBufferOrder.getShort();
        int i17 = s3 & 65535;
        int i18 = byteBufferOrder.getShort() & 65535;
        int i19 = byteBufferOrder.getShort() & 65535;
        long j3 = byteBufferOrder.getLong();
        if (i15 == 2) {
            boolean z6 = true;
            if (i16 >= 1 && i16 <= 7 && (65528 & s3) == 0) {
                if (i19 > 0) {
                    int i20 = 4000;
                    switch (i16) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                            break;
                        case 5:
                            i20 = 5000;
                            break;
                        default:
                            i20 = 300;
                            break;
                    }
                    if (i19 <= i20 && j3 > 0) {
                        String str = "";
                        float[] fArr2 = null;
                        try {
                            switch (i16) {
                                case 1:
                                case 2:
                                    fA = a(byteBufferOrder);
                                    fA2 = a(byteBufferOrder);
                                    fA3 = Float.NaN;
                                    fA4 = Float.NaN;
                                    i3 = 0;
                                    i4 = 0;
                                    i5 = 0;
                                    i6 = i5;
                                    f3 = fA;
                                    fArr = null;
                                    if (byteBufferOrder.hasRemaining()) {
                                        throw new m2("missing extension count");
                                    }
                                    float[] fArr3 = fArr;
                                    i7 = byteBufferOrder.get() & 255;
                                    if (i7 <= 2) {
                                        throw new m2("too many extensions");
                                    }
                                    float f4 = f3;
                                    i8 = 0;
                                    z2 = false;
                                    z3 = false;
                                    long j4 = 0;
                                    long j5 = 0;
                                    while (i8 < i7) {
                                        i10 = i7;
                                        i11 = i8;
                                        if (byteBufferOrder.remaining() >= 3) {
                                            throw new m2("truncated extension");
                                        }
                                        i12 = byteBufferOrder.get() & 255;
                                        i13 = byteBufferOrder.getShort() & 65535;
                                        i14 = i17;
                                        if (i13 <= byteBufferOrder.remaining()) {
                                            throw new m2("truncated extension data");
                                        }
                                        if (i12 == z6) {
                                            if (!z2 || i13 != 16) {
                                                throw new m2("invalid scene extension");
                                            }
                                            long j6 = byteBufferOrder.getLong();
                                            j5 = byteBufferOrder.getLong();
                                            z2 = true;
                                            j4 = j6;
                                        } else {
                                            if (i12 != 2) {
                                                byteBufferOrder.position(byteBufferOrder.position() + i13);
                                                throw new m2("unknown extension");
                                            }
                                            if (!z3 || i13 <= 0 || i13 > 255) {
                                                throw new m2("invalid node extension");
                                            }
                                            byte[] bArr2 = new byte[i13];
                                            byteBufferOrder.get(bArr2);
                                            Charset charset = StandardCharsets.UTF_8;
                                            String str2 = new String(bArr2, charset);
                                            if (!Arrays.equals(bArr2, str2.getBytes(charset))) {
                                                throw new m2("invalid node UTF-8");
                                            }
                                            str = str2;
                                            z3 = true;
                                        }
                                        i8 = i11 + 1;
                                        i7 = i10;
                                        i17 = i14;
                                        z6 = true;
                                    }
                                    int i21 = i17;
                                    if (!byteBufferOrder.hasRemaining()) {
                                        throw new m2("trailing payload");
                                    }
                                    if ((s3 & 1) != 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if ((s3 & 2) != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4 == z2 || z5 != z3) {
                                        throw new m2("extension flags do not match payload");
                                    }
                                    if ((s3 & 4) != 0 && !z2) {
                                        throw new m2("strict revision requires scene");
                                    }
                                    if (!z3 || i16 == 1 || i16 == 2) {
                                        i9 = 7;
                                    } else {
                                        i9 = 7;
                                        if (i16 != 7) {
                                            throw new m2("action kind does not support semantic target");
                                        }
                                    }
                                    if (i16 == i9 && (!z3 || !z2)) {
                                        throw new m2("node action requires target and scene");
                                    }
                                    if (i16 == 1 || i16 == 6) {
                                        if (i18 != 0) {
                                            throw new m2("duration not allowed");
                                        }
                                    } else if (i16 != 7) {
                                        if (i16 != 3) {
                                            int i22 = i16 != 2 ? 30 : 50;
                                            int i23 = i16 == 2 ? 3000 : 2000;
                                            if (i18 < i22 || i18 > i23) {
                                                throw new m2("invalid action duration");
                                            }
                                        } else if (i18 != 0 || i3 < 30 || i3 > 100 || i4 < 50 || i4 > 250) {
                                            throw new m2("invalid double tap timing");
                                        }
                                    } else if (i18 != 0) {
                                        throw new m2("duration not allowed");
                                    }
                                    return new n2(i16, i21, i18, i19, j3, f4, fA2, fA3, fA4, fArr2, fArr3, i5, i3, i4, j4, j5, str, i6, str);
                                case 3:
                                    fA = a(byteBufferOrder);
                                    float fA5 = a(byteBufferOrder);
                                    i3 = byteBufferOrder.getShort() & 65535;
                                    i4 = byteBufferOrder.getShort() & 65535;
                                    fA2 = fA5;
                                    fA3 = Float.NaN;
                                    fA4 = Float.NaN;
                                    i5 = 0;
                                    i6 = i5;
                                    f3 = fA;
                                    fArr = null;
                                    if (byteBufferOrder.hasRemaining()) {
                                        throw new m2("missing extension count");
                                    }
                                    float[] fArr4 = fArr;
                                    i7 = byteBufferOrder.get() & 255;
                                    if (i7 <= 2) {
                                        throw new m2("too many extensions");
                                    }
                                    float f5 = f3;
                                    i8 = 0;
                                    z2 = false;
                                    z3 = false;
                                    long j7 = 0;
                                    long j8 = 0;
                                    while (i8 < i7) {
                                        i10 = i7;
                                        i11 = i8;
                                        if (byteBufferOrder.remaining() >= 3) {
                                            throw new m2("truncated extension");
                                        }
                                        i12 = byteBufferOrder.get() & 255;
                                        i13 = byteBufferOrder.getShort() & 65535;
                                        i14 = i17;
                                        if (i13 <= byteBufferOrder.remaining()) {
                                            throw new m2("truncated extension data");
                                        }
                                        if (i12 == z6) {
                                            if (!z2) {
                                            }
                                            throw new m2("invalid scene extension");
                                        }
                                        if (i12 != 2) {
                                            if (z3) {
                                            }
                                            throw new m2("invalid node extension");
                                        }
                                        byteBufferOrder.position(byteBufferOrder.position() + i13);
                                        throw new m2("unknown extension");
                                        i8 = i11 + 1;
                                        i7 = i10;
                                        i17 = i14;
                                        z6 = true;
                                    }
                                    int i24 = i17;
                                    if (!byteBufferOrder.hasRemaining()) {
                                        throw new m2("trailing payload");
                                    }
                                    if ((s3 & 1) != 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if ((s3 & 2) != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4 == z2) {
                                    }
                                    throw new m2("extension flags do not match payload");
                                case 4:
                                    float fA6 = a(byteBufferOrder);
                                    fA2 = a(byteBufferOrder);
                                    fA3 = a(byteBufferOrder);
                                    fA4 = a(byteBufferOrder);
                                    fArr = null;
                                    f3 = fA6;
                                    i3 = 0;
                                    i4 = 0;
                                    i5 = 0;
                                    i6 = 0;
                                    if (byteBufferOrder.hasRemaining()) {
                                        throw new m2("missing extension count");
                                    }
                                    float[] fArr5 = fArr;
                                    i7 = byteBufferOrder.get() & 255;
                                    if (i7 <= 2) {
                                        throw new m2("too many extensions");
                                    }
                                    float f6 = f3;
                                    i8 = 0;
                                    z2 = false;
                                    z3 = false;
                                    long j9 = 0;
                                    long j10 = 0;
                                    while (i8 < i7) {
                                        i10 = i7;
                                        i11 = i8;
                                        if (byteBufferOrder.remaining() >= 3) {
                                            throw new m2("truncated extension");
                                        }
                                        i12 = byteBufferOrder.get() & 255;
                                        i13 = byteBufferOrder.getShort() & 65535;
                                        i14 = i17;
                                        if (i13 <= byteBufferOrder.remaining()) {
                                            throw new m2("truncated extension data");
                                        }
                                        if (i12 == z6) {
                                            if (!z2) {
                                            }
                                            throw new m2("invalid scene extension");
                                        }
                                        if (i12 != 2) {
                                            if (z3) {
                                            }
                                            throw new m2("invalid node extension");
                                        }
                                        byteBufferOrder.position(byteBufferOrder.position() + i13);
                                        throw new m2("unknown extension");
                                        i8 = i11 + 1;
                                        i7 = i10;
                                        i17 = i14;
                                        z6 = true;
                                    }
                                    int i25 = i17;
                                    if (!byteBufferOrder.hasRemaining()) {
                                        throw new m2("trailing payload");
                                    }
                                    if ((s3 & 1) != 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if ((s3 & 2) != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4 == z2) {
                                    }
                                    throw new m2("extension flags do not match payload");
                                case 5:
                                    int i26 = byteBufferOrder.getShort() & 65535;
                                    if (i26 < 2 || i26 > 1000 || byteBufferOrder.remaining() < (i26 * 8) + 1) {
                                        throw new m2("invalid path point count");
                                    }
                                    float[] fArr6 = new float[i26];
                                    float[] fArr7 = new float[i26];
                                    for (int i27 = 0; i27 < i26; i27++) {
                                        fArr6[i27] = a(byteBufferOrder);
                                        fArr7[i27] = a(byteBufferOrder);
                                    }
                                    fArr2 = fArr6;
                                    fArr = fArr7;
                                    f3 = Float.NaN;
                                    fA2 = Float.NaN;
                                    fA3 = Float.NaN;
                                    fA4 = Float.NaN;
                                    i3 = 0;
                                    i4 = 0;
                                    i5 = 0;
                                    i6 = 0;
                                    if (byteBufferOrder.hasRemaining()) {
                                        throw new m2("missing extension count");
                                    }
                                    float[] fArr8 = fArr;
                                    i7 = byteBufferOrder.get() & 255;
                                    if (i7 <= 2) {
                                        throw new m2("too many extensions");
                                    }
                                    float f7 = f3;
                                    i8 = 0;
                                    z2 = false;
                                    z3 = false;
                                    long j11 = 0;
                                    long j12 = 0;
                                    while (i8 < i7) {
                                        i10 = i7;
                                        i11 = i8;
                                        if (byteBufferOrder.remaining() >= 3) {
                                            throw new m2("truncated extension");
                                        }
                                        i12 = byteBufferOrder.get() & 255;
                                        i13 = byteBufferOrder.getShort() & 65535;
                                        i14 = i17;
                                        if (i13 <= byteBufferOrder.remaining()) {
                                            throw new m2("truncated extension data");
                                        }
                                        if (i12 == z6) {
                                            if (!z2) {
                                            }
                                            throw new m2("invalid scene extension");
                                        }
                                        if (i12 != 2) {
                                            if (z3) {
                                            }
                                            throw new m2("invalid node extension");
                                        }
                                        byteBufferOrder.position(byteBufferOrder.position() + i13);
                                        throw new m2("unknown extension");
                                        i8 = i11 + 1;
                                        i7 = i10;
                                        i17 = i14;
                                        z6 = true;
                                    }
                                    int i28 = i17;
                                    if (!byteBufferOrder.hasRemaining()) {
                                        throw new m2("trailing payload");
                                    }
                                    if ((s3 & 1) != 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if ((s3 & 2) != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4 == z2) {
                                    }
                                    throw new m2("extension flags do not match payload");
                                case 6:
                                    z6 = true;
                                    str = "";
                                    f3 = Float.NaN;
                                    fA2 = Float.NaN;
                                    fA3 = Float.NaN;
                                    fA4 = Float.NaN;
                                    i3 = 0;
                                    i4 = 0;
                                    i6 = 0;
                                    i5 = byteBufferOrder.get() & 255;
                                    fArr = null;
                                    if (byteBufferOrder.hasRemaining()) {
                                        throw new m2("missing extension count");
                                    }
                                    float[] fArr9 = fArr;
                                    i7 = byteBufferOrder.get() & 255;
                                    if (i7 <= 2) {
                                        throw new m2("too many extensions");
                                    }
                                    float f8 = f3;
                                    i8 = 0;
                                    z2 = false;
                                    z3 = false;
                                    long j13 = 0;
                                    long j14 = 0;
                                    while (i8 < i7) {
                                        i10 = i7;
                                        i11 = i8;
                                        if (byteBufferOrder.remaining() >= 3) {
                                            throw new m2("truncated extension");
                                        }
                                        i12 = byteBufferOrder.get() & 255;
                                        i13 = byteBufferOrder.getShort() & 65535;
                                        i14 = i17;
                                        if (i13 <= byteBufferOrder.remaining()) {
                                            throw new m2("truncated extension data");
                                        }
                                        if (i12 == z6) {
                                            if (!z2) {
                                            }
                                            throw new m2("invalid scene extension");
                                        }
                                        if (i12 != 2) {
                                            if (z3) {
                                            }
                                            throw new m2("invalid node extension");
                                        }
                                        byteBufferOrder.position(byteBufferOrder.position() + i13);
                                        throw new m2("unknown extension");
                                        i8 = i11 + 1;
                                        i7 = i10;
                                        i17 = i14;
                                        z6 = true;
                                    }
                                    int i29 = i17;
                                    if (!byteBufferOrder.hasRemaining()) {
                                        throw new m2("trailing payload");
                                    }
                                    if ((s3 & 1) != 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if ((s3 & 2) != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4 == z2) {
                                    }
                                    throw new m2("extension flags do not match payload");
                                case 7:
                                    int i30 = byteBufferOrder.get() & 255;
                                    int i31 = byteBufferOrder.getShort() & 65535;
                                    if (i30 >= 3 && i30 <= 5) {
                                        z6 = true;
                                        if (i31 <= byteBufferOrder.remaining() - 1) {
                                            byte[] bArr3 = new byte[i31];
                                            byteBufferOrder.get(bArr3);
                                            Charset charset2 = StandardCharsets.UTF_8;
                                            String str3 = new String(bArr3, charset2);
                                            if (!Arrays.equals(bArr3, str3.getBytes(charset2))) {
                                                throw new m2("invalid semantic text UTF-8");
                                            }
                                            if (i30 != 5 && i31 != 0) {
                                                throw new m2("text only allowed for set-text");
                                            }
                                            str = str3;
                                            i6 = i30;
                                            fArr = null;
                                            f3 = Float.NaN;
                                            fA2 = Float.NaN;
                                            fA3 = Float.NaN;
                                            fA4 = Float.NaN;
                                            i3 = 0;
                                            i4 = 0;
                                            i5 = 0;
                                            if (byteBufferOrder.hasRemaining()) {
                                                throw new m2("missing extension count");
                                            }
                                            float[] fArr10 = fArr;
                                            i7 = byteBufferOrder.get() & 255;
                                            if (i7 <= 2) {
                                                throw new m2("too many extensions");
                                            }
                                            float f9 = f3;
                                            i8 = 0;
                                            z2 = false;
                                            z3 = false;
                                            long j15 = 0;
                                            long j16 = 0;
                                            while (i8 < i7) {
                                                i10 = i7;
                                                i11 = i8;
                                                if (byteBufferOrder.remaining() >= 3) {
                                                    throw new m2("truncated extension");
                                                }
                                                i12 = byteBufferOrder.get() & 255;
                                                i13 = byteBufferOrder.getShort() & 65535;
                                                i14 = i17;
                                                if (i13 <= byteBufferOrder.remaining()) {
                                                    throw new m2("truncated extension data");
                                                }
                                                if (i12 == z6) {
                                                    if (!z2) {
                                                    }
                                                    throw new m2("invalid scene extension");
                                                }
                                                if (i12 != 2) {
                                                    if (z3) {
                                                    }
                                                    throw new m2("invalid node extension");
                                                }
                                                byteBufferOrder.position(byteBufferOrder.position() + i13);
                                                throw new m2("unknown extension");
                                                i8 = i11 + 1;
                                                i7 = i10;
                                                i17 = i14;
                                                z6 = true;
                                            }
                                            int i210 = i17;
                                            if (!byteBufferOrder.hasRemaining()) {
                                                throw new m2("trailing payload");
                                            }
                                            if ((s3 & 1) != 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            if ((s3 & 2) != 0) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z4 == z2) {
                                            }
                                            throw new m2("extension flags do not match payload");
                                        }
                                    }
                                    throw new m2("invalid semantic action body");
                                default:
                                    throw new m2("unsupported kind");
                            }
                        } catch (BufferUnderflowException unused) {
                            throw new m2("truncated action body");
                        }
                    }
                }
                throw new m2("freshness budget invalid");
            }
        }
        throw new m2("unsupported schema, kind, or flags");
    }

    public final int b() {
        int i3 = this.f4599a;
        if (i3 == 1) {
            return 50;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return (this.f4611m * 2) + this.n;
            }
            if (i3 != 4 && i3 != 5) {
                return 0;
            }
        }
        return this.f4601c;
    }

    public final boolean c() {
        return this.f4599a == 7;
    }
}
