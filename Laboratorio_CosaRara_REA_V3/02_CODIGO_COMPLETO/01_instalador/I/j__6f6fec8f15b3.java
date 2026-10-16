// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import b1.p;
import p009f.C0115e;
import p009f.DialogC0119i;

/* JADX INFO: loaded from: classes.dex */
public final class j implements A, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f2919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f2920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f2921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f2922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f2923f;

    public j(ContextWrapper contextWrapper) {
        this.f2918a = contextWrapper;
        this.f2919b = LayoutInflater.from(contextWrapper);
    }

    @Override // p013i.A
    public final void a(n nVar, boolean z2) {
        z zVar = this.f2922e;
        if (zVar != null) {
            zVar.a(nVar, z2);
        }
    }

    @Override // p013i.A
    public final void c() {
        i iVar = this.f2923f;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    @Override // p013i.A
    public final boolean d(p pVar) {
        return false;
    }

    @Override // p013i.A
    public final boolean f() {
        return false;
    }

    @Override // p013i.A
    public final void g(Context context, n nVar) {
        if (this.f2918a != null) {
            this.f2918a = context;
            if (this.f2919b == null) {
                this.f2919b = LayoutInflater.from(context);
            }
        }
        this.f2920c = nVar;
        i iVar = this.f2923f;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    @Override // p013i.A
    public final void h(z zVar) {
        throw null;
    }

    @Override // p013i.A
    public final boolean j(p pVar) {
        return false;
    }

    @Override // p013i.A
    public final boolean k(G g) {
        if (!g.hasVisibleItems()) {
            return false;
        }
        o oVar = new o();
        oVar.f2954a = g;
        Context context = g.f2931a;
        p pVar = new p(context);
        C0115e c0115e = (C0115e) pVar.f2171b;
        j jVar = new j(c0115e.f2465a);
        oVar.f2956c = jVar;
        jVar.f2922e = oVar;
        g.b(jVar, context);
        j jVar2 = oVar.f2956c;
        if (jVar2.f2923f == null) {
            jVar2.f2923f = new i(jVar2);
        }
        c0115e.g = jVar2.f2923f;
        c0115e.f2471h = oVar;
        View view = g.f2944o;
        if (view != null) {
            c0115e.f2469e = view;
        } else {
            c0115e.f2467c = g.f2943n;
            c0115e.f2468d = g.f2942m;
        }
        c0115e.f2470f = oVar;
        DialogC0119i dialogC0119iC = pVar.c();
        oVar.f2955b = dialogC0119iC;
        dialogC0119iC.setOnDismissListener(oVar);
        WindowManager.LayoutParams attributes = oVar.f2955b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        oVar.f2955b.show();
        z zVar = this.f2922e;
        if (zVar == null) {
            return true;
        }
        zVar.j(g);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        this.f2920c.q(this.f2923f.getItem(i2), this, 0);
    }
}
