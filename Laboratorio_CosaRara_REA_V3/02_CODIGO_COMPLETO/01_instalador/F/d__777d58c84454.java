// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: f.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0114d implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0118h f2463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0115e f2464b;

    public C0114d(C0115e c0115e, C0118h c0118h) {
        this.f2464b = c0115e;
        this.f2463a = c0118h;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        C0115e c0115e = this.f2464b;
        DialogInterface.OnClickListener onClickListener = c0115e.f2471h;
        C0118h c0118h = this.f2463a;
        onClickListener.onClick(c0118h.f2476b, i2);
        if (c0115e.f2472i) {
            return;
        }
        c0118h.f2476b.dismiss();
    }
}
