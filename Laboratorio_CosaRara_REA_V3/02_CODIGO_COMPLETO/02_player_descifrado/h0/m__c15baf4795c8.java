// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f1911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f1913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f1915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f1916f;

    public m(com.google.android.gms.common.internal.a aVar, int i3, Bundle bundle) {
        this.f1916f = aVar;
        Boolean bool = Boolean.TRUE;
        this.f1913c = aVar;
        this.f1911a = bool;
        this.f1912b = false;
        this.f1914d = i3;
        this.f1915e = bundle;
    }

    public abstract boolean a();

    public abstract void b(e0.b bVar);
}
