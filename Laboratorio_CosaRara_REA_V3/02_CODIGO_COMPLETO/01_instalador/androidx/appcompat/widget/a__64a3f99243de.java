// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f1465a;

    public a(SearchView searchView) {
        this.f1465a = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchView searchView = this.f1465a;
        ImageView imageView = searchView.f1407t;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f1403p;
        if (view == imageView) {
            searchView.x(false);
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
            View.OnClickListener onClickListener = searchView.f1386L;
            if (onClickListener != null) {
                onClickListener.onClick(searchView);
                return;
            }
            return;
        }
        if (view == searchView.f1409v) {
            searchView.n();
            return;
        }
        if (view == searchView.f1408u) {
            searchView.r();
            return;
        }
        if (view != searchView.f1410w) {
            if (view == searchAutoComplete) {
                searchView.m();
                return;
            }
            return;
        }
        SearchableInfo searchableInfo = searchView.f1398b0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    searchView.getContext().startActivity(searchView.l(searchView.f1383I, searchableInfo));
                }
            } else {
                Intent intent = new Intent(searchView.f1382H);
                ComponentName searchActivity = searchableInfo.getSearchActivity();
                intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                searchView.getContext().startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }
}
