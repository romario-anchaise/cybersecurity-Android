// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements w2.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w2.h f2967d = new w2.h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ v f2969f;

    public s(v vVar, boolean z2) {
        this.f2969f = vVar;
        this.f2966c = z2;
    }

    @Override // w2.v
    public final w2.z a() {
        return this.f2969f.f2988l;
    }

    @Override // w2.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z2;
        v vVar = this.f2969f;
        byte[] bArr = j2.b.f2361a;
        synchronized (vVar) {
            if (this.f2968e) {
                return;
            }
            synchronized (vVar) {
                z2 = vVar.f2989m == 0;
            }
            v vVar2 = this.f2969f;
            if (!vVar2.f2986j.f2966c) {
                if (this.f2967d.f5777d > 0) {
                    while (this.f2967d.f5777d > 0) {
                        d(true);
                    }
                } else if (z2) {
                    vVar2.f2978b.B(vVar2.f2977a, true, null, 0L);
                }
            }
            synchronized (this.f2969f) {
                this.f2968e = true;
            }
            this.f2969f.f2978b.flush();
            this.f2969f.a();
        }
    }

    public final void d(boolean z2) {
        long jMin;
        boolean z3;
        v vVar = this.f2969f;
        synchronized (vVar) {
            vVar.f2988l.i();
            while (vVar.f2981e >= vVar.f2982f && !this.f2966c && !this.f2968e) {
                try {
                    synchronized (vVar) {
                        int i3 = vVar.f2989m;
                        if (i3 != 0) {
                            break;
                        }
                        try {
                            vVar.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } catch (Throwable th) {
                    vVar.f2988l.l();
                    throw th;
                }
            }
            vVar.f2988l.l();
            vVar.b();
            jMin = Math.min(vVar.f2982f - vVar.f2981e, this.f2967d.f5777d);
            vVar.f2981e += jMin;
            z3 = z2 && jMin == this.f2967d.f5777d;
        }
        this.f2969f.f2988l.i();
        try {
            v vVar2 = this.f2969f;
            vVar2.f2978b.B(vVar2.f2977a, z3, this.f2967d, jMin);
        } finally {
            this.f2969f.f2988l.l();
        }
    }

    @Override // w2.v, java.io.Flushable
    public final void flush() {
        v vVar = this.f2969f;
        byte[] bArr = j2.b.f2361a;
        synchronized (vVar) {
            vVar.b();
        }
        while (this.f2967d.f5777d > 0) {
            d(false);
            this.f2969f.f2978b.flush();
        }
    }

    @Override // w2.v
    public final void t(long j3, w2.h hVar) {
        byte[] bArr = j2.b.f2361a;
        w2.h hVar2 = this.f2967d;
        hVar2.t(j3, hVar);
        while (hVar2.f5777d >= 16384) {
            d(false);
        }
    }
}
