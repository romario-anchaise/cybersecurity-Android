// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.profileinstaller;

import H.C0028c;
import O.g;
import O.j;
import R.b;
import android.content.Context;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // R.b
    public final List a() {
        return Collections.emptyList();
    }

    @Override // R.b
    public final Object b(Context context) {
        j.a(new g(this, 0, context.getApplicationContext()));
        return new C0028c(10);
    }
}
