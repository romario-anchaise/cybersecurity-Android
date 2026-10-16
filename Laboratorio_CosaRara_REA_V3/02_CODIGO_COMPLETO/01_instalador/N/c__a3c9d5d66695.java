// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N;

import androidx.fragment.app.h;
import androidx.lifecycle.T;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f382a;

    public c(h hVar, T t2) {
        this.f382a = hVar;
        C.h hVar2 = new C.h(t2, b.f380e);
        String canonicalName = b.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        h hVar = this.f382a;
        String simpleName = hVar.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = hVar.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(hVar)));
        sb.append("}}");
        return sb.toString();
    }
}
