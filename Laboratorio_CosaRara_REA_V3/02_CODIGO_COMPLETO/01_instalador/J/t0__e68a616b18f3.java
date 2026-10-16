// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.widget.AbsListView;

/* JADX INFO: renamed from: j.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0172t0 {
    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    public static void b(AbsListView absListView, boolean z2) {
        absListView.setSelectedChildViewEnabled(z2);
    }
}
