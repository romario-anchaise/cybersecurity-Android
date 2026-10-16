// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import V.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.recyclerview.widget.j0;
import b1.p;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p021m.i;
import p033t.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f4176a = new j0(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f4177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f4179d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new j());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f4177b = threadPoolExecutor;
        f4178c = new Object();
        f4179d = new i(0);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020 A[EDGE_INSN: B:10:0x0020->B:24:0x003d BREAK  A[LOOP:0: B:17:0x002d->B:23:0x003a]] */
    public static f a(String str, Context context, a aVar, int i2) {
        j0 j0Var = f4176a;
        Typeface typeface = (Typeface) j0Var.g(str);
        if (typeface != null) {
            return new f(typeface);
        }
        try {
            p pVarA = c.a(context, aVar);
            int i3 = 1;
            h[] hVarArr = (h[]) pVarA.f2171b;
            int i4 = pVarA.f2170a;
            if (i4 != 0) {
                if (i4 != 1) {
                    i3 = -3;
                    break;
                }
                i3 = -2;
            } else if (hVarArr != null && hVarArr.length != 0) {
                i3 = 0;
                for (h hVar : hVarArr) {
                    int i5 = hVar.f4184e;
                    if (i5 != 0) {
                        if (i5 >= 0) {
                            i3 = i5;
                            break;
                        }
                        i3 = -3;
                        break;
                    }
                }
            }
            if (i3 != 0) {
                return new f(i3);
            }
            Typeface typefaceD = f.f4108a.d(context, hVarArr, i2);
            if (typefaceD == null) {
                return new f(-3);
            }
            j0Var.k(str, typefaceD);
            return new f(typefaceD);
        } catch (PackageManager.NameNotFoundException unused) {
            return new f(-1);
        }
    }
}
