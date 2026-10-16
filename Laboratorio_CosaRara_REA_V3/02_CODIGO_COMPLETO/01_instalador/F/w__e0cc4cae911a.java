// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import V0.j;
import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import p013i.u;
import p021m.i;
import p037v.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2527b;

    public w(Context context) {
        this.f2526a = context;
    }

    public void c() {
        j jVar = (j) this.f2526a;
        if (jVar != null) {
            try {
                ((z) this.f2527b).f2581k.unregisterReceiver(jVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f2526a = null;
        }
    }

    public abstract IntentFilter d();

    public abstract int e();

    public MenuItem f(MenuItem menuItem) {
        if (!(menuItem instanceof a)) {
            return menuItem;
        }
        a aVar = (a) menuItem;
        if (((i) this.f2527b) == null) {
            this.f2527b = new i(0);
        }
        MenuItem menuItem2 = (MenuItem) ((i) this.f2527b).get(aVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        u uVar = new u((Context) this.f2526a, aVar);
        ((i) this.f2527b).put(aVar, uVar);
        return uVar;
    }

    public abstract void g();

    public void h() {
        c();
        IntentFilter intentFilterD = d();
        if (intentFilterD.countActions() == 0) {
            return;
        }
        if (((j) this.f2526a) == null) {
            this.f2526a = new j(1, this);
        }
        ((z) this.f2527b).f2581k.registerReceiver((j) this.f2526a, intentFilterD);
    }

    public w(z zVar) {
        this.f2527b = zVar;
    }
}
