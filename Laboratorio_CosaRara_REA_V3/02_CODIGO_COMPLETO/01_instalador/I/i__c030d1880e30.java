// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2916a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f2917b;

    public i(j jVar) {
        this.f2917b = jVar;
        a();
    }

    public final void a() {
        n nVar = this.f2917b.f2920c;
        p pVar = nVar.f2951v;
        if (pVar != null) {
            nVar.i();
            ArrayList arrayList = nVar.f2939j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((p) arrayList.get(i2)) == pVar) {
                    this.f2916a = i2;
                    return;
                }
            }
        }
        this.f2916a = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final p getItem(int i2) {
        j jVar = this.f2917b;
        n nVar = jVar.f2920c;
        nVar.i();
        ArrayList arrayList = nVar.f2939j;
        jVar.getClass();
        int i3 = this.f2916a;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (p) arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        j jVar = this.f2917b;
        n nVar = jVar.f2920c;
        nVar.i();
        int size = nVar.f2939j.size();
        jVar.getClass();
        return this.f2916a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2917b.f2919b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((B) view).c(getItem(i2));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
