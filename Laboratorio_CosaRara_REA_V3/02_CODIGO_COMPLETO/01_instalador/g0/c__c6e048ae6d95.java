// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2740a;

    public c(Context context) {
        this.f2740a = context;
    }

    @Override // g0.i
    public final Object a(V.h hVar) {
        DisplayMetrics displayMetrics = this.f2740a.getResources().getDisplayMetrics();
        a aVar = new a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new h(aVar, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            if (F0.i.a(this.f2740a, ((c) obj).f2740a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2740a.hashCode();
    }
}
