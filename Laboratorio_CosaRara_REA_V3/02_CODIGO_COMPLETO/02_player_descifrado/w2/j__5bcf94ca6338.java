// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public interface j extends x, ReadableByteChannel {
    void b(long j3, h hVar);

    k e(long j3);

    String g(long j3);

    int k(p pVar);

    String n();

    void p(long j3);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j3);

    long u();

    String v(Charset charset);
}
