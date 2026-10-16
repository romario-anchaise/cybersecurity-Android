// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class t implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f3506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f3507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3509d;

    public t(C c2, Inflater inflater) {
        this.f3506a = c2;
        this.f3507b = inflater;
    }

    @Override // k1.I
    public final K c() {
        return this.f3506a.f3441a.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f3509d) {
            return;
        }
        this.f3507b.end();
        this.f3509d = true;
        this.f3506a.close();
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) {
        long j3;
        F0.i.e(c0193i, "sink");
        while (j2 >= 0) {
            if (this.f3509d) {
                throw new IllegalStateException("closed");
            }
            C c2 = this.f3506a;
            Inflater inflater = this.f3507b;
            if (j2 == 0) {
                j3 = 0;
            } else {
                try {
                    D dM = c0193i.M(1);
                    int iMin = (int) Math.min(j2, 8192 - dM.f3446c);
                    if (inflater.needsInput() && !c2.a()) {
                        D d2 = c2.f3442b.f3481a;
                        F0.i.b(d2);
                        int i2 = d2.f3446c;
                        int i3 = d2.f3445b;
                        int i4 = i2 - i3;
                        this.f3508c = i4;
                        inflater.setInput(d2.f3444a, i3, i4);
                    }
                    int iInflate = inflater.inflate(dM.f3444a, dM.f3446c, iMin);
                    int i5 = this.f3508c;
                    if (i5 != 0) {
                        int remaining = i5 - inflater.getRemaining();
                        this.f3508c -= remaining;
                        c2.A(remaining);
                    }
                    if (iInflate > 0) {
                        dM.f3446c += iInflate;
                        j3 = iInflate;
                        c0193i.f3482b += j3;
                    } else {
                        if (dM.f3445b == dM.f3446c) {
                            c0193i.f3481a = dM.a();
                            E.a(dM);
                        }
                        j3 = 0;
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            if (j3 > 0) {
                return j3;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
            if (c2.a()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
    }
}
