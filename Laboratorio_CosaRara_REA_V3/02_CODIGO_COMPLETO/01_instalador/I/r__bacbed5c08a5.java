// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import p011h.c;

/* JADX INFO: loaded from: classes.dex */
public final class r extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CollapsibleActionView f2988a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(View view) {
        super(view.getContext());
        this.f2988a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // p011h.c
    public final void a() {
        this.f2988a.onActionViewExpanded();
    }

    @Override // p011h.c
    public final void d() {
        this.f2988a.onActionViewCollapsed();
    }
}
