// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a1;

import F0.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f1225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1226d;

    public a(String str, boolean z2) {
        i.e(str, "name");
        this.f1223a = str;
        this.f1224b = z2;
        this.f1226d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f1223a;
    }
}
