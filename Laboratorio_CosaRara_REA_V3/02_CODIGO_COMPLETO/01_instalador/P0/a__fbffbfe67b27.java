// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p028p0;

import F0.i;
import F0.j;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import p029q.e;
import p029q.f;
import p033t.l;
import p040w0.g;
import p040w0.h;
import p045z.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(Context context, String str) {
        int iC;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) == -1) {
            return -1;
        }
        String strD = e.d(str);
        if (strD != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int iMyUid2 = Process.myUid();
            String packageName2 = context.getPackageName();
            if (iMyUid2 == iMyUid && b.a(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                AppOpsManager appOpsManagerC = f.c(context);
                iC = f.a(appOpsManagerC, strD, Binder.getCallingUid(), packageName);
                if (iC == 0) {
                    iC = f.a(appOpsManagerC, strD, iMyUid, f.b(context));
                }
            } else {
                iC = e.c((AppOpsManager) e.a(context, AppOpsManager.class), strD, packageName);
            }
            if (iC != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void d(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    public static boolean e(File file, Resources resources, int i2) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i2);
            try {
                boolean zF = f(file, inputStreamOpenRawResource);
                c(inputStreamOpenRawResource);
                return zF;
            } catch (Throwable th) {
                th = th;
                c(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean f(File file, InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 == -1) {
                            c(fileOutputStream2);
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    c(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    c(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static g g(g gVar, h hVar) {
        i.e(hVar, "key");
        if (i.a(gVar.getKey(), hVar)) {
            return gVar;
        }
        return null;
    }

    public static File k(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, str + i2);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static p034t0.b m(E0.a aVar) {
        p034t0.h hVar = p034t0.h.f4133c;
        p034t0.i iVar = new p034t0.i();
        iVar.f4135a = (j) aVar;
        iVar.f4136b = hVar;
        return iVar;
    }

    public static p040w0.i n(g gVar, h hVar) {
        i.e(hVar, "key");
        return i.a(gVar.getKey(), hVar) ? p040w0.j.f4165a : gVar;
    }

    public static MappedByteBuffer o(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorA = l.a(context.getContentResolver(), uri, "r", null);
            if (parcelFileDescriptorA == null) {
                if (parcelFileDescriptorA != null) {
                    parcelFileDescriptorA.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorA.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorA.close();
                    return map;
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
                    parcelFileDescriptorA.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public abstract Method h(Class cls, Field field);

    public abstract Constructor i(Class cls);

    public abstract String[] j(Class cls);

    public abstract boolean l(Class cls);
}
