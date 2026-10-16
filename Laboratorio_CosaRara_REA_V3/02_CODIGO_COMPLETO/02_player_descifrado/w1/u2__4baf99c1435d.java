// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f5219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f5220c;

    public u2(float f3, float f4, long j3) {
        this.f5218a = j3;
        this.f5219b = f3;
        this.f5220c = f4;
    }

    public static u2 a(byte[] bArr) {
        if (bArr.length != 13) {
            o2.i("pointer payload must be exactly 13 bytes");
            return null;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        int i3 = byteBufferOrder.get() & 255;
        long j3 = ((long) byteBufferOrder.getInt()) & 4294967295L;
        float f3 = byteBufferOrder.getFloat();
        float f4 = byteBufferOrder.getFloat();
        if (i3 != 1 || j3 == 0) {
            o2.i("pointer schema or sequence invalid");
            return null;
        }
        if (Float.isFinite(f3) && Float.isFinite(f4) && f3 >= 0.0f && f3 <= 1.0f && f4 >= 0.0f && f4 <= 1.0f) {
            return new u2(f3, f4, j3);
        }
        o2.i("pointer coordinates invalid");
        return null;
    }
}
