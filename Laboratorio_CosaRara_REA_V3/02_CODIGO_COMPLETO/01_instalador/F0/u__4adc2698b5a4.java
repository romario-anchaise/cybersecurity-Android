// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import N0.AbstractC0049v;
import N0.C0052y;
import android.view.View;
import androidx.lifecycle.AbstractC0078p;
import p012h0.a;

/* JADX INFO: loaded from: classes.dex */
public final class u implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f2697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0052y f2698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f2699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2700d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        s sVar = this.f2699c;
        if (sVar == null) {
            return;
        }
        this.f2700d = true;
        sVar.f2691a.b(sVar.f2692b);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        s sVar = this.f2699c;
        if (sVar != null) {
            AbstractC0049v.a(sVar.f2695e);
            AbstractC0078p abstractC0078p = sVar.f2694d;
            a aVar = sVar.f2693c;
            if (aVar != null) {
                abstractC0078p.c(aVar);
            }
            abstractC0078p.c(sVar);
        }
    }
}
