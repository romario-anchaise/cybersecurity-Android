// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.Z;
import A.a0;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p031r.c;

/* JADX INFO: loaded from: classes.dex */
public class n implements Menu {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f2930y = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f2932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f2935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f2936f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f2938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f2939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2940k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f2942m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f2943n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f2944o;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p f2951v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2953x;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2941l = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2945p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2946q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2947r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2948s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f2949t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f2950u = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2952w = false;

    public n(Context context) {
        boolean zB;
        boolean z2 = false;
        this.f2931a = context;
        Resources resources = context.getResources();
        this.f2932b = resources;
        this.f2936f = new ArrayList();
        this.g = new ArrayList();
        this.f2937h = true;
        this.f2938i = new ArrayList();
        this.f2939j = new ArrayList();
        this.f2940k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = a0.f20a;
            if (Build.VERSION.SDK_INT >= 28) {
                zB = Z.b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zB = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zB) {
                z2 = true;
            }
        }
        this.f2934d = z2;
    }

    public final p a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = ((-65536) & i4) >> 16;
        if (i6 < 0 || i6 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i7 = (f2930y[i6] << 16) | (65535 & i4);
        p pVar = new p(this, i2, i3, i4, i7, charSequence, this.f2941l);
        ArrayList arrayList = this.f2936f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((p) arrayList.get(size)).f2963d <= i7) {
                i5 = size + 1;
                arrayList.add(i5, pVar);
                p(true);
                return pVar;
            }
        }
        i5 = 0;
        arrayList.add(i5, pVar);
        p(true);
        return pVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f2931a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            p pVarA = a(i2, i3, i4, resolveInfo.loadLabel(packageManager));
            pVarA.setIcon(resolveInfo.loadIcon(packageManager));
            pVarA.g = intent2;
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = pVarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(A a2, Context context) {
        this.f2950u.add(new WeakReference(a2));
        a2.g(context, this);
        this.f2940k = true;
    }

    public final void c(boolean z2) {
        if (this.f2948s) {
            return;
        }
        this.f2948s = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f2950u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            A a2 = (A) weakReference.get();
            if (a2 == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                a2.a(this, z2);
            }
        }
        this.f2948s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        p pVar = this.f2951v;
        if (pVar != null) {
            d(pVar);
        }
        this.f2936f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f2943n = null;
        this.f2942m = null;
        this.f2944o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(p pVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f2950u;
        boolean zD = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f2951v == pVar) {
            w();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                A a2 = (A) weakReference.get();
                if (a2 != null) {
                    zD = a2.d(pVar);
                    if (zD) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            v();
            if (zD) {
                this.f2951v = null;
            }
        }
        return zD;
    }

    public boolean e(n nVar, MenuItem menuItem) {
        l lVar = this.f2935e;
        return lVar != null && lVar.m(nVar, menuItem);
    }

    public boolean f(p pVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f2950u;
        boolean zJ = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            A a2 = (A) weakReference.get();
            if (a2 != null) {
                zJ = a2.j(pVar);
                if (zJ) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        v();
        if (zJ) {
            this.f2951v = pVar;
        }
        return zJ;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i2) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) arrayList.get(i3);
            if (pVar.f2960a == i2) {
                return pVar;
            }
            if (pVar.hasSubMenu() && (menuItemFindItem = pVar.f2973o.findItem(i2)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final p g(int i2, KeyEvent keyEvent) {
        ArrayList arrayList = this.f2949t;
        arrayList.clear();
        h(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (p) arrayList.get(0);
        }
        boolean zN = n();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) arrayList.get(i3);
            char c2 = zN ? pVar.f2968j : pVar.f2966h;
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (zN && c2 == '\b' && i2 == 67))) {
                return pVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i2) {
        return (MenuItem) this.f2936f.get(i2);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0069  */
    public final void h(ArrayList arrayList, int i2, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            ArrayList arrayList2 = this.f2936f;
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = (p) arrayList2.get(i3);
                if (pVar.hasSubMenu()) {
                    pVar.f2973o.h(arrayList, i2, keyEvent);
                }
                char c2 = zN ? pVar.f2968j : pVar.f2966h;
                if ((modifiers & 69647) == ((zN ? pVar.f2969k : pVar.f2967i) & 69647) && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if (c2 != cArr[0] && c2 != cArr[2]) {
                        if (zN && c2 == '\b') {
                            if (i2 == 67) {
                            }
                        }
                    }
                    if (pVar.isEnabled()) {
                        arrayList.add(pVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f2953x) {
            return true;
        }
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((p) arrayList.get(i2)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f2940k) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f2950u;
            boolean zF = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                A a2 = (A) weakReference.get();
                if (a2 == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zF |= a2.f();
                }
            }
            ArrayList arrayList = this.f2938i;
            ArrayList arrayList2 = this.f2939j;
            if (zF) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i2 = 0; i2 < size; i2++) {
                    p pVar = (p) arrayListL.get(i2);
                    if (pVar.f()) {
                        arrayList.add(pVar);
                    } else {
                        arrayList2.add(pVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f2940k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return g(i2, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z2 = this.f2937h;
        ArrayList arrayList = this.g;
        if (!z2) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f2936f;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = (p) arrayList2.get(i2);
            if (pVar.isVisible()) {
                arrayList.add(pVar);
            }
        }
        this.f2937h = false;
        this.f2940k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f2952w;
    }

    public boolean n() {
        return this.f2933c;
    }

    public boolean o() {
        return this.f2934d;
    }

    public final void p(boolean z2) {
        if (this.f2945p) {
            this.f2946q = true;
            if (z2) {
                this.f2947r = true;
                return;
            }
            return;
        }
        if (z2) {
            this.f2937h = true;
            this.f2940k = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f2950u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            A a2 = (A) weakReference.get();
            if (a2 == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                a2.c();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i2, int i3) {
        return q(findItem(i2), null, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        p pVarG = g(i2, keyEvent);
        boolean zQ = pVarG != null ? q(pVarG, null, i3) : false;
        if ((i3 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    /* JADX WARN: Code duplicated, block: B:32:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x005f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064  */
    /* JADX WARN: Code duplicated, block: B:45:0x0075  */
    /* JADX WARN: Code duplicated, block: B:47:0x0079  */
    /* JADX WARN: Code duplicated, block: B:50:0x0082  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00b1 A[SYNTHETIC] */
    public final boolean q(MenuItem menuItem, A a2, int i2) {
        q qVar;
        boolean zExpandActionView;
        q qVar2;
        boolean z2;
        G g;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList;
        A a3;
        p pVar = (p) menuItem;
        boolean zK = false;
        if (pVar == null || !pVar.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = pVar.f2974p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(pVar)) {
            n nVar = pVar.f2972n;
            if (nVar.e(nVar, pVar)) {
                zExpandActionView = true;
            } else {
                Intent intent = pVar.g;
                if (intent != null) {
                    try {
                        nVar.f2931a.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
                        qVar = pVar.f2957A;
                        if (qVar == null) {
                        }
                        zExpandActionView = false;
                        qVar2 = pVar.f2957A;
                        if (qVar2 == null) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (pVar.e()) {
                            zExpandActionView |= pVar.expandActionView();
                            if (zExpandActionView) {
                                c(true);
                            }
                        } else if (pVar.hasSubMenu()) {
                            if ((i2 & 4) == 0) {
                                c(false);
                            }
                            if (!pVar.hasSubMenu()) {
                                G g2 = new G(this.f2931a, this, pVar);
                                pVar.f2973o = g2;
                                g2.setHeaderTitle(pVar.f2964e);
                            }
                            g = pVar.f2973o;
                            if (z2) {
                                qVar2.f2986b.getClass();
                                qVar2.f2985a.onPrepareSubMenu(g);
                            }
                            copyOnWriteArrayList = this.f2950u;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                if (a2 != null) {
                                }
                                for (WeakReference weakReference : copyOnWriteArrayList) {
                                    a3 = (A) weakReference.get();
                                    if (a3 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zK) {
                                        zK = a3.k(g);
                                    }
                                }
                            }
                            zExpandActionView |= zK;
                            if (!zExpandActionView) {
                                c(true);
                            }
                        } else {
                            if ((i2 & 4) == 0) {
                                c(false);
                            }
                            if (!pVar.hasSubMenu()) {
                                G g3 = new G(this.f2931a, this, pVar);
                                pVar.f2973o = g3;
                                g3.setHeaderTitle(pVar.f2964e);
                            }
                            g = pVar.f2973o;
                            if (z2) {
                                qVar2.f2986b.getClass();
                                qVar2.f2985a.onPrepareSubMenu(g);
                            }
                            copyOnWriteArrayList = this.f2950u;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                zK = a2 != null ? a2.k(g) : false;
                                while (r8.hasNext()) {
                                    a3 = (A) weakReference.get();
                                    if (a3 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zK) {
                                        zK = a3.k(g);
                                    }
                                }
                            }
                            zExpandActionView |= zK;
                            if (!zExpandActionView) {
                                c(true);
                            }
                        }
                        return zExpandActionView;
                    }
                    zExpandActionView = true;
                } else {
                    qVar = pVar.f2957A;
                    if (qVar == null && qVar.f2985a.onPerformDefaultAction()) {
                        zExpandActionView = true;
                    } else {
                        zExpandActionView = false;
                    }
                }
            }
        } else {
            zExpandActionView = true;
        }
        qVar2 = pVar.f2957A;
        if (qVar2 == null && qVar2.f2985a.hasSubMenu()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (pVar.e()) {
            zExpandActionView |= pVar.expandActionView();
            if (zExpandActionView) {
                c(true);
            }
        } else if (pVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                c(false);
            }
            if (!pVar.hasSubMenu()) {
                G g4 = new G(this.f2931a, this, pVar);
                pVar.f2973o = g4;
                g4.setHeaderTitle(pVar.f2964e);
            }
            g = pVar.f2973o;
            if (z2) {
                qVar2.f2986b.getClass();
                qVar2.f2985a.onPrepareSubMenu(g);
            }
            copyOnWriteArrayList = this.f2950u;
            if (!copyOnWriteArrayList.isEmpty()) {
                if (a2 != null) {
                }
                while (r8.hasNext()) {
                    a3 = (A) weakReference.get();
                    if (a3 == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!zK) {
                        zK = a3.k(g);
                    }
                }
            }
            zExpandActionView |= zK;
            if (!zExpandActionView) {
                c(true);
            }
        } else if ((i2 & 1) == 0) {
            c(true);
        }
        return zExpandActionView;
    }

    public final void r(A a2) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f2950u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            A a3 = (A) weakReference.get();
            if (a3 == null || a3 == a2) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i2) {
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            } else if (((p) arrayList.get(i4)).f2961b == i2) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int size2 = arrayList.size() - i4;
            while (true) {
                int i5 = i3 + 1;
                if (i3 >= size2 || ((p) arrayList.get(i4)).f2961b != i2) {
                    break;
                }
                if (i4 >= 0) {
                    ArrayList arrayList2 = this.f2936f;
                    if (i4 < arrayList2.size()) {
                        arrayList2.remove(i4);
                    }
                }
                i3 = i5;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i2) {
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((p) arrayList.get(i3)).f2960a == i2) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            ArrayList arrayList2 = this.f2936f;
            if (i3 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i3);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f2936f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((G) item.getSubMenu()).s(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i2, boolean z2, boolean z3) {
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) arrayList.get(i3);
            if (pVar.f2961b == i2) {
                pVar.f2982x = (pVar.f2982x & (-5)) | (z3 ? 4 : 0);
                pVar.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f2952w = z2;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i2, boolean z2) {
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) arrayList.get(i3);
            if (pVar.f2961b == i2) {
                pVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i2, boolean z2) {
        ArrayList arrayList = this.f2936f;
        int size = arrayList.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) arrayList.get(i3);
            if (pVar.f2961b == i2) {
                int i4 = pVar.f2982x;
                int i5 = (i4 & (-9)) | (z2 ? 0 : 8);
                pVar.f2982x = i5;
                if (i4 != i5) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f2933c = z2;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f2936f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f2936f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((G) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        if (view != null) {
            this.f2944o = view;
            this.f2942m = null;
            this.f2943n = null;
        } else {
            if (i2 > 0) {
                this.f2942m = this.f2932b.getText(i2);
            } else if (charSequence != null) {
                this.f2942m = charSequence;
            }
            if (i3 > 0) {
                this.f2943n = c.b(this.f2931a, i3);
            } else if (drawable != null) {
                this.f2943n = drawable;
            }
            this.f2944o = null;
        }
        p(false);
    }

    public final void v() {
        this.f2945p = false;
        if (this.f2946q) {
            this.f2946q = false;
            p(this.f2947r);
        }
    }

    public final void w() {
        if (this.f2945p) {
            return;
        }
        this.f2945p = true;
        this.f2946q = false;
        this.f2947r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2) {
        return a(0, 0, 0, this.f2932b.getString(i2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f2932b.getString(i2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        p pVarA = a(i2, i3, i4, charSequence);
        G g = new G(this.f2931a, this, pVarA);
        pVarA.f2973o = g;
        g.setHeaderTitle(pVarA.f2964e);
        return g;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f2932b.getString(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f2932b.getString(i5));
    }

    public n k() {
        return this;
    }
}
