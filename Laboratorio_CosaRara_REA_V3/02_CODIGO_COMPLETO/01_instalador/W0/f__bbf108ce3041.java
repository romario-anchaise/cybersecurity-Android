// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Method;
import lyr.stable.wrapper.core.PayloadDecrypt;
import lyr.stable.wrapper.core.PpVpn;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f795b;

    public /* synthetic */ f(Activity activity, int i2) {
        this.f794a = i2;
        this.f795b = activity;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00c8 A[Catch: Exception -> 0x00e0, TryCatch #0 {Exception -> 0x00e0, blocks: (B:53:0x00b9, B:59:0x00c8, B:61:0x00d0, B:63:0x00da, B:66:0x00e2, B:69:0x00f6, B:70:0x0104, B:71:0x010a, B:72:0x0111, B:56:0x00c3), top: B:84:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d0 A[Catch: Exception -> 0x00e0, LOOP:0: B:61:0x00d0->B:63:0x00da, LOOP_START, TryCatch #0 {Exception -> 0x00e0, blocks: (B:53:0x00b9, B:59:0x00c8, B:61:0x00d0, B:63:0x00da, B:66:0x00e2, B:69:0x00f6, B:70:0x0104, B:71:0x010a, B:72:0x0111, B:56:0x00c3), top: B:84:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00da A[Catch: Exception -> 0x00e0, LOOP:0: B:61:0x00d0->B:63:0x00da, LOOP_END, TryCatch #0 {Exception -> 0x00e0, blocks: (B:53:0x00b9, B:59:0x00c8, B:61:0x00d0, B:63:0x00da, B:66:0x00e2, B:69:0x00f6, B:70:0x0104, B:71:0x010a, B:72:0x0111, B:56:0x00c3), top: B:84:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00f6 A[Catch: Exception -> 0x00e0, LOOP:1: B:67:0x00f2->B:69:0x00f6, LOOP_END, TryCatch #0 {Exception -> 0x00e0, blocks: (B:53:0x00b9, B:59:0x00c8, B:61:0x00d0, B:63:0x00da, B:66:0x00e2, B:69:0x00f6, B:70:0x0104, B:71:0x010a, B:72:0x0111, B:56:0x00c3), top: B:84:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x010a A[Catch: Exception -> 0x00e0, TryCatch #0 {Exception -> 0x00e0, blocks: (B:53:0x00b9, B:59:0x00c8, B:61:0x00d0, B:63:0x00da, B:66:0x00e2, B:69:0x00f6, B:70:0x0104, B:71:0x010a, B:72:0x0111, B:56:0x00c3), top: B:84:0x00b7 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        final int iF;
        final int i2;
        Object obj;
        ?? r7;
        ?? r6;
        ?? r4;
        ?? r5 = 1;
        r5 = 1;
        switch (this.f794a) {
            case 0:
                final Activity activity = this.f795b;
                String str = i.f797a;
                Handler handler = i.f799c;
                try {
                    if (activity != null) {
                        z2 = k.a(activity).f819c;
                        if (z2) {
                            throw new IllegalStateException("Embedded core package does not match wrapper brand");
                        }
                        byte[] bArrC = PayloadDecrypt.c(activity);
                        if (Build.VERSION.SDK_INT >= 26) {
                            while (!activity.getPackageManager().canRequestPackageInstalls()) {
                                Thread.sleep(500L);
                            }
                        }
                        i.b(activity);
                        iF = i.f(activity, bArrC);
                        handler.post(new d(1));
                        for (i2 = 1; i2 <= 10; i2++) {
                            handler.postDelayed(new Runnable() { // from class: W0.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    boolean zD;
                                    m mVar = i.f804i;
                                    int i3 = iF;
                                    synchronized (mVar) {
                                        zD = mVar.d(i3);
                                    }
                                    if (zD) {
                                        Context context = activity;
                                        try {
                                            context.getPackageManager().getPackageInfo(c.f784a, 0);
                                            if (k.b(context)) {
                                                return;
                                            }
                                            Log.i(i.f797a, "install poll hit on attempt " + i2);
                                            i.k(context, i3);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }, ((long) i2) * 3000);
                        }
                        Log.i(str, "Mirror payload install session committed");
                        return;
                    }
                    String str2 = k.f815d;
                    if (z2) {
                        throw new IllegalStateException("Embedded core package does not match wrapper brand");
                    }
                    byte[] bArrC2 = PayloadDecrypt.c(activity);
                    if (Build.VERSION.SDK_INT >= 26) {
                        while (!activity.getPackageManager().canRequestPackageInstalls()) {
                            Thread.sleep(500L);
                        }
                    }
                    i.b(activity);
                    iF = i.f(activity, bArrC2);
                    handler.post(new d(1));
                    while (i2 <= 10) {
                        handler.postDelayed(new Runnable() { // from class: W0.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                boolean zD;
                                m mVar = i.f804i;
                                int i3 = iF;
                                synchronized (mVar) {
                                    zD = mVar.d(i3);
                                }
                                if (zD) {
                                    Context context = activity;
                                    try {
                                        context.getPackageManager().getPackageInfo(c.f784a, 0);
                                        if (k.b(context)) {
                                            return;
                                        }
                                        Log.i(i.f797a, "install poll hit on attempt " + i2);
                                        i.k(context, i3);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }, ((long) i2) * 3000);
                    }
                    Log.i(str, "Mirror payload install session committed");
                    return;
                } catch (Exception e2) {
                    Log.e(str, "Mirror install failed", e2);
                    m mVar = i.f804i;
                    synchronized (mVar) {
                        mVar.f822a = false;
                        mVar.f823b = false;
                        mVar.f824c = -1;
                        i.d(activity);
                        i.e(activity);
                        i.f806k = -1;
                        PpVpn.b();
                        handler.post(new H.t(1, e2));
                        return;
                    }
                }
            default:
                Activity activity2 = this.f795b;
                if (activity2.isFinishing()) {
                    return;
                }
                p029q.c cVar = Build.VERSION.SDK_INT;
                if (cVar >= 28) {
                    Class cls = p029q.d.f4008a;
                    activity2.recreate();
                    return;
                }
                Class cls2 = p029q.d.f4008a;
                Application application = 27;
                boolean z3 = cVar == 26 || cVar == 27;
                Method method = p029q.d.f4013f;
                if ((!z3 || method != null) && (p029q.d.f4012e != null || p029q.d.f4011d != null)) {
                    try {
                        Object obj2 = p029q.d.f4010c.get(activity2);
                        if (obj2 != null && (obj = p029q.d.f4009b.get(activity2)) != null) {
                            application = activity2.getApplication();
                            cVar = new p029q.c(activity2);
                            application.registerActivityLifecycleCallbacks(cVar);
                            r5 = p029q.d.g;
                            r5.post(new R0.h(cVar, 2, obj2));
                            if (cVar != 26 && cVar != 27) {
                                r5 = 0;
                            }
                            try {
                                if (r5 != 0) {
                                    try {
                                        Boolean bool = Boolean.FALSE;
                                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                    } catch (Throwable th) {
                                        th = th;
                                        r4 = r5;
                                        r6 = cVar;
                                        r7 = application;
                                        r4.post(new R0.h(r7, 3, r6));
                                        throw th;
                                    }
                                } else {
                                    activity2.recreate();
                                }
                                r5.post(new R0.h(application, 3, cVar));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                r4 = r5;
                                r6 = cVar;
                                r7 = application;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity2.recreate();
                return;
        }
    }
}
