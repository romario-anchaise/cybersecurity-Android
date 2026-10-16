// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import b1.p;
import p009f.C0115e;
import p009f.DialogC0119i;

/* JADX INFO: loaded from: classes.dex */
public final class L implements S, DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogC0119i f3079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public M f3080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f3081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ T f3082d;

    public L(T t2) {
        this.f3082d = t2;
    }

    @Override // p015j.S
    public final CharSequence a() {
        return this.f3081c;
    }

    @Override // p015j.S
    public final boolean b() {
        DialogC0119i dialogC0119i = this.f3079a;
        if (dialogC0119i != null) {
            return dialogC0119i.isShowing();
        }
        return false;
    }

    @Override // p015j.S
    public final void c(int i2) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // p015j.S
    public final int d() {
        return 0;
    }

    @Override // p015j.S
    public final void dismiss() {
        DialogC0119i dialogC0119i = this.f3079a;
        if (dialogC0119i != null) {
            dialogC0119i.dismiss();
            this.f3079a = null;
        }
    }

    @Override // p015j.S
    public final void f(int i2, int i3) {
        if (this.f3080b == null) {
            return;
        }
        T t2 = this.f3082d;
        p pVar = new p(t2.getPopupContext());
        CharSequence charSequence = this.f3081c;
        C0115e c0115e = (C0115e) pVar.f2171b;
        if (charSequence != null) {
            c0115e.f2468d = charSequence;
        }
        M m2 = this.f3080b;
        int selectedItemPosition = t2.getSelectedItemPosition();
        c0115e.g = m2;
        c0115e.f2471h = this;
        c0115e.f2473j = selectedItemPosition;
        c0115e.f2472i = true;
        DialogC0119i dialogC0119iC = pVar.c();
        this.f3079a = dialogC0119iC;
        AlertController$RecycleListView alertController$RecycleListView = dialogC0119iC.f2501e.f2479e;
        J.d(alertController$RecycleListView, i2);
        J.c(alertController$RecycleListView, i3);
        this.f3079a.show();
    }

    @Override // p015j.S
    public final void g(CharSequence charSequence) {
        this.f3081c = charSequence;
    }

    @Override // p015j.S
    public final int j() {
        return 0;
    }

    @Override // p015j.S
    public final void k(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // p015j.S
    public final void l(int i2) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // p015j.S
    public final Drawable m() {
        return null;
    }

    @Override // p015j.S
    public final void o(ListAdapter listAdapter) {
        this.f3080b = (M) listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        T t2 = this.f3082d;
        t2.setSelection(i2);
        if (t2.getOnItemClickListener() != null) {
            t2.performItemClick(null, i2, this.f3080b.getItemId(i2));
        }
        dismiss();
    }

    @Override // p015j.S
    public final void p(int i2) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
}
