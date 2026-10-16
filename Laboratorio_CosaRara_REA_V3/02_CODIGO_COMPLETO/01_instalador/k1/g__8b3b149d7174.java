// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: k1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0191g extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0195k f3479b;

    public /* synthetic */ C0191g(InterfaceC0195k interfaceC0195k, int i2) {
        this.f3478a = i2;
        this.f3479b = interfaceC0195k;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        switch (this.f3478a) {
            case 0:
                return (int) Math.min(((C0193i) this.f3479b).f3482b, Integer.MAX_VALUE);
            default:
                C c2 = (C) this.f3479b;
                if (c2.f3443c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(c2.f3442b.f3482b, Integer.MAX_VALUE);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f3478a) {
            case 0:
                break;
            default:
                ((C) this.f3479b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f3478a) {
            case 0:
                C0193i c0193i = (C0193i) this.f3479b;
                if (c0193i.f3482b > 0) {
                    return c0193i.B() & 255;
                }
                return -1;
            default:
                C c2 = (C) this.f3479b;
                if (c2.f3443c) {
                    throw new IOException("closed");
                }
                C0193i c0193i2 = c2.f3442b;
                if (c0193i2.f3482b == 0 && c2.f3441a.m(c0193i2, 8192L) == -1) {
                    return -1;
                }
                return c0193i2.B() & 255;
        }
    }

    public final String toString() {
        switch (this.f3478a) {
            case 0:
                return ((C0193i) this.f3479b) + ".inputStream()";
            default:
                return ((C) this.f3479b) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        switch (this.f3478a) {
            case 0:
                F0.i.e(bArr, "sink");
                return ((C0193i) this.f3479b).A(bArr, i2, i3);
            default:
                F0.i.e(bArr, "data");
                C c2 = (C) this.f3479b;
                if (!c2.f3443c) {
                    f1.d.g(bArr.length, i2, i3);
                    C0193i c0193i = c2.f3442b;
                    if (c0193i.f3482b == 0 && c2.f3441a.m(c0193i, 8192L) == -1) {
                        return -1;
                    }
                    return c0193i.A(bArr, i2, i3);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
