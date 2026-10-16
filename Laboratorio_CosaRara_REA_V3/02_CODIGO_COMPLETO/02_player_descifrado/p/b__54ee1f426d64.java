// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f2822a = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new a(false));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f2823b = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new a(true));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f2824c = new v();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0.i f2825d = new e0.i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q.c f2826e = new q.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2827f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2828g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2829h = 20;

    public b(h0.g gVar) {
    }
}
