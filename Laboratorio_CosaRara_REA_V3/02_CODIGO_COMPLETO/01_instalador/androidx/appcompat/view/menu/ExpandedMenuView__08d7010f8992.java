// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.view.menu;

import C.h;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p013i.C;
import p013i.m;
import p013i.n;
import p013i.p;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements m, C, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1279b = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f1280a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        h hVarP = h.p(context, attributeSet, f1279b, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(hVarP.l(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(hVarP.l(1));
        }
        hVarP.r();
    }

    @Override // p013i.C
    public final void b(n nVar) {
        this.f1280a = nVar;
    }

    @Override // p013i.m
    public final boolean c(p pVar) {
        return this.f1280a.q(pVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        c((p) getAdapter().getItem(i2));
    }
}
