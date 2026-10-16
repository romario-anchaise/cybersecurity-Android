// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;

/* JADX INFO: renamed from: A.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0023x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f86a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f87b;

    public void a(androidx.recyclerview.widget.c0 c0Var) {
        View view = c0Var.itemView;
        this.f86a = view.getLeft();
        this.f87b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
