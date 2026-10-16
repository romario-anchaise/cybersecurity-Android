// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2925b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f2928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2929f;

    public k(n nVar, LayoutInflater layoutInflater, boolean z2, int i2) {
        this.f2927d = z2;
        this.f2928e = layoutInflater;
        this.f2924a = nVar;
        this.f2929f = i2;
        a();
    }

    public final void a() {
        n nVar = this.f2924a;
        p pVar = nVar.f2951v;
        if (pVar != null) {
            nVar.i();
            ArrayList arrayList = nVar.f2939j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((p) arrayList.get(i2)) == pVar) {
                    this.f2925b = i2;
                    return;
                }
            }
        }
        this.f2925b = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final p getItem(int i2) {
        ArrayList arrayListL;
        n nVar = this.f2924a;
        if (this.f2927d) {
            nVar.i();
            arrayListL = nVar.f2939j;
        } else {
            arrayListL = nVar.l();
        }
        int i3 = this.f2925b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (p) arrayListL.get(i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        n nVar = this.f2924a;
        if (this.f2927d) {
            nVar.i();
            arrayListL = nVar.f2939j;
        } else {
            arrayListL = nVar.l();
        }
        return this.f2925b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z2 = false;
        if (view == null) {
            view = this.f2928e.inflate(this.f2929f, viewGroup, false);
        }
        int i3 = getItem(i2).f2961b;
        int i4 = i2 - 1;
        int i5 = i4 >= 0 ? getItem(i4).f2961b : i3;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f2924a.m() && i3 != i5) {
            z2 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z2);
        B b2 = (B) view;
        if (this.f2926c) {
            listMenuItemView.setForceShowIcon(true);
        }
        b2.c(getItem(i2));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
