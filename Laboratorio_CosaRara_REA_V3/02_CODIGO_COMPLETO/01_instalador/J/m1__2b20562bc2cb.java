// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import p011h.c;
import p013i.A;
import p013i.G;
import p013i.n;
import p013i.p;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f3250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f3251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3252c;

    public m1(Toolbar toolbar) {
        this.f3252c = toolbar;
    }

    @Override // p013i.A
    public final void c() {
        if (this.f3251b != null) {
            n nVar = this.f3250a;
            if (nVar != null) {
                int size = nVar.f2936f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f3250a.getItem(i2) == this.f3251b) {
                        return;
                    }
                }
            }
            d(this.f3251b);
        }
    }

    @Override // p013i.A
    public final boolean d(p pVar) {
        Toolbar toolbar = this.f3252c;
        KeyEvent.Callback callback = toolbar.f1443i;
        if (callback instanceof c) {
            ((c) callback).d();
        }
        toolbar.removeView(toolbar.f1443i);
        toolbar.removeView(toolbar.f1442h);
        toolbar.f1443i = null;
        ArrayList arrayList = toolbar.f1421E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f3251b = null;
        toolbar.requestLayout();
        pVar.f2959C = false;
        pVar.f2972n.p(false);
        toolbar.w();
        return true;
    }

    @Override // p013i.A
    public final boolean f() {
        return false;
    }

    @Override // p013i.A
    public final void g(Context context, n nVar) {
        p pVar;
        n nVar2 = this.f3250a;
        if (nVar2 != null && (pVar = this.f3251b) != null) {
            nVar2.d(pVar);
        }
        this.f3250a = nVar;
    }

    @Override // p013i.A
    public final boolean j(p pVar) {
        Toolbar toolbar = this.f3252c;
        toolbar.c();
        ViewParent parent = toolbar.f1442h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f1442h);
            }
            toolbar.addView(toolbar.f1442h);
        }
        View actionView = pVar.getActionView();
        toolbar.f1443i = actionView;
        this.f3251b = pVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f1443i);
            }
            n1 n1VarH = Toolbar.h();
            n1VarH.f3253a = (toolbar.f1448n & 112) | 8388611;
            n1VarH.f3254b = 2;
            toolbar.f1443i.setLayoutParams(n1VarH);
            toolbar.addView(toolbar.f1443i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((n1) childAt.getLayoutParams()).f3254b != 2 && childAt != toolbar.f1436a) {
                toolbar.removeViewAt(childCount);
                toolbar.f1421E.add(childAt);
            }
        }
        toolbar.requestLayout();
        pVar.f2959C = true;
        pVar.f2972n.p(false);
        KeyEvent.Callback callback = toolbar.f1443i;
        if (callback instanceof c) {
            ((c) callback).a();
        }
        toolbar.w();
        return true;
    }

    @Override // p013i.A
    public final boolean k(G g) {
        return false;
    }

    @Override // p013i.A
    public final void a(n nVar, boolean z2) {
    }
}
