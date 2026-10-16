// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work;

import a2.i;
import android.content.Context;
import p.j;
import p.l;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a0.l f205e;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // p.l
    public final a0.l a() {
        a0.l lVar = new a0.l();
        this.f2851b.f208c.execute(new i(this, lVar, 12));
        return lVar;
    }

    @Override // p.l
    public final a0.l e() {
        this.f205e = new a0.l();
        this.f2851b.f208c.execute(new i(11, this));
        return this.f205e;
    }

    public abstract j g();
}
