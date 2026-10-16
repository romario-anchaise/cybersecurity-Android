// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.H;
import A.X;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f2998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f3001e;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z f3003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v f3004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public w f3005j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3002f = 8388611;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final w f3006k = new w(this);

    public y(int i2, Context context, View view, n nVar, boolean z2) {
        this.f2997a = context;
        this.f2998b = nVar;
        this.f3001e = view;
        this.f2999c = z2;
        this.f3000d = i2;
    }

    public final v a() {
        v f2;
        if (this.f3004i == null) {
            Context context = this.f2997a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            x.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                f2 = new h(context, this.f3001e, this.f3000d, this.f2999c);
            } else {
                View view = this.f3001e;
                Context context2 = this.f2997a;
                boolean z2 = this.f2999c;
                f2 = new F(this.f3000d, context2, view, this.f2998b, z2);
            }
            f2.l(this.f2998b);
            f2.r(this.f3006k);
            f2.n(this.f3001e);
            f2.h(this.f3003h);
            f2.o(this.g);
            f2.p(this.f3002f);
            this.f3004i = f2;
        }
        return this.f3004i;
    }

    public final boolean b() {
        v vVar = this.f3004i;
        return vVar != null && vVar.b();
    }

    public void c() {
        this.f3004i = null;
        w wVar = this.f3005j;
        if (wVar != null) {
            wVar.onDismiss();
        }
    }

    public final void d(int i2, int i3, boolean z2, boolean z3) {
        v vVarA = a();
        vVarA.s(z3);
        if (z2) {
            int i4 = this.f3002f;
            View view = this.f3001e;
            WeakHashMap weakHashMap = X.f14a;
            if ((Gravity.getAbsoluteGravity(i4, H.d(view)) & 7) == 5) {
                i2 -= this.f3001e.getWidth();
            }
            vVarA.q(i2);
            vVarA.t(i3);
            int i5 = (int) ((this.f2997a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            vVarA.f2995a = new Rect(i2 - i5, i3 - i5, i2 + i5, i3 + i5);
        }
        vVarA.i();
    }
}
