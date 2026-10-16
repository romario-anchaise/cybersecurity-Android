// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import A.AbstractC0018s;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p013i.p;
import p013i.q;
import p013i.u;
import p037v.a;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public CharSequence f2794A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public CharSequence f2795B;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final /* synthetic */ j f2798E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Menu f2799a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f2808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f2809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public char f2811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public char f2813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2814q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2815r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2816s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2817t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2818u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2820w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f2821x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f2822y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public q f2823z;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public ColorStateList f2796C = null;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public PorterDuff.Mode f2797D = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2800b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2801c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2802d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2803e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2804f = true;
    public boolean g = true;

    public i(j jVar, Menu menu) {
        this.f2798E = jVar;
        this.f2799a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f2798E.f2828c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e2) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z2 = false;
        menuItem.setChecked(this.f2816s).setVisible(this.f2817t).setEnabled(this.f2818u).setCheckable(this.f2815r >= 1).setTitleCondensed(this.f2809l).setIcon(this.f2810m);
        int i2 = this.f2819v;
        if (i2 >= 0) {
            menuItem.setShowAsAction(i2);
        }
        String str = this.f2822y;
        j jVar = this.f2798E;
        if (str != null) {
            if (jVar.f2828c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (jVar.f2829d == null) {
                jVar.f2829d = j.a(jVar.f2828c);
            }
            Object obj = jVar.f2829d;
            String str2 = this.f2822y;
            h hVar = new h();
            hVar.f2792a = obj;
            Class<?> cls = obj.getClass();
            try {
                hVar.f2793b = cls.getMethod(str2, h.f2791c);
                menuItem.setOnMenuItemClickListener(hVar);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str2 + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }
        if (this.f2815r >= 2) {
            if (menuItem instanceof p) {
                p pVar = (p) menuItem;
                pVar.f2982x = (pVar.f2982x & (-5)) | 4;
            } else if (menuItem instanceof u) {
                u uVar = (u) menuItem;
                try {
                    Method method = uVar.f2994d;
                    a aVar = uVar.f2993c;
                    if (method == null) {
                        uVar.f2994d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    uVar.f2994d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e3) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e3);
                }
            }
        }
        String str3 = this.f2821x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, j.f2824e, jVar.f2826a));
            z2 = true;
        }
        int i3 = this.f2820w;
        if (i3 > 0) {
            if (z2) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i3);
            }
        }
        q qVar = this.f2823z;
        if (qVar != null) {
            if (menuItem instanceof a) {
                ((a) menuItem).b(qVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.f2794A;
        boolean z3 = menuItem instanceof a;
        if (z3) {
            ((a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0018s.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f2795B;
        if (z3) {
            ((a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0018s.m(menuItem, charSequence2);
        }
        char c2 = this.f2811n;
        int i4 = this.f2812o;
        if (z3) {
            ((a) menuItem).setAlphabeticShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0018s.g(menuItem, c2, i4);
        }
        char c3 = this.f2813p;
        int i5 = this.f2814q;
        if (z3) {
            ((a) menuItem).setNumericShortcut(c3, i5);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0018s.k(menuItem, c3, i5);
        }
        PorterDuff.Mode mode = this.f2797D;
        if (mode != null) {
            if (z3) {
                ((a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC0018s.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f2796C;
        if (colorStateList != null) {
            if (z3) {
                ((a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC0018s.i(menuItem, colorStateList);
            }
        }
    }
}
