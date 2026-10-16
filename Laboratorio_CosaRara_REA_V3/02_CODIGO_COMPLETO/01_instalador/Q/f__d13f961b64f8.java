// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Q;

import A.C0016p;
import androidx.activity.i;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.EnumC0077o;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f527b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f528c;

    public f(i iVar) {
        this.f526a = iVar;
    }

    public final void a() {
        i iVar = this.f526a;
        AbstractC0078p lifecycle = iVar.getLifecycle();
        if (lifecycle.b() != EnumC0077o.f1682b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new b(0, iVar));
        e eVar = this.f527b;
        eVar.getClass();
        if (eVar.f521b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new C0016p(1, eVar));
        eVar.f521b = true;
        this.f528c = true;
    }
}
