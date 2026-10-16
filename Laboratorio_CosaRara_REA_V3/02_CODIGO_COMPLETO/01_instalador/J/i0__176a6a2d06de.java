// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;

/* JADX INFO: renamed from: j.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0151i0 extends AbstractC0155k0 {
    @Override // p015j.AbstractC0155k0
    public void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection((TextDirectionHeuristic) C0157l0.e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
    }
}
