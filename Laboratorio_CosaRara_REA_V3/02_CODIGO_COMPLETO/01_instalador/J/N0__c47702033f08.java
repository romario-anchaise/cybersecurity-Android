// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import p013i.k;
import p013i.n;
import p013i.p;

/* JADX INFO: loaded from: classes.dex */
public final class N0 extends C0178w0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f3087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public J0 f3089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f3090p;

    public N0(Context context, boolean z2) {
        super(context, z2);
        if (1 == M0.a(context.getResources().getConfiguration())) {
            this.f3087m = 21;
            this.f3088n = 22;
        } else {
            this.f3087m = 22;
            this.f3088n = 21;
        }
    }

    @Override // p015j.C0178w0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        k kVar;
        int headersCount;
        int iPointToPosition;
        int i2;
        if (this.f3089o != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                kVar = (k) headerViewListAdapter.getWrappedAdapter();
            } else {
                kVar = (k) adapter;
                headersCount = 0;
            }
            p item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i2 = iPointToPosition - headersCount) < 0 || i2 >= kVar.getCount()) ? null : kVar.getItem(i2);
            p pVar = this.f3090p;
            if (pVar != item) {
                n nVar = kVar.f2924a;
                if (pVar != null) {
                    this.f3089o.n(nVar, pVar);
                }
                this.f3090p = item;
                if (item != null) {
                    this.f3089o.h(nVar, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i2 == this.f3087m) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i2 != this.f3088n) {
            return super.onKeyDown(i2, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (k) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (k) adapter).f2924a.c(false);
        return true;
    }

    public void setHoverListener(J0 j2) {
        this.f3089o = j2;
    }

    @Override // p015j.C0178w0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
