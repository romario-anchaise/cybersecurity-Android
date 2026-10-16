// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class W extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1873a;

    public W(RecyclerView recyclerView) {
        this.f1873a = recyclerView;
    }

    public final void a() {
        boolean z2 = RecyclerView.D0;
        RecyclerView recyclerView = this.f1873a;
        if (z2 && recyclerView.f1825t && recyclerView.f1823s) {
            WeakHashMap weakHashMap = A.X.f14a;
            A.G.m(recyclerView, recyclerView.f1803i);
        } else {
            recyclerView.f1766A = true;
            recyclerView.requestLayout();
        }
    }
}
