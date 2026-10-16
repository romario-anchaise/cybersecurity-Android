// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.C0005e;
import A.H;
import A.X;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p015j.A;
import p015j.C0178w0;
import p015j.K0;
import p015j.L0;
import p015j.O0;

/* JADX INFO: loaded from: classes.dex */
public final class h extends v implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f2896f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f2903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f2904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2906q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2907r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2908s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2909t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2911v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public z f2912w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewTreeObserver f2913x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public w f2914y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2915z;
    public final ArrayList g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f2897h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0130d f2898i = new ViewTreeObserverOnGlobalLayoutListenerC0130d(0, this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0131e f2899j = new ViewOnAttachStateChangeListenerC0131e(this, 0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0005e f2900k = new C0005e(17, this);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2901l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2902m = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2910u = false;

    public h(Context context, View view, int i2, boolean z2) {
        this.f2892b = context;
        this.f2903n = view;
        this.f2894d = i2;
        this.f2895e = z2;
        WeakHashMap weakHashMap = X.f14a;
        this.f2905p = H.d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f2893c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2896f = new Handler();
    }

    @Override // p013i.A
    public final void a(n nVar, boolean z2) {
        ArrayList arrayList = this.f2897h;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (nVar == ((C0133g) arrayList.get(i2)).f2890b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 < arrayList.size()) {
            ((C0133g) arrayList.get(i3)).f2890b.c(false);
        }
        C0133g c0133g = (C0133g) arrayList.remove(i2);
        c0133g.f2890b.r(this);
        boolean z3 = this.f2915z;
        O0 o2 = c0133g.f2889a;
        if (z3) {
            K0.b(o2.f3078y, null);
            o2.f3078y.setAnimationStyle(0);
        }
        o2.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f2905p = ((C0133g) arrayList.get(size2 - 1)).f2891c;
        } else {
            View view = this.f2903n;
            WeakHashMap weakHashMap = X.f14a;
            this.f2905p = H.d(view) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z2) {
                ((C0133g) arrayList.get(0)).f2890b.c(false);
                return;
            }
            return;
        }
        dismiss();
        z zVar = this.f2912w;
        if (zVar != null) {
            zVar.a(nVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f2913x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f2913x.removeGlobalOnLayoutListener(this.f2898i);
            }
            this.f2913x = null;
        }
        this.f2904o.removeOnAttachStateChangeListener(this.f2899j);
        this.f2914y.onDismiss();
    }

    @Override // p013i.E
    public final boolean b() {
        ArrayList arrayList = this.f2897h;
        return arrayList.size() > 0 && ((C0133g) arrayList.get(0)).f2889a.f3078y.isShowing();
    }

    @Override // p013i.A
    public final void c() {
        Iterator it = this.f2897h.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C0133g) it.next()).f2889a.f3057c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((k) adapter).notifyDataSetChanged();
        }
    }

    @Override // p013i.E
    public final void dismiss() {
        ArrayList arrayList = this.f2897h;
        int size = arrayList.size();
        if (size > 0) {
            C0133g[] c0133gArr = (C0133g[]) arrayList.toArray(new C0133g[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0133g c0133g = c0133gArr[i2];
                if (c0133g.f2889a.f3078y.isShowing()) {
                    c0133g.f2889a.dismiss();
                }
            }
        }
    }

    @Override // p013i.E
    public final C0178w0 e() {
        ArrayList arrayList = this.f2897h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C0133g) arrayList.get(arrayList.size() - 1)).f2889a.f3057c;
    }

    @Override // p013i.A
    public final boolean f() {
        return false;
    }

    @Override // p013i.A
    public final void h(z zVar) {
        this.f2912w = zVar;
    }

    @Override // p013i.E
    public final void i() {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v((n) it.next());
        }
        arrayList.clear();
        View view = this.f2903n;
        this.f2904o = view;
        if (view != null) {
            boolean z2 = this.f2913x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f2913x = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f2898i);
            }
            this.f2904o.addOnAttachStateChangeListener(this.f2899j);
        }
    }

    @Override // p013i.A
    public final boolean k(G g) {
        for (C0133g c0133g : this.f2897h) {
            if (g == c0133g.f2890b) {
                c0133g.f2889a.f3057c.requestFocus();
                return true;
            }
        }
        if (!g.hasVisibleItems()) {
            return false;
        }
        l(g);
        z zVar = this.f2912w;
        if (zVar != null) {
            zVar.j(g);
        }
        return true;
    }

    @Override // p013i.v
    public final void l(n nVar) {
        nVar.b(this, this.f2892b);
        if (b()) {
            v(nVar);
        } else {
            this.g.add(nVar);
        }
    }

    @Override // p013i.v
    public final void n(View view) {
        if (this.f2903n != view) {
            this.f2903n = view;
            int i2 = this.f2901l;
            WeakHashMap weakHashMap = X.f14a;
            this.f2902m = Gravity.getAbsoluteGravity(i2, H.d(view));
        }
    }

    @Override // p013i.v
    public final void o(boolean z2) {
        this.f2910u = z2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C0133g c0133g;
        ArrayList arrayList = this.f2897h;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                c0133g = null;
                break;
            }
            c0133g = (C0133g) arrayList.get(i2);
            if (!c0133g.f2889a.f3078y.isShowing()) {
                break;
            } else {
                i2++;
            }
        }
        if (c0133g != null) {
            c0133g.f2890b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // p013i.v
    public final void p(int i2) {
        if (this.f2901l != i2) {
            this.f2901l = i2;
            View view = this.f2903n;
            WeakHashMap weakHashMap = X.f14a;
            this.f2902m = Gravity.getAbsoluteGravity(i2, H.d(view));
        }
    }

    @Override // p013i.v
    public final void q(int i2) {
        this.f2906q = true;
        this.f2908s = i2;
    }

    @Override // p013i.v
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f2914y = (w) onDismissListener;
    }

    @Override // p013i.v
    public final void s(boolean z2) {
        this.f2911v = z2;
    }

    @Override // p013i.v
    public final void t(int i2) {
        this.f2907r = true;
        this.f2909t = i2;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:53:0x0107  */
    /* JADX WARN: Code duplicated, block: B:56:0x0135  */
    /* JADX WARN: Code duplicated, block: B:58:0x0141  */
    /* JADX WARN: Code duplicated, block: B:60:0x0144  */
    /* JADX WARN: Code duplicated, block: B:61:0x0146  */
    /* JADX WARN: Code duplicated, block: B:65:0x014e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0150  */
    /* JADX WARN: Code duplicated, block: B:69:0x015a  */
    /* JADX WARN: Code duplicated, block: B:70:0x015f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0172  */
    /* JADX WARN: Code duplicated, block: B:76:0x0196 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0198  */
    /* JADX WARN: Code duplicated, block: B:78:0x019a  */
    /* JADX WARN: Code duplicated, block: B:79:0x019e A[PHI: r5
  0x019e: PHI (r5v13 int) = (r5v5 int), (r5v15 int) binds: [B:80:0x01a0, B:78:0x019a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x01a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:88:0x01be  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:92:0x01cd  */
    public final void v(n nVar) {
        C0133g c0133g;
        View childAt;
        Rect rect;
        Rect rect2;
        int i2;
        A a2;
        C0178w0 c0178w0;
        int[] iArr;
        Rect rect3;
        int i3;
        boolean z2;
        int[] iArr2;
        int[] iArr3;
        int i4;
        int i5;
        int width;
        Method method;
        MenuItem item;
        k kVar;
        int headersCount;
        int firstVisiblePosition;
        Context context = this.f2892b;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        k kVar2 = new k(nVar, layoutInflaterFrom, this.f2895e, R.layout.abc_cascading_menu_item_layout);
        if (!b() && this.f2910u) {
            kVar2.f2926c = true;
        } else if (b()) {
            kVar2.f2926c = v.u(nVar);
        }
        int iM = v.m(kVar2, context, this.f2893c);
        O0 o2 = new O0(context, null, this.f2894d);
        o2.f3094B = this.f2900k;
        o2.f3069p = this;
        o2.f3078y.setOnDismissListener(this);
        o2.f3068o = this.f2903n;
        o2.f3065l = this.f2902m;
        o2.f3077x = true;
        o2.f3078y.setFocusable(true);
        o2.f3078y.setInputMethodMode(2);
        o2.o(kVar2);
        o2.r(iM);
        o2.f3065l = this.f2902m;
        ArrayList arrayList = this.f2897h;
        if (arrayList.size() > 0) {
            c0133g = (C0133g) arrayList.get(arrayList.size() - 1);
            n nVar2 = c0133g.f2890b;
            int size = nVar2.f2936f.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    item = null;
                    break;
                }
                item = nVar2.getItem(i6);
                if (item.hasSubMenu() && nVar == item.getSubMenu()) {
                    break;
                } else {
                    i6++;
                }
            }
            if (item == null) {
                childAt = null;
            } else {
                C0178w0 c0178w1 = c0133g.f2889a.f3057c;
                ListAdapter adapter = c0178w1.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    kVar = (k) headerViewListAdapter.getWrappedAdapter();
                } else {
                    kVar = (k) adapter;
                    headersCount = 0;
                }
                int count = kVar.getCount();
                int i7 = 0;
                while (true) {
                    if (i7 >= count) {
                        i7 = -1;
                        break;
                    } else if (item == kVar.getItem(i7)) {
                        break;
                    } else {
                        i7++;
                    }
                }
                if (i7 != -1 && (firstVisiblePosition = (i7 + headersCount) - c0178w1.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < c0178w1.getChildCount()) {
                    childAt = c0178w1.getChildAt(firstVisiblePosition);
                }
            }
            if (childAt != null) {
                i2 = Build.VERSION.SDK_INT;
                a2 = o2.f3078y;
                if (i2 <= 28) {
                    method = O0.f3093C;
                    if (method != null) {
                        try {
                            method.invoke(a2, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    L0.a(a2, false);
                }
                K0.a(o2.f3078y, null);
                c0178w0 = ((C0133g) arrayList.get(arrayList.size() - 1)).f2889a.f3057c;
                iArr = new int[2];
                c0178w0.getLocationOnScreen(iArr);
                rect3 = new Rect();
                this.f2904o.getWindowVisibleDisplayFrame(rect3);
                if (this.f2905p == 1) {
                    if (c0178w0.getWidth() + iArr[0] + iM > rect3.right) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                } else if (iArr[0] - iM < 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f2905p = i3;
                if (Build.VERSION.SDK_INT >= 26) {
                    o2.f3068o = childAt;
                    i5 = 0;
                    i4 = 0;
                } else {
                    iArr2 = new int[2];
                    this.f2903n.getLocationOnScreen(iArr2);
                    iArr3 = new int[2];
                    childAt.getLocationOnScreen(iArr3);
                    if ((this.f2902m & 7) == 5) {
                        iArr2[0] = this.f2903n.getWidth() + iArr2[0];
                        iArr3[0] = childAt.getWidth() + iArr3[0];
                    }
                    i4 = iArr3[0] - iArr2[0];
                    i5 = iArr3[1] - iArr2[1];
                }
                if ((this.f2902m & 5) == 5) {
                    if (z2) {
                        width = i4 + iM;
                    } else {
                        iM = childAt.getWidth();
                        width = i4 - iM;
                    }
                } else if (z2) {
                    width = i4 + childAt.getWidth();
                } else {
                    width = i4 - iM;
                }
                o2.f3060f = width;
                o2.f3064k = true;
                o2.f3063j = true;
                o2.l(i5);
            } else {
                if (this.f2906q) {
                    o2.f3060f = this.f2908s;
                }
                if (this.f2907r) {
                    o2.l(this.f2909t);
                }
                rect = this.f2995a;
                if (rect != null) {
                    rect2 = new Rect(rect);
                } else {
                    rect2 = null;
                }
                o2.f3076w = rect2;
            }
            arrayList.add(new C0133g(o2, nVar, this.f2905p));
            o2.i();
            C0178w0 c0178w2 = o2.f3057c;
            c0178w2.setOnKeyListener(this);
            if (c0133g == null || !this.f2911v || nVar.f2942m == null) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0178w2, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(nVar.f2942m);
            c0178w2.addHeaderView(frameLayout, null, false);
            o2.i();
            return;
        }
        c0133g = null;
        childAt = null;
        if (childAt != null) {
            i2 = Build.VERSION.SDK_INT;
            a2 = o2.f3078y;
            if (i2 <= 28) {
                method = O0.f3093C;
                if (method != null) {
                    method.invoke(a2, Boolean.FALSE);
                }
            } else {
                L0.a(a2, false);
            }
            K0.a(o2.f3078y, null);
            c0178w0 = ((C0133g) arrayList.get(arrayList.size() - 1)).f2889a.f3057c;
            iArr = new int[2];
            c0178w0.getLocationOnScreen(iArr);
            rect3 = new Rect();
            this.f2904o.getWindowVisibleDisplayFrame(rect3);
            if (this.f2905p == 1) {
                if (c0178w0.getWidth() + iArr[0] + iM > rect3.right) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
            } else if (iArr[0] - iM < 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f2905p = i3;
            if (Build.VERSION.SDK_INT >= 26) {
                o2.f3068o = childAt;
                i5 = 0;
                i4 = 0;
            } else {
                iArr2 = new int[2];
                this.f2903n.getLocationOnScreen(iArr2);
                iArr3 = new int[2];
                childAt.getLocationOnScreen(iArr3);
                if ((this.f2902m & 7) == 5) {
                    iArr2[0] = this.f2903n.getWidth() + iArr2[0];
                    iArr3[0] = childAt.getWidth() + iArr3[0];
                }
                i4 = iArr3[0] - iArr2[0];
                i5 = iArr3[1] - iArr2[1];
            }
            if ((this.f2902m & 5) == 5) {
                if (z2) {
                    width = i4 + iM;
                } else {
                    iM = childAt.getWidth();
                    width = i4 - iM;
                }
            } else if (z2) {
                width = i4 + childAt.getWidth();
            } else {
                width = i4 - iM;
            }
            o2.f3060f = width;
            o2.f3064k = true;
            o2.f3063j = true;
            o2.l(i5);
        } else {
            if (this.f2906q) {
                o2.f3060f = this.f2908s;
            }
            if (this.f2907r) {
                o2.l(this.f2909t);
            }
            rect = this.f2995a;
            if (rect != null) {
                rect2 = new Rect(rect);
            } else {
                rect2 = null;
            }
            o2.f3076w = rect2;
        }
        arrayList.add(new C0133g(o2, nVar, this.f2905p));
        o2.i();
        C0178w0 c0178w3 = o2.f3057c;
        c0178w3.setOnKeyListener(this);
        if (c0133g == null) {
        }
    }
}
