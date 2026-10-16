// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.G;
import A.X;
import C.h;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.o2s2m.gae1fc3b2uc0u.R;
import g1.i;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p015j.B0;
import p015j.C0;
import p015j.C0162o;
import p015j.N;
import p015j.U0;
import p015j.V0;
import p015j.W0;
import p015j.X0;
import p015j.Y0;
import p015j.Z0;
import p015j.a1;
import p015j.b1;
import p015j.c1;
import p015j.d1;
import p015j.f1;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends B0 implements p011h.c {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final i f1374g0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final Rect f1375A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final int[] f1376B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final int[] f1377C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ImageView f1378D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Drawable f1379E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int f1380F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int f1381G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final Intent f1382H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final Intent f1383I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CharSequence f1384J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public View.OnFocusChangeListener f1385K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public View.OnClickListener f1386L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f1387M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f1388N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public E.c f1389O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f1390P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CharSequence f1391Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f1392R;
    public boolean S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f1393T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public boolean f1394U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public CharSequence f1395V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public boolean f1396W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f1397a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public SearchableInfo f1398b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Bundle f1399c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final V0 f1400d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final V0 f1401e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final WeakHashMap f1402f0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SearchAutoComplete f1403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f1404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f1405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f1406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f1407t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f1408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f1409v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f1410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View f1411x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d1 f1412y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Rect f1413z;

    public static class SearchAutoComplete extends C0162o {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1414e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SearchView f1415f;
        public boolean g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final d f1416h;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1416h = new d(this);
            this.f1414e = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 < 600) {
                return (i2 < 640 || i3 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            i iVar = SearchView.f1374g0;
            iVar.getClass();
            i.a();
            Method method = iVar.f2772c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f1414e <= 0 || super.enoughToFilter();
        }

        @Override // p015j.C0162o, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.g) {
                d dVar = this.f1416h;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z2, int i2, Rect rect) {
            super.onFocusChanged(z2, i2, rect);
            SearchView searchView = this.f1415f;
            searchView.x(searchView.f1388N);
            searchView.post(searchView.f1400d0);
            if (searchView.f1403p.hasFocus()) {
                searchView.m();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1415f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f1415f.hasFocus() && getVisibility() == 0) {
                this.g = true;
                Context context = getContext();
                i iVar = SearchView.f1374g0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.f1416h;
            if (!z2) {
                this.g = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.g = true;
                    return;
                }
                this.g = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1415f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f1414e = i2;
        }
    }

    static {
        i iVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            i iVar2 = new i();
            iVar2.f2770a = null;
            iVar2.f2771b = null;
            iVar2.f2772c = null;
            i.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                iVar2.f2770a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                iVar2.f2771b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                iVar2.f2772c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            iVar = iVar2;
        }
        f1374g0 = iVar;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f1403p;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // p011h.c
    public final void a() {
        if (this.f1396W) {
            return;
        }
        this.f1396W = true;
        SearchAutoComplete searchAutoComplete = this.f1403p;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f1397a0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.S = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f1403p;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.S = false;
    }

    @Override // p011h.c
    public final void d() {
        SearchAutoComplete searchAutoComplete = this.f1403p;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f1395V = "";
        clearFocus();
        x(true);
        searchAutoComplete.setImeOptions(this.f1397a0);
        this.f1396W = false;
    }

    public int getImeOptions() {
        return this.f1403p.getImeOptions();
    }

    public int getInputType() {
        return this.f1403p.getInputType();
    }

    public int getMaxWidth() {
        return this.f1393T;
    }

    public CharSequence getQuery() {
        return this.f1403p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1391Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1398b0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f1384J : getContext().getText(this.f1398b0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f1381G;
    }

    public int getSuggestionRowLayout() {
        return this.f1380F;
    }

    public E.c getSuggestionsAdapter() {
        return this.f1389O;
    }

    public final Intent k(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1395V);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1399c0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f1398b0.getSearchActivity());
        return intent;
    }

    public final Intent l(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1399c0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void m() {
        int i2 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f1403p;
        if (i2 >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        i iVar = f1374g0;
        iVar.getClass();
        i.a();
        Method method = iVar.f2770a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        iVar.getClass();
        i.a();
        Method method2 = iVar.f2771b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void n() {
        SearchAutoComplete searchAutoComplete = this.f1403p;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f1387M) {
            clearFocus();
            x(true);
        }
    }

    public final void o(int i2) {
        int position;
        String strH;
        Cursor cursor = this.f1389O.f155c;
        if (cursor != null && cursor.moveToPosition(i2)) {
            Intent intentK = null;
            try {
                int i3 = f1.f3174x;
                String strH2 = f1.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strH2 == null) {
                    strH2 = this.f1398b0.getSuggestIntentAction();
                }
                if (strH2 == null) {
                    strH2 = "android.intent.action.SEARCH";
                }
                String strH3 = f1.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strH3 == null) {
                    strH3 = this.f1398b0.getSuggestIntentData();
                }
                if (strH3 != null && (strH = f1.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strH3 = strH3 + "/" + Uri.encode(strH);
                }
                intentK = k(strH2, strH3 == null ? null : Uri.parse(strH3), f1.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), f1.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e2) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            }
            if (intentK != null) {
                try {
                    getContext().startActivity(intentK);
                } catch (RuntimeException e3) {
                    Log.e("SearchView", "Failed launch activity: " + intentK, e3);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f1403p;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f1400d0);
        post(this.f1401e0);
        super.onDetachedFromWindow();
    }

    @Override // p015j.B0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            int[] iArr = this.f1376B;
            SearchAutoComplete searchAutoComplete = this.f1403p;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f1377C;
            getLocationInWindow(iArr2);
            int i6 = iArr[1] - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i7;
            int height = searchAutoComplete.getHeight() + i6;
            Rect rect = this.f1413z;
            rect.set(i7, i6, width, height);
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = i5 - i3;
            Rect rect2 = this.f1375A;
            rect2.set(i8, 0, i9, i10);
            d1 d1Var = this.f1412y;
            if (d1Var == null) {
                d1 d1Var2 = new d1(rect2, rect, searchAutoComplete);
                this.f1412y = d1Var2;
                setTouchDelegate(d1Var2);
            } else {
                d1Var.f3158b.set(rect2);
                Rect rect3 = d1Var.f3160d;
                rect3.set(rect2);
                int i11 = -d1Var.f3161e;
                rect3.inset(i11, i11);
                d1Var.f3159c.set(rect);
            }
        }
    }

    @Override // p015j.B0, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        if (this.f1388N) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.f1393T;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f1393T;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.f1393T) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c1 c1Var = (c1) parcelable;
        super.onRestoreInstanceState(c1Var.f184a);
        x(c1Var.f3153c);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        c1 c1Var = new c1(super.onSaveInstanceState());
        c1Var.f3153c = this.f1388N;
        return c1Var;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        post(this.f1400d0);
    }

    public final void p(int i2) {
        Editable text = this.f1403p.getText();
        Cursor cursor = this.f1389O.f155c;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        String strC = this.f1389O.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    public final void q(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void r() {
        SearchAutoComplete searchAutoComplete = this.f1403p;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f1398b0 != null) {
            getContext().startActivity(k("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        if (this.S || !isFocusable()) {
            return false;
        }
        if (this.f1388N) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.f1403p.requestFocus(i2, rect);
        if (zRequestFocus) {
            x(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f1403p.getText());
        int i2 = (!zIsEmpty || (this.f1387M && !this.f1396W)) ? 0 : 8;
        ImageView imageView = this.f1409v;
        imageView.setVisibility(i2);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1399c0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            n();
            return;
        }
        x(false);
        SearchAutoComplete searchAutoComplete = this.f1403p;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1386L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.f1387M == z2) {
            return;
        }
        this.f1387M = z2;
        x(z2);
        u();
    }

    public void setImeOptions(int i2) {
        this.f1403p.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f1403p.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.f1393T = i2;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1385K = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1386L = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1391Q = charSequence;
        u();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.f1392R = z2;
        E.c cVar = this.f1389O;
        if (cVar instanceof f1) {
            ((f1) cVar).f3183p = z2 ? 2 : 1;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1398b0 = searchableInfo;
        Intent intent = null;
        SearchAutoComplete searchAutoComplete = this.f1403p;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.f1398b0.getImeOptions());
            int inputType = this.f1398b0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.f1398b0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            E.c cVar = this.f1389O;
            if (cVar != null) {
                cVar.b(null);
            }
            if (this.f1398b0.getSuggestAuthority() != null) {
                f1 f1Var = new f1(getContext(), this, this.f1398b0, this.f1402f0);
                this.f1389O = f1Var;
                searchAutoComplete.setAdapter(f1Var);
                ((f1) this.f1389O).f3183p = this.f1392R ? 2 : 1;
            }
            u();
        }
        SearchableInfo searchableInfo2 = this.f1398b0;
        boolean z2 = false;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.f1398b0.getVoiceSearchLaunchWebSearch()) {
                intent = this.f1382H;
            } else if (this.f1398b0.getVoiceSearchLaunchRecognizer()) {
                intent = this.f1383I;
            }
            if (intent != null) {
                z2 = getContext().getPackageManager().resolveActivity(intent, 65536) != null;
            }
        }
        this.f1394U = z2;
        if (z2) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        x(this.f1388N);
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.f1390P = z2;
        x(this.f1388N);
    }

    public void setSuggestionsAdapter(E.c cVar) {
        this.f1389O = cVar;
        this.f1403p.setAdapter(cVar);
    }

    public final void t() {
        int[] iArr = this.f1403p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1405r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1406s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void u() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z2 = this.f1387M;
        SearchAutoComplete searchAutoComplete = this.f1403p;
        CharSequence charSequence2 = charSequence;
        if (z2 && (drawable = this.f1379E) != null) {
            charSequence2 = charSequence;
            int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            charSequence2 = spannableStringBuilder;
        }
        charSequence2 = charSequence;
        searchAutoComplete.setHint(charSequence2);
    }

    public final void v() {
        this.f1406s.setVisibility(((this.f1390P || this.f1394U) && !this.f1388N && (this.f1408u.getVisibility() == 0 || this.f1410w.getVisibility() == 0)) ? 0 : 8);
    }

    public final void w(boolean z2) {
        boolean z3 = this.f1390P;
        this.f1408u.setVisibility((!z3 || !(z3 || this.f1394U) || this.f1388N || !hasFocus() || (!z2 && this.f1394U)) ? 8 : 0);
    }

    public final void x(boolean z2) {
        this.f1388N = z2;
        int i2 = 8;
        int i3 = z2 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f1403p.getText());
        this.f1407t.setVisibility(i3);
        w(!zIsEmpty);
        this.f1404q.setVisibility(z2 ? 8 : 0);
        ImageView imageView = this.f1378D;
        imageView.setVisibility((imageView.getDrawable() == null || this.f1387M) ? 8 : 0);
        s();
        if (this.f1394U && !this.f1388N && zIsEmpty) {
            this.f1408u.setVisibility(8);
            i2 = 0;
        }
        this.f1410w.setVisibility(i2);
        v();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1413z = new Rect();
        this.f1375A = new Rect();
        this.f1376B = new int[2];
        this.f1377C = new int[2];
        this.f1400d0 = new V0(this, 0);
        this.f1401e0 = new V0(this, 1);
        this.f1402f0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        Y0 y1 = new Y0(this);
        int i3 = 1;
        N n2 = new N(i3, this);
        C0 c2 = new C0(i3, this);
        U0 u1 = new U0(this);
        int[] iArr = p007e.a.f2245u;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        h hVar = new h(context, typedArrayObtainStyledAttributes);
        X.g(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i2);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f1403p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1404q = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.f1405r = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f1406s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f1407t = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f1408u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f1409v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f1410w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f1378D = imageView5;
        G.q(viewFindViewById, hVar.l(10));
        G.q(viewFindViewById2, hVar.l(14));
        imageView.setImageDrawable(hVar.l(13));
        imageView2.setImageDrawable(hVar.l(7));
        imageView3.setImageDrawable(hVar.l(4));
        imageView4.setImageDrawable(hVar.l(16));
        imageView5.setImageDrawable(hVar.l(13));
        this.f1379E = hVar.l(12);
        f1.d.z(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f1380F = typedArrayObtainStyledAttributes.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.f1381G = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(u1);
        searchAutoComplete.setOnEditorActionListener(y1);
        searchAutoComplete.setOnItemClickListener(n2);
        searchAutoComplete.setOnItemSelectedListener(c2);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new W0(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(8, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f1384J = typedArrayObtainStyledAttributes.getText(6);
        this.f1391Q = typedArrayObtainStyledAttributes.getText(11);
        int i4 = typedArrayObtainStyledAttributes.getInt(3, -1);
        if (i4 != -1) {
            setImeOptions(i4);
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(2, -1);
        if (i5 != -1) {
            setInputType(i5);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(0, true));
        hVar.r();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1382H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1383I = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1411x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new X0(this));
        }
        x(this.f1387M);
        u();
    }

    public void setOnCloseListener(Z0 z1) {
    }

    public void setOnQueryTextListener(a1 a1Var) {
    }

    public void setOnSuggestionListener(b1 b1Var) {
    }
}
