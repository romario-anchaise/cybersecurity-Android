// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import android.content.Context;
import android.view.View;
import com.o2s2m.gae1fc3b2uc0u.R;
import p013i.G;
import p013i.n;
import p013i.v;
import p013i.y;

/* JADX INFO: renamed from: j.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0146g extends y {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f3191l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0154k f3192m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0146g(C0154k c0154k, Context context, n nVar, View view) {
        super(R.attr.actionOverflowMenuStyle, context, view, nVar, true);
        this.f3192m = c0154k;
        this.f3002f = 8388613;
        C0005e c0005e = c0154k.f3227w;
        this.f3003h = c0005e;
        v vVar = this.f3004i;
        if (vVar != null) {
            vVar.h(c0005e);
        }
    }

    @Override // p013i.y
    public final void c() {
        switch (this.f3191l) {
            case 0:
                C0154k c0154k = this.f3192m;
                c0154k.f3224t = null;
                c0154k.getClass();
                super.c();
                break;
            default:
                C0154k c0154k2 = this.f3192m;
                n nVar = c0154k2.f3208c;
                if (nVar != null) {
                    nVar.c(true);
                }
                c0154k2.f3223s = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0146g(C0154k c0154k, Context context, G g, View view) {
        super(R.attr.actionOverflowMenuStyle, context, view, g, false);
        this.f3192m = c0154k;
        if (!g.f2862A.f()) {
            View view2 = c0154k.f3213i;
            this.f3001e = view2 == null ? (View) c0154k.f3212h : view2;
        }
        C0005e c0005e = c0154k.f3227w;
        this.f3003h = c0005e;
        v vVar = this.f3004i;
        if (vVar != null) {
            vVar.h(c0005e);
        }
    }
}
