// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f1072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f1073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f1074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1.a f1075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p1.l f1076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1077f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1078g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w0 f1080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1084m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f1085o;

    public x0(ExecutorService executorService, z zVar, z zVar2, p1.a aVar, p1.l lVar) {
        this.f1072a = executorService;
        this.f1073b = zVar;
        this.f1074c = zVar2;
        this.f1075d = aVar;
        this.f1076e = lVar;
    }

    public final boolean a(f fVar) {
        return fVar.f792f == b.f714e || fVar.f793g >= this.f1085o;
    }
}
