// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class J implements Q.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q.e f1648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p034t0.g f1651d;

    public J(Q.e eVar, androidx.activity.i iVar) {
        F0.i.e(eVar, "savedStateRegistry");
        this.f1648a = eVar;
        this.f1651d = new p034t0.g(new W.e(3, iVar));
    }

    @Override // Q.d
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1650c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((K) this.f1651d.getValue()).f1652d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((F) entry.getValue()).f1641e.a();
            if (!F0.i.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f1649b = false;
        return bundle;
    }

    public final void b() {
        if (this.f1649b) {
            return;
        }
        Bundle bundleA = this.f1648a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1650c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        this.f1650c = bundle;
        this.f1649b = true;
    }
}
