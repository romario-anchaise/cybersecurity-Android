// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p039w;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final void a(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
