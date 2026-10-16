// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p028p0.a;
import p029q.j;
import p041x.h;
import s.f;

/* JADX INFO: loaded from: classes.dex */
public class g extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f4110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Constructor f4111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f4112c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f4113d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f4114e = false;

    public static boolean p(Object obj, String str, int i2, boolean z2) throws NoSuchMethodException {
        q();
        try {
            return ((Boolean) f4112c.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void q() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f4114e) {
            return;
        }
        f4114e = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f4111b = constructor;
        f4110a = cls;
        f4112c = method2;
        f4113d = method;
    }

    @Override // p029q.j
    public Typeface c(Context context, f fVar, Resources resources, int i2) throws NoSuchMethodException {
        q();
        try {
            Object objNewInstance = f4111b.newInstance(null);
            for (s.g gVar : fVar.f4045a) {
                File fileK = a.k(context);
                if (fileK == null) {
                    return null;
                }
                try {
                    if (!a.e(fileK, resources, gVar.f4051f)) {
                        return null;
                    }
                    if (!p(objNewInstance, fileK.getPath(), gVar.f4047b, gVar.f4048c)) {
                        return null;
                    }
                    fileK.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileK.delete();
                }
            }
            q();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) f4110a, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f4113d.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // p029q.j
    public Typeface d(Context context, h[] hVarArr, int i2) {
        File file;
        if (hVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(g(i2, hVarArr).f4180a, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                try {
                    String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                    file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                } catch (ErrnoException unused) {
                }
                if (file != null && file.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceE = e(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceE;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}
