// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package E;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import androidx.appcompat.widget.SearchView;
import p015j.f1;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f159a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return ((f1) this.f159a).c((Cursor) obj);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        String string;
        Cursor cursorG;
        f1 f1Var = (f1) this.f159a;
        if (charSequence == null) {
            string = "";
        } else {
            f1Var.getClass();
            string = charSequence.toString();
        }
        SearchView searchView = f1Var.f3178k;
        if (searchView.getVisibility() == 0 && searchView.getWindowVisibility() == 0) {
            try {
                cursorG = f1Var.g(f1Var.f3179l, string);
                if (cursorG != null) {
                    cursorG.getCount();
                } else {
                    cursorG = null;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        } else {
            cursorG = null;
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorG != null) {
            filterResults.count = cursorG.getCount();
            filterResults.values = cursorG;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        c cVar = this.f159a;
        Cursor cursor = cVar.f155c;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((f1) cVar).b((Cursor) obj);
    }
}
