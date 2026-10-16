// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import g2.m0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f124c;

    public o(p pVar, boolean z2, long j3) {
        this.f124c = pVar;
        this.f123b = z2;
        this.f122a = j3;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x000f  */
    public synchronized boolean a(d2.t tVar) {
        boolean z2;
        if (tVar == null) {
            z2 = false;
        } else if (((d2.t) this.f124c) == tVar) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public synchronized Object b(long j3) {
        d2.t tVar;
        tVar = (d2.t) this.f124c;
        return (tVar == null || tVar.f612c != j3) ? null : (m0) tVar.f613d;
    }
}
