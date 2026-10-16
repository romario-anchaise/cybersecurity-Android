// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import A.C0016p;
import A.C0017q;
import A.InterfaceC0019t;
import A.r;
import H.t;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.C;
import androidx.lifecycle.C0074l;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.EnumC0077o;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0072j;
import androidx.lifecycle.InterfaceC0080s;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.J;
import androidx.lifecycle.L;
import androidx.lifecycle.O;
import androidx.lifecycle.Q;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.w;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends p029q.h implements U, InterfaceC0072j, Q.g {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final p002b.i mActivityResultRegistry;
    private int mContentLayoutId;
    private Q mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final r mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final o mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<p045z.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<p045z.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<p045z.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<p045z.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<p045z.a> mOnTrimMemoryListeners;
    final Q.f mSavedStateRegistryController;
    private T mViewModelStore;
    final p000a.a mContextAwareHelper = new p000a.a();
    private final w mLifecycleRegistry = new w(this);

    public i() {
        final androidx.fragment.app.h hVar = (androidx.fragment.app.h) this;
        this.mMenuHostHelper = new r(new t(3, hVar));
        Q.f fVar = new Q.f(this);
        this.mSavedStateRegistryController = fVar;
        this.mOnBackPressedDispatcher = new o(new d(hVar));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new e();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new f(hVar, 1));
        getLifecycle().a(new f(hVar, 0));
        getLifecycle().a(new f(hVar, 2));
        fVar.a();
        EnumC0077o enumC0077oB = getLifecycle().b();
        if (enumC0077oB != EnumC0077o.f1682b && enumC0077oB != EnumC0077o.f1683c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (getSavedStateRegistry().b() == null) {
            J j2 = new J(getSavedStateRegistry(), this);
            getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", j2);
            getLifecycle().a(new Q.b(2, j2));
        }
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new b(0, hVar));
        addOnContextAvailableListener(new p000a.b() { // from class: androidx.activity.c
            @Override // p000a.b
            public final void a(i iVar) {
                i.a(hVar);
            }
        });
    }

    public static void a(androidx.fragment.app.h hVar) {
        Bundle bundleA = hVar.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            p002b.i iVar = ((i) hVar).mActivityResultRegistry;
            iVar.getClass();
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            iVar.f2094e = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            iVar.f2090a = (Random) bundleA.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = iVar.f2096h;
            bundle2.putAll(bundle);
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                String str = stringArrayList.get(i2);
                HashMap map = iVar.f2092c;
                boolean zContainsKey = map.containsKey(str);
                HashMap map2 = iVar.f2091b;
                if (zContainsKey) {
                    Integer num = (Integer) map.remove(str);
                    if (!bundle2.containsKey(str)) {
                        map2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i2);
                num2.intValue();
                String str2 = stringArrayList.get(i2);
                map2.put(num2, str2);
                map.put(str2, num2);
            }
        }
    }

    public static Bundle b(androidx.fragment.app.h hVar) {
        Bundle bundle = new Bundle();
        p002b.i iVar = ((i) hVar).mActivityResultRegistry;
        iVar.getClass();
        HashMap map = iVar.f2092c;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(iVar.f2094e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) iVar.f2096h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", iVar.f2090a);
        return bundle;
    }

    public void addMenuProvider(InterfaceC0019t interfaceC0019t) {
        r rVar = this.mMenuHostHelper;
        rVar.f65b.add(null);
        rVar.f64a.run();
    }

    public final void addOnConfigurationChangedListener(p045z.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(p000a.b bVar) {
        p000a.a aVar = this.mContextAwareHelper;
        if (aVar.f1157b != null) {
            bVar.a(aVar.f1157b);
        }
        aVar.f1156a.add(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(p045z.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(p045z.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(p045z.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(p045z.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            h hVar = (h) getLastNonConfigurationInstance();
            if (hVar != null) {
                this.mViewModelStore = hVar.f1250b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new T();
            }
        }
    }

    public final p002b.i getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0072j
    public M.b getDefaultViewModelCreationExtras() {
        M.c cVar = new M.c(M.a.f358b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = cVar.f359a;
        if (application != null) {
            linkedHashMap.put(O.f1663a, getApplication());
        }
        linkedHashMap.put(I.f1645a, this);
        linkedHashMap.put(I.f1646b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(I.f1647c, getIntent().getExtras());
        }
        return cVar;
    }

    public Q getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new L(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        h hVar = (h) getLastNonConfigurationInstance();
        if (hVar != null) {
            return hVar.f1249a;
        }
        return null;
    }

    @Override // androidx.lifecycle.InterfaceC0082u
    public AbstractC0078p getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final o getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // Q.g
    public final Q.e getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f527b;
    }

    @Override // androidx.lifecycle.U
    public T getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.mActivityResultRegistry.a(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<p045z.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(configuration);
        }
    }

    @Override // p029q.h, android.app.Activity
    public void onCreate(Bundle bundle) {
        Q.f fVar = this.mSavedStateRegistryController;
        if (!fVar.f528c) {
            fVar.a();
        }
        AbstractC0078p lifecycle = fVar.f526a.getLifecycle();
        if (lifecycle.b().compareTo(EnumC0077o.f1684d) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
        }
        Q.e eVar = fVar.f527b;
        if (!eVar.f521b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (eVar.f523d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        eVar.f522c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        eVar.f523d = true;
        p000a.a aVar = this.mContextAwareHelper;
        aVar.f1157b = this;
        Iterator it = aVar.f1156a.iterator();
        while (it.hasNext()) {
            ((p000a.b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i2 = E.f1634b;
        C.b(this);
        if (p039w.b.a()) {
            o oVar = this.mOnBackPressedDispatcher;
            oVar.f1264e = g.a(this);
            oVar.b();
        }
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        r rVar = this.mMenuHostHelper;
        getMenuInflater();
        Iterator it = rVar.f65b.iterator();
        if (!it.hasNext()) {
            return true;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 != 0) {
            return false;
        }
        Iterator it = this.mMenuHostHelper.f65b.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z2, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<p045z.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(new p022m0.e());
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<p045z.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Iterator it = this.mMenuHostHelper.f65b.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z2, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<p045z.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(new p022m0.e());
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        Iterator it = this.mMenuHostHelper.f65b.iterator();
        if (!it.hasNext()) {
            return true;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        h hVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        T t2 = this.mViewModelStore;
        if (t2 == null && (hVar = (h) getLastNonConfigurationInstance()) != null) {
            t2 = hVar.f1250b;
        }
        if (t2 == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        h hVar2 = new h();
        hVar2.f1249a = objOnRetainCustomNonConfigurationInstance;
        hVar2.f1250b = t2;
        return hVar2;
    }

    @Override // p029q.h, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC0078p lifecycle = getLifecycle();
        if (lifecycle instanceof w) {
            w wVar = (w) lifecycle;
            EnumC0077o enumC0077o = EnumC0077o.f1683c;
            wVar.e("setCurrentState");
            wVar.g(enumC0077o);
        }
        super.onSaveInstanceState(bundle);
        Q.f fVar = this.mSavedStateRegistryController;
        fVar.getClass();
        F0.i.e(bundle, "outBundle");
        Q.e eVar = fVar.f527b;
        eVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = eVar.f522c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        p019l.f fVar2 = eVar.f520a;
        fVar2.getClass();
        p019l.d dVar = new p019l.d(fVar2);
        fVar2.f3532c.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((Q.d) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator<p045z.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().a(Integer.valueOf(i2));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f1157b;
    }

    public final <I, O> p002b.c registerForActivityResult(p004c.a aVar, p002b.i iVar, p002b.b bVar) {
        String str = "activity_rq#" + this.mNextLocalRequestCode.getAndIncrement();
        iVar.getClass();
        AbstractC0078p lifecycle = getLifecycle();
        if (lifecycle.b().compareTo(EnumC0077o.f1684d) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + this + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        iVar.c(str);
        HashMap map = iVar.f2093d;
        p002b.h hVar = (p002b.h) map.get(str);
        if (hVar == null) {
            hVar = new p002b.h(lifecycle);
        }
        p002b.d dVar = new p002b.d(iVar, str, bVar, aVar);
        hVar.f2088a.a(dVar);
        hVar.f2089b.add(dVar);
        map.put(str, hVar);
        return new p002b.e();
    }

    public void removeMenuProvider(InterfaceC0019t interfaceC0019t) {
        this.mMenuHostHelper.a();
    }

    public final void removeOnConfigurationChangedListener(p045z.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(p000a.b bVar) {
        this.mContextAwareHelper.f1156a.remove(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(p045z.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(p045z.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(p045z.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(p045z.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (f1.l.E()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i2);

    @Override // android.app.Activity
    public void setContentView(View view) {
        View decorView = getWindow().getDecorView();
        F0.i.e(decorView, "<this>");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        F0.i.e(decorView2, "<this>");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        F0.i.e(decorView3, "<this>");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        F0.i.e(decorView4, "<this>");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void addMenuProvider(InterfaceC0019t interfaceC0019t, InterfaceC0082u interfaceC0082u) {
        r rVar = this.mMenuHostHelper;
        rVar.f65b.add(null);
        rVar.f64a.run();
        AbstractC0078p lifecycle = interfaceC0082u.getLifecycle();
        HashMap map = rVar.f66c;
        C0017q c0017q = (C0017q) map.remove(interfaceC0019t);
        if (c0017q != null) {
            c0017q.f62a.c(c0017q.f63b);
            c0017q.f63b = null;
        }
        map.put(interfaceC0019t, new C0017q(lifecycle, new C0016p(0, rVar)));
    }

    public void addMenuProvider(InterfaceC0019t interfaceC0019t, InterfaceC0082u interfaceC0082u, final EnumC0077o enumC0077o) {
        final r rVar = this.mMenuHostHelper;
        rVar.getClass();
        AbstractC0078p lifecycle = interfaceC0082u.getLifecycle();
        HashMap map = rVar.f66c;
        C0017q c0017q = (C0017q) map.remove(interfaceC0019t);
        if (c0017q != null) {
            c0017q.f62a.c(c0017q.f63b);
            c0017q.f63b = null;
        }
        map.put(interfaceC0019t, new C0017q(lifecycle, new InterfaceC0080s() { // from class: A.o
            @Override // androidx.lifecycle.InterfaceC0080s
            public final void g(InterfaceC0082u interfaceC0082u2, EnumC0076n enumC0076n) {
                EnumC0076n enumC0076n2;
                r rVar2 = rVar;
                rVar2.getClass();
                EnumC0076n.Companion.getClass();
                EnumC0077o enumC0077o2 = enumC0077o;
                F0.i.e(enumC0077o2, "state");
                int iOrdinal = enumC0077o2.ordinal();
                if (iOrdinal == 2) {
                    enumC0076n2 = EnumC0076n.ON_CREATE;
                } else if (iOrdinal != 3) {
                    enumC0076n2 = iOrdinal != 4 ? null : EnumC0076n.ON_RESUME;
                } else {
                    enumC0076n2 = EnumC0076n.ON_START;
                }
                Runnable runnable = rVar2.f64a;
                CopyOnWriteArrayList copyOnWriteArrayList = rVar2.f65b;
                if (enumC0076n == enumC0076n2) {
                    copyOnWriteArrayList.add(null);
                    runnable.run();
                } else if (enumC0076n == EnumC0076n.ON_DESTROY) {
                    rVar2.a();
                } else if (enumC0076n == C0074l.a(enumC0077o2)) {
                    copyOnWriteArrayList.remove((Object) null);
                    runnable.run();
                }
            }
        }));
    }

    public final <I, O> p002b.c registerForActivityResult(p004c.a aVar, p002b.b bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }
}
