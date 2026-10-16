// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

/* JADX INFO: loaded from: classes.dex */
public final class A implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0195k f3432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0193i f3433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public D f3434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3437f;

    public A(InterfaceC0195k interfaceC0195k) {
        this.f3432a = interfaceC0195k;
        C0193i c0193iB = interfaceC0195k.b();
        this.f3433b = c0193iB;
        D d2 = c0193iB.f3481a;
        this.f3434c = d2;
        this.f3435d = d2 != null ? d2.f3445b : -1;
    }

    @Override // k1.I
    public final K c() {
        return this.f3432a.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3436e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.f3445b) goto L15;
     */
    @Override // k1.I
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m(k1.C0193i r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            F0.i.e(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6c
            boolean r3 = r8.f3436e
            if (r3 != 0) goto L64
            k1.D r3 = r8.f3434c
            k1.i r4 = r8.f3433b
            if (r3 == 0) goto L2b
            k1.D r5 = r4.f3481a
            if (r3 != r5) goto L23
            int r3 = r8.f3435d
            F0.i.b(r5)
            int r5 = r5.f3445b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f3437f
            r2 = 1
            long r0 = r0 + r2
            k1.k r2 = r8.f3432a
            boolean r0 = r2.q(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            k1.D r0 = r8.f3434c
            if (r0 != 0) goto L4c
            k1.D r0 = r4.f3481a
            if (r0 == 0) goto L4c
            r8.f3434c = r0
            int r0 = r0.f3445b
            r8.f3435d = r0
        L4c:
            long r0 = r4.f3482b
            long r2 = r8.f3437f
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            k1.i r2 = r8.f3433b
            long r4 = r8.f3437f
            r3 = r9
            r6 = r10
            r2.v(r3, r4, r6)
            long r0 = r8.f3437f
            long r0 = r0 + r10
            r8.f3437f = r0
            return r10
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6c:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = F0.h.d(r9, r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.A.m(k1.i, long):long");
    }
}
