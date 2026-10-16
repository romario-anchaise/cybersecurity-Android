// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import F0.i;
import H.C0028c;
import Q.a;
import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.h;
import f1.l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import p011h.e;
import p011h.j;
import p015j.C0171t;
import p015j.Q0;
import p015j.w1;
import p029q.n;
import p029q.o;
import p039w.b;
import p039w.g;
import s.m;

/* JADX INFO: renamed from: f.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0121k extends h implements InterfaceC0122l, n {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AbstractC0125o mDelegate;
    private Resources mResources;

    public AbstractActivityC0121k() {
        getSavedStateRegistry().c(DELEGATE_TAG, new a(this));
        addOnContextAvailableListener(new C0120j(this));
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        z zVar = (z) getDelegate();
        zVar.x();
        ((ViewGroup) zVar.f2548A.findViewById(R.id.content)).addView(view, layoutParams);
        zVar.f2583m.a(zVar.f2582l.getCallback());
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0182  */
    /* JADX WARN: Code duplicated, block: B:103:0x019d  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:109:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:112:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:115:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:118:0x01df  */
    /* JADX WARN: Code duplicated, block: B:121:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:122:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:126:0x0200  */
    /* JADX WARN: Code duplicated, block: B:128:0x0208  */
    /* JADX WARN: Code duplicated, block: B:129:0x020c  */
    /* JADX WARN: Code duplicated, block: B:140:0x022d A[Catch: all -> 0x0221, TRY_LEAVE, TryCatch #0 {, blocks: (B:131:0x020f, B:133:0x0213, B:139:0x022b, B:140:0x022d, B:142:0x0231, B:148:0x0241, B:147:0x0238, B:138:0x0224), top: B:158:0x020f, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00da  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:65:0x0101  */
    /* JADX WARN: Code duplicated, block: B:68:0x010c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0114  */
    /* JADX WARN: Code duplicated, block: B:74:0x011c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0124  */
    /* JADX WARN: Code duplicated, block: B:80:0x012c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0134  */
    /* JADX WARN: Code duplicated, block: B:86:0x0140  */
    /* JADX WARN: Code duplicated, block: B:89:0x014f  */
    /* JADX WARN: Code duplicated, block: B:92:0x015e  */
    /* JADX WARN: Code duplicated, block: B:95:0x016d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0176  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        int i2;
        Configuration configuration;
        Configuration configuration2;
        Configuration configuration3;
        e eVar;
        Resources.Theme theme;
        Method method;
        float f2;
        float f3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        z zVar = (z) getDelegate();
        zVar.f2562O = true;
        int i39 = zVar.S;
        if (i39 == -100) {
            i39 = AbstractC0125o.f2504b;
        }
        int iD = zVar.D(context, i39);
        if (AbstractC0125o.c(context) && AbstractC0125o.c(context)) {
            if (!b.a()) {
                synchronized (AbstractC0125o.f2510i) {
                    try {
                        g gVar = AbstractC0125o.f2505c;
                        if (gVar == null) {
                            if (AbstractC0125o.f2506d == null) {
                                AbstractC0125o.f2506d = g.a(l.R(context));
                            }
                            if (!AbstractC0125o.f2506d.f4155a.f4156a.isEmpty()) {
                                AbstractC0125o.f2505c = AbstractC0125o.f2506d;
                            }
                        } else if (!gVar.equals(AbstractC0125o.f2506d)) {
                            g gVar2 = AbstractC0125o.f2505c;
                            AbstractC0125o.f2506d = gVar2;
                            l.O(context, gVar2.f4155a.f4156a.toLanguageTags());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (!AbstractC0125o.f2508f) {
                AbstractC0125o.f2503a.execute(new O.h(context, 3));
            }
        }
        g gVarQ = z.q(context);
        if (z.f2547k0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(z.u(context, iD, gVarQ, null, false));
            } catch (IllegalStateException unused) {
                if (context instanceof e) {
                    ((e) context).a(z.u(context, iD, gVarQ, null, false));
                } else if (z.f2546j0) {
                    i2 = Build.VERSION.SDK_INT;
                    Configuration configuration4 = new Configuration();
                    configuration4.uiMode = -1;
                    configuration4.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration4).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (configuration.equals(configuration2)) {
                        configuration3 = null;
                    } else {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f2 = configuration.fontScale;
                            f3 = configuration2.fontScale;
                            if (f2 != f3) {
                                configuration3.fontScale = f3;
                            }
                            i3 = configuration.mcc;
                            i4 = configuration2.mcc;
                            if (i3 != i4) {
                                configuration3.mcc = i4;
                            }
                            i5 = configuration.mnc;
                            i6 = configuration2.mnc;
                            if (i5 != i6) {
                                configuration3.mnc = i6;
                            }
                            s.a(configuration, configuration2, configuration3);
                            i7 = configuration.touchscreen;
                            i8 = configuration2.touchscreen;
                            if (i7 != i8) {
                                configuration3.touchscreen = i8;
                            }
                            i9 = configuration.keyboard;
                            i10 = configuration2.keyboard;
                            if (i9 != i10) {
                                configuration3.keyboard = i10;
                            }
                            i11 = configuration.keyboardHidden;
                            i12 = configuration2.keyboardHidden;
                            if (i11 != i12) {
                                configuration3.keyboardHidden = i12;
                            }
                            i13 = configuration.navigation;
                            i14 = configuration2.navigation;
                            if (i13 != i14) {
                                configuration3.navigation = i14;
                            }
                            i15 = configuration.navigationHidden;
                            i16 = configuration2.navigationHidden;
                            if (i15 != i16) {
                                configuration3.navigationHidden = i16;
                            }
                            i17 = configuration.orientation;
                            i18 = configuration2.orientation;
                            if (i17 != i18) {
                                configuration3.orientation = i18;
                            }
                            i19 = configuration.screenLayout & 15;
                            i20 = configuration2.screenLayout & 15;
                            if (i19 != i20) {
                                configuration3.screenLayout |= i20;
                            }
                            i21 = configuration.screenLayout & 192;
                            i22 = configuration2.screenLayout & 192;
                            if (i21 != i22) {
                                configuration3.screenLayout |= i22;
                            }
                            i23 = configuration.screenLayout & 48;
                            i24 = configuration2.screenLayout & 48;
                            if (i23 != i24) {
                                configuration3.screenLayout |= i24;
                            }
                            i25 = configuration.screenLayout & 768;
                            i26 = configuration2.screenLayout & 768;
                            if (i25 != i26) {
                                configuration3.screenLayout |= i26;
                            }
                            if (i2 >= 26) {
                                if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                                    configuration3.colorMode = (3 & configuration2.colorMode) | configuration3.colorMode;
                                }
                                if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                                    configuration3.colorMode |= configuration2.colorMode & 12;
                                }
                            }
                            i27 = configuration.uiMode & 15;
                            i28 = configuration2.uiMode & 15;
                            if (i27 != i28) {
                                configuration3.uiMode |= i28;
                            }
                            i29 = configuration.uiMode & 48;
                            i30 = configuration2.uiMode & 48;
                            if (i29 != i30) {
                                configuration3.uiMode |= i30;
                            }
                            i31 = configuration.screenWidthDp;
                            i32 = configuration2.screenWidthDp;
                            if (i31 != i32) {
                                configuration3.screenWidthDp = i32;
                            }
                            i33 = configuration.screenHeightDp;
                            i34 = configuration2.screenHeightDp;
                            if (i33 != i34) {
                                configuration3.screenHeightDp = i34;
                            }
                            i35 = configuration.smallestScreenWidthDp;
                            i36 = configuration2.smallestScreenWidthDp;
                            if (i35 != i36) {
                                configuration3.smallestScreenWidthDp = i36;
                            }
                            i37 = configuration.densityDpi;
                            i38 = configuration2.densityDpi;
                            if (i37 != i38) {
                                configuration3.densityDpi = i38;
                            }
                        }
                    }
                    Configuration configurationU = z.u(context, iD, gVarQ, configuration3, true);
                    eVar = new e(context, com.o2s2m.gae1fc3b2uc0u.R.style.Theme_AppCompat_Empty);
                    eVar.a(configurationU);
                    if (context.getTheme() != null) {
                        theme = eVar.getTheme();
                        if (i2 >= 29) {
                            m.a(theme);
                        } else {
                            synchronized (s.b.f4042e) {
                                if (s.b.g) {
                                    method = s.b.f4043f;
                                    if (method != null) {
                                        method.invoke(theme, null);
                                    }
                                } else {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    s.b.f4043f = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                    s.b.g = true;
                                    method = s.b.f4043f;
                                    if (method != null) {
                                        method.invoke(theme, null);
                                    }
                                }
                            }
                        }
                    }
                    context = eVar;
                }
            }
        } else if (context instanceof e) {
            try {
                ((e) context).a(z.u(context, iD, gVarQ, null, false));
            } catch (IllegalStateException unused2) {
                if (z.f2546j0) {
                    i2 = Build.VERSION.SDK_INT;
                    Configuration configuration5 = new Configuration();
                    configuration5.uiMode = -1;
                    configuration5.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration5).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f2 = configuration.fontScale;
                            f3 = configuration2.fontScale;
                            if (f2 != f3) {
                                configuration3.fontScale = f3;
                            }
                            i3 = configuration.mcc;
                            i4 = configuration2.mcc;
                            if (i3 != i4) {
                                configuration3.mcc = i4;
                            }
                            i5 = configuration.mnc;
                            i6 = configuration2.mnc;
                            if (i5 != i6) {
                                configuration3.mnc = i6;
                            }
                            s.a(configuration, configuration2, configuration3);
                            i7 = configuration.touchscreen;
                            i8 = configuration2.touchscreen;
                            if (i7 != i8) {
                                configuration3.touchscreen = i8;
                            }
                            i9 = configuration.keyboard;
                            i10 = configuration2.keyboard;
                            if (i9 != i10) {
                                configuration3.keyboard = i10;
                            }
                            i11 = configuration.keyboardHidden;
                            i12 = configuration2.keyboardHidden;
                            if (i11 != i12) {
                                configuration3.keyboardHidden = i12;
                            }
                            i13 = configuration.navigation;
                            i14 = configuration2.navigation;
                            if (i13 != i14) {
                                configuration3.navigation = i14;
                            }
                            i15 = configuration.navigationHidden;
                            i16 = configuration2.navigationHidden;
                            if (i15 != i16) {
                                configuration3.navigationHidden = i16;
                            }
                            i17 = configuration.orientation;
                            i18 = configuration2.orientation;
                            if (i17 != i18) {
                                configuration3.orientation = i18;
                            }
                            i19 = configuration.screenLayout & 15;
                            i20 = configuration2.screenLayout & 15;
                            if (i19 != i20) {
                                configuration3.screenLayout |= i20;
                            }
                            i21 = configuration.screenLayout & 192;
                            i22 = configuration2.screenLayout & 192;
                            if (i21 != i22) {
                                configuration3.screenLayout |= i22;
                            }
                            i23 = configuration.screenLayout & 48;
                            i24 = configuration2.screenLayout & 48;
                            if (i23 != i24) {
                                configuration3.screenLayout |= i24;
                            }
                            i25 = configuration.screenLayout & 768;
                            i26 = configuration2.screenLayout & 768;
                            if (i25 != i26) {
                                configuration3.screenLayout |= i26;
                            }
                            if (i2 >= 26) {
                                if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                                    configuration3.colorMode = (3 & configuration2.colorMode) | configuration3.colorMode;
                                }
                                if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                                    configuration3.colorMode |= configuration2.colorMode & 12;
                                }
                            }
                            i27 = configuration.uiMode & 15;
                            i28 = configuration2.uiMode & 15;
                            if (i27 != i28) {
                                configuration3.uiMode |= i28;
                            }
                            i29 = configuration.uiMode & 48;
                            i30 = configuration2.uiMode & 48;
                            if (i29 != i30) {
                                configuration3.uiMode |= i30;
                            }
                            i31 = configuration.screenWidthDp;
                            i32 = configuration2.screenWidthDp;
                            if (i31 != i32) {
                                configuration3.screenWidthDp = i32;
                            }
                            i33 = configuration.screenHeightDp;
                            i34 = configuration2.screenHeightDp;
                            if (i33 != i34) {
                                configuration3.screenHeightDp = i34;
                            }
                            i35 = configuration.smallestScreenWidthDp;
                            i36 = configuration2.smallestScreenWidthDp;
                            if (i35 != i36) {
                                configuration3.smallestScreenWidthDp = i36;
                            }
                            i37 = configuration.densityDpi;
                            i38 = configuration2.densityDpi;
                            if (i37 != i38) {
                                configuration3.densityDpi = i38;
                            }
                        }
                    } else {
                        configuration3 = null;
                    }
                    Configuration configurationU2 = z.u(context, iD, gVarQ, configuration3, true);
                    eVar = new e(context, com.o2s2m.gae1fc3b2uc0u.R.style.Theme_AppCompat_Empty);
                    eVar.a(configurationU2);
                    try {
                        if (context.getTheme() != null) {
                            theme = eVar.getTheme();
                            if (i2 >= 29) {
                                m.a(theme);
                            } else {
                                synchronized (s.b.f4042e) {
                                    if (s.b.g) {
                                        try {
                                            Method declaredMethod2 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                            s.b.f4043f = declaredMethod2;
                                            declaredMethod2.setAccessible(true);
                                        } catch (NoSuchMethodException e2) {
                                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                                        }
                                        s.b.g = true;
                                        method = s.b.f4043f;
                                        if (method != null) {
                                            try {
                                                method.invoke(theme, null);
                                            } catch (IllegalAccessException | InvocationTargetException e3) {
                                                Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                                                s.b.f4043f = null;
                                            }
                                        }
                                    } else {
                                        method = s.b.f4043f;
                                        if (method != null) {
                                            method.invoke(theme, null);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (NullPointerException unused3) {
                    }
                    context = eVar;
                }
            }
        } else if (z.f2546j0) {
            i2 = Build.VERSION.SDK_INT;
            Configuration configuration6 = new Configuration();
            configuration6.uiMode = -1;
            configuration6.fontScale = 0.0f;
            configuration = context.createConfigurationContext(configuration6).getResources().getConfiguration();
            configuration2 = context.getResources().getConfiguration();
            configuration.uiMode = configuration2.uiMode;
            if (configuration.equals(configuration2)) {
                configuration3 = new Configuration();
                configuration3.fontScale = 0.0f;
                if (configuration.diff(configuration2) != 0) {
                    f2 = configuration.fontScale;
                    f3 = configuration2.fontScale;
                    if (f2 != f3) {
                        configuration3.fontScale = f3;
                    }
                    i3 = configuration.mcc;
                    i4 = configuration2.mcc;
                    if (i3 != i4) {
                        configuration3.mcc = i4;
                    }
                    i5 = configuration.mnc;
                    i6 = configuration2.mnc;
                    if (i5 != i6) {
                        configuration3.mnc = i6;
                    }
                    s.a(configuration, configuration2, configuration3);
                    i7 = configuration.touchscreen;
                    i8 = configuration2.touchscreen;
                    if (i7 != i8) {
                        configuration3.touchscreen = i8;
                    }
                    i9 = configuration.keyboard;
                    i10 = configuration2.keyboard;
                    if (i9 != i10) {
                        configuration3.keyboard = i10;
                    }
                    i11 = configuration.keyboardHidden;
                    i12 = configuration2.keyboardHidden;
                    if (i11 != i12) {
                        configuration3.keyboardHidden = i12;
                    }
                    i13 = configuration.navigation;
                    i14 = configuration2.navigation;
                    if (i13 != i14) {
                        configuration3.navigation = i14;
                    }
                    i15 = configuration.navigationHidden;
                    i16 = configuration2.navigationHidden;
                    if (i15 != i16) {
                        configuration3.navigationHidden = i16;
                    }
                    i17 = configuration.orientation;
                    i18 = configuration2.orientation;
                    if (i17 != i18) {
                        configuration3.orientation = i18;
                    }
                    i19 = configuration.screenLayout & 15;
                    i20 = configuration2.screenLayout & 15;
                    if (i19 != i20) {
                        configuration3.screenLayout |= i20;
                    }
                    i21 = configuration.screenLayout & 192;
                    i22 = configuration2.screenLayout & 192;
                    if (i21 != i22) {
                        configuration3.screenLayout |= i22;
                    }
                    i23 = configuration.screenLayout & 48;
                    i24 = configuration2.screenLayout & 48;
                    if (i23 != i24) {
                        configuration3.screenLayout |= i24;
                    }
                    i25 = configuration.screenLayout & 768;
                    i26 = configuration2.screenLayout & 768;
                    if (i25 != i26) {
                        configuration3.screenLayout |= i26;
                    }
                    if (i2 >= 26) {
                        if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                            configuration3.colorMode = (3 & configuration2.colorMode) | configuration3.colorMode;
                        }
                        if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                            configuration3.colorMode |= configuration2.colorMode & 12;
                        }
                    }
                    i27 = configuration.uiMode & 15;
                    i28 = configuration2.uiMode & 15;
                    if (i27 != i28) {
                        configuration3.uiMode |= i28;
                    }
                    i29 = configuration.uiMode & 48;
                    i30 = configuration2.uiMode & 48;
                    if (i29 != i30) {
                        configuration3.uiMode |= i30;
                    }
                    i31 = configuration.screenWidthDp;
                    i32 = configuration2.screenWidthDp;
                    if (i31 != i32) {
                        configuration3.screenWidthDp = i32;
                    }
                    i33 = configuration.screenHeightDp;
                    i34 = configuration2.screenHeightDp;
                    if (i33 != i34) {
                        configuration3.screenHeightDp = i34;
                    }
                    i35 = configuration.smallestScreenWidthDp;
                    i36 = configuration2.smallestScreenWidthDp;
                    if (i35 != i36) {
                        configuration3.smallestScreenWidthDp = i36;
                    }
                    i37 = configuration.densityDpi;
                    i38 = configuration2.densityDpi;
                    if (i37 != i38) {
                        configuration3.densityDpi = i38;
                    }
                }
            } else {
                configuration3 = null;
            }
            Configuration configurationU3 = z.u(context, iD, gVarQ, configuration3, true);
            eVar = new e(context, com.o2s2m.gae1fc3b2uc0u.R.style.Theme_AppCompat_Empty);
            eVar.a(configurationU3);
            if (context.getTheme() != null) {
                theme = eVar.getTheme();
                if (i2 >= 29) {
                    m.a(theme);
                } else {
                    synchronized (s.b.f4042e) {
                        if (s.b.g) {
                            Method declaredMethod3 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            s.b.f4043f = declaredMethod3;
                            declaredMethod3.setAccessible(true);
                            s.b.g = true;
                            method = s.b.f4043f;
                            if (method != null) {
                                method.invoke(theme, null);
                            }
                        } else {
                            method = s.b.f4043f;
                            if (method != null) {
                                method.invoke(theme, null);
                            }
                        }
                    }
                }
            }
            context = eVar;
        }
        super.attachBaseContext(context);
    }

    public final void c() {
        View decorView = getWindow().getDecorView();
        i.e(decorView, "<this>");
        decorView.setTag(com.o2s2m.gae1fc3b2uc0u.R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        i.e(decorView2, "<this>");
        decorView2.setTag(com.o2s2m.gae1fc3b2uc0u.R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        i.e(decorView3, "<this>");
        decorView3.setTag(com.o2s2m.gae1fc3b2uc0u.R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        i.e(decorView4, "<this>");
        decorView4.setTag(com.o2s2m.gae1fc3b2uc0u.R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0111a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // p029q.h, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0111a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        z zVar = (z) getDelegate();
        zVar.x();
        return (T) zVar.f2582l.findViewById(i2);
    }

    public AbstractC0125o getDelegate() {
        if (this.mDelegate == null) {
            F f2 = AbstractC0125o.f2503a;
            this.mDelegate = new z(this, null, this, this);
        }
        return this.mDelegate;
    }

    public InterfaceC0112b getDrawerToggleDelegate() {
        ((z) getDelegate()).getClass();
        return new C0028c(14);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        z zVar = (z) getDelegate();
        if (zVar.f2586p == null) {
            zVar.B();
            AbstractC0111a abstractC0111a = zVar.f2585o;
            zVar.f2586p = new j(abstractC0111a != null ? abstractC0111a.e() : zVar.f2581k);
        }
        return zVar.f2586p;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i2 = w1.f3345a;
        }
        return resources == null ? super.getResources() : resources;
    }

    public AbstractC0111a getSupportActionBar() {
        z zVar = (z) getDelegate();
        zVar.B();
        return zVar.f2585o;
    }

    @Override // p029q.n
    public Intent getSupportParentActivityIntent() {
        return p029q.j.h(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().b();
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException {
        super.onConfigurationChanged(configuration);
        z zVar = (z) getDelegate();
        if (zVar.f2553F && zVar.f2596z) {
            zVar.B();
            AbstractC0111a abstractC0111a = zVar.f2585o;
            if (abstractC0111a != null) {
                abstractC0111a.g();
            }
        }
        C0171t c0171tA = C0171t.a();
        Context context = zVar.f2581k;
        synchronized (c0171tA) {
            Q0 q1 = c0171tA.f3302a;
            synchronized (q1) {
                p021m.g gVar = (p021m.g) q1.f3104b.get(context);
                if (gVar != null) {
                    int i2 = gVar.f3684d;
                    Object[] objArr = gVar.f3683c;
                    for (int i3 = 0; i3 < i2; i3++) {
                        objArr[i3] = null;
                    }
                    gVar.f3684d = 0;
                    gVar.f3681a = false;
                }
            }
        }
        zVar.f2565R = new Configuration(zVar.f2581k.getResources().getConfiguration());
        zVar.o(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(o oVar) {
        oVar.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = p029q.j.h(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            AbstractActivityC0121k abstractActivityC0121k = oVar.f4016b;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(abstractActivityC0121k.getPackageManager());
            }
            ArrayList arrayList = oVar.f4015a;
            int size = arrayList.size();
            try {
                for (Intent intentI = p029q.j.i(abstractActivityC0121k, component); intentI != null; intentI = p029q.j.i(abstractActivityC0121k, intentI.getComponent())) {
                    arrayList.add(size, intentI);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e2);
            }
        }
    }

    @Override // androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().e();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        AbstractC0111a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((z) getDelegate()).x();
    }

    @Override // androidx.fragment.app.h, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        z zVar = (z) getDelegate();
        zVar.B();
        AbstractC0111a abstractC0111a = zVar.f2585o;
        if (abstractC0111a != null) {
            abstractC0111a.m(true);
        }
    }

    @Override // androidx.fragment.app.h, android.app.Activity
    public void onStart() throws IllegalAccessException {
        super.onStart();
        ((z) getDelegate()).o(true, false);
    }

    @Override // androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
        z zVar = (z) getDelegate();
        zVar.B();
        AbstractC0111a abstractC0111a = zVar.f2585o;
        if (abstractC0111a != null) {
            abstractC0111a.m(false);
        }
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        o oVar = new o(this);
        onCreateSupportNavigateUpTaskStack(oVar);
        onPrepareSupportNavigateUpTaskStack(oVar);
        ArrayList arrayList = oVar.f4015a;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        p031r.a.a(oVar.f4016b, intentArr, null);
        try {
            p029q.a.a(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().l(charSequence);
    }

    @Override // p009f.InterfaceC0122l
    public p011h.b onWindowStartingSupportActionMode(p011h.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0111a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.i, android.app.Activity
    public void setContentView(int i2) {
        c();
        getDelegate().i(i2);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        z zVar = (z) getDelegate();
        if (zVar.f2580j instanceof Activity) {
            zVar.B();
            AbstractC0111a abstractC0111a = zVar.f2585o;
            if (abstractC0111a instanceof P) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            zVar.f2586p = null;
            if (abstractC0111a != null) {
                abstractC0111a.h();
            }
            zVar.f2585o = null;
            if (toolbar != null) {
                Object obj = zVar.f2580j;
                K k2 = new K(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : zVar.f2587q, zVar.f2583m);
                zVar.f2585o = k2;
                zVar.f2583m.f2518b = k2.f2419c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                zVar.f2583m.f2518b = null;
            }
            zVar.b();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i2);
        ((z) getDelegate()).f2566T = i2;
    }

    public p011h.b startSupportActionMode(p011h.a aVar) {
        return getDelegate().n(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().b();
    }

    public void supportNavigateUpTo(Intent intent) {
        p029q.i.b(this, intent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().h(i2);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return p029q.i.c(this, intent);
    }

    @Override // androidx.activity.i, android.app.Activity
    public void setContentView(View view) {
        c();
        getDelegate().j(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        getDelegate().k(view, layoutParams);
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public void onLocalesChanged(g gVar) {
    }

    public void onNightModeChanged(int i2) {
    }

    public void onPrepareSupportNavigateUpTaskStack(o oVar) {
    }

    @Override // p009f.InterfaceC0122l
    public void onSupportActionModeFinished(p011h.b bVar) {
    }

    @Override // p009f.InterfaceC0122l
    public void onSupportActionModeStarted(p011h.b bVar) {
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z2) {
    }
}
