// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Q;

import F0.i;
import android.os.Bundle;
import androidx.lifecycle.C0073k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f524e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p019l.f f520a = new p019l.f();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f525f = true;

    public final Bundle a(String str) {
        if (!this.f523d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f522c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.f522c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f522c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f522c = null;
        }
        return bundle2;
    }

    public final d b() {
        String str;
        d dVar;
        Iterator it = this.f520a.iterator();
        do {
            p019l.b bVar = (p019l.b) it;
            if (!bVar.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            i.d(entry, "components");
            str = (String) entry.getKey();
            dVar = (d) entry.getValue();
        } while (!i.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return dVar;
    }

    public final void c(String str, d dVar) {
        Object obj;
        i.e(dVar, "provider");
        p019l.f fVar = this.f520a;
        p019l.c cVar = fVar.f3530a;
        while (cVar != null && !cVar.f3523a.equals(str)) {
            cVar = cVar.f3525c;
        }
        if (cVar != null) {
            obj = cVar.f3524b;
        } else {
            p019l.c cVar2 = new p019l.c(str, dVar);
            fVar.f3533d++;
            p019l.c cVar3 = fVar.f3531b;
            if (cVar3 == null) {
                fVar.f3530a = cVar2;
                fVar.f3531b = cVar2;
            } else {
                cVar3.f3525c = cVar2;
                cVar2.f3526d = cVar3;
                fVar.f3531b = cVar2;
            }
            obj = null;
        }
        if (((d) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (!this.f525f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        a aVar = this.f524e;
        if (aVar == null) {
            aVar = new a(this);
        }
        this.f524e = aVar;
        try {
            C0073k.class.getDeclaredConstructor(null);
            a aVar2 = this.f524e;
            if (aVar2 != null) {
                ((LinkedHashSet) aVar2.f517b).add(C0073k.class.getName());
            }
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + C0073k.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }
}
