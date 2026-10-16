// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import p015j.AbstractViewOnTouchListenerC0184z0;
import p015j.C0146g;
import p015j.C0148h;
import p015j.C0152j;
import p015j.C0154k;

/* JADX INFO: renamed from: i.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0128b extends AbstractViewOnTouchListenerC0184z0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2879j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ View f2880k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0128b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f2880k = actionMenuItemView;
    }

    @Override // p015j.AbstractViewOnTouchListenerC0184z0
    public final E b() {
        C0146g c0146g;
        switch (this.f2879j) {
            case 0:
                AbstractC0129c abstractC0129c = ((ActionMenuItemView) this.f2880k).f1273m;
                if (abstractC0129c == null || (c0146g = ((C0148h) abstractC0129c).f3199a.f3224t) == null) {
                    return null;
                }
                return c0146g.a();
            default:
                C0146g c0146g2 = ((C0152j) this.f2880k).f3203d.f3223s;
                if (c0146g2 == null) {
                    return null;
                }
                return c0146g2.a();
        }
    }

    @Override // p015j.AbstractViewOnTouchListenerC0184z0
    public final boolean c() {
        E eB;
        switch (this.f2879j) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f2880k;
                m mVar = actionMenuItemView.f1271k;
                return mVar != null && mVar.c(actionMenuItemView.f1268h) && (eB = b()) != null && eB.b();
            default:
                ((C0152j) this.f2880k).f3203d.l();
                return true;
        }
    }

    @Override // p015j.AbstractViewOnTouchListenerC0184z0
    public boolean d() {
        switch (this.f2879j) {
            case 1:
                C0154k c0154k = ((C0152j) this.f2880k).f3203d;
                if (c0154k.f3225u != null) {
                    return false;
                }
                c0154k.e();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0128b(C0152j c0152j, C0152j c0152j2) {
        super(c0152j2);
        this.f2880k = c0152j;
    }
}
