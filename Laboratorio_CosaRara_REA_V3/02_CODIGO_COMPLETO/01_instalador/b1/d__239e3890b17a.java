// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import java.io.IOException;
import java.net.ProtocolException;
import k1.C0193i;
import k1.I;

/* JADX INFO: loaded from: classes.dex */
public final class d extends k1.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2112f;
    public final /* synthetic */ e g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, I i2, long j2) {
        super(i2);
        F0.i.e(i2, "delegate");
        this.g = eVar;
        this.f2108b = j2;
        this.f2110d = true;
        if (j2 == 0) {
            a(null);
        }
    }

    public final IOException a(IOException iOException) {
        if (this.f2111e) {
            return iOException;
        }
        this.f2111e = true;
        e eVar = this.g;
        if (iOException == null && this.f2110d) {
            this.f2110d = false;
            eVar.getClass();
            F0.i.e(eVar.f2113a, "call");
        }
        return eVar.a(true, false, iOException);
    }

    @Override // k1.q, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f2112f) {
            return;
        }
        this.f2112f = true;
        try {
            super.close();
            a(null);
        } catch (IOException e2) {
            throw a(e2);
        }
    }

    @Override // k1.q, k1.I
    public final long m(C0193i c0193i, long j2) throws IOException {
        F0.i.e(c0193i, "sink");
        if (this.f2112f) {
            throw new IllegalStateException("closed");
        }
        try {
            long jM = this.f3499a.m(c0193i, j2);
            if (this.f2110d) {
                this.f2110d = false;
                e eVar = this.g;
                eVar.getClass();
                F0.i.e(eVar.f2113a, "call");
            }
            if (jM == -1) {
                a(null);
                return -1L;
            }
            long j3 = this.f2109c + jM;
            long j4 = this.f2108b;
            if (j4 == -1 || j3 <= j4) {
                this.f2109c = j3;
                if (j3 == j4) {
                    a(null);
                }
                return jM;
            }
            throw new ProtocolException("expected " + j4 + " bytes but received " + j3);
        } catch (IOException e2) {
            throw a(e2);
        }
    }
}
