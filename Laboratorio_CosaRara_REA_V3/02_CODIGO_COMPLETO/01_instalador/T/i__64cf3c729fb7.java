// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p028p0.a;
import p041x.h;
import s.f;
import s.g;

/* JADX INFO: loaded from: classes.dex */
public class i extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f4119f;
    public final Constructor g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Method f4120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f4121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Method f4122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Method f4123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f4124l;

    public i() throws NoSuchMethodException {
        Method methodY;
        Constructor<?> constructor;
        Method methodX;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodX = x(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodY = y(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e2.getClass().getName()), e2);
            methodY = null;
            constructor = null;
            methodX = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f4119f = cls;
        this.g = constructor;
        this.f4120h = methodX;
        this.f4121i = method;
        this.f4122j = method2;
        this.f4123k = method3;
        this.f4124l = methodY;
    }

    public static Method x(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // p033t.g, p029q.j
    public final Typeface c(Context context, f fVar, Resources resources, int i2) {
        if (!v()) {
            return super.c(context, fVar, resources, i2);
        }
        Object objW = w();
        if (objW == null) {
            return null;
        }
        for (g gVar : fVar.f4045a) {
            if (!s(context, objW, gVar.f4046a, gVar.f4050e, gVar.f4047b, gVar.f4048c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gVar.f4049d))) {
                r(objW);
                return null;
            }
        }
        if (u(objW)) {
            return t(objW);
        }
        return null;
    }

    @Override // p033t.g, p029q.j
    public final Typeface d(Context context, h[] hVarArr, int i2) {
        Typeface typefaceT;
        boolean zBooleanValue;
        if (hVarArr.length < 1) {
            return null;
        }
        if (!v()) {
            h hVarG = g(i2, hVarArr);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(hVarG.f4180a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(hVarG.f4182c).setItalic(hVarG.f4183d).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap map = new HashMap();
        for (h hVar : hVarArr) {
            if (hVar.f4184e == 0) {
                Uri uri = hVar.f4180a;
                if (!map.containsKey(uri)) {
                    map.put(uri, a.o(context, uri));
                }
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Object objW = w();
        if (objW == null) {
            return null;
        }
        int length = hVarArr.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            h hVar2 = hVarArr[i3];
            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(hVar2.f4180a);
            if (byteBuffer != null) {
                try {
                    zBooleanValue = ((Boolean) this.f4121i.invoke(objW, byteBuffer, Integer.valueOf(hVar2.f4181b), null, Integer.valueOf(hVar2.f4182c), Integer.valueOf(hVar2.f4183d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    r(objW);
                    return null;
                }
                z2 = true;
            }
            i3++;
            z2 = z2;
        }
        if (!z2) {
            r(objW);
            return null;
        }
        if (u(objW) && (typefaceT = t(objW)) != null) {
            return Typeface.create(typefaceT, i2);
        }
        return null;
    }

    @Override // p029q.j
    public final Typeface f(Context context, Resources resources, int i2, String str, int i3) {
        if (!v()) {
            return super.f(context, resources, i2, str, i3);
        }
        Object objW = w();
        if (objW == null) {
            return null;
        }
        if (!s(context, objW, str, 0, -1, -1, null)) {
            r(objW);
            return null;
        }
        if (u(objW)) {
            return t(objW);
        }
        return null;
    }

    public final void r(Object obj) {
        try {
            this.f4123k.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean s(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f4120h.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface t(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f4119f, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f4124l.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean u(Object obj) {
        try {
            return ((Boolean) this.f4122j.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean v() {
        Method method = this.f4120h;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public final Object w() {
        try {
            return this.g.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method y(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
