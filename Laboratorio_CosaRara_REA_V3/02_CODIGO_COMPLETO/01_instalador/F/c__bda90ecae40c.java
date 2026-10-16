// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import p011h.b;
import p013i.p;
import p015j.m1;

/* JADX INFO: renamed from: f.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0113c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2462b;

    public /* synthetic */ ViewOnClickListenerC0113c(int i2, Object obj) {
        this.f2461a = i2;
        this.f2462b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2461a) {
            case 0:
                C0118h c0118h = (C0118h) this.f2462b;
                Button button = c0118h.f2480f;
                c0118h.f2495v.obtainMessage(1, c0118h.f2476b).sendToTarget();
                break;
            case 1:
                ((b) this.f2462b).a();
                break;
            default:
                m1 m1Var = ((Toolbar) this.f2462b).f1429M;
                p pVar = m1Var == null ? null : m1Var.f3251b;
                if (pVar != null) {
                    pVar.collapseActionView();
                }
                break;
        }
    }
}
