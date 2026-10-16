// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.nio.ByteBuffer;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f5795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f5796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5797e;

    public q(v vVar) {
        vVar.getClass();
        this.f5795c = vVar;
        this.f5796d = new h();
    }

    @Override // w2.v
    public final z a() {
        return this.f5795c.a();
    }

    @Override // w2.i
    public final i c(long j3) {
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        this.f5796d.K(j3);
        d();
        return this;
    }

    @Override // w2.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        v vVar = this.f5795c;
        if (this.f5797e) {
            return;
        }
        h hVar = this.f5796d;
        long j3 = hVar.f5777d;
        if (j3 > 0) {
            vVar.t(j3, hVar);
        }
        th = null;
        try {
            vVar.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f5797e = true;
        if (th != null) {
            throw th;
        }
    }

    public final i d() {
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        h hVar = this.f5796d;
        long j3 = hVar.f5777d;
        if (j3 == 0) {
            j3 = 0;
        } else {
            s sVar = hVar.f5776c;
            sVar.getClass();
            s sVar2 = sVar.f5807g;
            sVar2.getClass();
            int i3 = sVar2.f5803c;
            if (i3 < 8192 && sVar2.f5805e) {
                j3 -= (long) (i3 - sVar2.f5802b);
            }
        }
        if (j3 > 0) {
            this.f5795c.t(j3, hVar);
        }
        return this;
    }

    @Override // w2.i, w2.v, java.io.Flushable
    public final void flush() {
        if (this.f5797e) {
            o2.k("closed");
            return;
        }
        h hVar = this.f5796d;
        long j3 = hVar.f5777d;
        v vVar = this.f5795c;
        if (j3 > 0) {
            vVar.t(j3, hVar);
        }
        vVar.flush();
    }

    @Override // w2.i
    public final i i() {
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        h hVar = this.f5796d;
        long j3 = hVar.f5777d;
        if (j3 > 0) {
            this.f5795c.t(j3, hVar);
        }
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f5797e;
    }

    @Override // w2.i
    public final i q(String str) {
        str.getClass();
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        this.f5796d.O(str);
        d();
        return this;
    }

    @Override // w2.i
    public final h s() {
        return this.f5796d;
    }

    @Override // w2.v
    public final void t(long j3, h hVar) {
        hVar.getClass();
        if (this.f5797e) {
            o2.k("closed");
        } else {
            this.f5796d.t(j3, hVar);
            d();
        }
    }

    public final String toString() {
        return "buffer(" + this.f5795c + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.f5797e) {
            o2.k("closed");
            return 0;
        }
        int iWrite = this.f5796d.write(byteBuffer);
        d();
        return iWrite;
    }

    @Override // w2.i
    public final i writeByte(int i3) {
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        this.f5796d.J(i3);
        d();
        return this;
    }

    @Override // w2.i
    public final i writeInt(int i3) {
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        this.f5796d.L(i3);
        d();
        return this;
    }

    @Override // w2.i
    public final i writeShort(int i3) {
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        this.f5796d.M(i3);
        d();
        return this;
    }

    @Override // w2.i
    public final i x(k kVar) {
        kVar.getClass();
        if (this.f5797e) {
            o2.k("closed");
            return null;
        }
        this.f5796d.H(kVar);
        d();
        return this;
    }

    @Override // w2.i
    public final i write(byte[] bArr) {
        if (!this.f5797e) {
            this.f5796d.G(bArr.length, bArr);
            d();
            return this;
        }
        o2.k("closed");
        return null;
    }
}
