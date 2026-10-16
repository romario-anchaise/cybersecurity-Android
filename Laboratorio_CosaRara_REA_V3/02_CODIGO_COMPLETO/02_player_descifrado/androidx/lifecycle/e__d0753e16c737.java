// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f186g;

    public e(f fVar) {
        new AtomicReference();
        b.a aVar = new b.a();
        aVar.f247e = new HashMap();
        this.f180a = aVar;
        this.f183d = 0;
        this.f184e = false;
        this.f185f = false;
        this.f186g = new ArrayList();
        this.f182c = new WeakReference(fVar);
        this.f181b = b.f173d;
    }

    public static a a(b bVar) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return a.ON_CREATE;
        }
        if (iOrdinal == 2) {
            return a.ON_START;
        }
        if (iOrdinal == 3) {
            return a.ON_RESUME;
        }
        if (iOrdinal == 4) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }
}
