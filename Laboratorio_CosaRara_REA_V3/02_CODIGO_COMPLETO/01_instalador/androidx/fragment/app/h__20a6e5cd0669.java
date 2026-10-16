// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.EnumC0076n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends androidx.activity.i {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final j mFragments;
    boolean mResumed;
    final androidx.lifecycle.w mFragmentLifecycleRegistry = new androidx.lifecycle.w(this);
    boolean mStopped = true;

    public h() {
        AbstractActivityC0121k abstractActivityC0121k = (AbstractActivityC0121k) this;
        this.mFragments = new j(new g(abstractActivityC0121k));
        getSavedStateRegistry().c(FRAGMENTS_TAG, new e(abstractActivityC0121k));
        addOnContextAvailableListener(new f(abstractActivityC0121k));
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f1556a.f1550c.f1574e.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            C.h hVar = new C.h(getViewModelStore(), N.b.f380e);
            String canonicalName = N.b.class.getCanonicalName();
            if (canonicalName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            p021m.j jVar = ((N.b) hVar.j("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), N.b.class)).f381d;
            if (jVar.f3692c > 0) {
                printWriter.print(str2);
                printWriter.println("Loaders:");
                if (jVar.f3692c > 0) {
                    if (jVar.f3691b[0] != null) {
                        throw new ClassCastException();
                    }
                    printWriter.print(str2);
                    printWriter.print("  #");
                    printWriter.print(jVar.f3690a[0]);
                    printWriter.print(": ");
                    throw null;
                }
            }
        }
        s sVar = this.mFragments.f1556a.f1550c;
        sVar.getClass();
        String str3 = str + "    ";
        H.s sVar2 = sVar.f1572c;
        sVar2.getClass();
        HashMap map = (HashMap) sVar2.f233c;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                printWriter.print(str);
                printWriter.println("null");
            }
        }
        ArrayList arrayList = (ArrayList) sVar2.f232b;
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            if (size2 > 0) {
                if (arrayList.get(0) != null) {
                    throw new ClassCastException();
                }
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(0);
                printWriter.print(": ");
                throw null;
            }
        }
        ArrayList arrayList2 = sVar.f1573d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) sVar.f1573d.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.b(str3, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + sVar.f1576h.get());
        synchronized (sVar.f1570a) {
            try {
                int size3 = sVar.f1570a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i3 = 0; i3 < size3; i3++) {
                        a aVar2 = (a) sVar.f1570a.get(i3);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i3);
                        printWriter.print(": ");
                        printWriter.println(aVar2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(sVar.f1580l);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(sVar.f1581m);
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(sVar.f1579k);
        printWriter.print(" mStateSaved=");
        printWriter.print(sVar.f1587s);
        printWriter.print(" mStopped=");
        printWriter.print(sVar.f1588t);
        printWriter.print(" mDestroyed=");
        printWriter.println(sVar.f1589u);
    }

    public r getSupportFragmentManager() {
        return this.mFragments.f1556a.f1550c;
    }

    @Deprecated
    public N.a getSupportLoaderManager() {
        return new N.c(this, getViewModelStore());
    }

    public void markFragmentsCreated() {
        Iterator it = getSupportFragmentManager().f1572c.w().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.activity.i, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(d dVar) {
    }

    @Override // androidx.activity.i, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.a();
        super.onConfigurationChanged(configuration);
        Iterator it = this.mFragments.f1556a.f1550c.f1572c.w().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.activity.i, p029q.h, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.f(EnumC0076n.ON_CREATE);
        s sVar = this.mFragments.f1556a.f1550c;
        sVar.f1587s = false;
        sVar.f1588t = false;
        sVar.f1593y.getClass();
        sVar.c(1);
    }

    @Override // androidx.activity.i, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            super.onCreatePanelMenu(i2, menu);
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        j jVar = this.mFragments;
        getMenuInflater();
        s sVar = jVar.f1556a.f1550c;
        if (sVar.f1579k >= 1) {
            Iterator it = sVar.f1572c.w().iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
            }
        }
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s sVar = this.mFragments.f1556a.f1550c;
        sVar.f1589u = true;
        sVar.e(true);
        Iterator it = sVar.b().iterator();
        if (it.hasNext()) {
            ((c) it.next()).a();
            throw null;
        }
        sVar.c(-1);
        sVar.f1580l = null;
        sVar.f1581m = null;
        if (sVar.f1575f != null) {
            Iterator it2 = sVar.g.f1561b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.a) it2.next()).cancel();
            }
            sVar.f1575f = null;
        }
        p002b.f fVar = sVar.f1583o;
        if (fVar != null) {
            fVar.f2085b.d(fVar.f2084a);
            p002b.f fVar2 = sVar.f1584p;
            fVar2.f2085b.d(fVar2.f2084a);
            p002b.f fVar3 = sVar.f1585q;
            fVar3.f2085b.d(fVar3.f2084a);
        }
        this.mFragmentLifecycleRegistry.f(EnumC0076n.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        Iterator it = this.mFragments.f1556a.f1550c.f1572c.w().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.activity.i, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            s sVar = this.mFragments.f1556a.f1550c;
            if (sVar.f1579k >= 1) {
                Iterator it = sVar.f1572c.w().iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                }
            }
            return false;
        }
        if (i2 != 6) {
            return false;
        }
        s sVar2 = this.mFragments.f1556a.f1550c;
        if (sVar2.f1579k >= 1) {
            Iterator it2 = sVar2.f1572c.w().iterator();
            while (it2.hasNext()) {
                if (it2.next() != null) {
                    throw new ClassCastException();
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        Iterator it = this.mFragments.f1556a.f1550c.f1572c.w().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.activity.i, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.mFragments.a();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.i, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            s sVar = this.mFragments.f1556a.f1550c;
            if (sVar.f1579k >= 1) {
                Iterator it = sVar.f1572c.w().iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                }
            }
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f1556a.f1550c.c(5);
        this.mFragmentLifecycleRegistry.f(EnumC0076n.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2) {
        Iterator it = this.mFragments.f1556a.f1550c.f1572c.w().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        super.onPreparePanel(0, view, menu);
        return true;
    }

    @Override // androidx.activity.i, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            super.onPreparePanel(i2, view, menu);
            return true;
        }
        boolean zOnPrepareOptionsPanel = onPrepareOptionsPanel(view, menu);
        s sVar = this.mFragments.f1556a.f1550c;
        if (sVar.f1579k >= 1) {
            Iterator it = sVar.f1572c.w().iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
            }
        }
        return zOnPrepareOptionsPanel;
    }

    @Override // androidx.activity.i, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f1556a.f1550c.e(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(EnumC0076n.ON_RESUME);
        s sVar = this.mFragments.f1556a.f1550c;
        sVar.f1587s = false;
        sVar.f1588t = false;
        sVar.f1593y.getClass();
        sVar.c(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            s sVar = this.mFragments.f1556a.f1550c;
            sVar.f1587s = false;
            sVar.f1588t = false;
            sVar.f1593y.getClass();
            sVar.c(4);
        }
        this.mFragments.f1556a.f1550c.e(true);
        this.mFragmentLifecycleRegistry.f(EnumC0076n.ON_START);
        s sVar2 = this.mFragments.f1556a.f1550c;
        sVar2.f1587s = false;
        sVar2.f1588t = false;
        sVar2.f1593y.getClass();
        sVar2.c(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        s sVar = this.mFragments.f1556a.f1550c;
        sVar.f1588t = true;
        sVar.f1593y.getClass();
        sVar.c(4);
        this.mFragmentLifecycleRegistry.f(EnumC0076n.ON_STOP);
    }

    public void setEnterSharedElementCallback(p029q.m mVar) {
        p029q.b.c(this, null);
    }

    public void setExitSharedElementCallback(p029q.m mVar) {
        p029q.b.d(this, null);
    }

    public void startActivityFromFragment(d dVar, Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            throw null;
        }
        p029q.a.b(this, intent, -1, bundle);
    }

    @Deprecated
    public void startIntentSenderFromFragment(d dVar, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 != -1) {
            throw null;
        }
        p029q.a.c(this, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void supportFinishAfterTransition() {
        p029q.b.a(this);
    }

    public void supportPostponeEnterTransition() {
        p029q.b.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        p029q.b.e(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(d dVar, Intent intent, int i2) {
        startActivityFromFragment(dVar, intent, i2, (Bundle) null);
    }
}
