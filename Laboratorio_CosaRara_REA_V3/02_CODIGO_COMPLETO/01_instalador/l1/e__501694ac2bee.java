// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import java.io.IOException;
import k1.C0193i;
import k1.I;
import k1.q;

/* JADX INFO: loaded from: classes.dex */
public final class e extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3545d;

    public e(I i2, long j2, boolean z2) {
        super(i2);
        this.f3543b = j2;
        this.f3544c = z2;
    }

    @Override // k1.q, k1.I
    public final long m(C0193i c0193i, long j2) throws IOException {
        F0.i.e(c0193i, "sink");
        long j3 = this.f3545d;
        long j4 = this.f3543b;
        if (j3 > j4) {
            j2 = 0;
        } else if (this.f3544c) {
            long j5 = j4 - j3;
            if (j5 == 0) {
                return -1L;
            }
            j2 = Math.min(j2, j5);
        }
        long jM = super.m(c0193i, j2);
        if (jM != -1) {
            this.f3545d += jM;
        }
        long j6 = this.f3545d;
        if ((j6 >= j4 || jM != -1) && j6 <= j4) {
            return jM;
        }
        if (jM > 0 && j6 > j4) {
            long j7 = c0193i.f3482b - (j6 - j4);
            C0193i c0193i2 = new C0193i();
            c0193i2.P(c0193i);
            c0193i.i(c0193i2, j7);
            c0193i2.t();
        }
        throw new IOException("expected " + j4 + " bytes but got " + this.f3545d);
    }
}
