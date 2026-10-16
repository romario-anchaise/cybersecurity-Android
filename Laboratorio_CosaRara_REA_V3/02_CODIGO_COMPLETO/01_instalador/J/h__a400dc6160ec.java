// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class h extends H.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f273a;

    public h(EditText editText) {
        this.f273a = new WeakReference(editText);
    }

    @Override // H.i
    public final void a() {
        i.a((EditText) this.f273a.get(), 1);
    }
}
