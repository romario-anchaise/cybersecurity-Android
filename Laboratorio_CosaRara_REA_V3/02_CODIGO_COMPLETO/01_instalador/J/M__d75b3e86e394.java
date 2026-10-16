// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class M implements ListAdapter, SpinnerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpinnerAdapter f3083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f3084b;

    @Override // android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f3084b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        if (spinnerAdapter == null) {
            return 0;
        }
        return spinnerAdapter.getCount();
    }

    @Override // android.widget.SpinnerAdapter
    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getDropDownView(i2, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getItem(i2);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        if (spinnerAdapter == null) {
            return -1L;
        }
        return spinnerAdapter.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public final int getItemViewType(int i2) {
        return 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        return getDropDownView(i2, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public final int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public final boolean hasStableIds() {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        return spinnerAdapter != null && spinnerAdapter.hasStableIds();
    }

    @Override // android.widget.Adapter
    public final boolean isEmpty() {
        return getCount() == 0;
    }

    @Override // android.widget.ListAdapter
    public final boolean isEnabled(int i2) {
        ListAdapter listAdapter = this.f3084b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i2);
        }
        return true;
    }

    @Override // android.widget.Adapter
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        if (spinnerAdapter != null) {
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f3083a;
        if (spinnerAdapter != null) {
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
