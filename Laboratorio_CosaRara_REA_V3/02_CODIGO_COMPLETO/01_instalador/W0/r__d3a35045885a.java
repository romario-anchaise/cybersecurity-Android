// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f834a;

    static {
        V0.p.a(new int[]{160, 47, 85, 17, 75, 26, 129, 251, 108, 34, 56, 187, 10});
        f834a = "APK Sig Block 42".getBytes(StandardCharsets.US_ASCII);
        Pattern pattern = V0.o.f716a;
    }

    public static long a(RandomAccessFile randomAccessFile) {
        return ((long) randomAccessFile.readUnsignedByte()) | (((long) randomAccessFile.readUnsignedByte()) << 8) | (((long) randomAccessFile.readUnsignedByte()) << 16) | (((long) randomAccessFile.readUnsignedByte()) << 24);
    }

    public static long b(RandomAccessFile randomAccessFile) {
        long jA = a(randomAccessFile);
        long jA2 = a(randomAccessFile);
        if ((2147483648L & jA2) != 0) {
            return -1L;
        }
        return jA | (jA2 << 32);
    }
}
