// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.view.View;
import android.view.Window;
import p013i.C0127a;

/* JADX INFO: loaded from: classes.dex */
public final class q1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0127a f3270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r1 f3271b;

    public q1(r1 r1Var) {
        this.f3271b = r1Var;
        Context context = r1Var.f3276a.getContext();
        CharSequence charSequence = r1Var.f3282h;
        C0127a c0127a = new C0127a();
        c0127a.f2868e = 4096;
        c0127a.g = 4096;
        c0127a.f2874l = null;
        c0127a.f2875m = null;
        c0127a.f2876n = false;
        c0127a.f2877o = false;
        c0127a.f2878p = 16;
        c0127a.f2871i = context;
        c0127a.f2864a = charSequence;
        this.f3270a = c0127a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        r1 r1Var = this.f3271b;
        Window.Callback callback = r1Var.f3285k;
        if (callback == null || !r1Var.f3286l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f3270a);
    }
}
