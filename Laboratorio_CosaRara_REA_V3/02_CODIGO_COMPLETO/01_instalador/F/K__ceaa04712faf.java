// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.G;
import A.X;
import D.b;
import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p013i.p;
import p015j.C0154k;
import p015j.m1;
import p015j.r1;

/* JADX INFO: loaded from: classes.dex */
public final class K extends AbstractC0111a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f2417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f2418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final I f2419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2422f;
    public final ArrayList g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f2423h = new b(2, this);

    public K(Toolbar toolbar, CharSequence charSequence, u uVar) {
        I i2 = new I(this);
        toolbar.getClass();
        r1 r1Var = new r1(toolbar, false);
        this.f2417a = r1Var;
        uVar.getClass();
        this.f2418b = uVar;
        r1Var.f3285k = uVar;
        toolbar.setOnMenuItemClickListener(i2);
        if (!r1Var.g) {
            r1Var.f3282h = charSequence;
            if ((r1Var.f3277b & 8) != 0) {
                Toolbar toolbar2 = r1Var.f3276a;
                toolbar2.setTitle(charSequence);
                if (r1Var.g) {
                    X.i(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.f2419c = new I(this);
    }

    @Override // p009f.AbstractC0111a
    public final boolean a() {
        C0154k c0154k;
        ActionMenuView actionMenuView = this.f2417a.f3276a.f1436a;
        return (actionMenuView == null || (c0154k = actionMenuView.f1356t) == null || !c0154k.e()) ? false : true;
    }

    @Override // p009f.AbstractC0111a
    public final boolean b() {
        p pVar;
        m1 m1Var = this.f2417a.f3276a.f1429M;
        if (m1Var == null || (pVar = m1Var.f3251b) == null) {
            return false;
        }
        if (m1Var == null) {
            pVar = null;
        }
        if (pVar == null) {
            return true;
        }
        pVar.collapseActionView();
        return true;
    }

    @Override // p009f.AbstractC0111a
    public final void c(boolean z2) {
        if (z2 == this.f2422f) {
            return;
        }
        this.f2422f = z2;
        ArrayList arrayList = this.g;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // p009f.AbstractC0111a
    public final int d() {
        return this.f2417a.f3277b;
    }

    @Override // p009f.AbstractC0111a
    public final Context e() {
        return this.f2417a.f3276a.getContext();
    }

    @Override // p009f.AbstractC0111a
    public final boolean f() {
        r1 r1Var = this.f2417a;
        Toolbar toolbar = r1Var.f3276a;
        b bVar = this.f2423h;
        toolbar.removeCallbacks(bVar);
        Toolbar toolbar2 = r1Var.f3276a;
        WeakHashMap weakHashMap = X.f14a;
        G.m(toolbar2, bVar);
        return true;
    }

    @Override // p009f.AbstractC0111a
    public final void h() {
        this.f2417a.f3276a.removeCallbacks(this.f2423h);
    }

    @Override // p009f.AbstractC0111a
    public final boolean i(int i2, KeyEvent keyEvent) {
        Menu menuP = p();
        if (menuP == null) {
            return false;
        }
        menuP.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuP.performShortcut(i2, keyEvent, 0);
    }

    @Override // p009f.AbstractC0111a
    public final boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // p009f.AbstractC0111a
    public final boolean k() {
        return this.f2417a.f3276a.v();
    }

    @Override // p009f.AbstractC0111a
    public final void n(CharSequence charSequence) {
        r1 r1Var = this.f2417a;
        if (r1Var.g) {
            return;
        }
        r1Var.f3282h = charSequence;
        if ((r1Var.f3277b & 8) != 0) {
            Toolbar toolbar = r1Var.f3276a;
            toolbar.setTitle(charSequence);
            if (r1Var.g) {
                X.i(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final Menu p() {
        boolean z2 = this.f2421e;
        r1 r1Var = this.f2417a;
        if (!z2) {
            J j2 = new J(this);
            I i2 = new I(this);
            Toolbar toolbar = r1Var.f3276a;
            toolbar.f1430N = j2;
            toolbar.f1431O = i2;
            ActionMenuView actionMenuView = toolbar.f1436a;
            if (actionMenuView != null) {
                actionMenuView.f1357u = j2;
                actionMenuView.f1358v = i2;
            }
            this.f2421e = true;
        }
        return r1Var.f3276a.getMenu();
    }

    @Override // p009f.AbstractC0111a
    public final void g() {
    }

    @Override // p009f.AbstractC0111a
    public final void l(boolean z2) {
    }

    @Override // p009f.AbstractC0111a
    public final void m(boolean z2) {
    }
}
