// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class m implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f3487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3489c;

    public m(u uVar, long j2) {
        F0.i.e(uVar, "fileHandle");
        this.f3487a = uVar;
        this.f3488b = j2;
    }

    @Override // k1.I
    public final K c() {
        return K.f3456d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f3489c) {
            return;
        }
        this.f3489c = true;
        u uVar = this.f3487a;
        ReentrantLock reentrantLock = uVar.f3512c;
        reentrantLock.lock();
        try {
            int i2 = uVar.f3511b - 1;
            uVar.f3511b = i2;
            if (i2 == 0 && uVar.f3510a) {
                reentrantLock.unlock();
                synchronized (uVar) {
                    uVar.f3513d.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) {
        long j3;
        long j4;
        int i2;
        int i3;
        F0.i.e(c0193i, "sink");
        if (this.f3489c) {
            throw new IllegalStateException("closed");
        }
        u uVar = this.f3487a;
        long j5 = this.f3488b;
        uVar.getClass();
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
        }
        long j6 = j2 + j5;
        long j7 = j5;
        while (true) {
            if (j7 < j6) {
                D dM = c0193i.M(1);
                byte[] bArr = dM.f3444a;
                int i4 = dM.f3446c;
                int iMin = (int) Math.min(j6 - j7, 8192 - i4);
                synchronized (uVar) {
                    F0.i.e(bArr, "array");
                    uVar.f3513d.seek(j7);
                    i2 = 0;
                    while (true) {
                        if (i2 < iMin) {
                            int i5 = uVar.f3513d.read(bArr, i4, iMin - i2);
                            if (i5 != -1) {
                                i2 += i5;
                            } else if (i2 == 0) {
                                i3 = -1;
                                i2 = -1;
                            }
                        }
                        i3 = -1;
                    }
                }
                if (i2 == i3) {
                    if (dM.f3445b == dM.f3446c) {
                        c0193i.f3481a = dM.a();
                        E.a(dM);
                    }
                    if (j5 == j7) {
                        j4 = -1;
                        j3 = -1;
                        break;
                    }
                } else {
                    dM.f3446c += i2;
                    long j8 = i2;
                    j7 += j8;
                    c0193i.f3482b += j8;
                }
            }
            j3 = j7 - j5;
            j4 = -1;
            break;
        }
        if (j3 != j4) {
            this.f3488b += j3;
        }
        return j3;
    }
}
