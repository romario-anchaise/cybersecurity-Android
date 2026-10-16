// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import p009f.DialogC0119i;

/* JADX INFO: loaded from: classes.dex */
public final class o implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public G f2954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogC0119i f2955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f2956c;

    @Override // p013i.z
    public final void a(n nVar, boolean z2) {
        DialogC0119i dialogC0119i;
        if ((z2 || nVar == this.f2954a) && (dialogC0119i = this.f2955b) != null) {
            dialogC0119i.dismiss();
        }
    }

    @Override // p013i.z
    public final boolean j(n nVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        j jVar = this.f2956c;
        if (jVar.f2923f == null) {
            jVar.f2923f = new i(jVar);
        }
        this.f2954a.q(jVar.f2923f.getItem(i2), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f2956c.a(this.f2954a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        G g = this.f2954a;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f2955b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f2955b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                g.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return g.performShortcut(i2, keyEvent, 0);
    }
}
