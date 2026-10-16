// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Q;

import F0.i;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f516a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f517b;

    public a(e eVar) {
        i.e(eVar, "registry");
        this.f517b = new LinkedHashSet();
        eVar.c("androidx.savedstate.Restarter", this);
    }

    @Override // Q.d
    public final Bundle a() {
        switch (this.f516a) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f517b));
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                ((AbstractActivityC0121k) this.f517b).getDelegate().getClass();
                return bundle2;
        }
    }

    public a(AbstractActivityC0121k abstractActivityC0121k) {
        this.f517b = abstractActivityC0121k;
    }
}
