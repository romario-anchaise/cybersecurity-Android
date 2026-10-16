// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j;

import android.content.Context;
import g.j;
import w1.q9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2306e;

    public b(Context context, String str, j jVar, boolean z2, boolean z3) {
        jVar.getClass();
        this.f2304c = context;
        this.f2305d = str;
        this.f2306e = jVar;
        this.f2302a = z2;
        this.f2303b = z3;
    }

    public b(boolean z2, q9 q9Var, Object obj, Thread thread, boolean z3) {
        this.f2302a = z2;
        this.f2304c = q9Var;
        this.f2305d = obj;
        this.f2306e = thread;
        this.f2303b = z3;
    }
}
