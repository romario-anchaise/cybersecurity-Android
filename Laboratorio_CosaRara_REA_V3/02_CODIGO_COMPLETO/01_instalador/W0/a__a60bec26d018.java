// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f775a = V0.p.a(new int[]{132, 52, 83, 35, 87, 16, 144, 207, 93, 55, 56, 170, 11, 244, 106, 200, 154, 41, 92, 12, 84, 16, 145, 227, 85, 44, 34});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f776b = V0.p.a(new int[]{146, 50, 70, 33, 78, 23, 151, 228, 85, 44, 34, 135, 22, 249, 116, 217, 157});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f777c = Pattern.compile("^v1\\.ats_[a-f0-9]{32}\\.[0-9]{1,19}\\.[A-Za-z0-9_-]{43}$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f778d = new Object();

    public static boolean a(String str) {
        if (str == null || str.length() < 85 || str.length() > 103) {
            return false;
        }
        return f777c.matcher(str).matches();
    }

    public static String b(File file) {
        byte[] bArr;
        byte[] bArr2 = r.f834a;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile.length();
                long j2 = -1;
                if (length >= 22) {
                    int iMin = (int) Math.min(length, 65557L);
                    byte[] bArr3 = new byte[iMin];
                    long j3 = length - ((long) iMin);
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(bArr3);
                    for (int i2 = iMin - 22; i2 >= 0; i2--) {
                        if ((bArr3[i2] & 255) == 80 && (bArr3[i2 + 1] & 255) == 75 && (bArr3[i2 + 2] & 255) == 5 && (bArr3[i2 + 3] & 255) == 6) {
                            long j4 = ((long) i2) + j3;
                            if (j4 + 22 + ((long) ((bArr3[i2 + 20] & 255) | ((bArr3[i2 + 21] & 255) << 8))) == length) {
                                j2 = j4;
                                break;
                            }
                        }
                    }
                }
                if (j2 >= 0) {
                    randomAccessFile.seek(16 + j2);
                    long jA = r.a(randomAccessFile);
                    if (jA >= 24 && jA <= j2 && jA <= length) {
                        long j5 = jA - 24;
                        randomAccessFile.seek(j5);
                        long jB = r.b(randomAccessFile);
                        if (jB >= 24 && jB <= jA - 8) {
                            byte[] bArr4 = r.f834a;
                            long length2 = jA - ((long) bArr4.length);
                            if (length2 >= 0 && ((long) bArr4.length) + length2 <= randomAccessFile.length()) {
                                randomAccessFile.seek(length2);
                                byte[] bArr5 = new byte[bArr4.length];
                                randomAccessFile.readFully(bArr5);
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= bArr4.length) {
                                        long j6 = jA - jB;
                                        randomAccessFile.seek(j6 - 8);
                                        if (r.b(randomAccessFile) == jB) {
                                            byte[] bArr6 = null;
                                            while (true) {
                                                if (j6 < j5) {
                                                    long j7 = j5 - j6;
                                                    if (j7 >= 8) {
                                                        randomAccessFile.seek(j6);
                                                        long jB2 = r.b(randomAccessFile);
                                                        long j8 = j7 - 8;
                                                        if (jB2 >= 4 && jB2 <= j8) {
                                                            long j9 = jB2 - 4;
                                                            if (((int) r.a(randomAccessFile)) == 1920234593) {
                                                                if (bArr6 == null && j9 <= 4096) {
                                                                    bArr6 = new byte[(int) j9];
                                                                    randomAccessFile.readFully(bArr6);
                                                                }
                                                            }
                                                            j6 += jB2 + 8;
                                                        }
                                                    }
                                                } else {
                                                    if (j6 != j5) {
                                                        bArr6 = null;
                                                    }
                                                    randomAccessFile.close();
                                                    bArr = bArr6;
                                                }
                                                if (bArr != null || bArr.length < 85 || bArr.length > 103) {
                                                    return "";
                                                }
                                                for (byte b2 : bArr) {
                                                    int i4 = b2 & 255;
                                                    if ((i4 < 65 || i4 > 90) && ((i4 < 97 || i4 > 122) && !((i4 >= 48 && i4 <= 57) || i4 == 45 || i4 == 95 || i4 == 46))) {
                                                        return "";
                                                    }
                                                }
                                                String str = new String(bArr, StandardCharsets.US_ASCII);
                                                return a(str) ? str : "";
                                            }
                                        }
                                    } else if (bArr5[i3] == bArr4[i3]) {
                                        i3++;
                                    }
                                }
                            }
                        }
                    }
                }
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (IOException | RuntimeException unused) {
        }
        bArr = null;
        return bArr != null ? "" : "";
    }
}
