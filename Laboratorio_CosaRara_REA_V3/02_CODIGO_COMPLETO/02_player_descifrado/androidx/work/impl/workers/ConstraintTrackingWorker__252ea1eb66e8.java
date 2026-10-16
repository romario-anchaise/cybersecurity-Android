// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import c0.a;
import java.util.ArrayList;
import java.util.List;
import p.l;
import p.m;
import u.b;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorker extends l implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WorkerParameters f242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0.l f245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f246i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f242e = workerParameters;
        this.f243f = new Object();
        this.f245h = new a0.l();
    }

    @Override // p.l
    public final void b() {
        l lVar = this.f246i;
        if (lVar == null || lVar.f2852c) {
            return;
        }
        lVar.f();
    }

    @Override // u.b
    public final void d(ArrayList arrayList) {
        arrayList.getClass();
        m.d().a(a.f396a, "Constraints changed for " + arrayList);
        synchronized (this.f243f) {
            this.f244g = true;
        }
    }

    @Override // p.l
    public final a0.l e() {
        this.f2851b.f208c.execute(new a2.b(4, this));
        a0.l lVar = this.f245h;
        lVar.getClass();
        return lVar;
    }

    @Override // u.b
    public final void c(List list) {
    }
}
