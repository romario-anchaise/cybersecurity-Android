// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: j.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0153j0 extends C0151i0 {
    @Override // p015j.C0151i0, p015j.AbstractC0155k0
    public void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override // p015j.AbstractC0155k0
    public boolean b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
