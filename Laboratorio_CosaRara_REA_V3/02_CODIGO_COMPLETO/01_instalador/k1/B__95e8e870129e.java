// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC0194j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f3438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0193i f3439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3440c;

    public B(G g) {
        F0.i.e(g, "sink");
        this.f3438a = g;
        this.f3439b = new C0193i();
    }

    public final InterfaceC0194j a() {
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        C0193i c0193i = this.f3439b;
        long jU = c0193i.u();
        if (jU > 0) {
            this.f3438a.i(c0193i, jU);
        }
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final C0193i b() {
        return this.f3439b;
    }

    @Override // k1.G
    public final K c() {
        return this.f3438a.c();
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        G g = this.f3438a;
        if (this.f3440c) {
            return;
        }
        C0193i c0193i = this.f3439b;
        long j2 = c0193i.f3482b;
        if (j2 > 0) {
            g.i(c0193i, j2);
        }
        th = null;
        try {
            g.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f3440c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j d(byte[] bArr) {
        F0.i.e(bArr, "source");
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.O(bArr, 0, bArr.length);
        a();
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j e(byte[] bArr, int i2, int i3) {
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.O(bArr, i2, i3);
        a();
        return this;
    }

    public final InterfaceC0194j f(int i2) {
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.T(i2);
        a();
        return this;
    }

    @Override // k1.G, java.io.Flushable
    public final void flush() {
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        C0193i c0193i = this.f3439b;
        long j2 = c0193i.f3482b;
        G g = this.f3438a;
        if (j2 > 0) {
            g.i(c0193i, j2);
        }
        g.flush();
    }

    @Override // k1.G
    public final void i(C0193i c0193i, long j2) {
        F0.i.e(c0193i, "source");
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.i(c0193i, j2);
        a();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f3440c;
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j k(String str) {
        F0.i.e(str, "string");
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.U(str);
        a();
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j l(long j2) {
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.R(j2);
        a();
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j o(int i2) {
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.Q(i2);
        a();
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j p(C0196l c0196l) {
        F0.i.e(c0196l, "byteString");
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        this.f3439b.N(c0196l);
        a();
        return this;
    }

    public final String toString() {
        return "buffer(" + this.f3438a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        F0.i.e(byteBuffer, "source");
        if (this.f3440c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f3439b.write(byteBuffer);
        a();
        return iWrite;
    }
}
