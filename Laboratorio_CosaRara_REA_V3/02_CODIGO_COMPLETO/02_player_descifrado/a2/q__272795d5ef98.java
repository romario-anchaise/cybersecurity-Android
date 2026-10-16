// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import w1.n5;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f136c;

    public q(String str, boolean z2, boolean z3) {
        this.f134a = z2;
        this.f135b = z3;
        this.f136c = str == null ? "" : str;
    }

    public static q a() {
        return new q("", false, true);
    }

    public q(boolean z2, boolean z3, n5 n5Var) {
        this.f134a = z2;
        this.f135b = z3;
        this.f136c = n5Var;
    }

    public q(p pVar, boolean z2, boolean z3) {
        this.f136c = pVar;
        this.f134a = z2;
        this.f135b = z3;
    }
}
