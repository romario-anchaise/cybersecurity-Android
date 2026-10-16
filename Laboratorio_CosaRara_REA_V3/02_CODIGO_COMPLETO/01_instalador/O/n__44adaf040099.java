// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import H.C0028c;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p025o.h f503a = new p025o.h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f504b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0028c f505c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? l.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static C0028c b() {
        C0028c c0028c = new C0028c(11);
        f505c = c0028c;
        p025o.h hVar = f503a;
        hVar.getClass();
        if (p025o.g.f3983f.h(hVar, null, c0028c)) {
            p025o.g.b(hVar);
        }
        return f505c;
    }

    public static void c(Context context, boolean z2) {
        m mVarA;
        int i2;
        if (z2 || f505c == null) {
            synchronized (f504b) {
                if (!z2) {
                    try {
                        if (f505c != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 28 && i3 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    int i4 = 0;
                    boolean z3 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z4 = file2.exists() && length2 > 0;
                    try {
                        long jA = a(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            try {
                                mVarA = m.a(file3);
                            } catch (IOException unused) {
                                b();
                                return;
                            }
                        } else {
                            mVarA = null;
                        }
                        if (mVarA != null && mVarA.f501c == jA && (i2 = mVarA.f500b) != 2) {
                            i4 = i2;
                        } else if (z3) {
                            i4 = 1;
                        } else if (z4) {
                            i4 = 2;
                        }
                        if (z2 && z4 && i4 != 1) {
                            i4 = 2;
                        }
                        m mVar = new m(1, (mVarA == null || mVarA.f500b != 2 || i4 != 1 || length >= mVarA.f502d) ? i4 : 3, jA, length2);
                        if (mVarA == null || !mVarA.equals(mVar)) {
                            try {
                                mVar.b(file3);
                            } catch (IOException unused2) {
                            }
                        }
                        b();
                        return;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        b();
                        return;
                    }
                }
                b();
            }
        }
    }
}
