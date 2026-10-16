// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import p021m.i;
import p028p0.a;
import p029q.j;
import s.f;
import s.g;

/* JADX INFO: loaded from: classes.dex */
public final class h extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f4115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Constructor f4116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f4117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f4118d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f4116b = constructor;
        f4115a = cls;
        f4117c = method2;
        f4118d = method;
    }

    public static boolean p(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z2) {
        try {
            return ((Boolean) f4117c.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface q(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f4115a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f4118d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[LOOP:0: B:9:0x0014->B:37:0x0069, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0068 A[SYNTHETIC] */
    @Override // p029q.j
    public final Typeface c(Context context, f fVar, Resources resources, int i2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        try {
            objNewInstance = f4116b.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        for (g gVar : fVar.f4045a) {
            int i3 = gVar.f4051f;
            File fileK = a.k(context);
            if (fileK != null) {
                try {
                    if (a.e(fileK, resources, i3)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(fileK);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                fileK.delete();
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (IOException unused2) {
                            map = null;
                        }
                    } else {
                        fileK.delete();
                    }
                    if (map == null) {
                        return null;
                    }
                    if (!p(objNewInstance, map, gVar.f4050e, gVar.f4047b, gVar.f4048c)) {
                        return null;
                    }
                } catch (Throwable th3) {
                    fileK.delete();
                    throw th3;
                }
            }
            map = null;
            if (map == null) {
                return null;
            }
            if (!p(objNewInstance, map, gVar.f4050e, gVar.f4047b, gVar.f4048c)) {
                return null;
            }
        }
        return q(objNewInstance);
    }

    @Override // p029q.j
    public final Typeface d(Context context, p041x.h[] hVarArr, int i2) {
        Object objNewInstance;
        try {
            objNewInstance = f4116b.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        i iVar = new i(0);
        for (p041x.h hVar : hVarArr) {
            Uri uri = hVar.f4180a;
            ByteBuffer byteBufferO = (ByteBuffer) iVar.get(uri);
            if (byteBufferO == null) {
                byteBufferO = a.o(context, uri);
                iVar.put(uri, byteBufferO);
            }
            if (byteBufferO == null) {
                return null;
            }
            if (!p(objNewInstance, byteBufferO, hVar.f4181b, hVar.f4182c, hVar.f4183d)) {
                return null;
            }
        }
        Typeface typefaceQ = q(objNewInstance);
        if (typefaceQ == null) {
            return null;
        }
        return Typeface.create(typefaceQ, i2);
    }
}
