// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import A0.a;
import F0.i;
import N0.AbstractC0045q;
import R0.g;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p009f.AbstractActivityC0121k;
import p034t0.e;
import p040w0.b;
import p040w0.d;
import p040w0.f;
import p041x.h;
import p044y0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public j() {
        new ConcurrentHashMap();
    }

    public static void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        i.e(th, "<this>");
        i.e(th2, "exception");
        if (th != th2) {
            Integer num = a.f92a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = p046z0.a.f4203a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static final e b(Throwable th) {
        i.e(th, "exception");
        return new e(th);
    }

    public static Intent h(AbstractActivityC0121k abstractActivityC0121k) {
        Intent intentA = i.a(abstractActivityC0121k);
        if (intentA != null) {
            return intentA;
        }
        try {
            String strJ = j(abstractActivityC0121k, abstractActivityC0121k.getComponentName());
            if (strJ == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(abstractActivityC0121k, strJ);
            try {
                return j(abstractActivityC0121k, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strJ + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Intent i(AbstractActivityC0121k abstractActivityC0121k, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strJ = j(abstractActivityC0121k, componentName);
        if (strJ == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strJ);
        return j(abstractActivityC0121k, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String j(Activity activity, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return activity.getPackageName() + string;
    }

    public static final int k(int i2, int i3, int i4) {
        if (i4 > 0) {
            if (i2 >= i3) {
                return i3;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            int i6 = i2 % i4;
            if (i6 < 0) {
                i6 += i4;
            }
            int i7 = (i5 - i6) % i4;
            if (i7 < 0) {
                i7 += i4;
            }
            return i3 - i7;
        }
        if (i4 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i2 <= i3) {
            return i3;
        }
        int i8 = -i4;
        int i9 = i2 % i8;
        if (i9 < 0) {
            i9 += i8;
        }
        int i10 = i3 % i8;
        if (i10 < 0) {
            i10 += i8;
        }
        int i11 = (i9 - i10) % i8;
        if (i11 < 0) {
            i11 += i8;
        }
        return i3 + i11;
    }

    public static d l(d dVar) {
        i.e(dVar, "<this>");
        c cVar = dVar instanceof c ? (c) dVar : null;
        if (cVar == null) {
            return dVar;
        }
        d dVar2 = cVar.f4198c;
        if (dVar2 != null) {
            return dVar2;
        }
        p040w0.i iVar = cVar.f4197b;
        i.b(iVar);
        f fVar = (f) iVar.j(p040w0.e.f4164a);
        d gVar = fVar != null ? new g((AbstractC0045q) fVar, cVar) : cVar;
        cVar.f4198c = gVar;
        return gVar;
    }

    public static List m(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        i.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static p040w0.i n(p040w0.i iVar, p040w0.i iVar2) {
        i.e(iVar2, "context");
        return iVar2 == p040w0.j.f4165a ? iVar : (p040w0.i) iVar2.n(iVar, b.f4160d);
    }

    public static final void o(Object obj) {
        if (obj instanceof e) {
            throw ((e) obj).f4128a;
        }
    }

    public abstract Typeface c(Context context, s.f fVar, Resources resources, int i2);

    public abstract Typeface d(Context context, h[] hVarArr, int i2);

    public Typeface e(Context context, InputStream inputStream) {
        File fileK = p028p0.a.k(context);
        if (fileK == null) {
            return null;
        }
        try {
            if (p028p0.a.f(fileK, inputStream)) {
                return Typeface.createFromFile(fileK.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileK.delete();
        }
    }

    public Typeface f(Context context, Resources resources, int i2, String str, int i3) {
        File fileK = p028p0.a.k(context);
        if (fileK == null) {
            return null;
        }
        try {
            if (p028p0.a.e(fileK, resources, i2)) {
                return Typeface.createFromFile(fileK.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileK.delete();
        }
    }

    public h g(int i2, h[] hVarArr) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z2 = (i2 & 2) != 0;
        h hVar = null;
        int i4 = Integer.MAX_VALUE;
        for (h hVar2 : hVarArr) {
            int iAbs = (Math.abs(hVar2.f4182c - i3) * 2) + (hVar2.f4183d == z2 ? 0 : 1);
            if (hVar == null || i4 > iAbs) {
                hVar = hVar2;
                i4 = iAbs;
            }
        }
        return hVar;
    }
}
