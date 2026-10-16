// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f601a = {75, 69, 89, 49};

    public static m a(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        for (int i3 = 0; i3 < 4; i3++) {
            if (bArr[i3] != f601a[i3]) {
                o2.l("bad KEY1 magic");
                return null;
            }
        }
        int unsignedByte = dataInputStream.readUnsignedByte();
        long unsignedLong = Integer.toUnsignedLong(dataInputStream.readInt());
        if (unsignedLong <= 4194304) {
            byte[] bArr2 = new byte[(int) unsignedLong];
            dataInputStream.readFully(bArr2);
            return new m((byte) unsignedByte, bArr2);
        }
        throw new IOException("KEY1 payload too large: " + unsignedLong);
    }
}
