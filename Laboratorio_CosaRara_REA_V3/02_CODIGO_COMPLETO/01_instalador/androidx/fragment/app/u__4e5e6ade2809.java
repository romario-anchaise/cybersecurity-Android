// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import H.C0028c;
import android.util.Log;
import androidx.lifecycle.N;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class u extends N {
    public static final C0028c g = new C0028c(12);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f1602d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f1603e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f1604f = new HashMap();

    public u(boolean z2) {
    }

    @Override // androidx.lifecycle.N
    public final void b() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f1602d.equals(uVar.f1602d) && this.f1603e.equals(uVar.f1603e) && this.f1604f.equals(uVar.f1604f);
    }

    public final int hashCode() {
        return this.f1604f.hashCode() + ((this.f1603e.hashCode() + (this.f1602d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1602d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1603e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1604f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
