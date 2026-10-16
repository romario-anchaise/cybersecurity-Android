// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.refreshAutoCompleteResults();
    }

    public static void b(SearchView.SearchAutoComplete searchAutoComplete, int i2) {
        searchAutoComplete.setInputMethodMode(i2);
    }
}
