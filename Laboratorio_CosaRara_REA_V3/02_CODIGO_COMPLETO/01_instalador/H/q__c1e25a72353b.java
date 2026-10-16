// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f221d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f224c = 0;

    public q(x xVar, int i2) {
        this.f223b = xVar;
        this.f222a = i2;
    }

    public final int a(int i2) {
        I.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarC.f5d;
        int i3 = iA + aVarC.f2a;
        return byteBuffer.getInt((i2 * 4) + byteBuffer.getInt(i3) + i3 + 4);
    }

    public final int b() {
        I.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        int i2 = iA + aVarC.f2a;
        return ((ByteBuffer) aVarC.f5d).getInt(((ByteBuffer) aVarC.f5d).getInt(i2) + i2);
    }

    public final I.a c() {
        ThreadLocal threadLocal = f221d;
        I.a aVar = (I.a) threadLocal.get();
        if (aVar == null) {
            aVar = new I.a();
            threadLocal.set(aVar);
        }
        I.b bVar = (I.b) this.f223b.f246a;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i2 = iA + bVar.f2a;
            int i3 = (this.f222a * 4) + ((ByteBuffer) bVar.f5d).getInt(i2) + i2 + 4;
            int i4 = ((ByteBuffer) bVar.f5d).getInt(i3) + i3;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f5d;
            aVar.f5d = byteBuffer;
            if (byteBuffer != null) {
                aVar.f2a = i4;
                int i5 = i4 - byteBuffer.getInt(i4);
                aVar.f3b = i5;
                aVar.f4c = ((ByteBuffer) aVar.f5d).getShort(i5);
            } else {
                aVar.f2a = 0;
                aVar.f3b = 0;
                aVar.f4c = 0;
            }
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        I.a aVarC = c();
        int iA = aVarC.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarC.f5d).getInt(iA + aVarC.f2a) : 0));
        sb.append(", codepoints:");
        int iB = b();
        for (int i2 = 0; i2 < iB; i2++) {
            sb.append(Integer.toHexString(a(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
