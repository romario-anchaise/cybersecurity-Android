// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: j.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0155k0 {
    public abstract void a(StaticLayout.Builder builder, TextView textView);

    public boolean b(TextView textView) {
        return ((Boolean) C0157l0.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
    }
}
