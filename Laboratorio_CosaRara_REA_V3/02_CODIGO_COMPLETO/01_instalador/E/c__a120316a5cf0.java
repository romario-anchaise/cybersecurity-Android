// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package E;

import F0.h;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import p015j.f1;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f158f;
    public d g;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f155c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f157e;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.f158f;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f155c = cursor;
            if (cursor != null) {
                a aVar2 = this.f157e;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.f158f;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f156d = cursor.getColumnIndexOrThrow("_id");
                this.f153a = true;
                notifyDataSetChanged();
            } else {
                this.f156d = -1;
                this.f153a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f153a || (cursor = this.f155c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f153a) {
            return null;
        }
        this.f155c.moveToPosition(i2);
        if (view == null) {
            f1 f1Var = (f1) this;
            view = f1Var.f3177j.inflate(f1Var.f3176i, viewGroup, false);
        }
        a(view, this.f155c);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.g == null) {
            d dVar = new d();
            dVar.f159a = this;
            this.g = dVar;
        }
        return this.g;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        Cursor cursor;
        if (!this.f153a || (cursor = this.f155c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f155c;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        Cursor cursor;
        if (this.f153a && (cursor = this.f155c) != null && cursor.moveToPosition(i2)) {
            return this.f155c.getLong(this.f156d);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f153a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f155c.moveToPosition(i2)) {
            throw new IllegalStateException(h.b(i2, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f155c);
        return view;
    }
}
