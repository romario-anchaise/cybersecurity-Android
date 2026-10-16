// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements w2.x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w2.h f2972e = new w2.h();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w2.h f2973f = new w2.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v f2975h;

    public t(v vVar, long j3, boolean z2) {
        this.f2975h = vVar;
        this.f2970c = j3;
        this.f2971d = z2;
    }

    @Override // w2.x
    public final w2.z a() {
        return this.f2975h.f2987k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j3;
        v vVar = this.f2975h;
        synchronized (vVar) {
            this.f2974g = true;
            w2.h hVar = this.f2973f;
            j3 = hVar.f5777d;
            hVar.skip(j3);
            vVar.notifyAll();
        }
        if (j3 > 0) {
            d(j3);
        }
        this.f2975h.a();
    }

    public final void d(long j3) {
        byte[] bArr = j2.b.f2361a;
        this.f2975h.f2978b.A(j3);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x002f A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:5:0x0008, B:7:0x000b, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:15:0x0019, B:17:0x001c, B:19:0x001f, B:23:0x0027, B:26:0x002a, B:27:0x002b, B:29:0x002f, B:31:0x003c, B:33:0x0050, B:35:0x005f, B:36:0x006b, B:39:0x0071, B:42:0x0077, B:43:0x0083, B:56:0x0099, B:57:0x00a0, B:60:0x00a3, B:6:0x0009, B:16:0x001a), top: B:67:0x0008, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x003c A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:5:0x0008, B:7:0x000b, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:15:0x0019, B:17:0x001c, B:19:0x001f, B:23:0x0027, B:26:0x002a, B:27:0x002b, B:29:0x002f, B:31:0x003c, B:33:0x0050, B:35:0x005f, B:36:0x006b, B:39:0x0071, B:42:0x0077, B:43:0x0083, B:56:0x0099, B:57:0x00a0, B:60:0x00a3, B:6:0x0009, B:16:0x001a), top: B:67:0x0008, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x006b A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:5:0x0008, B:7:0x000b, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:15:0x0019, B:17:0x001c, B:19:0x001f, B:23:0x0027, B:26:0x002a, B:27:0x002b, B:29:0x002f, B:31:0x003c, B:33:0x0050, B:35:0x005f, B:36:0x006b, B:39:0x0071, B:42:0x0077, B:43:0x0083, B:56:0x0099, B:57:0x00a0, B:60:0x00a3, B:6:0x0009, B:16:0x001a), top: B:67:0x0008, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0099 A[SYNTHETIC] */
    @Override // w2.x
    public final long f(long j3, w2.h hVar) throws Throwable {
        int i3;
        Throwable th;
        w2.h hVar2;
        long j4;
        boolean z2;
        long jF;
        long j5;
        do {
            v vVar = this.f2975h;
            synchronized (vVar) {
                vVar.f2987k.i();
                try {
                    synchronized (vVar) {
                        i3 = vVar.f2989m;
                    }
                } catch (Throwable th2) {
                    vVar.f2987k.l();
                    throw th2;
                }
            }
            th = null;
            if (i3 != 0 && !this.f2971d) {
                Throwable b0Var = vVar.n;
                if (b0Var == null) {
                    synchronized (vVar) {
                        int i4 = vVar.f2989m;
                        if (i4 == 0) {
                            throw null;
                        }
                        b0Var = new b0(i4);
                    }
                }
                th = b0Var;
                if (!this.f2974g) {
                    throw new IOException("stream closed");
                }
                hVar2 = this.f2973f;
                j4 = hVar2.f5777d;
                z2 = false;
                if (j4 > 0) {
                    jF = hVar2.f(Math.min(8192L, j4), hVar);
                    long j6 = vVar.f2979c + jF;
                    vVar.f2979c = j6;
                    j5 = j6 - vVar.f2980d;
                    if (th == null) {
                        vVar.f2978b.D(vVar.f2977a, j5);
                        vVar.f2980d = vVar.f2979c;
                    }
                } else {
                    if (!this.f2971d) {
                        vVar.wait();
                        z2 = true;
                    }
                    jF = -1;
                }
                vVar.f2987k.l();
            } else {
                if (!this.f2974g) {
                    throw new IOException("stream closed");
                }
                hVar2 = this.f2973f;
                j4 = hVar2.f5777d;
                z2 = false;
                if (j4 > 0) {
                    jF = hVar2.f(Math.min(8192L, j4), hVar);
                    long j7 = vVar.f2979c + jF;
                    vVar.f2979c = j7;
                    j5 = j7 - vVar.f2980d;
                    if (th == null && j5 >= vVar.f2978b.f2939r.a() / 2) {
                        vVar.f2978b.D(vVar.f2977a, j5);
                        vVar.f2980d = vVar.f2979c;
                    }
                } else {
                    if (!this.f2971d && th == null) {
                        try {
                            vVar.wait();
                            z2 = true;
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    jF = -1;
                }
                vVar.f2987k.l();
            }
            throw th;
        } while (z2);
        if (jF != -1) {
            return jF;
        }
        if (th == null) {
            return -1L;
        }
        throw th;
    }
}
