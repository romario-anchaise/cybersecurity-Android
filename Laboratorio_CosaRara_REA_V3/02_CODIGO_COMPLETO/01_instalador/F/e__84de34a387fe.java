// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import p013i.o;

/* JADX INFO: renamed from: f.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0115e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContextThemeWrapper f2465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f2466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f2467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f2468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f2469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f2470f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DialogInterface.OnClickListener f2471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2473j = -1;

    public C0115e(ContextThemeWrapper contextThemeWrapper) {
        this.f2465a = contextThemeWrapper;
        this.f2466b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
    }
}
