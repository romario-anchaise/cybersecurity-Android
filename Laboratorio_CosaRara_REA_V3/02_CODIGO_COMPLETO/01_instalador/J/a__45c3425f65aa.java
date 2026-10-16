// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.i0;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;

/* JADX INFO: renamed from: j.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0134a implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3136a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f3138c;

    public C0134a(ActionBarContextView actionBarContextView) {
        this.f3138c = actionBarContextView;
    }

    @Override // A.i0
    public final void a() {
        if (this.f3136a) {
            return;
        }
        ActionBarContextView actionBarContextView = this.f3138c;
        actionBarContextView.f1310f = null;
        super/*android.view.View*/.setVisibility(this.f3137b);
    }

    @Override // A.i0
    public final void b(View view) {
        this.f3136a = true;
    }

    @Override // A.i0
    public final void c() {
        super/*android.view.View*/.setVisibility(0);
        this.f3136a = false;
    }
}
