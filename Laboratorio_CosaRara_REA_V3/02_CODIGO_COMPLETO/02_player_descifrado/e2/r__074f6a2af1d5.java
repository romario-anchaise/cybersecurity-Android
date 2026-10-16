// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f935b;

    public r(s sVar, n nVar) {
        this.f934a = sVar;
        this.f935b = nVar;
    }

    public final void a(long j3) {
        a aVar;
        s sVar = this.f934a;
        n nVar = this.f935b;
        synchronized (sVar.f968h) {
            try {
                long j4 = sVar.f970j.get();
                long j5 = nVar.f894a;
                if (j4 == j5 && sVar.K == null) {
                    if (sVar.f970j.compareAndSet(j5, 0L)) {
                        n nVar2 = sVar.J;
                        if (nVar2 != null && nVar2.f894a == nVar.f894a) {
                            sVar.J = null;
                        }
                        sVar.f974o = Long.MIN_VALUE;
                        sVar.f973m = Long.MIN_VALUE;
                        i iVar = i.f818k;
                        sVar.m(nVar, ((Number) iVar.d()).longValue(), true);
                        if (j3 < 1) {
                            j3 = 1;
                        }
                        sVar.C = Math.max(sVar.C, ((Number) iVar.d()).longValue() + (j3 * 1000000));
                        aVar = sVar.j(false);
                    } else {
                        aVar = new a(null, null, 7);
                    }
                    sVar.e(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        s.a(this.f934a, this.f935b, -1);
    }

    /* JADX WARN: Code duplicated, block: B:135:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r41v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30, types: [long] */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v4 */
    public final void c(f fVar) {
        long j3;
        long j4;
        k kVar;
        boolean z2;
        long jLongValue;
        int i3;
        ?? r9;
        boolean z3;
        a aVar;
        l lVar;
        boolean z4;
        long j5;
        r rVar = this;
        i iVar = i.f818k;
        long jLongValue2 = ((Number) iVar.d()).longValue();
        s sVar = rVar.f934a;
        n nVar = rVar.f935b;
        synchronized (sVar.f968h) {
            try {
                j3 = Long.MIN_VALUE;
                if (sVar.f970j.get() == nVar.f894a && sVar.f969i) {
                    long j6 = nVar.f895b;
                    j4 = 0;
                    r9 = sVar.f972l;
                    if (j6 == r9 && sVar.K == null) {
                        sVar.f974o = Long.MIN_VALUE;
                        long j7 = fVar.f790d;
                        Long lValueOf = Long.valueOf(j7);
                        if (j7 <= 0) {
                            lValueOf = null;
                        }
                        long jI = sVar.i(lValueOf != null ? lValueOf.longValue() : jLongValue2);
                        long jD = s.d(nVar.f901h, jLongValue2);
                        if (sVar.f962b) {
                            sVar.f961a.d(jD, ((Number) sVar.f963c.d()).longValue());
                        }
                        long j8 = fVar.f791e;
                        Long lValueOf2 = Long.valueOf(j8);
                        if (j8 < nVar.f901h || j8 > jLongValue2) {
                            lValueOf2 = null;
                        }
                        long jLongValue3 = lValueOf2 != null ? lValueOf2.longValue() : jLongValue2;
                        m mVar = sVar.f984y;
                        long j9 = mVar.f866a;
                        j3 = Long.MIN_VALUE;
                        long j10 = nVar.f897d;
                        if (j9 > j10) {
                            long j11 = mVar.f867b;
                            if (j11 == Long.MIN_VALUE || j11 > jLongValue3) {
                                j5 = j10;
                            } else {
                                j5 = j9;
                            }
                        } else {
                            j5 = j10;
                        }
                        l lVar2 = new l();
                        sVar.K = lVar2;
                        kVar = new k(new f(fVar.f787a, fVar.f788b, fVar.f789c, jI, fVar.f791e, nVar.f896c, j5), lVar2, jLongValue3);
                    }
                } else {
                    j4 = 0;
                }
                kVar = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (kVar == null) {
            fVar.b();
        } else {
            synchronized (sVar.f968h) {
                z2 = sVar.K == kVar.f839b && sVar.f970j.get() == nVar.f894a && sVar.f969i && sVar.f972l == nVar.f895b;
            }
            if (z2) {
                long jLongValue4 = ((Number) iVar.d()).longValue();
                try {
                    try {
                        synchronized (sVar.f983x) {
                            try {
                                r9 = (nVar.f896c == b.f714e || kVar.f838a.f793g >= sVar.f984y.f866a) ? 0 : 1;
                                if (r9 == 0) {
                                    try {
                                        sVar.f966f.f(kVar.f838a);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                }
                                jLongValue = ((Number) iVar.d()).longValue();
                                i3 = r9 ^ 1;
                                ?? r10 = r9;
                                if (r9 != 0) {
                                    try {
                                        kVar.f838a.b();
                                        r10 = r9;
                                    } catch (Throwable unused) {
                                        kVar.f838a.b();
                                        r10 = r9;
                                    }
                                }
                                ?? r41 = r10;
                                synchronized (sVar.f968h) {
                                    try {
                                        boolean z5 = sVar.K == kVar.f839b;
                                        boolean z6 = sVar.f970j.get() == nVar.f894a && sVar.f969i && sVar.f972l == nVar.f895b && z5;
                                        if (r41 != 0) {
                                            sVar.n();
                                        }
                                        if (i3 != 0) {
                                            sVar.n();
                                            z3 = z6;
                                            long j12 = kVar.f838a.f793g;
                                            long j13 = sVar.A;
                                            if (j13 > j4 && j12 >= j13) {
                                                sVar.A = j4;
                                                sVar.B = j3;
                                            }
                                        } else {
                                            z3 = z6;
                                        }
                                        if (i3 != 0 || r41 != 0) {
                                            if (z5) {
                                                sVar.G.addLast(new e(nVar.f894a, nVar.f896c, kVar.f838a.f793g, nVar.f899f, nVar.f900g, r41, s.d(nVar.f901h, kVar.f840c), s.d(kVar.f840c, jLongValue2), s.d(jLongValue4, jLongValue), s.d(nVar.f901h, jLongValue)));
                                            }
                                        }
                                        if (i3 != 0 && z5 && z3) {
                                            sVar.f975p.compareAndSet(false, true);
                                        }
                                        if (sVar.f970j.compareAndSet(nVar.f894a, 0L)) {
                                            n nVar2 = sVar.J;
                                            if (nVar2 != null && nVar2.f894a == nVar.f894a) {
                                                sVar.J = null;
                                            }
                                            if (i3 == 0 && r41 == 0) {
                                                z4 = false;
                                                sVar.m(nVar, jLongValue2, false);
                                            } else {
                                                z4 = false;
                                            }
                                            aVar = sVar.j(z4);
                                            lVar = null;
                                        } else {
                                            lVar = null;
                                            aVar = new a(null, null, 7);
                                        }
                                        if (z5 != 0) {
                                            sVar.K = lVar;
                                        }
                                        kVar.f839b.f850b.countDown();
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                                sVar.e(aVar);
                                rVar = this;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } catch (Throwable unused2) {
                        jLongValue = jLongValue4;
                        i3 = 0;
                    }
                } catch (Throwable unused3) {
                    jLongValue = jLongValue4;
                    i3 = 0;
                    r9 = 0;
                }
            } else {
                kVar.f838a.b();
                synchronized (sVar.f968h) {
                    try {
                        l lVar3 = sVar.K;
                        l lVar4 = kVar.f839b;
                        if (lVar3 == lVar4) {
                            sVar.K = null;
                        }
                        lVar4.f850b.countDown();
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
            }
        }
        rVar.f934a.f();
    }
}
