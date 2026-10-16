// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import H.z;
import android.text.Editable;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f258a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f260c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f260c;
        return cls != null ? new z(cls, charSequence) : super.newEditable(charSequence);
    }
}
