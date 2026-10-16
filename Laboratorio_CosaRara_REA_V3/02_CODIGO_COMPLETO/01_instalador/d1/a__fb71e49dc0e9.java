// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d1;

import F0.i;
import b1.m;
import b1.q;
import java.io.IOException;
import k1.C;
import k1.C0193i;
import k1.I;
import k1.K;
import k1.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f2212c;

    public a(q qVar) {
        this.f2212c = qVar;
        this.f2210a = new r(((C) qVar.f2175d).f3441a.c());
    }

    public final void a() {
        q qVar = this.f2212c;
        int i2 = qVar.f2172a;
        if (i2 == 6) {
            return;
        }
        if (i2 != 5) {
            throw new IllegalStateException("state: " + qVar.f2172a);
        }
        r rVar = this.f2210a;
        K k2 = rVar.f3500e;
        rVar.f3500e = K.f3456d;
        k2.a();
        k2.b();
        qVar.f2172a = 6;
    }

    @Override // k1.I
    public final K c() {
        return this.f2210a;
    }

    @Override // k1.I
    public long m(C0193i c0193i, long j2) {
        q qVar = this.f2212c;
        i.e(c0193i, "sink");
        try {
            return ((C) qVar.f2175d).m(c0193i, j2);
        } catch (IOException e2) {
            ((m) qVar.f2174c).k();
            a();
            throw e2;
        }
    }
}
